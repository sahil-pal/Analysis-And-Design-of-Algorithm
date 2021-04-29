package Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class KruskalAlgoMST {
	
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
	
	public static void calcMST(ArrayList<Edge> edges, int size) {
		
		int totalcost = 0;
		// to store results
		Edge[] result = new Edge[size-1];
		
		for(int i =0; i < size-1; i++) {
			result[i] = new Edge();
		}
		
		for(int i =0; i < edges.size(); i++) {
			Edge value = edges.get(i);
			int hole = i-1;
			while(hole >= 0 && edges.get(hole).weight > value.weight) {
				int temp_src = edges.get(hole).src;
				int temp_des = edges.get(hole).des;
				int temp_wei = edges.get(hole).weight;
				edges.get(hole+1).src = temp_src;
				edges.get(hole+1).des = temp_des;
				edges.get(hole+1).weight = temp_wei;
				hole--;
			}
			edges.get(hole+1).src = value.src;
			edges.get(hole+1).des = value.des;
			edges.get(hole+1).weight = value.weight;
		}
		
		System.out.println();
		System.out.println("Non-increasing weight");
		System.out.println("src   des   weight");
		for(Edge e : edges) {
			System.out.println(e.src+"  "+e.des+"    "+e.weight);
		}
		
		// parent array for checking the subset
		int[] parent = new int[size];
				
		// initially all vertices are in their own subset
		for(int i = 0;i < size; i++) {
			parent[i] = -1;
		}
		
		int s = 0;
		for(int i = 0; i < edges.size(); i++) {
			int j = find(parent,edges.get(i).src);
			int k = find(parent,edges.get(i).des);
			
			if(j == k) {
				
			}
			else {
				union(j,k,parent);
				totalcost += edges.get(i).weight;
				result[s].src = edges.get(i).src;
				result[s].des = edges.get(i).des;
				result[s].weight = edges.get(i).weight;
				s++;
				
			}
		}
		
		System.out.println("");
		System.out.println("src   des   weight");
		for(int i = 0; i < size-1; i ++) {
			System.out.println(result[i].src+"   "+result[i].des+"   "+result[i].weight);
		}
		System.out.println("TOTAL COST == "+totalcost);
	}
	
	public static int find(int[] parent, int e) {
		
		if(parent[e] == -1) {
			//System.out.println("At parent[e] = "+parent[e]);
			return e;
		}
		else {
			//System.out.println("Going into recurssion");
			return find(parent,parent[e]);
		}
		
	}
	
	public static void union(int j, int k, int[] parent) {
		parent[j] = k;
	}
	

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
		
	int[][] graph = { { 0,4,8,0,0,0,0}, 
            { 4,0,9,8,10,0,0}, 
            { 8,9,0,2,0,1,0 }, 
            { 0,8,2,0,7,9,0 }, 
            { 0,10,0,7,0,5,6 },
            { 0,0,1,9,5,0,2}, 
            { 0,0,0,0,6,2,0 }}; 
		
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
					//System.out.println("Added edge from "+i+" to "+j);
					Edge temp = new Edge(i,j,graph[i][j]);
					edges.add(temp);
					System.out.println("Edge added : "+i+" to "+j+" of weight "+graph[i][j]);
				}
			}
		}
	}
		
	// calling the calculate MST method using the kruskal algorithm
	calcMST(edges,n);
		
		
	}

}
