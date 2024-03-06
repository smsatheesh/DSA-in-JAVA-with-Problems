import java.util.*;

class MergeSort {

	static void merge( int[] arr, int low, int mid, int high ) {
		
		int n1 = mid - low + 1;
		int n2 = high - mid;
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for( int loop1 = 0; loop1 < n1; ++loop1 )
			L[loop1] = arr[loop1 + low];
		
		for( int loop2 = 0; loop2 < n2; ++loop2 )
			R[loop2] = arr[loop2 + mid + 1];
		
		int i = 0, j = 0, k = low;
		while( i < n1 && j < n2 ) {
			
			if( L[i] <= R[j] ) {
				
				arr[k] = L[i];
				i++;
			} else {
				
				arr[k] = R[j];
				j++;
			}
			k++;	
		}
		
		while( i < n1 ) {
			
			arr[k] = L[i];
			k++;
			i++;
		}
		
		while( j < n2 ) {
			
			arr[k] = R[j];
			k++;
			j++;
		}
			
	}
	
	static void mergeSort( int[] arr, int low, int high ) {
		
		if( low < high ) {
			
			int mid = low + ( high - low ) / 2;
			mergeSort( arr, low, mid );
			mergeSort( arr, mid + 1, high );
			
			merge( arr, low, mid, high );
		}
	}
	
	static void printArray( int[] arr ) {
		
		System.out.println( Arrays.toString( arr ) );
	}
	
	public static void main(String[] args) {
		
		Scanner getInp = new Scanner(System.in);
		System.out.println( "MERGE SORT IN ARRAY" );
		System.out.println( "Enter size : " );
		int sz = getInp.nextInt();
		
		int[] arr = new int[sz];
		for( int loopVar = 0; loopVar < sz; loopVar++ )
			arr[loopVar] = getInp.nextInt();
		
		System.out.println( "\nBefore Merge Sort -> " );
		printArray( arr );
		mergeSort( arr, 0, sz - 1 );
		System.out.println( "\nAfter Merge Sort -> " );
		printArray( arr );
		
	}
}