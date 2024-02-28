import java.util.*;

class LinearSearch{

	static void linearSearch( int[] arrSearch, int keySearch ) {
		
		for( int loopVar = 0; loopVar < arrSearch.length; loopVar++ ) {
			
			if( arrSearch[loopVar] == keySearch ) {
				
				System.out.println( "Element found, at position " + (loopVar + 1 ));
				return;
			}
		}
		System.out.println( "Element " + keySearch + " not found" );
	}
	
	public static void main (String []args){
	
		Scanner getInp = new Scanner(System.in);
		System.out.println("Enter size of elements: ");
		int size = getInp.nextInt();
		int[] arr = new int[size];
		
		System.out.println("Enter elements ");
		for(int loopVar = 0; loopVar < size; loopVar++)
			arr[loopVar] = getInp.nextInt();
		
		System.out.println("Enter element to search");
		int key = getInp.nextInt();
		
		linearSearch( arr, key );
	}
}