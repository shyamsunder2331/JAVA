import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
class Edges{
    int src;
    int dst;
    public Edges(int src,int dst){
        this.src=src;
        this.dst=dst;
    }
}
public class perfectFriends {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int vertices=Integer.parseInt(br.readLine());
        int edges=Integer.parseInt(br.readLine());
        ArrayList<Edges>[] graph=new ArrayList[vertices];
        for(int i=0;i<vertices;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges;i++){
            String[] s=br.readLine().split(" ");
            int src=Integer.parseInt(s[0]);
            int dst=Integer.parseInt(s[1]);
            graph[src].add(new Edges(src, dst));
            graph[dst].add(new Edges(dst, src));
        }
        ArrayList<ArrayList<Integer>> comps=new ArrayList<>();
        boolean[] vis=new boolean[vertices];
        for(int i=0;i<vertices;i++){
            if(!vis[i]){
                ArrayList<Integer> comp=new ArrayList<>();
                dfs(graph,i,vis,comp);
                comps.add(comp);
            }
        }
        for(ArrayList<Integer> i:comps){
            System.out.println(i);
        }
        int pairs=0;
        for(int i=0;i<comps.size();i++){
            for(int j=i+1;j<comps.size();j++){
                pairs+=comps.get(i).size()*comps.get(j).size();
                System.out.println(pairs);
            }
        }
        System.out.println( pairs);
    }
    public static void dfs(ArrayList<Edges>[] graph,int src,boolean[] vis,ArrayList<Integer> comp){
        vis[src]=true;
        comp.add(src);
        for(Edges edge:graph[src]){
            if(!vis[edge.dst]){
                dfs(graph, edge.dst, vis, comp);
            }
        }
    }
}