import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameUI.InternalFramePropertyChangeListener;

import java.io.*;

public class DAGTopo{
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
            graph[src].add(new Edge(src, dst));
        }

        boolean[] vis=new boolean[vertices];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<vertices;i++){
            if(vis[i]==false){
                topoSort(graph,i,vis,stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
    public static void topoSort(ArrayList<Edge>[] graph,int source,boolean[] vis,Stack<Integer> stack){
        vis[source]=true;
        for(Edge e:graph[source]){
            if(vis[e.dst]==false){
                topoSort(graph, e.dst, vis, stack);
            }
        }
        stack.push(source);
    }
}