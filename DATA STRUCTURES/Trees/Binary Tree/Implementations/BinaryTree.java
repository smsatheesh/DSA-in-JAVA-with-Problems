import java.util.*;

class Node {
	
	int data;
	Node left;
	Node right;
	
	Node( int data ) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class Tree {
	
	static void inOrder( Node root ) {
		
		if( root != null ) {
			
			inOrder( root.left );
			System.out.print( root.data + " " );
			inOrder( root.right );
		}
	}
	
	static void postOrder( Node root ) {
		
		if( root != null ) {
			
			postOrder( root.left );
			postOrder( root.right );
			System.out.print( root.data + " " );
		}
	}
	
	static void preOrder( Node root ) {
		
		if( root != null ) {
			
			System.out.print( root.data + " " );
			preOrder( root.left );
			preOrder( root.right );
		}
	}
	
	static int maxHeight( Node node ) {
		
		if( node == null )
			return 0;
		else {
			
			int leftHeight = maxHeight( node.left );
			int rightHeight = maxHeight( node.right );
			
			if( leftHeight > rightHeight )
				return leftHeight + 1;
			else
				return rightHeight + 1;
		}
	}
	
	static void nodeAtKdistance( Node root, int distance ) {
		
		if( root == null )
			return;
		else if( distance == 0 )
			System.out.print( root.data + ", " );
		else {
			
			nodeAtKdistance( root.left, distance - 1 );
			nodeAtKdistance( root.right, distance - 1 );
		}
	}
	
	static void printLevelOrder( Node root ) {
		
		if( root == null )
			return;
		else {
			
			Queue<Node> queue = new ArrayDeque<Node>();
			queue.add( root );
			
			while( !queue.isEmpty() ) {
				
				Node temp = queue.poll();
				System.out.print( temp.data + " " );
				if( temp.left != null )
					queue.add( temp.left );
				if( temp.right != null )
					queue.add( temp.right );
			}
		}
	}
	
	public static void main( String[] args ) {
		
		Node root = new Node( 10 );
		root.left = new Node( 5 );
		root.right = new Node( 20 );
		root.left.left = new Node( 1 );
		root.right.right = new Node( 30 );
		
		System.out.print( "In-order traversal -> " );
		inOrder( root );
		System.out.println();

		System.out.print( "Post-order traversal -> " );
		postOrder( root );
		System.out.println();
		
		System.out.print( "Pre-order traversal -> " );
		preOrder( root );
		System.out.println();
		
		System.out.println( "Max height or depth of the tree is " + maxHeight( root ));
		
		int distance = 1;
		System.out.print( "Node at a distance " + distance + " is " );
		nodeAtKdistance( root, distance );
		System.out.println();
		
		System.out.print( "Level-Order Traversal -> " );
		printLevelOrder( root );
	}
}