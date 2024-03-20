class Node {
	
	int data;
	Node next;
	
	Node( int data ) {
		this.data = data;
		next = null;
	}
}

public class LinkedList {
	
	static Node insertStart( Node head, int data ) {
		
		Node newNode = new Node( data );
		newNode.next = head;
		head = newNode;
		return head;
	}
	
	static Node insertLast( Node head, int data ) {
		
		Node newNode = new Node( data );
		
		if( head == null ) {
			
			head = newNode;
			return head;
		}
		
		Node temp = head;
		
		while( temp.next != null ) {
			temp = temp.next;
		}
		
		temp.next = newNode;
		return head;
	}
	
	static Node insertPosition( Node head, int position, int data ) {
		
		int size = calculateSize( head );
		if( position == 0 ) {
			
			head = insertStart( head, data );
			return head;
		} else if( position < 1 || position > size ) {
			System.out.println( "Check the position " + position + " is available" );
			return head;
		} else {
			
			Node newNode = new Node( data );
			
			if( head == null ) {
				
				head = newNode;
				return head;
			}
			
			Node temp = head;
			while( --position > 0 ) {
				temp = temp.next;
			}
			
			newNode.next = temp.next;
			temp.next = newNode;
			return head;
		}
	}
	
	static int calculateSize( Node head ) {
		
		int len = 0;
		while( head.next != null ) {
			++len;
			head = head.next;
		}
		return len;
	}
	
	static void displayList( Node head ) {
		
		System.out.println( "Data in the Singly Linked-List are : " );
		while( head.next != null ) {
			System.out.print( head.data + " " );
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main( String[] args ) {

		Node head = null;
		head = insertStart( head, 10 );
		head = insertStart( head, 20 );
		head = insertStart( head, 30 );
		
		head = insertLast( head, 40 );
		head = insertLast( head, 50 );
		
		head = insertPosition( head, 4, 100 );
		displayList( head );
	}
}