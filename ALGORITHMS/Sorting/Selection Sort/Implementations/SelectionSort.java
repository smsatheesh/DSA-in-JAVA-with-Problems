import java.util.*;

class SelectionSort {

	static void swapElements( int[] arr, int pos1, int pos2 ) {
		int temp = arr[ pos1 ];
		arr[ pos1 ] = arr[ pos2 ];
		arr[ pos2 ] = temp;
	}
	
	static int[] selectionSort( int[] arr ) {
		
		for( int i = 0; i < arr.length; i++ ) { 
			for( int j = i; j < arr.length; j++ ) {
				
				int min = arr[i];
				if( min > arr[j] ) {
					swapElements( arr, i, j );
				}
			}
		}
		return arr;
	}
	
	static void printArray( int[] array ) {
		
		for( int num: array )
			System.out.print( num + " " );
	}
	
	public static void main( String[] args ) {
		
		Scanner getInp = new Scanner(System.in);
		System.out.println("Enter size of elements: ");
		int size = getInp.nextInt();
		int[] arr = new int[ size ];
		
		System.out.println("Enter elements ");
		for(int loopVar = 0; loopVar < size; loopVar++)
			arr[loopVar] = getInp.nextInt();		
		
		arr = selectionSort( arr );
		
		System.out.println( "Selection Sorted Array : " );
		printArray( arr );
	}
}