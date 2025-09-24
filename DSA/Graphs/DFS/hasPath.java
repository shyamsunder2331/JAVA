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
public class hasPath{

    public static boolean hasPatho(ArrayList<Edge>[] graph,int source,int destination,boolean[] visited){
        if(source==destination){
            return true;
        }
        visited[source]=true;
        for(Edge edge:graph[source]){
            if(!visited[edge.nbr]){
                boolean pathi=hasPatho(graph, edge.nbr, destination, visited);
                if(pathi){
                    return true;
                }
            }
        }
        return false;
    }
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
            int nbr=Integer.parseInt(s[1]);
            graph[src].add(new Edge(src, nbr));
            graph[nbr].add(new Edge(nbr, src));
        }

        for(int i=0;i<vertices;i++){
            for(Edge j:graph[i]){
                System.out.println(j.src+" "+j.nbr);
            }
            System.out.println();
        }
        int source=Integer.parseInt(br.readLine());
        int destination=Integer.parseInt(br.readLine());
        boolean[] visited=new boolean[vertices];
        boolean path=hasPatho(graph,source,destination,visited);
        System.out.println(path);
    }
}