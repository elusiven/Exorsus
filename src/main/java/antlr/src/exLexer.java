// Generated from /Users/elusiven/Projects/exorsus/src/main/java/antlr/ex.g4 by ANTLR 4.7
package antlr.src;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class exLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Class=1, CtorID=2, Println=3, Print=4, Input=5, Assert=6, Size=7, Def=8, 
		If=9, Else=10, Return=11, For=12, While=13, To=14, Do=15, End=16, In=17, 
		Null=18, Constant=19, Var=20, Or=21, And=22, Equals=23, NEquals=24, GTEquals=25, 
		LTEquals=26, Pow=27, Excl=28, GT=29, LT=30, Add=31, Subtract=32, Multiply=33, 
		Divide=34, Modulus=35, OBrace=36, CBrace=37, OBracket=38, CBracket=39, 
		OParen=40, CParen=41, SColon=42, Assign=43, Comma=44, QMark=45, Colon=46, 
		Arrow=47, Bool=48, Number=49, Identifier=50, String=51, Comment=52, Space=53;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Class", "CtorID", "Println", "Print", "Input", "Assert", "Size", "Def", 
		"If", "Else", "Return", "For", "While", "To", "Do", "End", "In", "Null", 
		"Constant", "Var", "Or", "And", "Equals", "NEquals", "GTEquals", "LTEquals", 
		"Pow", "Excl", "GT", "LT", "Add", "Subtract", "Multiply", "Divide", "Modulus", 
		"OBrace", "CBrace", "OBracket", "CBracket", "OParen", "CParen", "SColon", 
		"Assign", "Comma", "QMark", "Colon", "Arrow", "Bool", "Number", "Identifier", 
		"String", "Comment", "Space", "Int", "Digit"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'start'", "'println'", "'print'", "'input'", "'assert'", 
		"'size'", "'def'", "'if'", "'else'", "'return'", "'for'", "'while'", "'to'", 
		null, null, "'in'", "'null'", "'const'", "'var'", "'||'", "'&&'", "'=='", 
		"'!='", "'>='", "'<='", "'^'", "'!'", "'>'", "'<'", "'+'", "'-'", "'*'", 
		"'/'", "'%'", null, null, "'['", "']'", "'('", "')'", "';'", "'='", "','", 
		"'?'", "':'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Class", "CtorID", "Println", "Print", "Input", "Assert", "Size", 
		"Def", "If", "Else", "Return", "For", "While", "To", "Do", "End", "In", 
		"Null", "Constant", "Var", "Or", "And", "Equals", "NEquals", "GTEquals", 
		"LTEquals", "Pow", "Excl", "GT", "LT", "Add", "Subtract", "Multiply", 
		"Divide", "Modulus", "OBrace", "CBrace", "OBracket", "CBracket", "OParen", 
		"CParen", "SColon", "Assign", "Comma", "QMark", "Colon", "Arrow", "Bool", 
		"Number", "Identifier", "String", "Comment", "Space"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public exLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ex.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\67\u016a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$"+
		"\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3"+
		"/\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u011a"+
		"\n\61\3\62\3\62\3\62\7\62\u011f\n\62\f\62\16\62\u0122\13\62\5\62\u0124"+
		"\n\62\3\63\3\63\7\63\u0128\n\63\f\63\16\63\u012b\13\63\3\64\3\64\3\64"+
		"\3\64\7\64\u0131\n\64\f\64\16\64\u0134\13\64\3\64\3\64\3\64\3\64\3\64"+
		"\7\64\u013b\n\64\f\64\16\64\u013e\13\64\3\64\5\64\u0141\n\64\3\65\3\65"+
		"\3\65\3\65\7\65\u0147\n\65\f\65\16\65\u014a\13\65\3\65\3\65\3\65\3\65"+
		"\7\65\u0150\n\65\f\65\16\65\u0153\13\65\3\65\3\65\5\65\u0157\n\65\3\65"+
		"\3\65\3\66\3\66\3\66\3\66\3\67\3\67\7\67\u0161\n\67\f\67\16\67\u0164\13"+
		"\67\3\67\5\67\u0167\n\67\38\38\3\u0151\29\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m\2o\2\3\2\f\5\2C\\aac|\6\2\62"+
		";C\\aac|\3\2$$\6\2\f\f\17\17$$^^\4\2\f\f\17\17\3\2))\6\2\f\f\17\17))^"+
		"^\5\2\13\f\16\17\"\"\3\2\63;\3\2\62;\2\u0175\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2"+
		"\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\3q\3\2\2\2\5w\3\2\2\2\7}\3\2\2\2\t"+
		"\u0085\3\2\2\2\13\u008b\3\2\2\2\r\u0091\3\2\2\2\17\u0098\3\2\2\2\21\u009d"+
		"\3\2\2\2\23\u00a1\3\2\2\2\25\u00a4\3\2\2\2\27\u00a9\3\2\2\2\31\u00b0\3"+
		"\2\2\2\33\u00b4\3\2\2\2\35\u00ba\3\2\2\2\37\u00bd\3\2\2\2!\u00bf\3\2\2"+
		"\2#\u00c1\3\2\2\2%\u00c4\3\2\2\2\'\u00c9\3\2\2\2)\u00cf\3\2\2\2+\u00d3"+
		"\3\2\2\2-\u00d6\3\2\2\2/\u00d9\3\2\2\2\61\u00dc\3\2\2\2\63\u00df\3\2\2"+
		"\2\65\u00e2\3\2\2\2\67\u00e5\3\2\2\29\u00e7\3\2\2\2;\u00e9\3\2\2\2=\u00eb"+
		"\3\2\2\2?\u00ed\3\2\2\2A\u00ef\3\2\2\2C\u00f1\3\2\2\2E\u00f3\3\2\2\2G"+
		"\u00f5\3\2\2\2I\u00f7\3\2\2\2K\u00f9\3\2\2\2M\u00fb\3\2\2\2O\u00fd\3\2"+
		"\2\2Q\u00ff\3\2\2\2S\u0101\3\2\2\2U\u0103\3\2\2\2W\u0105\3\2\2\2Y\u0107"+
		"\3\2\2\2[\u0109\3\2\2\2]\u010b\3\2\2\2_\u010d\3\2\2\2a\u0119\3\2\2\2c"+
		"\u011b\3\2\2\2e\u0125\3\2\2\2g\u0140\3\2\2\2i\u0156\3\2\2\2k\u015a\3\2"+
		"\2\2m\u0166\3\2\2\2o\u0168\3\2\2\2qr\7e\2\2rs\7n\2\2st\7c\2\2tu\7u\2\2"+
		"uv\7u\2\2v\4\3\2\2\2wx\7u\2\2xy\7v\2\2yz\7c\2\2z{\7t\2\2{|\7v\2\2|\6\3"+
		"\2\2\2}~\7r\2\2~\177\7t\2\2\177\u0080\7k\2\2\u0080\u0081\7p\2\2\u0081"+
		"\u0082\7v\2\2\u0082\u0083\7n\2\2\u0083\u0084\7p\2\2\u0084\b\3\2\2\2\u0085"+
		"\u0086\7r\2\2\u0086\u0087\7t\2\2\u0087\u0088\7k\2\2\u0088\u0089\7p\2\2"+
		"\u0089\u008a\7v\2\2\u008a\n\3\2\2\2\u008b\u008c\7k\2\2\u008c\u008d\7p"+
		"\2\2\u008d\u008e\7r\2\2\u008e\u008f\7w\2\2\u008f\u0090\7v\2\2\u0090\f"+
		"\3\2\2\2\u0091\u0092\7c\2\2\u0092\u0093\7u\2\2\u0093\u0094\7u\2\2\u0094"+
		"\u0095\7g\2\2\u0095\u0096\7t\2\2\u0096\u0097\7v\2\2\u0097\16\3\2\2\2\u0098"+
		"\u0099\7u\2\2\u0099\u009a\7k\2\2\u009a\u009b\7|\2\2\u009b\u009c\7g\2\2"+
		"\u009c\20\3\2\2\2\u009d\u009e\7f\2\2\u009e\u009f\7g\2\2\u009f\u00a0\7"+
		"h\2\2\u00a0\22\3\2\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7h\2\2\u00a3\24"+
		"\3\2\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7u\2\2\u00a7"+
		"\u00a8\7g\2\2\u00a8\26\3\2\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7g\2\2\u00ab"+
		"\u00ac\7v\2\2\u00ac\u00ad\7w\2\2\u00ad\u00ae\7t\2\2\u00ae\u00af\7p\2\2"+
		"\u00af\30\3\2\2\2\u00b0\u00b1\7h\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7"+
		"t\2\2\u00b3\32\3\2\2\2\u00b4\u00b5\7y\2\2\u00b5\u00b6\7j\2\2\u00b6\u00b7"+
		"\7k\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7g\2\2\u00b9\34\3\2\2\2\u00ba\u00bb"+
		"\7v\2\2\u00bb\u00bc\7q\2\2\u00bc\36\3\2\2\2\u00bd\u00be\7}\2\2\u00be "+
		"\3\2\2\2\u00bf\u00c0\7\177\2\2\u00c0\"\3\2\2\2\u00c1\u00c2\7k\2\2\u00c2"+
		"\u00c3\7p\2\2\u00c3$\3\2\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6\7w\2\2\u00c6"+
		"\u00c7\7n\2\2\u00c7\u00c8\7n\2\2\u00c8&\3\2\2\2\u00c9\u00ca\7e\2\2\u00ca"+
		"\u00cb\7q\2\2\u00cb\u00cc\7p\2\2\u00cc\u00cd\7u\2\2\u00cd\u00ce\7v\2\2"+
		"\u00ce(\3\2\2\2\u00cf\u00d0\7x\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2\7t\2"+
		"\2\u00d2*\3\2\2\2\u00d3\u00d4\7~\2\2\u00d4\u00d5\7~\2\2\u00d5,\3\2\2\2"+
		"\u00d6\u00d7\7(\2\2\u00d7\u00d8\7(\2\2\u00d8.\3\2\2\2\u00d9\u00da\7?\2"+
		"\2\u00da\u00db\7?\2\2\u00db\60\3\2\2\2\u00dc\u00dd\7#\2\2\u00dd\u00de"+
		"\7?\2\2\u00de\62\3\2\2\2\u00df\u00e0\7@\2\2\u00e0\u00e1\7?\2\2\u00e1\64"+
		"\3\2\2\2\u00e2\u00e3\7>\2\2\u00e3\u00e4\7?\2\2\u00e4\66\3\2\2\2\u00e5"+
		"\u00e6\7`\2\2\u00e68\3\2\2\2\u00e7\u00e8\7#\2\2\u00e8:\3\2\2\2\u00e9\u00ea"+
		"\7@\2\2\u00ea<\3\2\2\2\u00eb\u00ec\7>\2\2\u00ec>\3\2\2\2\u00ed\u00ee\7"+
		"-\2\2\u00ee@\3\2\2\2\u00ef\u00f0\7/\2\2\u00f0B\3\2\2\2\u00f1\u00f2\7,"+
		"\2\2\u00f2D\3\2\2\2\u00f3\u00f4\7\61\2\2\u00f4F\3\2\2\2\u00f5\u00f6\7"+
		"\'\2\2\u00f6H\3\2\2\2\u00f7\u00f8\7}\2\2\u00f8J\3\2\2\2\u00f9\u00fa\7"+
		"\177\2\2\u00faL\3\2\2\2\u00fb\u00fc\7]\2\2\u00fcN\3\2\2\2\u00fd\u00fe"+
		"\7_\2\2\u00feP\3\2\2\2\u00ff\u0100\7*\2\2\u0100R\3\2\2\2\u0101\u0102\7"+
		"+\2\2\u0102T\3\2\2\2\u0103\u0104\7=\2\2\u0104V\3\2\2\2\u0105\u0106\7?"+
		"\2\2\u0106X\3\2\2\2\u0107\u0108\7.\2\2\u0108Z\3\2\2\2\u0109\u010a\7A\2"+
		"\2\u010a\\\3\2\2\2\u010b\u010c\7<\2\2\u010c^\3\2\2\2\u010d\u010e\7/\2"+
		"\2\u010e\u010f\7@\2\2\u010f`\3\2\2\2\u0110\u0111\7v\2\2\u0111\u0112\7"+
		"t\2\2\u0112\u0113\7w\2\2\u0113\u011a\7g\2\2\u0114\u0115\7h\2\2\u0115\u0116"+
		"\7c\2\2\u0116\u0117\7n\2\2\u0117\u0118\7u\2\2\u0118\u011a\7g\2\2\u0119"+
		"\u0110\3\2\2\2\u0119\u0114\3\2\2\2\u011ab\3\2\2\2\u011b\u0123\5m\67\2"+
		"\u011c\u0120\7\60\2\2\u011d\u011f\5o8\2\u011e\u011d\3\2\2\2\u011f\u0122"+
		"\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0124\3\2\2\2\u0122"+
		"\u0120\3\2\2\2\u0123\u011c\3\2\2\2\u0123\u0124\3\2\2\2\u0124d\3\2\2\2"+
		"\u0125\u0129\t\2\2\2\u0126\u0128\t\3\2\2\u0127\u0126\3\2\2\2\u0128\u012b"+
		"\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012af\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012c\u0132\t\4\2\2\u012d\u0131\n\5\2\2\u012e\u012f\7^"+
		"\2\2\u012f\u0131\n\6\2\2\u0130\u012d\3\2\2\2\u0130\u012e\3\2\2\2\u0131"+
		"\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2"+
		"\2\2\u0134\u0132\3\2\2\2\u0135\u0141\t\4\2\2\u0136\u013c\t\7\2\2\u0137"+
		"\u013b\n\b\2\2\u0138\u0139\7^\2\2\u0139\u013b\n\6\2\2\u013a\u0137\3\2"+
		"\2\2\u013a\u0138\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c"+
		"\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0141\t\7"+
		"\2\2\u0140\u012c\3\2\2\2\u0140\u0136\3\2\2\2\u0141h\3\2\2\2\u0142\u0143"+
		"\7\61\2\2\u0143\u0144\7\61\2\2\u0144\u0148\3\2\2\2\u0145\u0147\n\6\2\2"+
		"\u0146\u0145\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149"+
		"\3\2\2\2\u0149\u0157\3\2\2\2\u014a\u0148\3\2\2\2\u014b\u014c\7\61\2\2"+
		"\u014c\u014d\7,\2\2\u014d\u0151\3\2\2\2\u014e\u0150\13\2\2\2\u014f\u014e"+
		"\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u0152\3\2\2\2\u0151\u014f\3\2\2\2\u0152"+
		"\u0154\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0155\7,\2\2\u0155\u0157\7\61"+
		"\2\2\u0156\u0142\3\2\2\2\u0156\u014b\3\2\2\2\u0157\u0158\3\2\2\2\u0158"+
		"\u0159\b\65\2\2\u0159j\3\2\2\2\u015a\u015b\t\t\2\2\u015b\u015c\3\2\2\2"+
		"\u015c\u015d\b\66\2\2\u015dl\3\2\2\2\u015e\u0162\t\n\2\2\u015f\u0161\5"+
		"o8\2\u0160\u015f\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0167\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0167\7\62"+
		"\2\2\u0166\u015e\3\2\2\2\u0166\u0165\3\2\2\2\u0167n\3\2\2\2\u0168\u0169"+
		"\t\13\2\2\u0169p\3\2\2\2\21\2\u0119\u0120\u0123\u0129\u0130\u0132\u013a"+
		"\u013c\u0140\u0148\u0151\u0156\u0162\u0166\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}