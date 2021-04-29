package Practice;

public class DijkstraAlgo {

	public static void main(String[] args) {
		
		int[][] graph = {{0,10,30,0,0},
						 {0,0,1,2,0},
						 {0,4,0,8,2},
						 {0,0,0,0,7},
						 {0,0,0,9,0}};
		
		calcSingleSourceShortestPath(graph);
		
	}
	
	private static int V = 5;
	
	private static void calcSingleSourceShortestPath(int[][] graph) {
		int[] distance = new int[V];
		boolean[] mstSet = new boolean[V];
		
		for(int i =0 ; i< V; i++) {
			distance[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		
		distance[0] = 0;
		
		for(int i =0; i < V; i++) {
			int minDistance = calcMinDist(distance,mstSet);
			mstSet[minDistance] = true;
			
			for(int j = 0; j < V; j++) {
				if(graph[minDistance][j] != 0 && mstSet[j] == false && distance[minDistance] + graph[minDistance][j] < distance[j]) {
					distance[j] = distance[minDistance] + graph[minDistance][j]; 
				}
			}
			
		}
		
		System.out.println("Vertex \t\t Distance from source");
		for(int i = 0; i < V; i++) {
			System.out.println(i+" \t\t "+distance[i]);
		}
		
		
	}

	private static int calcMinDist(int[] distance, boolean[] mstSet) {
		int minDistance = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i = 0; i < V;i++) {
			if(mstSet[i] == false && distance[i] < minDistance) {
				minDistance = distance[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

}
