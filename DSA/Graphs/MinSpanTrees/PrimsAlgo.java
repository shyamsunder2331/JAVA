import java.util.*;
import java.io.*;
class Edge{
    int src,dst,wt;
    public Edge(int src,int dst,int wt){
        this.src=src;
        this.dst=dst;this.wt=wt;
    }
}
class Pair{
    int weightSum;
    int currNode;
    int parentNode;
    public Pair(int weightSum,int currNode,int parentNode){
        this.weightSum=weightSum;
        this.currNode=currNode;
        this.parentNode=parentNode;
    }
}
public class PrimsAlgo{
    public static int minimum(List<Edge>[] graph,boolean[] vis,List<int[]> result){
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weightSum-b.weightSum);
        pq.offer(new Pair(0,4,-1));
        int sum=0;
        vis[4]=true;
        while(!pq.isEmpty()){
            int n=pq.size();
            for(int i=0;i<n;i++){
                Pair temp=pq.poll();
                if(!vis[temp.currNode]){
                    sum+=temp.weightSum;
                    result.add(new int[]{temp.currNode,temp.parentNode});
                }
                vis[temp.currNode]=true;
                for(Edge j:graph[temp.currNode]){
                    if(!vis[j.dst]){
                        pq.offer(new Pair(j.wt,j.dst,temp.currNode));
                    }
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int vertices=Integer.parseInt(br.readLine());
        int edges=Integer.parseInt(br.readLine());
        List<Edge>[] graph=new ArrayList[vertices];
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
        List<int[]> result=new ArrayList<>();
        int sum=minimum(graph,vis,result);
        System.out.println(sum);
        for(int[] i:result){
            System.out.println(i[0]+" "+i[1]);
        }
    }
}
