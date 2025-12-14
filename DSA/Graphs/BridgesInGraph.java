import java.util.*;
import java.io.*;

public class BridgesInGraph
{
    private static int timer=1;
    public static void dfs(int node,int parent,int[] vis,int[] tin,int[] low,List<List<Integer>> graph,List<List<Integer>> result){
        vis[node]=1;
        tin[node]=low[node]=timer;
        timer++;
        for(Integer it:graph.get(node)){
            if(it==parent) continue;
            if(vis[it]==0){
                dfs(it,node,vis,tin,low,graph,result);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>tin[node]){
                    result.add(Arrays.asList(node,it));
                }
            }else{
                low[node]=Math.min(low[node],tin[it]);
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int vertices=Integer.parseInt(br.readLine());
		int edges=Integer.parseInt(br.readLine());
		List<List<Integer>> graph=new ArrayList<>();
		for(int i=0;i<=vertices;i++){
		    graph.add(new ArrayList<>());
		}
		for(int i=0;i<edges;i++){
		    String[] s=br.readLine().split(" ");
		    int u=Integer.parseInt(s[0]);
		    int v=Integer.parseInt(s[1]);
		    graph.get(u).add(v);
		    graph.get(v).add(u);
		}
		int[] vis=new int[vertices+1];
		int[] tin=new int[vertices+1];
		int[] low=new int[vertices+1];
		List<List<Integer>> result=new ArrayList<>();
		dfs(1,-1,vis,tin,low,graph,result);
		for(List<Integer> i:result){
		    for(Integer j:i){
		        System.out.print(j+" ");
		    }
		    System.out.println();
		}
	}
}
