import java.util.*;
import java.io.*;
class Edge{
    int src;
    int dst;
    int wt;
    public Edge(int src,int dst,int wt ){
        this.src=src;
        this.dst=dst;
        this.wt=wt;
    }
}
class Pair{
    int vertex;
    int parent;
    int wt;
    public Pair(int vertex,int parent,int wt){
        this.vertex=vertex;this.parent=parent;this.wt=wt;
    }
}
public class MSP
{
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int vertices=Integer.parseInt(br.readLine());
		int edges=Integer.parseInt(br.readLine());
		ArrayList<Edge>[] graph=new ArrayList[vertices];
		for(int i=0;i<vertices;i++){
		    graph[i]=new ArrayList<>();
		}
		for(int i=0;i<edges;i++){
		    String[] s=br.readLine().split(" ");
		    int src=Integer.parseInt(s[0]);
		    int dst=Integer.parseInt(s[1]);
		    int wt=Integer.parseInt(s[2]);
		    graph[src].add(new Edge(src,dst,wt));
		    graph[dst].add(new Edge(dst,src,wt));
		}
		boolean[] vis=new boolean[vertices];
		PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.wt-b.wt);
		String[] psf={""};
		minimumSpanTree(graph,0,vis,q,psf);
	}
	public static void minimumSpanTree(ArrayList<Edge>[] graph,int source,boolean[] vis,PriorityQueue<Pair> q,String[] psf){
	    q.offer(new Pair(source,-1,0));
	    int totalWeight=0;
	    Pair res=null;
	    while(!q.isEmpty()){
	        Pair temp=q.poll();
	        res=temp;
	        if(vis[temp.vertex]==true) continue;
	        vis[temp.vertex]=true;
	        totalWeight+=temp.wt;
	        psf[0]+=temp.vertex;
	        for(Edge e:graph[temp.vertex]){
	            if(vis[e.dst]==false){
	                q.offer(new Pair(e.dst,temp.vertex,e.wt));
	            }
	        }
	    }
	    System.out.println(psf[0]+" "+totalWeight);
	}
}
