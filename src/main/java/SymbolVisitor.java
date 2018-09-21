import antlr.src.exBaseVisitor;
import antlr.src.exParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SymbolVisitor extends exBaseVisitor<Value> {

    private Map<String, Function> functions;

    SymbolVisitor(Map<String, Function> functions) {
        this.functions = functions;
    }

    @Override
    public Value visitFunctionDecl(exParser.FunctionDeclContext ctx) {
        List<TerminalNode> params = ctx.idList() != null ? ctx.idList().Identifier() : new ArrayList<TerminalNode>();
        ParseTree block = ctx.block();
        String id = ctx.Identifier().getText() + params.size();
        functions.put(id, new Function(params, block));
        return Value.VOID;
    }
}
