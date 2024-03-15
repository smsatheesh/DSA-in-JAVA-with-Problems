import java.util.*;

public class Main {
		
	static boolean checkPair( char val1, char val2 ) {
	
		return (( val1 == '(' && val2 == ')') || ( val1 == '{' && val2 == '}' ) || ( val1 == '[' && val2 == ']' ));
	}
	
	static boolean checkExpression( char[] exp ) {
		
		Stack<Character> stack = new Stack<Character>();
		for( int i = 0; i < exp.length; i++ ) {
			if( exp[i] == '{' || exp[i] == '[' || exp[i] == '(' ) {
				stack.push( exp[i] );
				continue;
			} else {
				if( stack.isEmpty() ) {
					System.out.println( "Empty stack" );
					return false;
				} else if( checkPair( stack.peek(), exp[i] )) {
					stack.pop();
					continue;
				}
			}
			return false;
		}
		
		if( stack.isEmpty() )
			return true;
		else
			return false;
	}
	
	public static void main( String[] args ) {
	
		char[] exp = { '(', '{', '}', '[', ']', ')' };
		System.out.println( checkExpression( exp )? "Valid expression" : "Invalid expression" );
	}
}