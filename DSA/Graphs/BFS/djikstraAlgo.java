import java.util.*;
import java.io.*;
class Edg{
    int src;
    int dst;
    int wt;
    public Edg(int src,int dst,int wt){
        this.src=src;
        this.dst=dst;
        this.wt=wt;
    }
}
public class djikstraAlgo{
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
        for(int i=0;i<vertices;i++){
            for(int j=i+1;j<vertices;j++){
                shortestPath(graph, i, j);
            }
        }
        
    }
    public static void shortestPath(ArrayList<Edg>[] graph,int source,int destination){
        boolean[] vis=new boolean[graph.length];
        PriorityQueue<Pairs> pq=new PriorityQueue<>((a,b)->(a.wtsf-b.wtsf));
        pq.offer(new Pairs(source,0));
        while(!pq.isEmpty()){
            Pairs temp=pq.poll();
            vis[temp.src]=true;
            for(Edg e:graph[temp.src]){
                if(vis[e.dst]==false){
                    pq.offer(new Pairs(e.dst,temp.wtsf+e.wt));
                }
                if(e.dst==destination && vis[e.dst]==false){
                    System.out.println("distance berween " + source + " and " + destination + " is "+(temp.wtsf+e.wt));
                    vis[e.dst]=true;
                    break;
                }
            }
        }
    }
}

 class Pairs{
    int src;
    int wtsf;
    public Pairs(int src,int wt){
        this.src=src;
        this.wtsf=wt;
    }
}