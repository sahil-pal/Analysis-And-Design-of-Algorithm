package Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Edge{
	
	int src = -1;
	int des = -1;
	int weight = -1;
	Edge(int src,int des,int weight){
			this.src = src;
			this.des = des;
			this.weight = weight;
	}
		
	
	public Edge() {
		
	}


	public static boolean checkRepeatEdges(int src,int des,ArrayList<Edge> edges) {
		boolean already = false;
		for(Edge e : edges ) {
			if(e.src == des && e.des == src) {
				already = true;
				break;
			}
			else {
				already = false;
			}
		}
		return already;
	}
	
	public static boolean checkCycle(ArrayList<Edge> edges, int size) {
		int count = 0;
		
		// parent array for checking the subset
		int[] parent = new int[size];
		
		// initially all vertices are in their own subset
		for(int i = 0;i < size; i++) {
			parent[i] = -1;
		}
		
		for(int i = 0; i < edges.size(); i++) {
			System.out.println("Checking  : "+edges.get(i).src+" and "+edges.get(i).des);
			int j = find(parent,edges.get(i).src);
			int k = find(parent,edges.get(i).des);
			
			if(j == k) {
				count++;
			}
			else {
				System.out.println("assigning "+k+" as the parent of "+j);
				union(j,k,parent);
			}
		}
		
		if(count > 0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static int find(int[] parent, int e) {
		
		if(parent[e] == -1) {
			System.out.println("At parent[e] = "+parent[e]);
			return e;
		}
		else {
			System.out.println("Going into recurssion");
			return find(parent,parent[e]);
		}
		
	}
	
	public static void union(int j, int k, int[] parent) {
		parent[j] = k;
	}
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[][] graph = { { 0,4,8}, 
	            		{ 4,0,3}, 
	            		{ 8,3,0}}; 
	            		 
		System.out.println("Enter the number of vertices : ");
		int n = sc.nextInt();
		
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		// creating a new graph from the entered 2-D array
		for(int i = 0; i < n; i++) {
			for(int j =0; j < n;j++) {
				if(checkRepeatEdges(i,j,edges) == true) {	
				}
				else {
					if(graph[i][j] != 0 ) {
						System.out.println("Added edge from "+i+" to "+j);
						Edge temp = new Edge(i,j,graph[i][j]);
						edges.add(temp);
					}
				}
				
			}
		}
		
		// method to call cycle check 
		System.out.println();
		if(checkCycle(edges,n) == true) {
			System.out.println();
			System.out.println("This graph contain a cycle ");
		}
		else {
			System.out.println();
			System.out.println("This graph do not contain a cycle.");
		}
		
		
		

	}

}
