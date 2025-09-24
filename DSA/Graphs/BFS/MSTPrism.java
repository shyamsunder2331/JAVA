import java.util.*;
import java.io.*;
class Pairr{
	int vertex;
	int parent;
	int wt;
	public Pairr(int vertex,int parent,int wt){
		this.vertex=vertex;
		this.parent=parent;
		this.wt=wt;
	}
}
public class MSTPrism{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int vertices=Integer.parseInt(br.readLine());
		int edges=Integer.parseInt(br.readLine());
		ArrayList<Edg>[] graph=new ArrayList[vertices];
		for(int i=0;i<vertices;i++){
			graph[i]=new ArrayList<>();
		}
		for(int i=0;i<edges;i++){
			String[] s=br.readLine().split(" ");
			int src=Integer.parseInt(s[0]);
			int dst=Integer.parseInt(s[1]);
			int wt=Integer.parseInt(s[2]);
			graph[src].add(new Edg(src,dst,wt));
			graph[dst].add(new Edg(dst,src,wt));
		}
		boolean[] vis=new boolean[vertices];
		
		PriorityQueue<Pairr> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
		int source=Integer.parseInt(br.readLine());
		pq.offer(new Pairr(source,-1,0));
		int totalWeight=0;
		while(!pq.isEmpty()){
			Pairr rem=pq.poll();
			if(vis[rem.vertex]) continue;
			vis[rem.vertex]=true;
			if(rem.parent!=-1){
				System.out.println(rem.parent+"-"+rem.vertex+"@"+rem.wt);
				totalWeight+=rem.wt;
			}
			for(Edg e:graph[rem.vertex]){
				if(!vis[e.dst]){
					pq.offer(new Pairr(e.dst,rem.vertex,e.wt));
				}
			}
		}
		System.out.println("TotalWeight="+totalWeight);
	}
}
