
package Analyser;

import java_cup.runtime.*;
import java.io.IOException;

import Analyser.Sym;
import static Analyser.Sym.*;

%%

%class Lex

%unicode
%line
%column

// %public
%final
// %abstract

%cupsym Analyser.Sym
%cup
// %cupdebug

%init{
	// TODO: code that goes to constructor
%init}

%{

	public String lexeme;

	private Symbol sym(int type)
	{
		return sym(type, yytext());
	}

	private Symbol sym(int type, Object value)
	{
		return new Symbol(type, yyline, yycolumn, value);
	}

	private void error()
	throws IOException
	{
		throw new IOException("illegal text at line = "+yyline+", column = "+yycolumn+", text = '"+yytext()+"'");
	}
%}

L = [a-zA-Z_]                                           //letters
D = [0-9]                                               //digits
WHITE = [ \t\r\n]                                       //whitespace

%%

{WHITE} { /* Ignore */ }
"//".* { /* Ignore */ }
"=" { return sym(ASSIGN); }
"==" { return sym(EQUALS); }
"+" { return sym(PLUS); }
"*" { return sym(TIMES); }
{L}({L}|{D})* { lexeme = yytext (); return sym(ID); }   //variable name
[-+]?{D}+ { lexeme = yytext (); return sym(INT); }      //positive or negative number
. { System.out.println ("<ERROR>"); }                   //anything other symbols, print error

