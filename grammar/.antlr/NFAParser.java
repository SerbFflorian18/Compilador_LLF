// Generated from /home/milax/Documents/LF/Compilador_LLF/grammar/NFA.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class NFAParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, STATE=7, CHAR=8, WS=9;
	public static final int
		RULE_init = 0, RULE_states = 1, RULE_alphabet = 2, RULE_relations = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"init", "states", "alphabet", "relations"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'{'", "'}'", "','", "')'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "STATE", "CHAR", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	@Override
	public String getGrammarFileName() { return "NFA.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NFAParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitContext extends ParserRuleContext {
		public List<StatesContext> states() {
			return getRuleContexts(StatesContext.class);
		}
		public StatesContext states(int i) {
			return getRuleContext(StatesContext.class,i);
		}
		public AlphabetContext alphabet() {
			return getRuleContext(AlphabetContext.class,0);
		}
		public RelationsContext relations() {
			return getRuleContext(RelationsContext.class,0);
		}
		public TerminalNode STATE() { return getToken(NFAParser.STATE, 0); }
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			match(T__0);
			setState(9);
			match(T__1);
			setState(10);
			states();
			setState(11);
			match(T__2);
			setState(12);
			match(T__3);
			setState(13);
			match(T__1);
			setState(14);
			alphabet();
			setState(15);
			match(T__2);
			setState(16);
			match(T__3);
			setState(17);
			match(T__1);
			setState(18);
			relations(0);
			setState(19);
			match(T__2);
			setState(20);
			match(T__3);
			setState(21);
			match(STATE);
			setState(22);
			match(T__3);
			setState(23);
			match(T__1);
			setState(24);
			states();
			setState(25);
			match(T__2);
			setState(26);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatesContext extends ParserRuleContext {
		public TerminalNode STATE() { return getToken(NFAParser.STATE, 0); }
		public StatesContext states() {
			return getRuleContext(StatesContext.class,0);
		}
		public StatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_states; }
	}

	public final StatesContext states() throws RecognitionException {
		StatesContext _localctx = new StatesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_states);
		try {
			setState(32);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				match(STATE);
				setState(29);
				match(T__3);
				setState(30);
				states();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				match(STATE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AlphabetContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(NFAParser.CHAR, 0); }
		public AlphabetContext alphabet() {
			return getRuleContext(AlphabetContext.class,0);
		}
		public AlphabetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alphabet; }
	}

	public final AlphabetContext alphabet() throws RecognitionException {
		AlphabetContext _localctx = new AlphabetContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_alphabet);
		try {
			setState(38);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				match(CHAR);
				setState(35);
				match(T__3);
				setState(36);
				alphabet();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				match(CHAR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationsContext extends ParserRuleContext {
		public TerminalNode STATE() { return getToken(NFAParser.STATE, 0); }
		public TerminalNode CHAR() { return getToken(NFAParser.CHAR, 0); }
		public StatesContext states() {
			return getRuleContext(StatesContext.class,0);
		}
		public List<RelationsContext> relations() {
			return getRuleContexts(RelationsContext.class);
		}
		public RelationsContext relations(int i) {
			return getRuleContext(RelationsContext.class,i);
		}
		public RelationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relations; }
	}

	public final RelationsContext relations() throws RecognitionException {
		return relations(0);
	}

	private RelationsContext relations(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationsContext _localctx = new RelationsContext(_ctx, _parentState);
		RelationsContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_relations, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(41);
				match(T__0);
				setState(42);
				match(STATE);
				setState(43);
				match(T__3);
				setState(44);
				match(CHAR);
				setState(45);
				match(T__4);
				setState(46);
				match(T__5);
				setState(47);
				match(T__1);
				setState(48);
				states();
				setState(49);
				match(T__2);
				}
				break;
			case 2:
				{
				setState(51);
				match(T__0);
				setState(52);
				match(STATE);
				setState(53);
				match(T__3);
				setState(54);
				match(CHAR);
				setState(55);
				match(T__4);
				setState(56);
				match(T__5);
				setState(57);
				match(T__1);
				setState(58);
				match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(66);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RelationsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relations);
					setState(61);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(62);
					match(T__3);
					setState(63);
					relations(4);
					}
					} 
				}
				setState(68);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return relations_sempred((RelationsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean relations_sempred(RelationsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\tF\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001!\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\'\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003<\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u0003A\b\u0003\n\u0003\f\u0003D\t\u0003\u0001\u0003\u0000\u0001\u0006"+
		"\u0004\u0000\u0002\u0004\u0006\u0000\u0000E\u0000\b\u0001\u0000\u0000"+
		"\u0000\u0002 \u0001\u0000\u0000\u0000\u0004&\u0001\u0000\u0000\u0000\u0006"+
		";\u0001\u0000\u0000\u0000\b\t\u0005\u0001\u0000\u0000\t\n\u0005\u0002"+
		"\u0000\u0000\n\u000b\u0003\u0002\u0001\u0000\u000b\f\u0005\u0003\u0000"+
		"\u0000\f\r\u0005\u0004\u0000\u0000\r\u000e\u0005\u0002\u0000\u0000\u000e"+
		"\u000f\u0003\u0004\u0002\u0000\u000f\u0010\u0005\u0003\u0000\u0000\u0010"+
		"\u0011\u0005\u0004\u0000\u0000\u0011\u0012\u0005\u0002\u0000\u0000\u0012"+
		"\u0013\u0003\u0006\u0003\u0000\u0013\u0014\u0005\u0003\u0000\u0000\u0014"+
		"\u0015\u0005\u0004\u0000\u0000\u0015\u0016\u0005\u0007\u0000\u0000\u0016"+
		"\u0017\u0005\u0004\u0000\u0000\u0017\u0018\u0005\u0002\u0000\u0000\u0018"+
		"\u0019\u0003\u0002\u0001\u0000\u0019\u001a\u0005\u0003\u0000\u0000\u001a"+
		"\u001b\u0005\u0005\u0000\u0000\u001b\u0001\u0001\u0000\u0000\u0000\u001c"+
		"\u001d\u0005\u0007\u0000\u0000\u001d\u001e\u0005\u0004\u0000\u0000\u001e"+
		"!\u0003\u0002\u0001\u0000\u001f!\u0005\u0007\u0000\u0000 \u001c\u0001"+
		"\u0000\u0000\u0000 \u001f\u0001\u0000\u0000\u0000!\u0003\u0001\u0000\u0000"+
		"\u0000\"#\u0005\b\u0000\u0000#$\u0005\u0004\u0000\u0000$\'\u0003\u0004"+
		"\u0002\u0000%\'\u0005\b\u0000\u0000&\"\u0001\u0000\u0000\u0000&%\u0001"+
		"\u0000\u0000\u0000\'\u0005\u0001\u0000\u0000\u0000()\u0006\u0003\uffff"+
		"\uffff\u0000)*\u0005\u0001\u0000\u0000*+\u0005\u0007\u0000\u0000+,\u0005"+
		"\u0004\u0000\u0000,-\u0005\b\u0000\u0000-.\u0005\u0005\u0000\u0000./\u0005"+
		"\u0006\u0000\u0000/0\u0005\u0002\u0000\u000001\u0003\u0002\u0001\u0000"+
		"12\u0005\u0003\u0000\u00002<\u0001\u0000\u0000\u000034\u0005\u0001\u0000"+
		"\u000045\u0005\u0007\u0000\u000056\u0005\u0004\u0000\u000067\u0005\b\u0000"+
		"\u000078\u0005\u0005\u0000\u000089\u0005\u0006\u0000\u00009:\u0005\u0002"+
		"\u0000\u0000:<\u0005\u0003\u0000\u0000;(\u0001\u0000\u0000\u0000;3\u0001"+
		"\u0000\u0000\u0000<B\u0001\u0000\u0000\u0000=>\n\u0003\u0000\u0000>?\u0005"+
		"\u0004\u0000\u0000?A\u0003\u0006\u0003\u0004@=\u0001\u0000\u0000\u0000"+
		"AD\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000"+
		"\u0000C\u0007\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000\u0004"+
		" &;B";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}