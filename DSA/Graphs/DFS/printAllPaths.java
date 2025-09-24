import java.io.*;
import java.util.*;;
class Edge{
    int src;
    int nbr;
    public Edge(int src,int nbr){
        this.src=src;
        this.nbr=nbr;
    }
}

public class printAllPaths {
    public static void printAllP(ArrayList<Edge>[] graph,int source,int destination,String psf,boolean[] vis){
        if(source==destination){
            System.out.println(psf);
            return;
        }
        vis[source]=true;
        for(Edge edge:graph[source]){
            if(!vis[edge.nbr]){
                printAllP(graph, edge.nbr, destination, psf+edge.nbr+" ", vis);
            }
        }
        vis[source]=false;
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
        boolean flag=true;
        while(flag){
            String sr=br.readLine();
            flag=sr.equals("true");
            if(flag){
            int source=Integer.parseInt(br.readLine());
            int destination=Integer.parseInt(br.readLine());
            String psf=source+" ";
            boolean[] vis=new boolean[vertices];
            printAllP(graph,source,destination,psf,vis);}
            else{
                break;
            }
        }
    }
}
