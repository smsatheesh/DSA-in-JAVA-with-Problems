import java.util.*;

class BubbleSort {
	
	static void swap( int[] arr, int pos1, int pos2 ) {
		
		int temp = arr[ pos1 ];
		arr[ pos1 ] = arr[ pos2 ];
		arr[ pos2 ] = temp;
	}
	
	static void bubbleSort( int[] arr, int n ) {
		
		int i, j;
		boolean swapped = false;
		
		for( i = 0; i < n - 1; i++ ) {
			
			swapped = false;
			for( j = 0; j < n - i - 1; j++ ) {
				
				if( arr[ j ] > arr[ j + 1 ] ) {
					
					swap( arr, j , j + 1 );
					swapped = true;
				}
			}
			
			if( !swapped )
				break;
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
		
		bubbleSort( arr, arr.length );
		
		System.out.println( "Bubble Sorted Array : " );
		printArray( arr );
	}
}