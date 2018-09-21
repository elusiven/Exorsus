import exceptions.ExceptionSemantic;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Map;

public class Class  {

    // Class block
    private ParseTree classBody;
    private Map<String, Function> functions;

    public Class(ParseTree classBody) {

    }
}
