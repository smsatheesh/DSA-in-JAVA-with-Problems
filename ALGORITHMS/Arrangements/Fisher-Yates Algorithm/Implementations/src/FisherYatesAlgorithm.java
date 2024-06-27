class FisherYatesAlgorithm {
	
	static void swap( int element1, int element2, int[] array ) {
		
		int temp = array[ element1 ];
		array[ element1 ] = array[ element2 ];
		array[ element2 ] = temp;
	}
	
	static void display( int[] arr ) {
		
		System.out.println( "After algorithm run : " + Arrays.toString( arr ));
	}
	
	static void randomGeneration( int[] arr ) {
		
		Random random = new Random();
		
		for( int loopVar = arr.length - 1; loopVar > 0; --loopVar ) {
			
			int loopInternalVar = random.nextInt( loopVar + 1 );
			swap( loopVar, loopInternalVar, arr );
		}
		
		display( arr );
	}
	
	public static void main(String[] args) {
		
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		System.out.println( " \t-- Fisher-Yates Algorithm -- " );
		System.out.println( "Before algorithm run : " + Arrays.toString( array ));
		randomGeneration( array );
	}
}