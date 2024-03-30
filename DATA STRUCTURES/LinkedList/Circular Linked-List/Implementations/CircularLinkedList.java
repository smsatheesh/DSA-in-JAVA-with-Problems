class Node {
	
	int data;
	Node next;
	
	Node( int data ) {
		this.data = data;
		this.next = null;
	}
}

public class CircularLinkedList {
	
	static void swapData( Node head, Node newNode ) {
		
		int temp = head.data;
		head.data = newNode.data;
		newNode.data = temp;
	}
	
	static Node insertFirst( Node head, int data ) {
		
		Node newNode = new Node( data );
		if( head == null ) {
			
			head = newNode;
			head.next = head;
			return head;
		} else {
			
			newNode.next = head.next;
			head.next = newNode;
			swapData( head, newNode );
			return head;
		}	
	}
	
	static Node insertLast( Node head, int data ) {
		
		Node newNode = new Node( data );
		if( head == null ) {
			
			head = newNode;
			head.next = head;
			return head;
		} else {
			
			newNode.next = head.next;
	        head.next = newNode;
			swapData( head, newNode );
			return newNode;
		}
	}
	
	static Node deleteFirst( Node head ) {
		
		if( head == null ) {
			System.out.println( "Linked list is empty" );
			return head;
		} else {
			
			if( head.next == null ) {
				
				System.out.println( "Linked list is empty, element " + head.data + " have been deleted" );
				head = null;
				return head;
			}
			
			int temp = head.data;
			head.data = head.next.data;
			head.next = head.next.next;
			System.out.println( "Element deleted successfully " + temp );
			return head;
		}
	}
	
	static Node deleteKthNode( Node head, int position ) {
		
		if( position == 1 ) {
			deleteFirst( head );
			return head;
		} else {
			
			Node current_node = head;
			for( int i = 0; i < position - 2; i++ ) {
				current_node = current_node.next;
			}
			
			current_node.next = current_node.next.next;
			return head;
		}
	}

	static void displayList( Node head ) {
				
		if( head == null ) {
			System.out.println( "No data present in the Circular Linked List" );
			return;
		} else {
			
			System.out.print( "Data in the Circular Linked List are: " );
			Node temp = head;
			do {
				System.out.print( temp.data + " " );
				temp = temp.next;
			} while( temp != head );
			System.out.println();
		}
	}
	
	static int size( Node head ) {
		
		int size = 0;
		
		Node temp = head;
		do {
			++size;
			temp = temp.next;
		} while( temp != head );
		return size;
	}
	
	public static void main( String[] args ) {
		
		Node head = null;
		
        head = insertLast (head, 12);
        head = insertFirst (head, 16);
        head = insertLast (head, 20);
        head = insertLast (head, 24);
        head = insertFirst (head, 30);
        head = insertFirst (head, 22);
 
        displayList( head );
        
        System.out.println( "Total size of the list are: " + size( head ));
        
        head = deleteFirst( head );
        displayList( head );
        
        head = deleteFirst( head );
        displayList( head );
        
        head = deleteKthNode( head, 2 );
        displayList( head );
	}
}