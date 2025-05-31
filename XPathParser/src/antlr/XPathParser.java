package antlr;// Generated from XPath.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class XPathParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, ID=38, String=39, 
		WS=40;
	public static final int
		RULE_rp = 0, RULE_filter = 1, RULE_attName = 2, RULE_tagName = 3, RULE_filename = 4, 
		RULE_xq = 5, RULE_elementXQ = 6, RULE_stringconstant = 7, RULE_joinClause = 8, 
		RULE_forClause = 9, RULE_letClause = 10, RULE_returnClause = 11, RULE_whereClause = 12, 
		RULE_cond = 13, RULE_var = 14, RULE_comma = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"rp", "filter", "attName", "tagName", "filename", "xq", "elementXQ", 
			"stringconstant", "joinClause", "forClause", "letClause", "returnClause", 
			"whereClause", "cond", "var", "comma"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'.'", "'..'", "'text'", "'('", "')'", "'@'", "'/'", "'//'", 
			"'['", "']'", "','", "'='", "'eq'", "'=='", "'is'", "'and'", "'or'", 
			"'not'", "'document'", "'doc'", "'<'", "'>'", "'{'", "'}'", "'</'", "'join'", 
			"'for'", "'in'", "'let'", "':='", "'return'", "'where'", "'empty'", "'some'", 
			"'satisfies'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "ID", "String", "WS"
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
	public String getGrammarFileName() { return "XPath.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XPathParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RpContext extends ParserRuleContext {
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
	 
		public RpContext() { }
		public void copyFrom(RpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FilteredPathContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public FilteredPathContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterFilteredPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitFilteredPath(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GroupContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public GroupContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitGroup(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ChildPathContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public ChildPathContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterChildPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitChildPath(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnionPathContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public UnionPathContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterUnionPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitUnionPath(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WildcardContext extends RpContext {
		public WildcardContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterWildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitWildcard(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParentContext extends RpContext {
		public ParentContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterParent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitParent(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributeContext extends RpContext {
		public AttNameContext attName() {
			return getRuleContext(AttNameContext.class,0);
		}
		public AttributeContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAttribute(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextFunctionContext extends RpContext {
		public TextFunctionContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterTextFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitTextFunction(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DescendantPathContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public DescendantPathContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterDescendantPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitDescendantPath(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagContext extends RpContext {
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public TagContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitTag(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfContext extends RpContext {
		public SelfContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterSelf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitSelf(this);
		}
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new TagContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(33);
				tagName();
				}
				break;
			case T__0:
				{
				_localctx = new WildcardContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(34);
				match(T__0);
				}
				break;
			case T__1:
				{
				_localctx = new SelfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35);
				match(T__1);
				}
				break;
			case T__2:
				{
				_localctx = new ParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36);
				match(T__2);
				}
				break;
			case T__3:
				{
				_localctx = new TextFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37);
				match(T__3);
				setState(38);
				match(T__4);
				setState(39);
				match(T__5);
				}
				break;
			case T__6:
				{
				_localctx = new AttributeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				match(T__6);
				setState(41);
				attName();
				}
				break;
			case T__4:
				{
				_localctx = new GroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42);
				match(T__4);
				setState(43);
				rp(0);
				setState(44);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(62);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ChildPathContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(48);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(49);
						match(T__7);
						setState(50);
						rp(5);
						}
						break;
					case 2:
						{
						_localctx = new DescendantPathContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(51);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(52);
						match(T__8);
						setState(53);
						rp(4);
						}
						break;
					case 3:
						{
						_localctx = new UnionPathContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(54);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(55);
						match(T__11);
						setState(56);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new FilteredPathContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(57);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(58);
						match(T__9);
						setState(59);
						filter(0);
						setState(60);
						match(T__10);
						}
						break;
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FilterContext extends ParserRuleContext {
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
	 
		public FilterContext() { }
		public void copyFrom(FilterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndFilterContext extends FilterContext {
		public List<FilterContext> filter() {
			return getRuleContexts(FilterContext.class);
		}
		public FilterContext filter(int i) {
			return getRuleContext(FilterContext.class,i);
		}
		public AndFilterContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAndFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAndFilter(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IsFilterContext extends FilterContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public IsFilterContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterIsFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitIsFilter(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotFilterContext extends FilterContext {
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public NotFilterContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterNotFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitNotFilter(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FilterRpContext extends FilterContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FilterRpContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterFilterRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitFilterRp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GroupFilterContext extends FilterContext {
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public GroupFilterContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterGroupFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitGroupFilter(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualFilterContext extends FilterContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public EqualFilterContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterEqualFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitEqualFilter(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqFilterContext extends FilterContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public EqFilterContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterEqFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitEqFilter(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleEqualFilterContext extends FilterContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public DoubleEqualFilterContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterDoubleEqualFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitDoubleEqualFilter(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrFilterContext extends FilterContext {
		public List<FilterContext> filter() {
			return getRuleContexts(FilterContext.class);
		}
		public FilterContext filter(int i) {
			return getRuleContext(FilterContext.class,i);
		}
		public OrFilterContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterOrFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitOrFilter(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringEqualFilterContext extends FilterContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public StringconstantContext stringconstant() {
			return getRuleContext(StringconstantContext.class,0);
		}
		public StringEqualFilterContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterStringEqualFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitStringEqualFilter(this);
		}
	}

	public final FilterContext filter() throws RecognitionException {
		return filter(0);
	}

	private FilterContext filter(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FilterContext _localctx = new FilterContext(_ctx, _parentState);
		FilterContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_filter, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new FilterRpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(68);
				rp(0);
				}
				break;
			case 2:
				{
				_localctx = new EqualFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				rp(0);
				setState(70);
				match(T__12);
				setState(71);
				rp(0);
				}
				break;
			case 3:
				{
				_localctx = new EqFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73);
				rp(0);
				setState(74);
				match(T__13);
				setState(75);
				rp(0);
				}
				break;
			case 4:
				{
				_localctx = new DoubleEqualFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				rp(0);
				setState(78);
				match(T__14);
				setState(79);
				rp(0);
				}
				break;
			case 5:
				{
				_localctx = new IsFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81);
				rp(0);
				setState(82);
				match(T__15);
				setState(83);
				rp(0);
				}
				break;
			case 6:
				{
				_localctx = new StringEqualFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85);
				rp(0);
				setState(86);
				match(T__12);
				setState(87);
				stringconstant();
				}
				break;
			case 7:
				{
				_localctx = new GroupFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				match(T__4);
				setState(90);
				filter(0);
				setState(91);
				match(T__5);
				}
				break;
			case 8:
				{
				_localctx = new NotFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				match(T__18);
				setState(94);
				filter(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(105);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(103);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new AndFilterContext(new FilterContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_filter);
						setState(97);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(98);
						match(T__16);
						setState(99);
						filter(4);
						}
						break;
					case 2:
						{
						_localctx = new OrFilterContext(new FilterContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_filter);
						setState(100);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(101);
						match(T__17);
						setState(102);
						filter(3);
						}
						break;
					}
					} 
				}
				setState(107);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AttNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(XPathParser.ID, 0); }
		public AttNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAttName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAttName(this);
		}
	}

	public final AttNameContext attName() throws RecognitionException {
		AttNameContext _localctx = new AttNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_attName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(ID);
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
	public static class TagNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(XPathParser.ID, 0); }
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitTagName(this);
		}
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tagName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(ID);
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
	public static class FilenameContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(XPathParser.String, 0); }
		public FilenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterFilename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitFilename(this);
		}
	}

	public final FilenameContext filename() throws RecognitionException {
		FilenameContext _localctx = new FilenameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_filename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(String);
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
	public static class XqContext extends ParserRuleContext {
		public XqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xq; }
	 
		public XqContext() { }
		public void copyFrom(XqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XQLetXQContext extends XqContext {
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XQLetXQContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterXQLetXQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitXQLetXQ(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XQChildPathXQContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XQChildPathXQContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterXQChildPathXQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitXQChildPathXQ(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XQForXQContext extends XqContext {
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public ReturnClauseContext returnClause() {
			return getRuleContext(ReturnClauseContext.class,0);
		}
		public List<LetClauseContext> letClause() {
			return getRuleContexts(LetClauseContext.class);
		}
		public LetClauseContext letClause(int i) {
			return getRuleContext(LetClauseContext.class,i);
		}
		public List<WhereClauseContext> whereClause() {
			return getRuleContexts(WhereClauseContext.class);
		}
		public WhereClauseContext whereClause(int i) {
			return getRuleContext(WhereClauseContext.class,i);
		}
		public XQForXQContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterXQForXQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitXQForXQ(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AbsolutePathDoubleSlashContext extends XqContext {
		public FilenameContext filename() {
			return getRuleContext(FilenameContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public AbsolutePathDoubleSlashContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAbsolutePathDoubleSlash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAbsolutePathDoubleSlash(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XQGroupXQContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XQGroupXQContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterXQGroupXQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitXQGroupXQ(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XQJoinXQContext extends XqContext {
		public List<JoinClauseContext> joinClause() {
			return getRuleContexts(JoinClauseContext.class);
		}
		public JoinClauseContext joinClause(int i) {
			return getRuleContext(JoinClauseContext.class,i);
		}
		public List<CommaContext> comma() {
			return getRuleContexts(CommaContext.class);
		}
		public CommaContext comma(int i) {
			return getRuleContext(CommaContext.class,i);
		}
		public XQJoinXQContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterXQJoinXQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitXQJoinXQ(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XQUnionXQContext extends XqContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public XQUnionXQContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterXQUnionXQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitXQUnionXQ(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AbsolutePathContext extends XqContext {
		public FilenameContext filename() {
			return getRuleContext(FilenameContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public AbsolutePathContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAbsolutePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAbsolutePath(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XQVariableContext extends XqContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public XQVariableContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterXQVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitXQVariable(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XQNestedElementXQContext extends XqContext {
		public List<TagNameContext> tagName() {
			return getRuleContexts(TagNameContext.class);
		}
		public TagNameContext tagName(int i) {
			return getRuleContext(TagNameContext.class,i);
		}
		public List<ElementXQContext> elementXQ() {
			return getRuleContexts(ElementXQContext.class);
		}
		public ElementXQContext elementXQ(int i) {
			return getRuleContext(ElementXQContext.class,i);
		}
		public List<CommaContext> comma() {
			return getRuleContexts(CommaContext.class);
		}
		public CommaContext comma(int i) {
			return getRuleContext(CommaContext.class,i);
		}
		public XQNestedElementXQContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterXQNestedElementXQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitXQNestedElementXQ(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XQStringConstantContext extends XqContext {
		public StringconstantContext stringconstant() {
			return getRuleContext(StringconstantContext.class,0);
		}
		public XQStringConstantContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterXQStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitXQStringConstant(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XQDescendantPathXQContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XQDescendantPathXQContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterXQDescendantPathXQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitXQDescendantPathXQ(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XQElementXQContext extends XqContext {
		public List<TagNameContext> tagName() {
			return getRuleContexts(TagNameContext.class);
		}
		public TagNameContext tagName(int i) {
			return getRuleContext(TagNameContext.class,i);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XQElementXQContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterXQElementXQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitXQElementXQ(this);
		}
	}

	public final XqContext xq() throws RecognitionException {
		return xq(0);
	}

	private XqContext xq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XqContext _localctx = new XqContext(_ctx, _parentState);
		XqContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_xq, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new XQVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(115);
				var();
				}
				break;
			case 2:
				{
				_localctx = new XQStringConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				stringconstant();
				}
				break;
			case 3:
				{
				_localctx = new AbsolutePathContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(118);
				match(T__4);
				setState(119);
				filename();
				setState(120);
				match(T__5);
				setState(121);
				match(T__7);
				setState(122);
				rp(0);
				}
				break;
			case 4:
				{
				_localctx = new AbsolutePathDoubleSlashContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(125);
				match(T__4);
				setState(126);
				filename();
				setState(127);
				match(T__5);
				setState(128);
				match(T__8);
				setState(129);
				rp(0);
				}
				break;
			case 5:
				{
				_localctx = new XQGroupXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				match(T__4);
				setState(132);
				xq(0);
				setState(133);
				match(T__5);
				}
				break;
			case 6:
				{
				_localctx = new XQElementXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				match(T__21);
				setState(136);
				tagName();
				setState(137);
				match(T__22);
				setState(138);
				match(T__23);
				setState(139);
				xq(0);
				setState(140);
				match(T__24);
				setState(141);
				match(T__25);
				setState(142);
				tagName();
				setState(143);
				match(T__22);
				}
				break;
			case 7:
				{
				_localctx = new XQNestedElementXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				match(T__21);
				setState(146);
				tagName();
				setState(147);
				match(T__22);
				setState(155); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(148);
					elementXQ();
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__11) {
						{
						{
						setState(149);
						comma();
						}
						}
						setState(154);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(157); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__21 );
				setState(159);
				match(T__25);
				setState(160);
				tagName();
				setState(161);
				match(T__22);
				}
				break;
			case 8:
				{
				_localctx = new XQForXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				forClause();
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__29) {
					{
					{
					setState(164);
					letClause();
					}
					}
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__32) {
					{
					{
					setState(170);
					whereClause();
					}
					}
					setState(175);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(176);
				returnClause();
				}
				break;
			case 9:
				{
				_localctx = new XQLetXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				letClause();
				setState(179);
				xq(2);
				}
				break;
			case 10:
				{
				_localctx = new XQJoinXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				joinClause();
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(185);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__11) {
							{
							{
							setState(182);
							comma();
							}
							}
							setState(187);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(188);
						joinClause();
						}
						} 
					}
					setState(193);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(205);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new XQUnionXQContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(196);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(197);
						match(T__11);
						setState(198);
						xq(9);
						}
						break;
					case 2:
						{
						_localctx = new XQChildPathXQContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(199);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(200);
						match(T__7);
						setState(201);
						rp(0);
						}
						break;
					case 3:
						{
						_localctx = new XQDescendantPathXQContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(202);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(203);
						match(T__8);
						setState(204);
						rp(0);
						}
						break;
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementXQContext extends ParserRuleContext {
		public ElementXQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementXQ; }
	 
		public ElementXQContext() { }
		public void copyFrom(ElementXQContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XQNestedElementContext extends ElementXQContext {
		public List<TagNameContext> tagName() {
			return getRuleContexts(TagNameContext.class);
		}
		public TagNameContext tagName(int i) {
			return getRuleContext(TagNameContext.class,i);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XQNestedElementContext(ElementXQContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterXQNestedElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitXQNestedElement(this);
		}
	}

	public final ElementXQContext elementXQ() throws RecognitionException {
		ElementXQContext _localctx = new ElementXQContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_elementXQ);
		try {
			_localctx = new XQNestedElementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__21);
			setState(211);
			tagName();
			setState(212);
			match(T__22);
			setState(213);
			match(T__23);
			setState(214);
			xq(0);
			setState(215);
			match(T__24);
			setState(216);
			match(T__25);
			setState(217);
			tagName();
			setState(218);
			match(T__22);
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
	public static class StringconstantContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(XPathParser.String, 0); }
		public StringconstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringconstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterStringconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitStringconstant(this);
		}
	}

	public final StringconstantContext stringconstant() throws RecognitionException {
		StringconstantContext _localctx = new StringconstantContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stringconstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(String);
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
	public static class JoinClauseContext extends ParserRuleContext {
		public JoinClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinClause; }
	 
		public JoinClauseContext() { }
		public void copyFrom(JoinClauseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RuleJoinClauseContext extends JoinClauseContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(XPathParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(XPathParser.ID, i);
		}
		public List<CommaContext> comma() {
			return getRuleContexts(CommaContext.class);
		}
		public CommaContext comma(int i) {
			return getRuleContext(CommaContext.class,i);
		}
		public RuleJoinClauseContext(JoinClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterRuleJoinClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitRuleJoinClause(this);
		}
	}

	public final JoinClauseContext joinClause() throws RecognitionException {
		JoinClauseContext _localctx = new JoinClauseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_joinClause);
		int _la;
		try {
			int _alt;
			_localctx = new RuleJoinClauseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(T__26);
			setState(223);
			match(T__4);
			setState(224);
			xq(0);
			setState(232); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__11) {
						{
						{
						setState(225);
						comma();
						}
						}
						setState(230);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(231);
					xq(0);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(234); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(236);
				comma();
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(242);
			match(T__9);
			setState(243);
			match(ID);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11 || _la==ID) {
				{
				{
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(244);
					comma();
					}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(250);
				match(ID);
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(256);
			match(T__10);
			setState(278); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(257);
					comma();
					}
					}
					setState(262);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(263);
				match(T__9);
				setState(264);
				match(ID);
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11 || _la==ID) {
					{
					{
					setState(268);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__11) {
						{
						{
						setState(265);
						comma();
						}
						}
						setState(270);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(271);
					match(ID);
					}
					}
					setState(276);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(277);
				match(T__10);
				}
				}
				setState(280); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 || _la==T__11 );
			setState(282);
			match(T__5);
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(283);
					comma();
					}
					} 
				}
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
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
	public static class ForClauseContext extends ParserRuleContext {
		public ForClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClause; }
	 
		public ForClauseContext() { }
		public void copyFrom(ForClauseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RuleForClauseContext extends ForClauseContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<CommaContext> comma() {
			return getRuleContexts(CommaContext.class);
		}
		public CommaContext comma(int i) {
			return getRuleContext(CommaContext.class,i);
		}
		public RuleForClauseContext(ForClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterRuleForClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitRuleForClause(this);
		}
	}

	public final ForClauseContext forClause() throws RecognitionException {
		ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_forClause);
		int _la;
		try {
			int _alt;
			_localctx = new RuleForClauseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(T__27);
			setState(290);
			var();
			setState(291);
			match(T__28);
			setState(292);
			xq(0);
			setState(305);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(296);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__11) {
						{
						{
						setState(293);
						comma();
						}
						}
						setState(298);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(299);
					var();
					setState(300);
					match(T__28);
					setState(301);
					xq(0);
					}
					} 
				}
				setState(307);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(308);
				comma();
				}
				}
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class LetClauseContext extends ParserRuleContext {
		public LetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letClause; }
	 
		public LetClauseContext() { }
		public void copyFrom(LetClauseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RuleLetClauseContext extends LetClauseContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public RuleLetClauseContext(LetClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterRuleLetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitRuleLetClause(this);
		}
	}

	public final LetClauseContext letClause() throws RecognitionException {
		LetClauseContext _localctx = new LetClauseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_letClause);
		int _la;
		try {
			_localctx = new RuleLetClauseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(T__29);
			setState(315);
			var();
			setState(316);
			match(T__30);
			setState(317);
			xq(0);
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(318);
				match(T__11);
				setState(319);
				var();
				setState(320);
				match(T__30);
				setState(321);
				xq(0);
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class ReturnClauseContext extends ParserRuleContext {
		public ReturnClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnClause; }
	 
		public ReturnClauseContext() { }
		public void copyFrom(ReturnClauseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RuleReturnClauseContext extends ReturnClauseContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public RuleReturnClauseContext(ReturnClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterRuleReturnClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitRuleReturnClause(this);
		}
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_returnClause);
		try {
			_localctx = new RuleReturnClauseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(T__31);
			setState(329);
			xq(0);
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
	public static class WhereClauseContext extends ParserRuleContext {
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
	 
		public WhereClauseContext() { }
		public void copyFrom(WhereClauseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RuleWhereClauseContext extends WhereClauseContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public RuleWhereClauseContext(WhereClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterRuleWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitRuleWhereClause(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_whereClause);
		try {
			_localctx = new RuleWhereClauseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(T__32);
			setState(332);
			cond(0);
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
	public static class CondContext extends ParserRuleContext {
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
	 
		public CondContext() { }
		public void copyFrom(CondContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CondOrContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public CondOrContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterCondOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitCondOr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CondAndContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public CondAndContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterCondAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitCondAnd(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CondDoubleEqualContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public CondDoubleEqualContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterCondDoubleEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitCondDoubleEqual(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GroupCondContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public GroupCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterGroupCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitGroupCond(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CondEmptyContext extends CondContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public CondEmptyContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterCondEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitCondEmpty(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CondSomeContext extends CondContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CondSomeContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterCondSome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitCondSome(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CondIsContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public CondIsContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterCondIs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitCondIs(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CondNotContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CondNotContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterCondNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitCondNot(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CondEqContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public CondEqContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterCondEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitCondEq(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CondEqualContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public CondEqualContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterCondEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitCondEqual(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_cond, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new CondEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(335);
				xq(0);
				setState(336);
				match(T__12);
				setState(337);
				xq(0);
				}
				break;
			case 2:
				{
				_localctx = new CondEqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(339);
				xq(0);
				setState(340);
				match(T__13);
				setState(341);
				xq(0);
				}
				break;
			case 3:
				{
				_localctx = new CondDoubleEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(343);
				xq(0);
				setState(344);
				match(T__14);
				setState(345);
				xq(0);
				}
				break;
			case 4:
				{
				_localctx = new CondIsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(347);
				xq(0);
				setState(348);
				match(T__15);
				setState(349);
				xq(0);
				}
				break;
			case 5:
				{
				_localctx = new CondEmptyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(351);
				match(T__33);
				setState(352);
				match(T__4);
				setState(353);
				xq(0);
				setState(354);
				match(T__5);
				}
				break;
			case 6:
				{
				_localctx = new CondNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(356);
				match(T__18);
				setState(357);
				cond(3);
				}
				break;
			case 7:
				{
				_localctx = new GroupCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(358);
				match(T__4);
				setState(359);
				cond(0);
				setState(360);
				match(T__5);
				}
				break;
			case 8:
				{
				_localctx = new CondSomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(362);
				match(T__34);
				setState(363);
				var();
				setState(364);
				match(T__28);
				setState(365);
				xq(0);
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(366);
					match(T__11);
					setState(367);
					var();
					setState(368);
					match(T__28);
					setState(369);
					xq(0);
					}
					}
					setState(375);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(376);
				match(T__35);
				setState(377);
				cond(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(389);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(387);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new CondAndContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(381);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(382);
						match(T__16);
						setState(383);
						cond(6);
						}
						break;
					case 2:
						{
						_localctx = new CondOrContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(384);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(385);
						match(T__17);
						setState(386);
						cond(5);
						}
						break;
					}
					} 
				}
				setState(391);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(XPathParser.ID, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			match(T__36);
			setState(393);
			match(ID);
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
	public static class CommaContext extends ParserRuleContext {
		public CommaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comma; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterComma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitComma(this);
		}
	}

	public final CommaContext comma() throws RecognitionException {
		CommaContext _localctx = new CommaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comma);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(T__11);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 1:
			return filter_sempred((FilterContext)_localctx, predIndex);
		case 5:
			return xq_sempred((XqContext)_localctx, predIndex);
		case 13:
			return cond_sempred((CondContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 1);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean filter_sempred(FilterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean xq_sempred(XqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001(\u018e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0003\u0000/\b\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000?\b\u0000\n\u0000\f\u0000B\t\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001`\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001h\b\u0001"+
		"\n\u0001\f\u0001k\t\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u0097\b\u0005\n\u0005\f\u0005\u009a"+
		"\t\u0005\u0004\u0005\u009c\b\u0005\u000b\u0005\f\u0005\u009d\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u00a6\b\u0005\n\u0005\f\u0005\u00a9\t\u0005\u0001\u0005\u0005\u0005\u00ac"+
		"\b\u0005\n\u0005\f\u0005\u00af\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00b8\b\u0005"+
		"\n\u0005\f\u0005\u00bb\t\u0005\u0001\u0005\u0005\u0005\u00be\b\u0005\n"+
		"\u0005\f\u0005\u00c1\t\u0005\u0003\u0005\u00c3\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005\u00ce\b\u0005\n\u0005\f\u0005\u00d1\t\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00e3\b\b\n\b\f\b\u00e6\t\b\u0001"+
		"\b\u0004\b\u00e9\b\b\u000b\b\f\b\u00ea\u0001\b\u0005\b\u00ee\b\b\n\b\f"+
		"\b\u00f1\t\b\u0001\b\u0001\b\u0001\b\u0005\b\u00f6\b\b\n\b\f\b\u00f9\t"+
		"\b\u0001\b\u0005\b\u00fc\b\b\n\b\f\b\u00ff\t\b\u0001\b\u0001\b\u0005\b"+
		"\u0103\b\b\n\b\f\b\u0106\t\b\u0001\b\u0001\b\u0001\b\u0005\b\u010b\b\b"+
		"\n\b\f\b\u010e\t\b\u0001\b\u0005\b\u0111\b\b\n\b\f\b\u0114\t\b\u0001\b"+
		"\u0004\b\u0117\b\b\u000b\b\f\b\u0118\u0001\b\u0001\b\u0005\b\u011d\b\b"+
		"\n\b\f\b\u0120\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0127"+
		"\b\t\n\t\f\t\u012a\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0130\b"+
		"\t\n\t\f\t\u0133\t\t\u0001\t\u0005\t\u0136\b\t\n\t\f\t\u0139\t\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u0144\b\n\n\n\f\n\u0147\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0005\r\u0174\b\r\n\r\f\r\u0177\t\r\u0001\r"+
		"\u0001\r\u0001\r\u0003\r\u017c\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u0184\b\r\n\r\f\r\u0187\t\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0000\u0004\u0000\u0002"+
		"\n\u001a\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e\u0000\u0001\u0001\u0000\u0014\u0015\u01ba\u0000"+
		".\u0001\u0000\u0000\u0000\u0002_\u0001\u0000\u0000\u0000\u0004l\u0001"+
		"\u0000\u0000\u0000\u0006n\u0001\u0000\u0000\u0000\bp\u0001\u0000\u0000"+
		"\u0000\n\u00c2\u0001\u0000\u0000\u0000\f\u00d2\u0001\u0000\u0000\u0000"+
		"\u000e\u00dc\u0001\u0000\u0000\u0000\u0010\u00de\u0001\u0000\u0000\u0000"+
		"\u0012\u0121\u0001\u0000\u0000\u0000\u0014\u013a\u0001\u0000\u0000\u0000"+
		"\u0016\u0148\u0001\u0000\u0000\u0000\u0018\u014b\u0001\u0000\u0000\u0000"+
		"\u001a\u017b\u0001\u0000\u0000\u0000\u001c\u0188\u0001\u0000\u0000\u0000"+
		"\u001e\u018b\u0001\u0000\u0000\u0000 !\u0006\u0000\uffff\uffff\u0000!"+
		"/\u0003\u0006\u0003\u0000\"/\u0005\u0001\u0000\u0000#/\u0005\u0002\u0000"+
		"\u0000$/\u0005\u0003\u0000\u0000%&\u0005\u0004\u0000\u0000&\'\u0005\u0005"+
		"\u0000\u0000\'/\u0005\u0006\u0000\u0000()\u0005\u0007\u0000\u0000)/\u0003"+
		"\u0004\u0002\u0000*+\u0005\u0005\u0000\u0000+,\u0003\u0000\u0000\u0000"+
		",-\u0005\u0006\u0000\u0000-/\u0001\u0000\u0000\u0000. \u0001\u0000\u0000"+
		"\u0000.\"\u0001\u0000\u0000\u0000.#\u0001\u0000\u0000\u0000.$\u0001\u0000"+
		"\u0000\u0000.%\u0001\u0000\u0000\u0000.(\u0001\u0000\u0000\u0000.*\u0001"+
		"\u0000\u0000\u0000/@\u0001\u0000\u0000\u000001\n\u0004\u0000\u000012\u0005"+
		"\b\u0000\u00002?\u0003\u0000\u0000\u000534\n\u0003\u0000\u000045\u0005"+
		"\t\u0000\u00005?\u0003\u0000\u0000\u000467\n\u0001\u0000\u000078\u0005"+
		"\f\u0000\u00008?\u0003\u0000\u0000\u00029:\n\u0002\u0000\u0000:;\u0005"+
		"\n\u0000\u0000;<\u0003\u0002\u0001\u0000<=\u0005\u000b\u0000\u0000=?\u0001"+
		"\u0000\u0000\u0000>0\u0001\u0000\u0000\u0000>3\u0001\u0000\u0000\u0000"+
		">6\u0001\u0000\u0000\u0000>9\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000"+
		"\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A\u0001\u0001"+
		"\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000CD\u0006\u0001\uffff\uffff"+
		"\u0000D`\u0003\u0000\u0000\u0000EF\u0003\u0000\u0000\u0000FG\u0005\r\u0000"+
		"\u0000GH\u0003\u0000\u0000\u0000H`\u0001\u0000\u0000\u0000IJ\u0003\u0000"+
		"\u0000\u0000JK\u0005\u000e\u0000\u0000KL\u0003\u0000\u0000\u0000L`\u0001"+
		"\u0000\u0000\u0000MN\u0003\u0000\u0000\u0000NO\u0005\u000f\u0000\u0000"+
		"OP\u0003\u0000\u0000\u0000P`\u0001\u0000\u0000\u0000QR\u0003\u0000\u0000"+
		"\u0000RS\u0005\u0010\u0000\u0000ST\u0003\u0000\u0000\u0000T`\u0001\u0000"+
		"\u0000\u0000UV\u0003\u0000\u0000\u0000VW\u0005\r\u0000\u0000WX\u0003\u000e"+
		"\u0007\u0000X`\u0001\u0000\u0000\u0000YZ\u0005\u0005\u0000\u0000Z[\u0003"+
		"\u0002\u0001\u0000[\\\u0005\u0006\u0000\u0000\\`\u0001\u0000\u0000\u0000"+
		"]^\u0005\u0013\u0000\u0000^`\u0003\u0002\u0001\u0001_C\u0001\u0000\u0000"+
		"\u0000_E\u0001\u0000\u0000\u0000_I\u0001\u0000\u0000\u0000_M\u0001\u0000"+
		"\u0000\u0000_Q\u0001\u0000\u0000\u0000_U\u0001\u0000\u0000\u0000_Y\u0001"+
		"\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000`i\u0001\u0000\u0000\u0000"+
		"ab\n\u0003\u0000\u0000bc\u0005\u0011\u0000\u0000ch\u0003\u0002\u0001\u0004"+
		"de\n\u0002\u0000\u0000ef\u0005\u0012\u0000\u0000fh\u0003\u0002\u0001\u0003"+
		"ga\u0001\u0000\u0000\u0000gd\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000"+
		"\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000j\u0003\u0001"+
		"\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000lm\u0005&\u0000\u0000m\u0005"+
		"\u0001\u0000\u0000\u0000no\u0005&\u0000\u0000o\u0007\u0001\u0000\u0000"+
		"\u0000pq\u0005\'\u0000\u0000q\t\u0001\u0000\u0000\u0000rs\u0006\u0005"+
		"\uffff\uffff\u0000s\u00c3\u0003\u001c\u000e\u0000t\u00c3\u0003\u000e\u0007"+
		"\u0000uv\u0007\u0000\u0000\u0000vw\u0005\u0005\u0000\u0000wx\u0003\b\u0004"+
		"\u0000xy\u0005\u0006\u0000\u0000yz\u0005\b\u0000\u0000z{\u0003\u0000\u0000"+
		"\u0000{\u00c3\u0001\u0000\u0000\u0000|}\u0007\u0000\u0000\u0000}~\u0005"+
		"\u0005\u0000\u0000~\u007f\u0003\b\u0004\u0000\u007f\u0080\u0005\u0006"+
		"\u0000\u0000\u0080\u0081\u0005\t\u0000\u0000\u0081\u0082\u0003\u0000\u0000"+
		"\u0000\u0082\u00c3\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u0005\u0000"+
		"\u0000\u0084\u0085\u0003\n\u0005\u0000\u0085\u0086\u0005\u0006\u0000\u0000"+
		"\u0086\u00c3\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0016\u0000\u0000"+
		"\u0088\u0089\u0003\u0006\u0003\u0000\u0089\u008a\u0005\u0017\u0000\u0000"+
		"\u008a\u008b\u0005\u0018\u0000\u0000\u008b\u008c\u0003\n\u0005\u0000\u008c"+
		"\u008d\u0005\u0019\u0000\u0000\u008d\u008e\u0005\u001a\u0000\u0000\u008e"+
		"\u008f\u0003\u0006\u0003\u0000\u008f\u0090\u0005\u0017\u0000\u0000\u0090"+
		"\u00c3\u0001\u0000\u0000\u0000\u0091\u0092\u0005\u0016\u0000\u0000\u0092"+
		"\u0093\u0003\u0006\u0003\u0000\u0093\u009b\u0005\u0017\u0000\u0000\u0094"+
		"\u0098\u0003\f\u0006\u0000\u0095\u0097\u0003\u001e\u000f\u0000\u0096\u0095"+
		"\u0001\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000\u0098\u0096"+
		"\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009c"+
		"\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009b\u0094"+
		"\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009b"+
		"\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u001a\u0000\u0000\u00a0\u00a1"+
		"\u0003\u0006\u0003\u0000\u00a1\u00a2\u0005\u0017\u0000\u0000\u00a2\u00c3"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a7\u0003\u0012\t\u0000\u00a4\u00a6\u0003"+
		"\u0014\n\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000"+
		"\u0000\u0000\u00a8\u00ad\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ac\u0003\u0018\f\u0000\u00ab\u00aa\u0001\u0000\u0000"+
		"\u0000\u00ac\u00af\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00b0\u0001\u0000\u0000"+
		"\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u00b1\u0003\u0016\u000b"+
		"\u0000\u00b1\u00c3\u0001\u0000\u0000\u0000\u00b2\u00b3\u0003\u0014\n\u0000"+
		"\u00b3\u00b4\u0003\n\u0005\u0002\u00b4\u00c3\u0001\u0000\u0000\u0000\u00b5"+
		"\u00bf\u0003\u0010\b\u0000\u00b6\u00b8\u0003\u001e\u000f\u0000\u00b7\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bc"+
		"\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00be"+
		"\u0003\u0010\b\u0000\u00bd\u00b9\u0001\u0000\u0000\u0000\u00be\u00c1\u0001"+
		"\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001"+
		"\u0000\u0000\u0000\u00c2r\u0001\u0000\u0000\u0000\u00c2t\u0001\u0000\u0000"+
		"\u0000\u00c2u\u0001\u0000\u0000\u0000\u00c2|\u0001\u0000\u0000\u0000\u00c2"+
		"\u0083\u0001\u0000\u0000\u0000\u00c2\u0087\u0001\u0000\u0000\u0000\u00c2"+
		"\u0091\u0001\u0000\u0000\u0000\u00c2\u00a3\u0001\u0000\u0000\u0000\u00c2"+
		"\u00b2\u0001\u0000\u0000\u0000\u00c2\u00b5\u0001\u0000\u0000\u0000\u00c3"+
		"\u00cf\u0001\u0000\u0000\u0000\u00c4\u00c5\n\b\u0000\u0000\u00c5\u00c6"+
		"\u0005\f\u0000\u0000\u00c6\u00ce\u0003\n\u0005\t\u00c7\u00c8\n\u0007\u0000"+
		"\u0000\u00c8\u00c9\u0005\b\u0000\u0000\u00c9\u00ce\u0003\u0000\u0000\u0000"+
		"\u00ca\u00cb\n\u0006\u0000\u0000\u00cb\u00cc\u0005\t\u0000\u0000\u00cc"+
		"\u00ce\u0003\u0000\u0000\u0000\u00cd\u00c4\u0001\u0000\u0000\u0000\u00cd"+
		"\u00c7\u0001\u0000\u0000\u0000\u00cd\u00ca\u0001\u0000\u0000\u0000\u00ce"+
		"\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d0\u000b\u0001\u0000\u0000\u0000\u00d1"+
		"\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005\u0016\u0000\u0000\u00d3"+
		"\u00d4\u0003\u0006\u0003\u0000\u00d4\u00d5\u0005\u0017\u0000\u0000\u00d5"+
		"\u00d6\u0005\u0018\u0000\u0000\u00d6\u00d7\u0003\n\u0005\u0000\u00d7\u00d8"+
		"\u0005\u0019\u0000\u0000\u00d8\u00d9\u0005\u001a\u0000\u0000\u00d9\u00da"+
		"\u0003\u0006\u0003\u0000\u00da\u00db\u0005\u0017\u0000\u0000\u00db\r\u0001"+
		"\u0000\u0000\u0000\u00dc\u00dd\u0005\'\u0000\u0000\u00dd\u000f\u0001\u0000"+
		"\u0000\u0000\u00de\u00df\u0005\u001b\u0000\u0000\u00df\u00e0\u0005\u0005"+
		"\u0000\u0000\u00e0\u00e8\u0003\n\u0005\u0000\u00e1\u00e3\u0003\u001e\u000f"+
		"\u0000\u00e2\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e6\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e7\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e9\u0003\n\u0005\u0000\u00e8\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000"+
		"\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ef\u0001\u0000\u0000\u0000"+
		"\u00ec\u00ee\u0003\u001e\u000f\u0000\u00ed\u00ec\u0001\u0000\u0000\u0000"+
		"\u00ee\u00f1\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005\n\u0000\u0000\u00f3"+
		"\u00fd\u0005&\u0000\u0000\u00f4\u00f6\u0003\u001e\u000f\u0000\u00f5\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f6\u00f9\u0001\u0000\u0000\u0000\u00f7\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8\u00fa"+
		"\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00fa\u00fc"+
		"\u0005&\u0000\u0000\u00fb\u00f7\u0001\u0000\u0000\u0000\u00fc\u00ff\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001"+
		"\u0000\u0000\u0000\u00fe\u0100\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001"+
		"\u0000\u0000\u0000\u0100\u0116\u0005\u000b\u0000\u0000\u0101\u0103\u0003"+
		"\u001e\u000f\u0000\u0102\u0101\u0001\u0000\u0000\u0000\u0103\u0106\u0001"+
		"\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0104\u0105\u0001"+
		"\u0000\u0000\u0000\u0105\u0107\u0001\u0000\u0000\u0000\u0106\u0104\u0001"+
		"\u0000\u0000\u0000\u0107\u0108\u0005\n\u0000\u0000\u0108\u0112\u0005&"+
		"\u0000\u0000\u0109\u010b\u0003\u001e\u000f\u0000\u010a\u0109\u0001\u0000"+
		"\u0000\u0000\u010b\u010e\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000"+
		"\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u010f\u0001\u0000"+
		"\u0000\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010f\u0111\u0005&\u0000"+
		"\u0000\u0110\u010c\u0001\u0000\u0000\u0000\u0111\u0114\u0001\u0000\u0000"+
		"\u0000\u0112\u0110\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000"+
		"\u0000\u0113\u0115\u0001\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000"+
		"\u0000\u0115\u0117\u0005\u000b\u0000\u0000\u0116\u0104\u0001\u0000\u0000"+
		"\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000"+
		"\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000"+
		"\u0000\u011a\u011e\u0005\u0006\u0000\u0000\u011b\u011d\u0003\u001e\u000f"+
		"\u0000\u011c\u011b\u0001\u0000\u0000\u0000\u011d\u0120\u0001\u0000\u0000"+
		"\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000"+
		"\u0000\u011f\u0011\u0001\u0000\u0000\u0000\u0120\u011e\u0001\u0000\u0000"+
		"\u0000\u0121\u0122\u0005\u001c\u0000\u0000\u0122\u0123\u0003\u001c\u000e"+
		"\u0000\u0123\u0124\u0005\u001d\u0000\u0000\u0124\u0131\u0003\n\u0005\u0000"+
		"\u0125\u0127\u0003\u001e\u000f\u0000\u0126\u0125\u0001\u0000\u0000\u0000"+
		"\u0127\u012a\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000"+
		"\u0128\u0129\u0001\u0000\u0000\u0000\u0129\u012b\u0001\u0000\u0000\u0000"+
		"\u012a\u0128\u0001\u0000\u0000\u0000\u012b\u012c\u0003\u001c\u000e\u0000"+
		"\u012c\u012d\u0005\u001d\u0000\u0000\u012d\u012e\u0003\n\u0005\u0000\u012e"+
		"\u0130\u0001\u0000\u0000\u0000\u012f\u0128\u0001\u0000\u0000\u0000\u0130"+
		"\u0133\u0001\u0000\u0000\u0000\u0131\u012f\u0001\u0000\u0000\u0000\u0131"+
		"\u0132\u0001\u0000\u0000\u0000\u0132\u0137\u0001\u0000\u0000\u0000\u0133"+
		"\u0131\u0001\u0000\u0000\u0000\u0134\u0136\u0003\u001e\u000f\u0000\u0135"+
		"\u0134\u0001\u0000\u0000\u0000\u0136\u0139\u0001\u0000\u0000\u0000\u0137"+
		"\u0135\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138"+
		"\u0013\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000\u0000\u0000\u013a"+
		"\u013b\u0005\u001e\u0000\u0000\u013b\u013c\u0003\u001c\u000e\u0000\u013c"+
		"\u013d\u0005\u001f\u0000\u0000\u013d\u0145\u0003\n\u0005\u0000\u013e\u013f"+
		"\u0005\f\u0000\u0000\u013f\u0140\u0003\u001c\u000e\u0000\u0140\u0141\u0005"+
		"\u001f\u0000\u0000\u0141\u0142\u0003\n\u0005\u0000\u0142\u0144\u0001\u0000"+
		"\u0000\u0000\u0143\u013e\u0001\u0000\u0000\u0000\u0144\u0147\u0001\u0000"+
		"\u0000\u0000\u0145\u0143\u0001\u0000\u0000\u0000\u0145\u0146\u0001\u0000"+
		"\u0000\u0000\u0146\u0015\u0001\u0000\u0000\u0000\u0147\u0145\u0001\u0000"+
		"\u0000\u0000\u0148\u0149\u0005 \u0000\u0000\u0149\u014a\u0003\n\u0005"+
		"\u0000\u014a\u0017\u0001\u0000\u0000\u0000\u014b\u014c\u0005!\u0000\u0000"+
		"\u014c\u014d\u0003\u001a\r\u0000\u014d\u0019\u0001\u0000\u0000\u0000\u014e"+
		"\u014f\u0006\r\uffff\uffff\u0000\u014f\u0150\u0003\n\u0005\u0000\u0150"+
		"\u0151\u0005\r\u0000\u0000\u0151\u0152\u0003\n\u0005\u0000\u0152\u017c"+
		"\u0001\u0000\u0000\u0000\u0153\u0154\u0003\n\u0005\u0000\u0154\u0155\u0005"+
		"\u000e\u0000\u0000\u0155\u0156\u0003\n\u0005\u0000\u0156\u017c\u0001\u0000"+
		"\u0000\u0000\u0157\u0158\u0003\n\u0005\u0000\u0158\u0159\u0005\u000f\u0000"+
		"\u0000\u0159\u015a\u0003\n\u0005\u0000\u015a\u017c\u0001\u0000\u0000\u0000"+
		"\u015b\u015c\u0003\n\u0005\u0000\u015c\u015d\u0005\u0010\u0000\u0000\u015d"+
		"\u015e\u0003\n\u0005\u0000\u015e\u017c\u0001\u0000\u0000\u0000\u015f\u0160"+
		"\u0005\"\u0000\u0000\u0160\u0161\u0005\u0005\u0000\u0000\u0161\u0162\u0003"+
		"\n\u0005\u0000\u0162\u0163\u0005\u0006\u0000\u0000\u0163\u017c\u0001\u0000"+
		"\u0000\u0000\u0164\u0165\u0005\u0013\u0000\u0000\u0165\u017c\u0003\u001a"+
		"\r\u0003\u0166\u0167\u0005\u0005\u0000\u0000\u0167\u0168\u0003\u001a\r"+
		"\u0000\u0168\u0169\u0005\u0006\u0000\u0000\u0169\u017c\u0001\u0000\u0000"+
		"\u0000\u016a\u016b\u0005#\u0000\u0000\u016b\u016c\u0003\u001c\u000e\u0000"+
		"\u016c\u016d\u0005\u001d\u0000\u0000\u016d\u0175\u0003\n\u0005\u0000\u016e"+
		"\u016f\u0005\f\u0000\u0000\u016f\u0170\u0003\u001c\u000e\u0000\u0170\u0171"+
		"\u0005\u001d\u0000\u0000\u0171\u0172\u0003\n\u0005\u0000\u0172\u0174\u0001"+
		"\u0000\u0000\u0000\u0173\u016e\u0001\u0000\u0000\u0000\u0174\u0177\u0001"+
		"\u0000\u0000\u0000\u0175\u0173\u0001\u0000\u0000\u0000\u0175\u0176\u0001"+
		"\u0000\u0000\u0000\u0176\u0178\u0001\u0000\u0000\u0000\u0177\u0175\u0001"+
		"\u0000\u0000\u0000\u0178\u0179\u0005$\u0000\u0000\u0179\u017a\u0003\u001a"+
		"\r\u0001\u017a\u017c\u0001\u0000\u0000\u0000\u017b\u014e\u0001\u0000\u0000"+
		"\u0000\u017b\u0153\u0001\u0000\u0000\u0000\u017b\u0157\u0001\u0000\u0000"+
		"\u0000\u017b\u015b\u0001\u0000\u0000\u0000\u017b\u015f\u0001\u0000\u0000"+
		"\u0000\u017b\u0164\u0001\u0000\u0000\u0000\u017b\u0166\u0001\u0000\u0000"+
		"\u0000\u017b\u016a\u0001\u0000\u0000\u0000\u017c\u0185\u0001\u0000\u0000"+
		"\u0000\u017d\u017e\n\u0005\u0000\u0000\u017e\u017f\u0005\u0011\u0000\u0000"+
		"\u017f\u0184\u0003\u001a\r\u0006\u0180\u0181\n\u0004\u0000\u0000\u0181"+
		"\u0182\u0005\u0012\u0000\u0000\u0182\u0184\u0003\u001a\r\u0005\u0183\u017d"+
		"\u0001\u0000\u0000\u0000\u0183\u0180\u0001\u0000\u0000\u0000\u0184\u0187"+
		"\u0001\u0000\u0000\u0000\u0185\u0183\u0001\u0000\u0000\u0000\u0185\u0186"+
		"\u0001\u0000\u0000\u0000\u0186\u001b\u0001\u0000\u0000\u0000\u0187\u0185"+
		"\u0001\u0000\u0000\u0000\u0188\u0189\u0005%\u0000\u0000\u0189\u018a\u0005"+
		"&\u0000\u0000\u018a\u001d\u0001\u0000\u0000\u0000\u018b\u018c\u0005\f"+
		"\u0000\u0000\u018c\u001f\u0001\u0000\u0000\u0000!.>@_gi\u0098\u009d\u00a7"+
		"\u00ad\u00b9\u00bf\u00c2\u00cd\u00cf\u00e4\u00ea\u00ef\u00f7\u00fd\u0104"+
		"\u010c\u0112\u0118\u011e\u0128\u0131\u0137\u0145\u0175\u017b\u0183\u0185";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}