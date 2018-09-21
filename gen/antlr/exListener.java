// Generated from C:/Users/elusiven/IdeaProjects/Exorsus/antlr.src/main/java/antlr.src\ex.g4 by ANTLR 4.7
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link exParser}.
 */
public interface exListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link exParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(exParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link exParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(exParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link exParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(exParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link exParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(exParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link exParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(exParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link exParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(exParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link exParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(exParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link exParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(exParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link exParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierFunctionCall(exParser.IdentifierFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link exParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierFunctionCall(exParser.IdentifierFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printlnFunctionCall}
	 * labeled alternative in {@link exParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintlnFunctionCall(exParser.PrintlnFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printlnFunctionCall}
	 * labeled alternative in {@link exParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintlnFunctionCall(exParser.PrintlnFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link exParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintFunctionCall(exParser.PrintFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link exParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintFunctionCall(exParser.PrintFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assertFunctionCall}
	 * labeled alternative in {@link exParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterAssertFunctionCall(exParser.AssertFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assertFunctionCall}
	 * labeled alternative in {@link exParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitAssertFunctionCall(exParser.AssertFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sizeFunctionCall}
	 * labeled alternative in {@link exParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterSizeFunctionCall(exParser.SizeFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sizeFunctionCall}
	 * labeled alternative in {@link exParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitSizeFunctionCall(exParser.SizeFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link exParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(exParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link exParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(exParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link exParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(exParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link exParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(exParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link exParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStat(exParser.ElseIfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link exParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStat(exParser.ElseIfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link exParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void enterElseStat(exParser.ElseStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link exParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void exitElseStat(exParser.ElseStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link exParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(exParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link exParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(exParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link exParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(exParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link exParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(exParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link exParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(exParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link exParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(exParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link exParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(exParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link exParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(exParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link exParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(exParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link exParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(exParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(exParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(exParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(exParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(exParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(exParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(exParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(exParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(exParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(exParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(exParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpression(exParser.UnaryMinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpression(exParser.UnaryMinusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpression(exParser.EqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpression(exParser.EqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(exParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(exParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(exParser.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(exParser.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(exParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(exParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionExpression(exParser.ExpressionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionExpression(exParser.ExpressionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(exParser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(exParser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompExpression(exParser.CompExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompExpression(exParser.CompExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNullExpression(exParser.NullExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNullExpression(exParser.NullExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(exParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(exParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultExpression(exParser.MultExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultExpression(exParser.MultExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterListExpression(exParser.ListExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitListExpression(exParser.ListExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(exParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(exParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inputExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInputExpression(exParser.InputExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inputExpression}
	 * labeled alternative in {@link exParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInputExpression(exParser.InputExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link exParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(exParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link exParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(exParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link exParser#indexes}.
	 * @param ctx the parse tree
	 */
	void enterIndexes(exParser.IndexesContext ctx);
	/**
	 * Exit a parse tree produced by {@link exParser#indexes}.
	 * @param ctx the parse tree
	 */
	void exitIndexes(exParser.IndexesContext ctx);
}