import antlr.src.exParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class Function {

    private List<TerminalNode> params;
    private ParseTree block;

    Function(List<TerminalNode> params, ParseTree block) {
        this.params = params;
        this.block = block;
    }

    public Value invoke(List<exParser.ExpressionContext> params, Map<String, Function> functions, Scope scope) {
        // Check if params are correct
        if(params.size() != this.params.size()) {
            throw new RuntimeException("Invalid function call");
        }

        // Create new scope for this function so all variables will be declared in it unless global
        scope = new Scope(scope);
        EvaluationVisitor visitor = new EvaluationVisitor(scope, functions);
        for (int i=0; i < this.params.size(); i++) {
            // Evaluate each param in the visitor
            Value value = visitor.visit(params.get(i));
            // Assign each param to this function's scope
            scope.assignParam(this.params.get(i).getText(), value);
        }

        Value ret = Value.VOID;

        try {
            visitor.visit(this.block);
        } catch (ReturnValue returnValue) {
            ret = returnValue.value;
        }

        return ret;
    }
}
