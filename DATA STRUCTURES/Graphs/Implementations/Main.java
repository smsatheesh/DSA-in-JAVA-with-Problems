import java.util.*;

class Main {
	
	int vertex, edge;
	int[][] adj;
	Main( int v, int e ) {
		
		this.vertex = v;
		this.edge = e;
		
		adj = new int[v][e];
		
		for( int row = 0; row < v; row++ ) {
		
			adj[row] = new int[v];
			for( int column = 0; column < v; column++ ) {
				adj[row][column] = 0;
			}
		}
	}
	
	public void newEdge( int start, int ele ) {
		
		adj[ start ][ ele ] = 1;
		adj[ ele ][ start ] = 1;
	}
	
	public void DFS( int start, boolean[] visited ) {
		
		System.out.print( start + " " );
		visited[ start ] = true;
		for( int loop = 0; loop < this.vertex; loop++ ) {
			
			if( adj[ start ][ loop ] == 1 && ( !visited[ loop ] ))
				this.DFS( loop, visited );
		}
	}
 	
	public static void main(String[] args) { 

		int v = 8, e = 8;
		Main obj = new Main( v, e );
		
		obj.newEdge( 0, 1 );
		obj.newEdge( 0, 2 );
		obj.newEdge( 1, 3 );
		obj.newEdge( 2, 4 );
		obj.newEdge( 2, 6 );
		obj.newEdge( 6, 7 );
		obj.newEdge( 3, 5 );
		obj.newEdge( 5, 4 );
		
		boolean[] visited = new boolean[ v ];
		Arrays.fill( visited, false);
		
		// Perform Depth-First Search
		System.out.print( "DFS of the graph and connected edges are : " );
		obj.DFS( 0, visited );
	} 
} 
