import antlr.src.exLexer;
import antlr.src.exParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            if(args.length == 0) {
                System.out.println("Usage: exorsus.jar <sourceFile>.exo");
            } else {

                if (getFileExtension(args[0]).equals("exo")) {

                    exLexer lexer = new exLexer(CharStreams.fromFileName(args[0]));
                    exParser parser = new exParser(new CommonTokenStream(lexer));
                    parser.setBuildParseTree(true);
                    ParseTree tree = parser.parse();

                    Scope scope = new Scope();
                    Map<String, Function> functions = new HashMap<>();

                    SymbolVisitor symbolVisitor = new SymbolVisitor(functions);
                    symbolVisitor.visit(tree);

                    ClassVisitor classVisitor = new ClassVisitor();
                    classVisitor.visit(tree);

                    EvaluationVisitor visitor = new EvaluationVisitor(scope, functions);
                    visitor.visit(tree);

                } else {
                    System.out.println("File format must be .exo");
                }
            }
        }catch (Exception e) {
            if (e.getMessage() != null){
                System.err.println(e.getMessage());

            } else {
                e.printStackTrace();
            }
        }
    }

    public static String getFileExtension(String fullName) {
        if(fullName != null) {
            String fileName = new File(fullName).getName();
            int dotIndex = fileName.lastIndexOf('.');
            return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
        } else {
            return null;
        }
    }
}
