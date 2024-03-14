import java.util.*;

public class Stack {
	
	int top;
	int capacity;
	List<Integer> arrStack;
	
	Stack( int size ) {
		top = -1;
		capacity = size;
		arrStack = new ArrayList<Integer>( size );
	}
		
	boolean push( int element ) {
		
		if( isFull() ) {
			System.out.println( "Stack overflow" );
			return false;
		} else {
			
			arrStack.add( element );
			System.out.println( element + " pushed into the stack" );
			++top;
			return true;
		}
	}
	
	int pop() {
		
		if( isEmpty() ) {
			System.out.println( "Stack underflow" );
			return 0;
		} else {
			int ele = arrStack.remove( --top );
			return ele;
		}
	}
	
	int peek() {
		
		if( isEmpty() ) {
			System.out.println( "Stack underflow" );
			return 0;
		} else {
			int ele = arrStack.get( top );
			return ele;
		}
	}
	
	int size() {
		return ( top + 1 );
	}
	
	boolean isEmpty() {
		return ( top < 0 ) ? true: false;
	}
	
	boolean isFull() {
		return ( top >= ( capacity + 1 ));
	}
	
	static void print( Stack s ) {
		
		System.out.println( "Elements in the stack are : " );
		for( int loop = s.top; loop >= 0; --loop ) {
			if( loop != 0 )
				System.out.print( s.arrStack.get( loop ) + ", " );
			else
				System.out.print( s.arrStack.get( loop ));
		}
	}
	
	public static void main( String[] args ) {
	
		Stack s = new Stack( 5 );
		s.push( 10 );
		s.push( 20 );
		s.push( 30 );
		System.out.println( "Element " + s.pop() + " removed from the stack" );
		System.out.println( "Size of the stack is " + s.size());
        System.out.println( s.peek() + " is the top element" );
        System.out.println( s.isEmpty() ? "Stack is Empty" : "Stack is not Empty" );
        System.out.println( s.isFull() ? "Stack is Full" : "Stack is not Full" );
		print( s );
		
	}
}