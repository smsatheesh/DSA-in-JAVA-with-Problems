class Node {
	
	int data;
	Node next;
	Node prev;
	
	Node( int data ) {
		this.data = data;
		next = null;
		prev = null;
	}
}

public class DoublyLinkedList {
	
	static Node insertStart( Node head, int data ) {
		
		Node newNode = new Node( data );
		newNode.next = head;
		newNode.prev = null;
		
		if( head != null )
			head.prev = newNode;

		head = newNode;
		return head;
	}
	
	static Node insertLast( Node head, int data ) {
		
		Node newNode = new Node( data );
		newNode.next = null;
		
		if( head == null ) {
			
			newNode.prev = null;
			head = newNode;
			return head;
		}
		
		Node temp = head;
		
		while( temp.next != null ) {
			temp = temp.next;
		}
		
		temp.next = newNode;
		newNode.prev = temp;
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
				
				newNode.next = null;
				newNode.prev = null;
				head = newNode;
				return head;
			}
			
			Node temp = head;
			while( --position > 0 ) {
				temp = temp.next;
			}
			
			newNode.next = temp.next;
			newNode.prev = temp;
			temp.next = newNode;
			return head;
		}
	}
	
	static Node deleteNode( Node head, int dataTobeDeleted ) {
		
		Node temp = head;
		Node previous = null;
		
		if( temp.next == null ) {
			
			head = null;
			System.out.println( dataTobeDeleted + " deleted successfully!" );
			return head;
		} else if( temp != null && temp.data == dataTobeDeleted ) {
			
			head = temp.next;
			System.out.println( dataTobeDeleted + " deleted successfully!" );
			return head;
		} else if( temp != null && temp.data != dataTobeDeleted ) {
			
			previous = temp;
			while( temp.next != null && temp.data != dataTobeDeleted ) {
				previous = temp;
				temp = temp.next;
			}
			
			if( temp == null ) {
				System.out.println( "Values " + dataTobeDeleted + " not found" );
				return head; 
			}
			previous.next = temp.next;
			System.out.println( dataTobeDeleted + " deleted successfully!" );
			return head;
		} else {
			
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
		
		System.out.println( "Data in the Doubly Linked-List are : " );
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
		
		head = insertPosition( head, 3, 100 );
		displayList( head );
		
		head = deleteNode( head, 30 );
		displayList( head );
	}
}