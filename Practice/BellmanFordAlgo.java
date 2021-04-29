package Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class BellmanFordAlgo {
		
	int src = -1;
	int des = -1;
	int weight = -1;
	BellmanFordAlgo(int src,int des,int weight){
			this.src = src;
			this.des = des;
			this.weight = weight;
	}
	
	
	
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] graph = { {0,3,0,0,5},
				  		  {0,0,8,5,0},
				          {0,0,0,0,0},
				          {0,0,2,0,0},
				          {0,0,0,4,0} };
		
		// enter the number of vertices
		System.out.println("Enter the number of vertices : ");
		int n = sc.nextInt();
		
		ArrayList<BellmanFordAlgo> edges = new ArrayList<BellmanFordAlgo>();
		
		for(int i =0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(checkRepeatedEdges(i,j,edges)) {
					
				}
				else {
					if(graph[i][j] != 0) {
						BellmanFordAlgo temp = new BellmanFordAlgo(i,j,graph[i][j]);
						edges.add(temp);
						System.out.println("Edge added : "+i+" to "+j+" of weight "+graph[i][j]);
					}
				}
			}
		}
		
		// call the function
		calcBellmanFordAlgo(edges,n);
		
	}

	private static void calcBellmanFordAlgo(ArrayList<BellmanFordAlgo> edges, int n) {
		
		int[] distance = new int[n];
		
		for(int i = 0; i < n; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		distance[0] = 0;
		
		// relaxing the edges
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < edges.size(); j++) {
				int u = edges.get(j).src;
				int v = edges.get(j).des;
				int weight = edges.get(j).weight;
				if(distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
					distance[v] = distance[u] + weight;
				}
			}
		}
		
		
		// checking for negative edges
		for(int i = 0; i < edges.size(); i++) {
			int u = edges.get(i).src;
			int v = edges.get(i).des;
			int weight = edges.get(i).weight;
			if(distance[u] + weight < distance[v]) {
				System.out.println("Graph contains negative cycle ");
				System.exit(1);
			}
		}
		
		// print the results 
		System.out.println("vertex \t\t distance");
 		for(int i =0 ; i < n; i++) {
 			System.out.println((i+1)+" \t\t "+distance[i]);
 		}
		
	}

	private static boolean checkRepeatedEdges(int i, int j, ArrayList<BellmanFordAlgo> edges) {
		boolean already = false;
		for(BellmanFordAlgo e : edges) {
			if(e.src == j && e.des == i){
				already = true;
				break;
			}
			else {
			}
		}
		return already;
	}
}
