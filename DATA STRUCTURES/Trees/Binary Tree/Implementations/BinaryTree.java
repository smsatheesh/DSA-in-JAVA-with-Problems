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
	
	static int calSize( Node node ) {
		
		if( node == null )
			return 0;
		else 
			return ( 1 + calSize( node.left ) + calSize( node.right ));
	}
	
	static int maxElement( Node node ) {
		
		if( node == null )
			return Integer.MIN_VALUE;
		else 
			return Math.max( node.data, Math.max( maxElement( node.left ), maxElement( node.right )));
	}
	
	static int minElement( Node node ) {
		
		if( node == null )
			return Integer.MAX_VALUE;
		else
			return Math.min( node.data, Math.min( minElement( node.left ), minElement( node.left )));
	}
	
	static int max_node_visited = 0;
	
	static void leftView( Node node, int current_level ) {
		
		if( node == null )
			return;
		else {
			
			if( max_node_visited < current_level ) {
				
				System.out.print( node.data + " " );
				max_node_visited++;
			}
			leftView( node.left, current_level + 1 );
			leftView( node.right, current_level + 1 );
		}
	}
	
	static void printSpiralOrder( Node node ) {
		
		if( node == null )
			return;
		else {
			
			Stack<Node> stack1 = new Stack<Node>();
			Stack<Node> stack2 = new Stack<Node>();
			stack1.add( node );
			
			while( !stack1.empty() || !stack2.empty() ) {
			
				while( !stack1.empty() ) {
					
					Node temp = stack1.pop();
					System.out.print( " " + temp.data );
					
					if( temp.left != null )
						stack2.add( temp.left );
					if( temp.right != null )
						stack2.add( temp.right );
				}
				
				while( !stack2.empty() ) {
					
					Node temp = stack2.pop();
					System.out.print( " " + temp.data );
					
					if( temp.left != null )
						stack1.add( temp.left );
					if( temp.right != null )
						stack1.add( temp.right );
				}
			}
		}
	}
	
	static int MAX_DIAMETER = 0;
	
	static int diameter( Node node ) {
		
		if( node == null )
			return 0;
		else {
			
			int left_height = diameter( node.left );
			int right_height = diameter( node.right );
			
			MAX_DIAMETER = Math.max( MAX_DIAMETER , ( 1 + left_height + right_height ));
			return ( 1 + left_height + right_height );
		}
	}
	
	static boolean findPath( Node node, int key, ArrayList<Node> path ) {
		
		if( node == null )
			return false;
		else {
			
			path.add( node );
			if( node.data == key )
				return true;
			if( findPath( node.left, key, path ) || findPath( node.right, key, path ))
				return true;
			
			path.remove( path.size() - 1 );
			return false;
		}
	}
	
	static Node lca( Node node, int value1, int value2 ) {
		
		ArrayList<Node> path1 = new ArrayList<Node>();
		ArrayList<Node> path2 = new ArrayList<Node>();
		
		if(( findPath( node, value1, path1 ) == false ) || ( findPath( node, value2, path2 ) == false ))
			return null;
		
		for( int loop = 0; ( loop < path1.size() && loop < path2.size()); loop++ ) {
			
			if( path1.get( loop ).data != path2.get( loop ).data )
				return path1.get( loop - 1 );
		}
		
		return null;
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
		System.out.println();
		
		System.out.println( "Size of the BST tree is : " + calSize( root ));
		
		System.out.println( "Maximum element in the BST tree is : " + maxElement( root ));
		System.out.println( "Minimum element in the BST tree is : " + minElement( root ));
		
		System.out.print( "Left view of Binary Tree is : " );
		leftView( root, 1 );
		System.out.println();
		
		System.out.print( "Spiral view of a binary tree is :" );
		printSpiralOrder( root );
		System.out.println();
		
		System.out.println( "Diameter of binary tree is : " + diameter( root ));
		
		System.out.print( "Lowest Common Ancestor of 1 and 30 : " );
		Node result = lca( root, 1, 30 );
		if( result != null )
			System.out.print( result.data );
		else
			System.out.print( "Common ancestor does not exist" );
		System.out.println ();
	}
}