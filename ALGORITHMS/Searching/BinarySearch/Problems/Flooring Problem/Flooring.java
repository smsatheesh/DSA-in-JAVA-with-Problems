
public class Flooring
{
	static int printResult(int[] arr, int target) {
        
	        int low = 0, high = arr.length;
	        
	        if(target > arr[high - 1])
	            return arr[high - 1];
	        else {
	            
	            while(low <= high) {
	                
	                int mid = low + (high - low) / 2;
	                if(arr[mid] > target)
	                    high = mid - 1;
	                else if(arr[mid] < target)
	                    low = mid + 1;
	                else
	                    return arr[mid];
	            }   
	        }
	        
	        return arr[high];
	}
    
	public static void main(String[] args) {

		int[] arr = { 2, 3, 5, 9, 14, 16, 18 };
	    	int target = 15;
	    
	    	int resp = printResult(arr, target);
	    	System.out.println(resp);
	}
}
