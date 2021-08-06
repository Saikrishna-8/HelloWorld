import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class DisjointSets {    // Graph 
	
	static ArrayList<LinkedList<Integer>> al;
	static int[] arr;
	
	int V,E;
	Edge edge[];
	
	class Edge
	{
		int src, dest;
	};
	public DisjointSets(int V,int E) {
		
		this.E=E;
		this.V=V;
		edge =new Edge[E];
		for(int i=0;i<E;i++)
		{
			edge[i]=new Edge();
		}
	}
	public static int find(int i)
	{
		if(arr[i]==-1)
			return i;
		return arr[i];
	}
	
	public static void union(int x,int y)
	{
		if(al.get(x).size() >= al.get(y).size())
		{
			al.get(x).addAll(al.get(y));
		
			for(int i:al.get(y))
			{
				arr[i]=x;
			}
			
		}
		else
		{
			al.get(y).addAll(al.get(x));
			for(int i:al.get(x))
			{
				arr[i]=y;
			}
			
			
		}
	}
	public static int isCycle(DisjointSets graph)
	{
		for(int i=0;i<graph.E;i++)
		{
		 int x = find(graph.edge[i].src);
		 int y = find(graph.edge[i].dest);
		 if(x==y)
			 return 1;
		 union(x,y);
		}
		
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 /* Let us create the following graph
               
         4  5      0
         | /      | \
         |/       |  \
         3--------1---2
                
    
                */
		
		 int V = 6, E = 5;
		 
		 DisjointSets graph=new DisjointSets(V,E);
		 //this will create edge[] object for holding edges
		 
		 // add edge 0-1
	        graph.edge[0].src = 0;
	        graph.edge[0].dest = 1;
	 
	        // add edge 1-2
	        graph.edge[1].src = 1;
	        graph.edge[1].dest = 2;
	 
	        // add edge 0-2
	    //    graph.edge[2].src = 0;
	    //    graph.edge[2].dest = 2;
	        graph.edge[2].src = 3;
		    graph.edge[2].dest = 4;
		    
		    graph.edge[3].src = 3;
		    graph.edge[3].dest = 5;
		    
		    graph.edge[4].src = 1;
		    graph.edge[4].dest = 3;
		    
	        
	        arr=new int[V];
	        Arrays.fill(arr, -1);
	        
	        al=new ArrayList<LinkedList<Integer>>(V);
	   
	        for(int i=0;i<V;i++)
	        {
	        	LinkedList<Integer> list=new LinkedList<Integer>();
	        	list.add(i);
	        	al.add(i,list);
	        }  
	        
	        if(isCycle(graph)==1)
	        	System.out.println("Cycle is Detected");
	        else
	        	System.out.println("No Cycle is Detected");
	        
	        for(int i:al.get(0))
	        System.out.println(i);
	        
	        for(int i=0;i<arr.length;i++)
	        	System.out.print(arr[i]+" ");
	}
}
