
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Edge{
    int src;
    int nbr;
    public Edge(int src,int nbr){
        this.src=src;
        this.nbr=nbr;
    }
}
public class connectedComponents{
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
            int nbr=Integer.parseInt(s[1]);
            graph[src].add(new Edge(src, nbr));
            graph[nbr].add(new Edge(nbr, src));
        }
        boolean[] vis=new boolean[vertices];
        int count=0;
        ArrayList<ArrayList<Integer>> comps=new ArrayList<>();
        for(int i=0;i<vertices;i++){
            if(!vis[i]){
                ArrayList<Integer> comp=new ArrayList<>();
                dfs(graph,i,vis,comp);
                comps.add(comp);
                count++;
            }
        }
        System.out.println(comps);
        for(ArrayList<Integer> i:comps){
            for(Integer j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println(count);
    }
    public static void dfs(ArrayList<Edge>[] graph,int src,boolean[] vis,ArrayList<Integer> comp){
        vis[src]=true;
        comp.add(src);
        for(Edge edge:graph[src]){
            if(!vis[edge.nbr]){
                dfs(graph,edge.nbr,vis,comp);
            }
        }
    }
}