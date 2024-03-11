# COUNT SORT `( JAVA Version )`

* It is a non-comparison based sorting algorithms that works well when there is a limited range of set of inputs.
* It is particularly efficient when the range of input values are small compared to the number of elements to be sorted.
* The idea behind the count sort is that is the count the frequency of each element from the input array and use that information to place the element in the relative position of the order.

## ANALYSIS OF COUNT SORT:

	1. Time complexity  -> O( N + M )
	2. Space complexity -> O( N + M )

## ADVANTAGES:

	* It generally performs faster than all comparsio based sorting algorithms.
	* It is easy to code.
	* It is much stable algorithm 

## DISADVANTAGES:

	* It does not work on decimal values.
	* It is inefficient when the range of inputed values are to be high.
	* It is not an in-place sorting algorithm, so that it uses extra spaces, for storing array elements.

### Contributed by [Sm Satheesh](https://github.com/smsatheesh)