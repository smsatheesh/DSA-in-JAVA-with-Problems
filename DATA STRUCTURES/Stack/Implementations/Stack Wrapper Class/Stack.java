import java.util.*;

public class Stack {
		
	public static void main( String[] args ) {
	
		Stack<Integer> stack = new Stack<Integer>();
		
		// Insertion of elements in stack
		stack.push( 100 );
		stack.push( 200 );
		stack.push( 300 );
		
		System.out.println( "Top of the stack -> " + stack.peek());
		System.out.println( "Size of the stack -> " + stack.size());
		System.out.println( "Popped element from the stack -> " + stack.pop());
		System.out.println( "Top of the stack -> " + stack.peek());
		System.out.println( "Elements in the stack are : " + stack );
		System.out.println( "Element 100 present in the stack ? " + stack.search( 100 ));
		System.out.println( "Element 400 present in the stack ? " + stack.search( 400 ));
	}
}