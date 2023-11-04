import java.util.*;

class HeapSort {

	static void printArr( int[] arr ) {
		
		System.out.println( Arrays.toString( arr ) );
	}
	
	static void heapSortMethod( int[] arr ) {
		
		int N = arr.length;
		
		for( int loopVar = N / 2 - 1; loopVar >= 0; loopVar-- )
			heapify( arr, N, loopVar );
		
		for( int loop = N - 1; loop > 0; loop-- ) { 
			
			int temp = arr[0];
			arr[0] = arr[loop];
			arr[loop] = temp;
			
			heapify( arr, loop, 0 );
		}
	}
	
	static void heapify( int[] arr, int N, int loop ) {
		
		int largest = loop;
		
		int left = loop * 2 + 1;
		int right = loop * 2 + 2;
		
		if( left < N && arr[left] > arr[largest] )
			largest = left;
		
		if( right < N && arr[right] > arr[largest] )
			largest = right;
		
		if(largest != loop) {
			
			int temp = arr[largest];
			arr[largest] = arr[loop];
			arr[loop] = temp;
			
			heapify( arr, N, largest );
		}
	}
		
	public static void main(String[] args) {
		
		Scanner inpGet = new Scanner(System.in);
		System.out.println("Enter size of elements: ");
		int size = inpGet.nextInt();
		int[] arr = new int[size];
		
		System.out.println("Enter elements ");
		for(int loopVar = 0; loopVar < size; loopVar++)
			arr[loopVar] = inpGet.nextInt();
		
		heapSortMethod( arr );
		
		System.out.println( "Heap Sorted Array" );
		printArr( arr ); 
	}
}