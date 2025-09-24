import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Edge{
    int src;
    int dst;
    public Edge(int src,int dst){
        this.src=src;
        this.dst=dst;
    }
}

public class bfsSearch{

    public static void bfs(ArrayList<Edge>[] graph,int source){
        ArrayDeque<Integer> queue=new ArrayDeque<>();
        queue.offer(source);
        boolean[] vis=new boolean[graph.length];
        ArrayList<Integer> list=new ArrayList<>();
        while(!queue.isEmpty()){
            int temp=queue.poll();
            vis[temp]=true;
            for(int i=0;i<graph[temp].size();i++){
                if(!vis[graph[temp].get(i).dst]){
                    queue.offer(graph[temp].get(i).dst);
                }
            }
            if(!list.contains(temp)){
                list.add(temp);
            }
        }
        for(Integer i:list){
            System.out.print(i+" ");
        }
    }
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
        int source=Integer.parseInt(br.readLine());
        bfs(graph,source);
    }
}