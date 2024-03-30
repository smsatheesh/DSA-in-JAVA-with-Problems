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
			System.out.println( root.data + " " );
			inOrder( root.right );
		}
	}
	
	public static void main( String[] args ) {
		
		Node root = new Node( 10 );
		root.left = new Node( 5 );
		root.right = new Node( 20 );
		root.left.left = new Node( 1 );
		root.right.right = new Node( 30 );
		
		inOrder( root );
	}
}