package exceptions;

import org.antlr.v4.runtime.ParserRuleContext;

public class EvaluationException extends ExceptionSemantic {
    public EvaluationException(ParserRuleContext ctx) {
        this("You made a boo-boo: " + ctx.getText(), ctx);
    }

    public EvaluationException(String msg, ParserRuleContext ctx) {
        super(msg + " line: " + ctx.start.getLine());
    }
}
