import java.util.*;
import java.io.*;
public class KosarjuAlgo{
    public static void dfs(int node,List<List<Integer>> graph,int[] vis,Stack<Integer> stack){
        vis[node]=1;
        for(Integer it:graph.get(node)){
            if(vis[it]==0){
                dfs(it,graph,vis,stack);
            }
        }
        stack.push(node);
    }
    public static void dfs3(int node,List<List<Integer>> graphT,int[] vis,List<Integer> temp){
        vis[node]=1;
        for(Integer it:graphT.get(node)){
            if(vis[it]==0){
                temp.add(it);
                dfs3(it,graphT,vis,temp);
            }
        }
    }
    public static int kosarju(List<List<Integer>> graph,int vertices){
        int[] vis=new int[vertices+1];
        Stack<Integer> stack=new Stack<>();
      //add dfs elements into the stack
        for(int i=0;i<vertices;i++){
            if(vis[i]==0){
                dfs(i,graph,vis,stack);
            }
        }
      //reverse the edges in the graph and create a new graph edgeT
        List<List<Integer>> graphT=new ArrayList<>();
        for(int i=0;i<vertices;i++){
            graphT.add(new ArrayList<>());
        }
        Arrays.fill(vis,0);
        for(int i=0;i<vertices;i++){
            for(Integer it:graph.get(i)){
                graphT.get(it).add(i);
            }
        }
        int count=0;
        List<List<Integer>> result=new ArrayList<>();
      // Do the dfs traversal and calculate the Strongly connected components and the scc elements into the result list.
        while(!stack.isEmpty()){
            int node=stack.pop();
            if(vis[node]==0){
                List<Integer> temp=new ArrayList<>();
                count++;
                temp.add(node);
                dfs3(node,graphT,vis,temp);
                result.add(temp);
            }
        }
        for(List<Integer> i:result){
            for(Integer j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int vertices=Integer.parseInt(br.readLine());
        int edges=Integer.parseInt(br.readLine());
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<vertices;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges;i++){
            String[] s=br.readLine().split(" ");
            int u=Integer.parseInt(s[0]);
            int v=Integer.parseInt(s[1]);
            graph.get(u).add(v);
        }
        int n=kosarju(graph,vertices);
        System.out.println(n);
    }
}
