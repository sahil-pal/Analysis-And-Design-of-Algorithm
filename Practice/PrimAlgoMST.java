package Practice;

public class PrimAlgoMST {

	private int V = 7;
	
	// method to calculate the MST using prim's algorithm
	private void calcMST(int[][] graph) {
		
		// declaring a parent array that will consist of actual MST
		int[] parent = new int[V];
		
		// declaring a key array to keep the record for distance between edges
		int[] key = new int[V];
		
		// declaring a mstSet array of boolean type to keep track of already selected vertices
		boolean[] mstSet = new boolean[V];
		
		// initializing the mstSet with false because nothing is selected so far
		// and to set key as maximum integer value to represent the infinity in code
		for(int i = 0; i < V;i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		
		// to select root vertices or starting vertices
		key[0] = 0;
		
		// call function to get minimum key 
		// in first case root i.e. key[0] is minimum should be returned
		for(int j = 0; j < V-1; j++) {
			int minIndex = calcMinIndex(key,mstSet);
	
			// since one vertices is selected using calcMinIndex function
			// set the boolean to true for that vertices
			mstSet[minIndex] = true;
		
			// now, we need to update the adjacent distance of the selected vertices
			for(int i = 0; i < V; i++) {
				if(graph[minIndex][i] != 0 && mstSet[i] == false && graph[minIndex][i] < key[i]) {
					key[i] = graph[minIndex][i];
				
					// constructing the MST
					parent[i] = minIndex; 
				}
			}
		}
		
		
		System.out.println("EGDES        DISTANCE");
		// printing the constructed
		int totalcost = 0;
		for(int i = 1; i < V; i++) {
			totalcost += graph[i][parent[i]];
			System.out.println(parent[i]+" --> "+(i)+"     "+graph[i][parent[i]]);
		}
		
		System.out.println("TOTAL COST = "+totalcost);
	
	
	
	}
	
	private int calcMinIndex(int[] key,boolean[] mstSet) {
		
		int minValue = Integer.MAX_VALUE;
		int minIndex = -1;
		
		// comparing each key
		for(int i = 0; i < V; i++) {
			if(mstSet[i] == false && key[i] < minValue) {
				minValue = key[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	
	
	
	public static void main(String[] args) {
	
		PrimAlgoMST obj = new PrimAlgoMST();
		
		int[][] graph = new int[][] { { 0,4,8,0,0,0,0}, 
            { 4,0,9,8,10,0,0}, 
            { 8,9,0,2,0,1,0 }, 
            { 0,8,2,0,7,9,0 }, 
            { 0,10,0,7,0,5,6 },
            { 0,0,1,9,5,0,2}, 
            { 0,0,0,0,6,2,0 }}; 
		
		// calling the function 
		obj.calcMST(graph);

	}

}
