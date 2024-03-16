import java.util.*;

public class Queue {
	
	private int curr_size, front, rear, capacity;

	private int[] queueArray;
	
	public Queue( int capacity ) {
		
		this.curr_size = 0;
		this.capacity = capacity;
		this.front = this.rear = -1;
		this.queueArray = new int[ capacity ];
	}
	
	void enQueue( int element ) {
		
		if( isFull() ) {
			
			System.out.println( "Queue Overflow" );
			return;
		} else  {
			
			if( front == -1 ) {
				front = 0;
			}
			rear = ( rear + 1 ) % capacity;
			queueArray[ rear ] = element;
		}
		System.out.println( element  + " inserted in the queue" );
	}
	
	
	int deQueue() {
		
		int temp = -1;
		
		if( isEmpty() ) {
			
			System.out.println( "Queue underflow"  );
			return temp;
		} else {
			
			temp = queueArray[ front ];
			if( front == rear ) {
				front = rear = -1;
			} else {
				front = (front + 1) % capacity;
			}
		}
		System.out.println( temp + " were removed from the queue" );
		return temp;
	}
	
	void print() {
		
		if( isEmpty() ) {
			System.out.println( "Queue is empty" );
			return;
		} else {
			int i;
			System.out.print( "\nElements in the queue are : " );
			for( i = front; i != rear; i = ( i + 1 ) % capacity )
				System.out.print( queueArray[i] + " " );
			
			System.out.print( queueArray[i] );
		}
		
		System.out.println();
	}
	
	boolean isFull() {
        return (front == rear + 1) ||
                (front == 0 && rear == capacity - 1);
    }
	
	boolean isEmpty() {
        return front == -1;
    }
	
	public static void main( String[] args ) {
		
		Queue queue = new Queue(6);

        queue.deQueue();  //Underflow condition

        queue.enQueue(12);
        queue.enQueue(14);
        queue.enQueue(16);
        queue.enQueue(18);
        queue.enQueue(20);

        queue.print();
        queue.deQueue();
        queue.deQueue();

        queue.print();

        queue.enQueue(22);
        queue.enQueue(24);
        queue.enQueue(26);
        queue.enQueue(28); //Overflow condition
        queue.print();
	}
}