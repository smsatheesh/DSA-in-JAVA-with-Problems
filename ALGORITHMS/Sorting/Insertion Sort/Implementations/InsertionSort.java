import java.util.*;

class InsertionSort {
	
	static void insertionSort( int[] arr, int n ) {
		
		int i, j;
		for( i = 1; i < n; i++ ) {
			int temp = arr[ i ];
			j = i - 1;
			while(( j > -1 ) && ( arr[ j ] > temp )) {
				arr[ j + 1 ] = arr[ j ];
				j--;
			}
			arr[ j + 1 ] = temp;
		}
	}
	
	static void printArray( int[] arr ) {
		
		for( int element: arr )
			System.out.print( element + " " );
	}
	
	public static void main( String[] args ) {
		
		Scanner getInp = new Scanner(System.in);
		System.out.println("Enter size of elements: ");
		int size = getInp.nextInt();
		int[] arr = new int[ size ];
		
		System.out.println("Enter elements ");
		for(int loopVar = 0; loopVar < size; loopVar++)
			arr[loopVar] = getInp.nextInt();
		
		insertionSort( arr, arr.length );
		
		System.out.println( "Insertion Sorted Array : " );
		printArray( arr );
	}
}