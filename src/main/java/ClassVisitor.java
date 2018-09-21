import antlr.src.exBaseVisitor;
import antlr.src.exParser;
import org.antlr.v4.runtime.tree.ParseTree;

public class ClassVisitor extends exBaseVisitor {

    ClassVisitor() {

    }

    @Override
    public Object visitClassDecl(exParser.ClassDeclContext ctx) {
        ParseTree classBody = ctx.classBody();
        String id = ctx.Identifier().getText();
        Class _class = new Class(classBody);
        return Value.VOID;
    }

}
