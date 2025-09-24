import java.util.*;
import java.io.*;
class Edges{
    int src;
    int dst;
    public Edges(int x,int y){
        this.src=x;
        this.dst=y;
    }
}
public class MakeConPipe{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int vertices=Integer.parseInt(br.readLine());
        int edges=Integer.parseInt(br.readLine());
        if(edges<vertices-1){
            System.out.println("Unable to make the connections to make all the nodes into a single component");
        }else{
            ArrayList<Edges>[] graph=new ArrayList[vertices];
            for(int i=0;i<vertices;i++){
                graph[i]=new ArrayList<>();
            }
            for(int i=0;i<edges;i++){
                String[] s=br.readLine().split(" ");
                int src=Integer.parseInt(s[0]);
                int dst=Integer.parseInt(s[1]);
                graph[src].add(new Edges(src,dst));
                graph[dst].add(new Edges(dst,src));
            }
            int count=0;
            boolean[] vis=new boolean[vertices];
            for(int i=0;i<vertices;i++){
                if(!vis[i]){
                    traverse(graph,i,vis);
                    count++;
                }
            }
            System.out.println(count-1);
        }
    }
        public static void traverse(ArrayList<Edges>[] graph,int vtx,boolean[] vis){
            vis[vtx]=true;
            for(Edges e:graph[vtx]){
                if(!vis[e.dst]){
                    traverse(graph,e.dst,vis);
                }
            }
        }
}