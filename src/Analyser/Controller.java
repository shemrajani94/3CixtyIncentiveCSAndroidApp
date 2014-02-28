package Analyser;

import java.io.IOException;

import java_cup.runtime.Symbol;

import Analyser.Sym;
import static Analyser.Sym.*;

public class Controller {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Lex lexer = new Lex (System.in);
		while (true) {
			
			Symbol s = lexer.next_token();
			
			if (s == null) {
				System.out.println ("EOF");
				return;
			}
			
			switch (s.sym) {
			
				case ID: 
				case INT:

				System.out.printf ("%s(\"%s\")%n",s, lexer.lexeme);
				break;
				
				default:
					
				System.out.println (s);
			
			}
		}
	}
	
}
