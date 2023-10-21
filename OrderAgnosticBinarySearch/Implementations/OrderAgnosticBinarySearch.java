import java.util.*;

class OrderAgnosticBinarySearch {

	static int binarySearchIterativeApproach(int[] arr, int sz, int key) {
		
		int low = 0, high = sz;
		boolean isAsc = arr[low] < arr[high - 1];
		
		while(low <= high) {
			int mid = low + ((high - low) / 2);
			if(arr[mid] == key)
				return mid;
			if(isAsc) {
				if(key > arr[mid])
					low = mid + 1;
				else
					high = mid - 1;
			} else {
				if(arr[mid] < key)
					high = mid - 1;
				else
					low = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		Scanner inpGet = new Scanner(System.in);
		System.out.println("Enter size of elements: ");
		int size = inpGet.nextInt();
		int[] arr = new int[size];
		
		System.out.println("Enter elements ");
		for(int loopVar = 0; loopVar < size; loopVar++)
			arr[loopVar] = inpGet.nextInt();
		
		System.out.println("Enter element to search");
		int key = inpGet.nextInt();
		
		int resFromIterApp = binarySearchIterativeApproach(arr, size, key);
		if(resFromIterApp != -1)
			System.out.println("Result from Iterative approach, Element " + key + " present at " + (++resFromIterApp));
		else
			System.out.println("Search element " + key + " not present in the list");
	}
}