import java.util.*;
import java.io.*;
class Edges{
    int src;
    int dst;
    public Edges(int src,int dst){
        this.src=src;
        this.dst=dst;
    }
}
public class hamiltonianCycle {
    public static void hamiltonian(ArrayList<Edges>[] graph,int source,String psf,HashSet<Integer> visited,int osrc){
        if(visited.size()==graph.length-1){
            boolean containsHamiltonian=false;
            for(Edges e:graph[source]){
                if(e.dst==osrc){
                    containsHamiltonian=true;
                    break;
                }
            }
            if(containsHamiltonian){
                System.out.println(psf+"*");
            }else{
                System.out.println(psf+".");
            }
            return;
        }
        visited.add(source);
        for(Edges edge:graph[source]){
            if(visited.contains(edge.dst)==false){
                hamiltonian(graph, edge.dst, psf+edge.dst, visited, osrc);
            }
        }
        visited.remove(source);
    }
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
        HashSet<Integer> visited=new HashSet<>();
        int source=Integer.parseInt(br.readLine());
        hamiltonian(graph,source,source+"",visited,source);
    }
    
}
