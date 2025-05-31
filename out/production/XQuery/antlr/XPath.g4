grammar XPath;

//// 入口规则
// 绝对路径：doc(filename) / rp | doc(filename) // rp


// 相对路径：tagName | * | . | .. | text() | @attName | (rp) | rp1/rp2 | rp1//rp2 | rp[f] | rp1,rp2
rp : tagName                                              #Tag
   | '*'                                                  #Wildcard
   | '.'                                                  #Self
   | '..'                                                 #Parent
   | 'text' '(' ')'                                       #TextFunction
   | '@' attName                                          #Attribute
   | '(' rp ')'                                           #Group
   | rp '/' rp                                            #ChildPath
   | rp '//' rp                                           #DescendantPath
   | rp '[' filter ']'                                    #FilteredPath
   | rp ',' rp                                            #UnionPath
   ;

// 过滤条件：rp | rp1 = rp2 | rp1 eq rp2 | rp1 == rp2 | rp1 is rp2 | rp = StringConstant |  rp1 and rp2 | rp1 or rp2 | (f) | not f
filter: rp                                                #FilterRp
      | rp '=' rp                                         #EqualFilter
      | rp 'eq' rp                                        #EqFilter
      | rp '==' rp                                        #DoubleEqualFilter
      | rp 'is' rp                                        #IsFilter
      | rp '=' stringconstant                             #StringEqualFilter
      | '(' filter ')'                                    #GroupFilter
      | filter 'and' filter                               #AndFilter
      | filter 'or' filter                                #OrFilter
      | 'not' filter                                      #NotFilter
      ;


attName: ID;

tagName: ID;

filename
    : String;


// Var | StringConstant | ap | (XQ) | XQ,XQ | XQ/rp | XQ//rp | <tagName>{XQ}</tagName> | forCluase letClause whereClause returnClause | letClause XQ
// FIXME: ap 两个 没有XQ开头
xq:   var                                                  #XQVariable
    | stringconstant                                       #XQStringConstant
    //| ap                                                   #XQApPath
    | ('document' | 'doc') '(' filename ')' '/' rp                   #AbsolutePath
    | ('document' | 'doc') '(' filename ')' '//' rp                  #AbsolutePathDoubleSlash
    | '(' xq ')'                                           #XQGroupXQ
    | xq ',' xq                                            #XQUnionXQ
    | xq '/' rp                                            #XQChildPathXQ
    | xq '//' rp                                           #XQDescendantPathXQ
    | '<' tagName '>' '{' xq '}' '</' tagName '>'          #XQElementXQ
    | '<' tagName '>' (elementXQ(comma)*)+ '</' tagName '>'        #XQNestedElementXQ
    | forClause (letClause)* (whereClause)* returnClause   #XQForXQ
    | letClause xq                                         #XQLetXQ
    | joinClause ((comma)* joinClause)*                         #XQJoinXQ
    ;

elementXQ:
    '<' tagName '>' '{' xq '}' '</' tagName '>'  #XQNestedElement;

stringconstant
    : String;

joinClause:
    'join' '(' xq ((comma)* xq)+ (comma)* '[' ID ((comma)*ID)* ']' ((comma)* '[' ID ((comma)*ID)* ']' )+ ')' (comma)*  #RuleJoinClause;

// for var in XQ, ... , var in XQ
forClause:
    'for' var 'in' xq ((comma)* var 'in' xq)* (comma)*                #RuleForClause;

letClause:
    'let' var ':=' xq (',' var ':=' xq)*                 #RuleLetClause;

returnClause:
    'return' xq                                          #RuleReturnClause;

whereClause:
    'where' cond                                         #RuleWhereClause;

// XQ = XQ | XQ eq XQ | XQ == XQ | XQ is XQ | empty(XQ) | Cond and Cond | Cond or Cond | not Cond | (Cond) | some var in XQ , ... , var in XQ satisfies Cond
cond:     xq '=' xq                                                 #CondEqual
        | xq 'eq' xq                                                #CondEq
        | xq '==' xq                                                #CondDoubleEqual
        | xq 'is' xq                                                #CondIs
        | 'empty' '(' xq ')'                                        #CondEmpty
        | cond 'and' cond                                           #CondAnd
        | cond 'or' cond                                            #CondOr
        | 'not' cond                                                #CondNot
        | '(' cond ')'                                              #GroupCond
        | 'some' var 'in' xq (',' var 'in' xq)* 'satisfies' cond    #CondSome
    ;



var:
    '$'ID;

ID
    : [a-zA-Z_][a-zA-Z0-9_-]*;

String
    : '"' (~["])* '"'
    | '\'' (~['])* '\''
    ;

WS
    : [ \t\r\n]+ -> skip;

comma:
    ',';

//COMMENT
//    : '/*' .*? '*/' -> skip;