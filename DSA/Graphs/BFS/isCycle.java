import java.util.*;
import java.io.*;
class Edge{
    int src;
    int dst;
    public Edge(int src,int dst){
        this.src=src;
        this.dst=dst;
    }
}
public class isCycle{
    public static void main(String[] args) throws IOException{
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
            graph[src].add(new Edge(src,dst));
            graph[dst].add(new Edge(dst,src));
        }
        boolean[] vis=new boolean[vertices];
        for(int i=0;i<vertices;i++){
            if(vis[i]==false){
                if(isCycled(graph,i,vis)){
                    break;
                }
            }
        }
    }
    public static boolean isCycled(ArrayList<Edge>[] graph,int src,boolean[] vis){
        ArrayDeque<Pair> q=new ArrayDeque<>();
        q.offer(new Pair(src,src+""));
        boolean flag=false;
        while(!q.isEmpty()){
            Pair temp=q.poll();
            if(vis[temp.v]==true){
                System.out.println(temp.psf);
                flag=true;
                break;
            }
            vis[temp.v]=true;
            for(Edge e:graph[temp.v]){
                if(vis[e.dst]==false){
                    q.offer(new Pair(e.dst,temp.psf+e.dst));
                }
            }
        }
        return flag;
    }
    static class Pair{
        int v;
        String psf;
        public Pair(int v,String psf){
            this.v=v;
            this.psf=psf;
        }
    }
}