import java.util.*;

class RadixSort {
	
	static void countSort( int[] arr, int N, int exp ) {
		
		int Max = Integer.MIN_VALUE, Min = Integer.MAX_VALUE;
		
		for( int i = 0; i < N; i++ ) {
			Max = Math.max( Max, arr[i] );
			Min = Math.min( Min, arr[i] );
		}
				
		int count[] = new int[ Max + 1 ];
		Arrays.fill( count, 0 );
		
		for( int i = 0; i < N; i++ )
            count[( arr[i] / exp) % 10 ]++;
				
		for( int i = 1; i <= 10; i++ )
			count[ i ] += count[ i - 1 ];
		
		int[] output = new int[N];
		for( int i = N - 1; i >= 0; i-- ) {
			output[ count[( arr[i] / exp ) % 10 ] - 1 ] = arr[ i ];
			count[( arr[i] / exp ) % 10 ]--;
		}
		
		for( int loop = 0; loop < N; loop++ )
			arr[ loop ] = output[ loop ];
	}
	
	static void radixSort( int[] arr, int N ) {
		
		int Max = Integer.MIN_VALUE;
		for( int loop = 0; loop < N; loop++ )
			Max = Math.max( Max, arr[ loop ] );
		
		for( int exp = 1; Max / exp > 0; exp *= 10 )
			countSort( arr, N, exp );
	}
	
	static void printArray( int[] arr ) {
		
		System.out.println( Arrays.toString( arr ));
	}
	
	public static void main( String[] args ) {
		
		Scanner getInp = new Scanner(System.in);
		System.out.println("Enter size of elements: ");
		int size = getInp.nextInt();
		int[] arr = new int[ size ];
		
		System.out.println("Enter elements ");
		for(int loopVar = 0; loopVar < size; loopVar++)
			arr[loopVar] = getInp.nextInt();

		radixSort( arr, arr.length );		
		System.out.println( "Radix Sorted Array : " );
		printArray( arr );
	}
}