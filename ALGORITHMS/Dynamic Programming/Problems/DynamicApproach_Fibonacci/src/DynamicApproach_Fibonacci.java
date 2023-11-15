import java.util.*;

class DynamicApproach_Fibonacci {

	static int fibonacci( int num, int[] fiboMemoization ) {
		
		if( num == 1 || num == 0 )
			return num;
		else { 
			
			if( fiboMemoization[num] != 0 ) 
				return fiboMemoization[num];
			else {
				
				return fibonacci( num - 2, fiboMemoization ) + fibonacci( num - 1, fiboMemoization );
			}
		}
	}
	
	public static void main( String[] args ) {
		
		Scanner getInp = new Scanner(System.in);
		System.out.println( "Dynamic Programming In Fibonaccci Series" );
		System.out.println( "Enter number n'th :: " );
		int num = getInp.nextInt();
		int[] storeArr = new int[num + 1];
		
		System.out.println( fibonacci( num, storeArr ) );
	}
}