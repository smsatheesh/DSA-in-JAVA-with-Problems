public class Queue {
	
	private int size, front, rear;

	private ArrayList<Integer> queue = new ArrayList<Integer>();
	
	public Queue( int size ) {
		
		this.size = size;
		this.front = this.rear = -1;
	}
	
	void enQueue( int element ) {
		
		if( isFull() ) {
			
			System.out.println( "Queue Overflow" );
			return;
		} else if( front == -1 ) {
			
			front = 0;
			rear = 0;
			queue.add( rear, element );
		} else if( rear == size - 1 && front != 0 ) {
			
			rear = 0;
			queue.set( rear, element );
		} else {
			
			rear = rear + 1;
			if( front <= rear ) {
				queue.add( rear, element );
			} else {
				queue.set( rear, element );
			}
		}
		System.out.println( element  + " inserted in the queue" );
	}
	
	
	int deQueue() {
		
		int temp;
		
		if( isEmpty() ) {
			System.out.println( "Queue Underflow" );
			return -1;
		} else {
			
			temp = queue.get( front );

			if( front == rear ) {
				front = rear = -1;
			} else if( front == size - 1 ) {
				front = 0;
			} else {
				front++;
			}
			return temp;
		}
	}
	
	void print() {
		
		if( isEmpty() ) {
			System.out.println( "Queue is empty !" );
			return;
		} else {
			
			System.out.print( "Elements in the circuar queue are -> " );
			if( rear >= front  ) {
				
				for( int i = front; i <= rear; i++ )
					System.out.print( queue.get( i ) + " " );
			} else {
				
				for( int i = front; i < size; i++ )
					System.out.print( queue.get( i ) + " " );
				for( int i = 0; i <= rear; i++ )
					System.out.print( queue.get( i ) + " " );
			}
			System.out.println();
		}
	}
	
	boolean isFull() {
		
		return ((front == 0 && rear == size - 1) ||
			      (rear == (front - 1) % (size - 1)));
	}
	
	boolean isEmpty() {
		return ( front == -1 );
	}
	
	public static void main( String[] args ) {
		
		Queue queueObject = new Queue( 5 );
	     
	    queueObject.enQueue( 14 );
	    queueObject.enQueue( 22 );
	    queueObject.enQueue( 13 );
	    queueObject.enQueue( -6 );
	     
	    queueObject.print();
	 
	    int x = queueObject.deQueue();
	 
	    // Checking for empty queue.
	    if(x != -1)
	    {
	        System.out.println( "Deleted value = " + x );
	    }
	 
	    x = queueObject.deQueue();
	 
	    // Checking for empty queue.
	    if(x != -1)
	    {
	        System.out.println( "Deleted value = " + x );
	    }
	 
	    queueObject.print();
	     
	    queueObject.enQueue( 9 );
	    queueObject.enQueue( 20 );
	    queueObject.enQueue( 5 );

	    queueObject.print();
	     
	    queueObject.enQueue( 20 );
	}
}