import java.util.*;

class QuickSort {

	static void swap( int[] arr, int i, int j ) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static int partition( int[] arr, int low, int high ) {
		
		int pivot = arr[high];
		
		int i = ( low - 1 );
		
		for( int j = low; j <= high - 1; j++ ) {
			
			if( arr[j] < pivot ) {
				
				i++;
				swap( arr, i, j );
			}
		}
		
		swap( arr, i + 1, high );
		return ( i + 1 );
	}
		
	static void  quickSort( int[] arr, int low, int high ) {
		
		if( low < high ) {
			
			int par = partition( arr, low, high );
			System.out.println(par);
			quickSort( arr, low, par - 1 );
			quickSort( arr, par + 1, high );
		}
	}
	
	static void printArray( int[] arr ) {
		
		System.out.println( Arrays.toString( arr ) );
	}
	
	public static void main(String[] args) throws Exception {

		Scanner getInp = new Scanner(System.in);
		System.out.println( "Quick Sort in JAVA" );
		System.out.println( "Enter size : " );
		int sz = getInp.nextInt();
		
		System.out.println( "Enter elements : " );
		int[] arr = new int[sz];
		for( int loopVar = 0; loopVar < sz; loopVar++ )
			arr[loopVar] = getInp.nextInt();
		
		System.out.println( "Before Sorting" );
		printArray( arr );
		
		quickSort(arr, 0, sz - 1);
		
		System.out.println( "\nAfter Sorting" );
		printArray( arr );
		
	}
}