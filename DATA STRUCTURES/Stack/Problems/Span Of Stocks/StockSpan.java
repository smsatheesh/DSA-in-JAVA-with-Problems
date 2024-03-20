public class StockSpan {
	
	static void stockSpanNaiveApproach( int[] arr, int size ) {
		
		int[] spanArray = new int[ size ];
		for( int i = size - 1; i >= 0; --i ) {
			
			int count = 1;
			for( int j = i - 1; j >= 0; --j ) {
				
				if( arr[j] < arr[i] )
					++count;
			}
			
			spanArray[i] = count;
		}
		
		print( spanArray );
	}
	
	static void print( int arr[] ) {
		
		System.out.println( Arrays.toString( arr ));
	}
	
	public static void main( String[] args ) {
		
		int[] arr = { 50, 40, 30, 20, 10 };
		stockSpanNaiveApproach( arr, arr.length ); // time complexity -> O( N^2 ) 
	}
}