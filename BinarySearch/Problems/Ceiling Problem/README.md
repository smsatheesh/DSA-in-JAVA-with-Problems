# Ceiling Of A Number #

* Greatest element in an array which is equal or greater than the target
* Follow the steps :
	1. Find the closest or equal to the target by using Binary Search Algorithm
	2. Find the number which are larger than the current target element
	3. Return the greater element from previous iteration
	
--------

* Consider the following example:
* arr = [2, 3, 5, 9, 14, 16, 18], target = 14
* ceiling(arr, target=14) = 14
* ceiling(arr, target=15) = 16
* ceiling(arr, target=4) = 5
* ceiling(arr, target=9) = 9

--------

* If target is found, return the target
* Else return the start
* Because when the condition is violated in the while loop: start = end + 1
* <div style="background-color:grey"> start  target  end              =>              end  target  start </div>
* So the answer is not in this range, and the smallest element which is greater than or equal to target is the start

### Link -> [Ceiling Program](https://github.com/smsatheesh/DSA-in-JAVA-with-Problems/blob/main/BinarySearch/Problems/Ceiling%20Problem/Ceiling.java) 
### Contributed by [Sm Satheesh](https://github.com/smsatheesh)
