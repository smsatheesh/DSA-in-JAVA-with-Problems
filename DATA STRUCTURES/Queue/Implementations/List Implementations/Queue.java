import java.util.*;

public class Queue {
	
	int front, rear;
	int capacity;
	List<Integer> queueList;
	
	Queue( int capacity ) {
		front = -1;
		rear = -1;
		this.capacity = capacity;
		queueList = new ArrayList<Integer>(capacity);
	}
	
	void enQueue( int element ) {
		
		if( isFull() ) {
			return;
		} else {
			
			if( front == -1 )
				front = 0;
			
			queueList.add( element );
			++rear;
			System.out.println( element + " is inserted in the queue" );
		}
	}
	
	int deQueue() {
		
		if( isEmpty() ) {
			return -1;
		} else {
			
			int item = queueList.get( front );
			front++;
			
			if( front > rear )
				front = rear = -1;
			
			System.out.println( item + " dequeued from the queue" );
			return item;
		}
	}
	
	int front() {
		
		if( isEmpty() ) {
			return -1;
		} else {
			return queueList.get( front );
		}
	}
	
	int rear() {
		
		if( isEmpty() ) {
			return -1;
		} else {
			return queueList.get( rear );
		}
	}
	
	boolean isFull() {
		
		if( rear == capacity - 1 ) {
			
			System.out.println( "Queue Overflow" );
			return true;
		} else {
			
			return ( rear == capacity -1 );
		}
	}
	
	boolean isEmpty() {
		
		if( front == -1 ) {
			
			System.out.println( "Queue underflow" );
			return false;
		} else {
			
			return ( front == -1 );
		}
	}
	
	void print( Queue q ) {
		
		System.out.println( "Elements in the queue are : " );
		for( int i = front; i <= rear; i++ ) {
			System.out.print( q.queueList.get(i) + " " );
		}
	}
	
	public static void main( String[] args ) {
	
		Queue queue = new Queue( 5 );
		
		queue.enQueue( 10 );
		queue.enQueue( 20 );
		queue.enQueue( 30 );
		queue.enQueue( 40 );
		queue.enQueue( 50 );
		
		queue.deQueue();
		queue.deQueue();
		queue.print( queue );
		
		System.out.println( "\nFront value now in the queue are -> " + queue.front());
		System.out.println( "Rear value now in the queue are  -> " + queue.rear());
		
	}
}