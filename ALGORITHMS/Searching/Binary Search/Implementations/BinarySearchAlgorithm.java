import java.util.*;

class BinarySearchAlgorithm {

	static int binarySearchIterativeApproach(int[] arr, int sz, int key) {
		
		int low = 0, high = sz - 1;
		
		while(low <= high) {
			int mid = low + ((high - low) / 2);
			if(arr[mid] == key)
				return mid;
			else if(key > arr[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}
		
		return -1;
	}
	
	static int binarySearchRecursiveApproach(int[] arr, int sz, int key, int low, int high) {
		
		int mid = low + ((high - low) / 2);
	
		if(low >= high) {
			return -1;
		}else {
			
			if(arr[mid] == key)
				return mid;
			else if(arr[mid] > key)
				return binarySearchRecursiveApproach(arr, sz, key, low, mid - 1);
			else
				return binarySearchRecursiveApproach(arr, sz, key, mid + 1, high);
		}
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
		
		int resFromRecurApp = binarySearchRecursiveApproach(arr, size, key, 0, size - 1);
		if(resFromIterApp != -1)
			System.out.println("Result from Recursive approach, Element " + key + " present at " + (++resFromRecurApp));
		else
			System.out.println("Search element " + key + " not present in the list");
	}
}
