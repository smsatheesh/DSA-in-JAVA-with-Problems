import java.io.*;
import java.util.*;

class PriorityQueueImplementation {

	public static class PriorityQueue {
		
		ArrayList<Integer> list;
		
		public PriorityQueue() {
			list = new ArrayList<Integer>();
		}
		
		public void add( int ele ) {
			
			list.add( ele );
			upHeapify( this.size() - 1 );
		}
		
		public void remove() {
			
			if( this.size() == 0 )
				System.out.println( "Underflow" );
			else {
				
				swap( 0, this.size() - 1 );
				int value = list.remove(0);
				System.out.println( "Element removed was " + value );
				downHeapify(0);
			}
		}
		
		public void peek() {
			
			if( this.size() == 0 )
				System.out.println( "Underflow" );
			else {
				
				System.out.println( list.get( 0 ) + " is the peek element" );
			}
		}
		
		public void print() {
			
			System.out.println( Arrays.toString( list.toArray() ) );
		}
		
		public void upHeapify(int var) {
			if( var == 0 )
				return;
			else {
				
				int parent = (var - 1) / 2;
				
				if( list.get(parent) > list.get(var) ) {
					
					swap(parent, var);
					upHeapify(parent);
				}
			}
		}
		
		public void downHeapify( int loopVar ) {
			
			int largest = loopVar;
			
			int leftChild = ( loopVar * 2 ) + 1;
			int rightChild = ( loopVar * 2 ) + 2;
		
			if( leftChild < this.size() && list.get( largest ) < list.get(leftChild) )
				largest = leftChild;
			
			if( rightChild < this.size() && list.get( largest ) < list.get(rightChild) )
				largest = rightChild;
			
			if( loopVar != largest ) {
				
				swap( largest, loopVar );
				downHeapify( largest );
			}
		}
		
		public void swap( int a, int b ) {
			
			int ith = list.get( a );
			int jth = list.get( b );
			
			list.set( a, jth );
			list.set( b, ith );
			
		}
		
		public int size() {
			
			return this.list.size();
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		PriorityQueue pq = new PriorityQueue();
		
		String str = "" ;
		System.out.println( "PRIORITY QUEUE IMPLEMENTATION" );
		System.out.println( "\n\nadd ...( element )\npeek\nremove\nprint\nexit" );
		while( str.equals( "exit" ) == false ) {
			
			System.out.print( "Enter operation :: " );
			str = br.readLine();
			str = str.toLowerCase();
			if( str.startsWith( "add" ) ) {
				
				int value = Integer.parseInt( str.split(" ")[1] );
				pq.add( value );
			} else if( str.startsWith( "remove" ) ) {
				
				pq.remove();
			} else if( str.startsWith( "peek" ) ) {
				
				pq.peek();
			} else if( str.startsWith( "size" ) ) {
				
				System.out.println(pq.size() + " is the size");
			} else if( str.startsWith( "print" ) ) {
				
				pq.print();
			}
		}
		
		System.out.println( "Successfully terminated !" );
	}
}