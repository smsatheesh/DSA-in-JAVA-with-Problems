import java.util.*;

class CountSort {
	static int[] countSort( int[] arr, int N ) {
		
		int Max = Integer.MIN_VALUE, Min = Integer.MAX_VALUE;
		int[] outputArray = new int[ N ];
		
		for( int i = 0; i < N; i++ ) {
			Max = Math.max( Max, arr[i] );
			Min = Math.min( Min, arr[i] );
		}
		
		int[] freqArray = new int[ Max + 1 ];
		for( int i = 0; i < N; i++ )
			freqArray[ arr[i] ]++;
		
		for( int i = 1; i <= Max; i++ )
			freqArray[i] += ( freqArray[i - 1 ] );
		
		for( int i = N - 1; i >= 0; i-- ) {
			outputArray[ freqArray[ arr[ i ]] - 1 ] = arr[ i ];
			freqArray[ arr[ i ]]--;
		}
		return outputArray;		
	}
	
	static void printArray( int[] arr ) {
		
		System.out.println( Arrays.toString( arr ));
	}
	
	public static void main( String[] args ) {
		
		Scanner getInp = new Scanner(System.in);
		System.out.println("Enter size of elements: ");3
		int size = getInp.nextInt();
		int[] arr = new int[ size ];
		
		System.out.println("Enter elements ");
		for(int loopVar = 0; loopVar < size; loopVar++)
			arr[loopVar] = getInp.nextInt();

		arr = countSort( arr, arr.length );		
		System.out.println( "Count Sorted Array : " );
		printArray( arr );
	}
}
