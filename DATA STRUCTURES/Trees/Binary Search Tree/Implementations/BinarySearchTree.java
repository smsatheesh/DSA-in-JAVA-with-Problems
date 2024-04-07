import java.util.*;

class Node {
	
	int data;
	Node left;
	Node right;
	
	Node( int data ) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class BinarySearchTree {
	
	static boolean searchItem( Node node, int value ) {
		
		if( node == null )
			return false;
		else if( node.data == value )
			return true;
		else if( node.data < value )
			return searchItem( node.right, value );
		else
			return searchItem( node.left, value );		
	}
	
	static Node insertNode( Node root, int value ) {
		
		if( root == null )
			return new Node( value );
		else if( root.data > value )
			root.left = insertNode( root.left, value );
		else if( root.data < value )
			root.right =  insertNode( root.right, value );
		
		return root;
	}
	
	static Node inorderSuccessor( Node current ) {
		
		current = current.right;
		
		while( current != null && current.left != null )
			current = current.left;
		
		return current;
	}
	
	static Node inorderPredecessor( Node current ) {
		
		current = current.left;
		
		while( current != null && current.right != null )
			current = current.right;
		
		return current;
	}
	
	static Node deleteNode( Node node, int value ) {
		
		if( node == null )
			return null;

		if( node.data > value )
			node.left = deleteNode( node.left, value );
		else if( node.data < value )
			node.right = deleteNode( node.right, value );
		else {
			
			if( node.left == null ) {
				
				Node temp = node.right;
				node = null;
				return temp;
			} else if( node.right == null ) {
				
				Node temp = node.left;
				node = null;
				return temp;
			} else {
				
				Node temp = inorderSuccessor( node );
				node.data = temp.data;
				node.right = deleteNode( node.right, temp.data );
			}
		}
		
		return node;
	}
	
	static void inOrder( Node node ) {

		if( node != null ) {
			
			inOrder( node.left );
			System.out.print( node.data + " " );
			inOrder( node.right );
		}
	}
	
	static int ceil( Node node, int value ) {
		
		int ceilValue = -1;
		if( node == null )
			return Integer.MIN_VALUE;
		else {
			
			if( node.data == value )
				return value;
			
			if( node.data < value )
				return ceil( node.right, value );

			ceilValue = ceil( node.left, value );
			ceilValue = ( ceilValue >= value ) ? ceilValue: node.data;
		}
		
		return ceilValue;
	}
	
	static int floor( Node node, int value ) {
		
		int floorValue = -1;
		if( node == null )
			return Integer.MAX_VALUE;
		else {
			
			if( node.data == value )
				return value;
			
			if( node.data > value )
				return floor( node.left, value );
			
			floorValue = floor( node.right, value );
			floorValue = ( floorValue <= value ) ? floorValue: node.data;
		}
		
		return floorValue;
	}
	
	public static void main( String[] args ) {

		Node root = new Node( 50 );
		root = insertNode( root, 45 );
		root = insertNode( root, 40 );
		root = insertNode( root, 55 );
		root = insertNode( root, 60 );
		root = insertNode( root, 10 );
		root = insertNode( root, 100 );
		root = insertNode( root, 48 );
		root = insertNode( root, 52 );
		
		if( searchItem( root, 100 ) )
			System.out.println( "Node of value 100 searching ???? RESULT => presents" );
		else
			System.out.println( "100 not presents" );
		
		System.out.println( "In-order successor of element 50 is : " + inorderSuccessor( root ).data );
		System.out.println( "In-order predecessor of element 50 is : " + inorderPredecessor( root ).data );
		
		System.out.print( "BST tree is : " );
		inOrder( root );
		System.out.println();
		
		System.out.println( "Deletion of node 10" );
		deleteNode( root, 10 );
		
		System.out.print( "After deletion of leaf node 10 -> " );
		inOrder( root );
		System.out.println();
		
		System.out.println( "Deletion of node 45" );
		root = deleteNode( root, 45 );
		
		System.out.print( "After deletion of leaf node 45 -> " );
		inOrder( root );
		System.out.println();
		
		System.out.println( "Deletion of node 50" );
		root = deleteNode( root, 50 );

		System.out.print( "After deletion of leaf node 50 -> " );
		inOrder( root );
		System.out.println();
		
		System.out.println( "Ceil value of 40 is " + ceil( root, 40 ));
		System.out.println( "Ceil value of 53 is " + ceil( root, 53 ));

		System.out.println( "Floor value of 0 " + floor( root, 0 ));
		System.out.println( "Floor value of 41 " + floor( root, 41 ));
		System.out.println( "Floor value of 101 " + floor( root, 90 ));
	}
}