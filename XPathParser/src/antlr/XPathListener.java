package antlr;// Generated from XPath.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathParser}.
 */
public interface XPathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code FilteredPath}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterFilteredPath(XPathParser.FilteredPathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilteredPath}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitFilteredPath(XPathParser.FilteredPathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Group}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterGroup(XPathParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Group}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitGroup(XPathParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChildPath}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterChildPath(XPathParser.ChildPathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChildPath}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitChildPath(XPathParser.ChildPathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnionPath}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterUnionPath(XPathParser.UnionPathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnionPath}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitUnionPath(XPathParser.UnionPathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Wildcard}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterWildcard(XPathParser.WildcardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Wildcard}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitWildcard(XPathParser.WildcardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParent(XPathParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParent(XPathParser.ParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Attribute}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(XPathParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Attribute}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(XPathParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TextFunction}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTextFunction(XPathParser.TextFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TextFunction}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTextFunction(XPathParser.TextFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DescendantPath}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterDescendantPath(XPathParser.DescendantPathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DescendantPath}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitDescendantPath(XPathParser.DescendantPathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Tag}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTag(XPathParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Tag}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTag(XPathParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Self}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSelf(XPathParser.SelfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Self}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSelf(XPathParser.SelfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterAndFilter(XPathParser.AndFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitAndFilter(XPathParser.AndFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IsFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterIsFilter(XPathParser.IsFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IsFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitIsFilter(XPathParser.IsFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterNotFilter(XPathParser.NotFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitNotFilter(XPathParser.NotFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilterRp(XPathParser.FilterRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilterRp(XPathParser.FilterRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GroupFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterGroupFilter(XPathParser.GroupFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GroupFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitGroupFilter(XPathParser.GroupFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterEqualFilter(XPathParser.EqualFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitEqualFilter(XPathParser.EqualFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterEqFilter(XPathParser.EqFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitEqFilter(XPathParser.EqFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleEqualFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterDoubleEqualFilter(XPathParser.DoubleEqualFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleEqualFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitDoubleEqualFilter(XPathParser.DoubleEqualFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterOrFilter(XPathParser.OrFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitOrFilter(XPathParser.OrFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringEqualFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterStringEqualFilter(XPathParser.StringEqualFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringEqualFilter}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitStringEqualFilter(XPathParser.StringEqualFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#attName}.
	 * @param ctx the parse tree
	 */
	void enterAttName(XPathParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#attName}.
	 * @param ctx the parse tree
	 */
	void exitAttName(XPathParser.AttNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XPathParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XPathParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#filename}.
	 * @param ctx the parse tree
	 */
	void enterFilename(XPathParser.FilenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#filename}.
	 * @param ctx the parse tree
	 */
	void exitFilename(XPathParser.FilenameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQLetXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQLetXQ(XPathParser.XQLetXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQLetXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQLetXQ(XPathParser.XQLetXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQChildPathXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQChildPathXQ(XPathParser.XQChildPathXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQChildPathXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQChildPathXQ(XPathParser.XQChildPathXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQForXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQForXQ(XPathParser.XQForXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQForXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQForXQ(XPathParser.XQForXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AbsolutePathDoubleSlash}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterAbsolutePathDoubleSlash(XPathParser.AbsolutePathDoubleSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AbsolutePathDoubleSlash}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitAbsolutePathDoubleSlash(XPathParser.AbsolutePathDoubleSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQGroupXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQGroupXQ(XPathParser.XQGroupXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQGroupXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQGroupXQ(XPathParser.XQGroupXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQJoinXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQJoinXQ(XPathParser.XQJoinXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQJoinXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQJoinXQ(XPathParser.XQJoinXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQUnionXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQUnionXQ(XPathParser.XQUnionXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQUnionXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQUnionXQ(XPathParser.XQUnionXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AbsolutePath}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterAbsolutePath(XPathParser.AbsolutePathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AbsolutePath}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitAbsolutePath(XPathParser.AbsolutePathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQVariable}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQVariable(XPathParser.XQVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQVariable}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQVariable(XPathParser.XQVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQNestedElementXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQNestedElementXQ(XPathParser.XQNestedElementXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQNestedElementXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQNestedElementXQ(XPathParser.XQNestedElementXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQStringConstant}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQStringConstant(XPathParser.XQStringConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQStringConstant}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQStringConstant(XPathParser.XQStringConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQDescendantPathXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQDescendantPathXQ(XPathParser.XQDescendantPathXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQDescendantPathXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQDescendantPathXQ(XPathParser.XQDescendantPathXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQElementXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQElementXQ(XPathParser.XQElementXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQElementXQ}
	 * labeled alternative in {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQElementXQ(XPathParser.XQElementXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQNestedElement}
	 * labeled alternative in {@link XPathParser#elementXQ}.
	 * @param ctx the parse tree
	 */
	void enterXQNestedElement(XPathParser.XQNestedElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQNestedElement}
	 * labeled alternative in {@link XPathParser#elementXQ}.
	 * @param ctx the parse tree
	 */
	void exitXQNestedElement(XPathParser.XQNestedElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#stringconstant}.
	 * @param ctx the parse tree
	 */
	void enterStringconstant(XPathParser.StringconstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#stringconstant}.
	 * @param ctx the parse tree
	 */
	void exitStringconstant(XPathParser.StringconstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RuleJoinClause}
	 * labeled alternative in {@link XPathParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void enterRuleJoinClause(XPathParser.RuleJoinClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RuleJoinClause}
	 * labeled alternative in {@link XPathParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void exitRuleJoinClause(XPathParser.RuleJoinClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RuleForClause}
	 * labeled alternative in {@link XPathParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterRuleForClause(XPathParser.RuleForClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RuleForClause}
	 * labeled alternative in {@link XPathParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitRuleForClause(XPathParser.RuleForClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RuleLetClause}
	 * labeled alternative in {@link XPathParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterRuleLetClause(XPathParser.RuleLetClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RuleLetClause}
	 * labeled alternative in {@link XPathParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitRuleLetClause(XPathParser.RuleLetClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RuleReturnClause}
	 * labeled alternative in {@link XPathParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterRuleReturnClause(XPathParser.RuleReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RuleReturnClause}
	 * labeled alternative in {@link XPathParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitRuleReturnClause(XPathParser.RuleReturnClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RuleWhereClause}
	 * labeled alternative in {@link XPathParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterRuleWhereClause(XPathParser.RuleWhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RuleWhereClause}
	 * labeled alternative in {@link XPathParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitRuleWhereClause(XPathParser.RuleWhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondOr}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondOr(XPathParser.CondOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondOr}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondOr(XPathParser.CondOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondAnd}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondAnd(XPathParser.CondAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondAnd}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondAnd(XPathParser.CondAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondDoubleEqual}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondDoubleEqual(XPathParser.CondDoubleEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondDoubleEqual}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondDoubleEqual(XPathParser.CondDoubleEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GroupCond}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterGroupCond(XPathParser.GroupCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GroupCond}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitGroupCond(XPathParser.GroupCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondEmpty}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondEmpty(XPathParser.CondEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondEmpty}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondEmpty(XPathParser.CondEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondSome}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondSome(XPathParser.CondSomeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondSome}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondSome(XPathParser.CondSomeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondIs}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondIs(XPathParser.CondIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondIs}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondIs(XPathParser.CondIsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondNot}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondNot(XPathParser.CondNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondNot}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondNot(XPathParser.CondNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondEq}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondEq(XPathParser.CondEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondEq}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondEq(XPathParser.CondEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondEqual}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondEqual(XPathParser.CondEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondEqual}
	 * labeled alternative in {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondEqual(XPathParser.CondEqualContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(XPathParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(XPathParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#comma}.
	 * @param ctx the parse tree
	 */
	void enterComma(XPathParser.CommaContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#comma}.
	 * @param ctx the parse tree
	 */
	void exitComma(XPathParser.CommaContext ctx);
}