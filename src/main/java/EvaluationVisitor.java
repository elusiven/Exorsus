import antlr.src.exBaseVisitor;
import antlr.src.exLexer;
import antlr.src.exParser;
import exceptions.EvaluationException;
import exceptions.ExceptionSemantic;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EvaluationVisitor extends exBaseVisitor<Value> {

    private static ReturnValue returnValue = new ReturnValue();
    private Scope scope;
    private Map<String, Function> functions;

    EvaluationVisitor(Scope scope, Map<String, Function> functions) {
        this.scope = scope;
        this.functions = functions;
    }

    @Override
    public Value visitFunctionDecl(exParser.FunctionDeclContext ctx) {
        return Value.VOID;
    }

    @Override
    public Value visitList(exParser.ListContext ctx) {
        List<Value> list = new ArrayList<Value>();
        if(ctx.exprList() != null) {
            for(exParser.ExpressionContext ex: ctx.exprList().expression()){
                list.add(this.visit(ex));
            }
        }

        return new Value(list);
    }

    // Expression '-' e.g. 1-1
    @Override
    public Value visitUnaryMinusExpression(exParser.UnaryMinusExpressionContext ctx) {
        Value value = this.visit(ctx.expression());
        if (!value.isNumber()) {
            throw new EvaluationException(ctx);
        }

        return new Value(-1 * value.asDouble());
    }

    @Override
    public Value visitMultExpression(exParser.MultExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case exLexer.Multiply:
                return multiply(ctx);
            case exLexer.Divide:
                return divide(ctx);
            case exLexer.Modulus:
                return modulus(ctx);
            default:
                throw new RuntimeException("Unknown operator type: " + ctx.op.getType());
        }
    }

    @Override
    public Value visitAddExpression(exParser.AddExpressionContext ctx) {
        switch(ctx.op.getType()){
            case exLexer.Add:
                return add(ctx);
            case exLexer.Subtract:
                return substract(ctx);
            default:
                throw new RuntimeException("Unknown operator type: " + ctx.op.getType());
        }
    }

    @Override
    public Value visitCompExpression(exParser.CompExpressionContext ctx) {
        switch (ctx.op.getType()){
            case exLexer.LT:
                return lt(ctx);
            case exLexer.LTEquals:
                return ltEq(ctx);
            case exLexer.GT:
                return gt(ctx);
            case exLexer.GTEquals:
                return gtEq(ctx);
            default:
                throw new RuntimeException("Unknown operator type: " + ctx.op.getType());
        }
    }

    @Override
    public Value visitEqExpression(exParser.EqExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case exLexer.Equals:
                return eq(ctx);
            case exLexer.NEquals:
                return nEq(ctx);
            default:
                throw new RuntimeException("Unknown operator type: " + ctx.op.getType());
        }
    }

    // Expression '!' e.g. !booleanValue
    @Override
    public Value visitNotExpression(exParser.NotExpressionContext ctx) {
        Value value = this.visit(ctx.expression());
        if (!value.isBoolean()) {
            throw new EvaluationException(ctx);
        }

        return new Value(!value.asBoolean());
    }

    // Expression '&&'
    @Override
    public Value visitAndExpression(exParser.AndExpressionContext ctx) {
        Value leftv = this.visit(ctx.expression(0));
        Value rightv = this.visit(ctx.expression(1));

        if (!leftv.isBoolean() || !rightv.isBoolean()) {
            throw new EvaluationException(ctx);
        }

        return new Value(leftv.asBoolean() && rightv.asBoolean());
    }

    // Expression '||'
    @Override
    public Value visitOrExpression(exParser.OrExpressionContext ctx) {
        Value leftv = this.visit(ctx.expression(0));
        Value rightv = this.visit(ctx.expression(1));

        if (!leftv.isBoolean() || !rightv.isBoolean()) {
            throw new EvaluationException(ctx);
        }

        return new Value(leftv.asBoolean() || rightv.asBoolean());
    }

    // Expression '?' expression ':' short hand
    @Override
    public Value visitTernaryExpression(exParser.TernaryExpressionContext ctx) {
        Value condition = this.visit(ctx.expression(0));
        if(condition.asBoolean()) {
            return new Value(this.visit(ctx.expression(1)));
        } else {
            return new Value(this.visit(ctx.expression(2)));
        }
    }

    // Expression 'in' Expression
    @Override
    public Value visitInExpression(exParser.InExpressionContext ctx) {
        Value leftv = this.visit(ctx.expression(0));
        Value rightv = this.visit(ctx.expression(1));

        if(rightv.isList()) {
            for (Value value: rightv.asList()) {
                if (value.equals(leftv)) {
                    return new Value(true);
                }
            }

            return new Value(false);
        }

        throw new EvaluationException(ctx);
    }

    // Get a number from the ctx's string
    @Override
    public Value visitNumberExpression(exParser.NumberExpressionContext ctx) {
        return new Value(Double.valueOf(ctx.getText()));
    }

    // Get bool from the ctx's string
    @Override
    public Value visitBoolExpression(exParser.BoolExpressionContext ctx) {
        return new Value(Boolean.valueOf(ctx.getText()));
    }

    @Override
    public Value visitNullExpression(exParser.NullExpressionContext ctx) {
        return Value.NULL;
    }

    private Value resolveIndexes(Value val, List<exParser.ExpressionContext> indexes) {
        for (exParser.ExpressionContext ec: indexes) {
            Value idx = this.visit(ec);
            if (!idx.isNumber() || (!val.isList() && !val.isString())) {
                throw new EvaluationException("Problem resolving boo-boo index on " + val + " at " + idx, ec);
            }

            int i = idx.asDouble().intValue();
            if (val.isString()) {
                val = new Value(val.asString().substring(i, i+1));
            } else {
                val = val.asList().get(i);
            }
        }

        return val;
    }

    private void setAtIndex(ParserRuleContext ctx, List<exParser.ExpressionContext> indexes, Value val, Value newVal) {
        if (!val.isList()) {
            throw new EvaluationException(ctx);
        }

        for(int i=0; i < indexes.size() - 1; i++) {
            Value idx = this.visit(indexes.get(i));
            if (!idx.isNumber()) {
                throw new EvaluationException(ctx);
            }

            val = val.asList().get(idx.asDouble().intValue());
        }

        Value idx = this.visit(indexes.get(indexes.size() - 1));
        if (!idx.isNumber()) {
            throw new EvaluationException(ctx);
        }

        val.asList().set(idx.asDouble().intValue(), newVal);
    }

    // Function call exp
    @Override
    public Value visitFunctionCallExpression(exParser.FunctionCallExpressionContext ctx) {
        Value value = this.visit(ctx.functionCall());
        if (ctx.indexes() != null) {
            List<exParser.ExpressionContext> exps = ctx.indexes().expression();
            value = resolveIndexes(value, exps);
        }

        return value;
    }

    // List expression
    @Override
    public Value visitListExpression(exParser.ListExpressionContext ctx) {
        Value value = this.visit(ctx.list());
        if (ctx.indexes() != null) {
            List<exParser.ExpressionContext> exps = ctx.indexes().expression();
            value = resolveIndexes(value, exps);
        }

        return value;
    }

    // Identifer indexes
    @Override
    public Value visitIdentifierExpression(exParser.IdentifierExpressionContext ctx) {
        String id = ctx.Identifier().getText();
        Value value = scope.resolve(id);

        if (ctx.indexes() != null) {
            List<exParser.ExpressionContext> exps = ctx.indexes().expression();
            value = resolveIndexes(value, exps);
        }

        return value;
    }

    // String indexes

    @Override
    public Value visitStringExpression(exParser.StringExpressionContext ctx) {
        String text = ctx.getText();
        text = text.substring(1, text.length() - 1).replaceAll("\\\\(.)", "$1");
        Value value = new Value(text);

        if (ctx.indexes() != null) {
            List<exParser.ExpressionContext> exps = ctx.indexes().expression();
            value = resolveIndexes(value, exps);
        }

        return value;
    }

    @Override
    public Value visitExpressionExpression(exParser.ExpressionExpressionContext ctx) {
        Value value = this.visit(ctx.expression());
        if (ctx.indexes() != null) {
            List<exParser.ExpressionContext> exps = ctx.indexes().expression();
            value = resolveIndexes(value, exps);
        }

        return value;
    }

    @Override
    public Value visitInputExpression(exParser.InputExpressionContext ctx) {
        TerminalNode inputString = ctx.String();
        try {
            if (inputString != null) {
                String text = inputString.getText();
                text = text.substring(1, text.length() - 1).replaceAll("\\\\(.)", "$1");
                return new Value(new String(Files.readAllBytes(Paths.get(text))));
            } else {
                BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
                return new Value(buffer.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // assignment : var? const? Identifier indexes '=' expression ;
    @Override
    public Value visitAssignment(exParser.AssignmentContext ctx) {
        Value newValue = this.visit(ctx.expression());
        // Get name of var
        String id = ctx.Identifier().getText();

        // var arleady exists, check if its constant
        Value localScopeV = scope.resolve(id);
        if (localScopeV != null) {
            if(localScopeV.getIsConstant()) throw new ExceptionSemantic("Constant value " + id +  " at line: " + ctx.start.getLine() + " cannot be modified");
        }

        // var exists, check if its in parent scope
        Value parentScopeV = scope.parent().resolve(id);
        if(parentScopeV != null) {
            if(parentScopeV.getIsConstant()) throw new ExceptionSemantic("Constant value " + id +  " at line: " + ctx.start.getLine() + " cannot be modified");
        }

        // if tagged constant set to constant
        if(ctx.Constant() != null) {
            newValue.setConstant();
        }

        // check if var has any indexes
        if (ctx.indexes() != null) {
            Value value = scope.resolve(id);
            List<exParser.ExpressionContext> exps = ctx.indexes().expression();
            setAtIndex(ctx, exps, value, newValue);
        } else {
            scope.assign(id, newValue);
        }

        return Value.VOID;
    }

    // Identifier '(' exprList ')'
    @Override
    public Value visitIdentifierFunctionCall(exParser.IdentifierFunctionCallContext ctx) {
        List<exParser.ExpressionContext> params = ctx.exprList() != null ? ctx.exprList().expression() : new ArrayList<exParser.ExpressionContext>();
        String id = ctx.Identifier().getText() + params.size();
        Function function;
        if ((function = functions.get(id)) != null) {
            return function.invoke(params, functions, scope);
        }

        throw new EvaluationException(ctx);
    }

    // Print line
    @Override
    public Value visitPrintlnFunctionCall(exParser.PrintlnFunctionCallContext ctx) {
        System.out.println(this.visit(ctx.expression()));
        return Value.VOID;
    }

    // Print
    @Override
    public Value visitPrintFunctionCall(exParser.PrintFunctionCallContext ctx) {
        System.out.println(this.visit(ctx.expression()));
        return Value.VOID;
    }

    // Assert '(' expression ')'
    @Override
    public Value visitAssertFunctionCall(exParser.AssertFunctionCallContext ctx) {
        Value value = this.visit(ctx.expression());

        if (!value.isBoolean()) {
            throw new EvaluationException(ctx);
        }

        if(!value.asBoolean()) {
            throw new AssertionError("Failed Assertion " + ctx.expression().getText() + " line: " + ctx.start.getLine());
        }

        return Value.VOID;
    }

    // Size '(' expression ')'
    @Override
    public Value visitSizeFunctionCall(exParser.SizeFunctionCallContext ctx) {
        Value value = this.visit(ctx.expression());

        if (value.isString()) {
            return new Value(value.asString().length());
        }

        if(value.isList()) {
            return new Value(value.asList().size());
        }

        throw new EvaluationException(ctx);
    }

    @Override
    public Value visitIfStatement(exParser.IfStatementContext ctx) {


        // IF
        if (this.visit(ctx.ifStat().statementExpression().expression()).asBoolean()) {
            return this.visit(ctx.ifStat().block());
        }

        // ELSE IF
        for (int i=0; i < ctx.elseIfStat().size(); i++) {
            if (this.visit(ctx.elseIfStat(i).statementExpression().expression()).asBoolean()) {
                return this.visit(ctx.elseIfStat(i).block());
            }
        }

        // ELSE
        if (ctx.elseStat() != null) {
            return this.visit(ctx.elseStat().block());
        }

        return Value.VOID;
    }

    // block : (statement | functiondecl) * (return expression) ;
    @Override
    public Value visitBlock(exParser.BlockContext ctx) {
        scope = new Scope(scope); // create new local scope
        for (exParser.StatementContext sx: ctx.statement()) {
            this.visit(sx);
        }

        exParser.ExpressionContext ex;

        if ((ex = ctx.expression()) != null) {
            returnValue.value = this.visit(ex);
            scope = scope.parent();
            throw returnValue;
        }

        scope = scope.parent();
        return Value.VOID;
    }

    @Override
    public Value visitForStatement(exParser.ForStatementContext ctx) {
        int start = this.visit(ctx.expression(0)).asDouble().intValue();
        int stop = this.visit(ctx.expression(1)).asDouble().intValue();
        for (int i = start; i <= stop; i++) {
            scope.assign(ctx.Identifier().getText(), new Value(i));
            Value returnValue = this.visit(ctx.block());
            if (returnValue != Value.VOID) {
                return returnValue;
            }
        }

        return Value.VOID;
    }

    @Override
    public Value visitWhileStatement(exParser.WhileStatementContext ctx) {
        while (this.visit(ctx.statementExpression().expression()).asBoolean()) {
            Value returnValue = this.visit(ctx.block());
            if (returnValue != Value.VOID) {
                return returnValue;
            }
        }

        return Value.VOID;
    }

    private Value multiply(exParser.MultExpressionContext ctx) {
        Value leftv = this.visit(ctx.expression(0));
        Value rightv = this.visit(ctx.expression(1));

        // throw error if both values are null
        if (leftv == null || rightv == null) {
            System.err.println("left value: " + leftv + " right value: " + rightv);
            throw new EvaluationException(ctx);
        }

        // number * number
        if (leftv.isNumber() && rightv.isNumber()) {
            return new Value(leftv.asDouble() * rightv.asDouble());
        }

        // string * number
        if(leftv.isString() && rightv.isNumber()) {
            StringBuilder str = new StringBuilder();
            int stop = rightv.asDouble().intValue();
            for (int i=0; i < stop; i++) {
                str.append(leftv.asString());
            }

            return new Value(str.toString());
        }

        // list * number
        if (leftv.isList() && rightv.isNumber()) {
            List<Value> total = new ArrayList<>();
            int stop = rightv.asDouble().intValue();
            for (int i=0; i < stop; i++) {
                total.addAll(leftv.asList());
            }

            return new Value(total);
        }

        throw new EvaluationException(ctx);
    }

    // Divide number / number
    private Value divide(exParser.MultExpressionContext ctx) {
        Value leftv = this.visit(ctx.expression(0));
        Value rightv = this.visit(ctx.expression(1));

        if (leftv.isNumber() && rightv.isNumber()) {
            return new Value(leftv.asDouble() / rightv.asDouble());
        }

        throw new EvaluationException(ctx);
    }

    // number % number
    private Value modulus(exParser.MultExpressionContext ctx) {
        Value leftv = this.visit(ctx.expression(0));
        Value rightv = this.visit(ctx.expression(1));

        if (leftv.isNumber() && rightv.isNumber()) {
            return new Value(leftv.asDouble() % rightv.asDouble());
        }

        throw new EvaluationException(ctx);
    }

    private Value add(exParser.AddExpressionContext ctx) {
        Value leftv = this.visit(ctx.expression(0));
        Value rightv = this.visit(ctx.expression(1));

        if (leftv == null && rightv == null) {
            throw new EvaluationException(ctx);
        }

        // number + number
        if (leftv.isNumber() && rightv.isNumber()) {
            return new Value(leftv.asDouble() + rightv.asDouble());
        }

        // list + any
        if (leftv.isList()) {
            List<Value> list = leftv.asList();
            list.add(rightv);
            return new Value(list);
        }

        // string + any
        if (leftv.isString()) {
            return new Value(leftv.asString() + "" + rightv.toString());
        }

        // any + string
        if (rightv.isString()) {
            return new Value(leftv.toString() + "" + rightv.asString());
        }

        return new Value(leftv.toString() + rightv.toString());
    }

    private Value substract(exParser.AddExpressionContext ctx) {
        Value leftv = this.visit(ctx.expression(0));
        Value rightv = this.visit(ctx.expression(1));

        if (leftv.isNumber() && rightv.isNumber()) {
            return new Value(leftv.asDouble() - rightv.asDouble());
        }

        if (leftv.isList()) {
            List<Value> list = leftv.asList();
            list.remove(rightv);
            return new Value(list);
        }

        throw new EvaluationException(ctx);
    }

    // Greater or equal '>='
    private Value gtEq(exParser.CompExpressionContext ctx) {
        Value leftv = this.visit(ctx.expression(0));
        Value rightv = this.visit(ctx.expression(1));

        if (leftv.isNumber() && rightv.isNumber()) {
            return new Value(leftv.asDouble() >= rightv.asDouble());
        }

        if (leftv.isString() && rightv.isString()) {
            return new Value(leftv.asString().compareTo(rightv.asString()) >= 0);
        }

        throw new EvaluationException(ctx);
    }

    // Lower than '<='
    // Greater or equal '>='
    private Value ltEq(exParser.CompExpressionContext ctx) {
        Value leftv = this.visit(ctx.expression(0));
        Value rightv = this.visit(ctx.expression(1));

        if (leftv.isNumber() && rightv.isNumber()) {
            return new Value(leftv.asDouble() <= rightv.asDouble());
        }

        if (leftv.isString() && rightv.isString()) {
            return new Value(leftv.asString().compareTo(rightv.asString()) <= 0);
        }

        throw new EvaluationException(ctx);
    }

    private Value gt(exParser.CompExpressionContext ctx) {
        Value leftv = this.visit(ctx.expression(0));
        Value rightv = this.visit(ctx.expression(1));

        if (leftv.isNumber() && rightv.isNumber()) {
            return new Value(leftv.asDouble() > rightv.asDouble());
        }

        if (leftv.isString() && rightv.isString()) {
            return new Value(leftv.asString().compareTo(rightv.asString()) > 0);
        }

        throw new EvaluationException(ctx);
    }

    private Value lt(exParser.CompExpressionContext ctx) {
        Value leftv = this.visit(ctx.expression(0));
        Value rightv = this.visit(ctx.expression(1));

        if (leftv.isNumber() && rightv.isNumber()) {
            return new Value(leftv.asDouble() < rightv.asDouble());
        }

        if (leftv.isString() && rightv.isString()) {
            return new Value(leftv.asString().compareTo(rightv.asString()) < 0);
        }

        throw new EvaluationException(ctx);
    }

    private Value eq(exParser.EqExpressionContext ctx) {
        Value leftv = this.visit(ctx.expression(0));
        Value rightv = this.visit(ctx.expression(1));

        if (leftv == null) {
            throw new EvaluationException(ctx);
        }

        return new Value(leftv.equals(rightv));
    }

    private Value nEq(exParser.EqExpressionContext ctx) {
        Value leftv = this.visit(ctx.expression(0));
        Value rightv = this.visit(ctx.expression(1));
        return new Value(!leftv.equals(rightv));
    }
}
