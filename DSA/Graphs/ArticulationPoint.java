import java.util.*;
import java.io.*;
public class ArticulationPoint{
    private static int timer=1;
    public static List<Integer> articulation(int node,int parent,int[] vis,int[] tin,int[] low,int[] mark,List<List<Integer>> graph){
        vis[node]=1;
        tin[node]=low[node]=timer++;
        int child=0;
        for(Integer it:graph.get(node)){
            if(it==parent) continue;
            if(vis[it]==0){
                articulation(it,node,vis,tin,low,mark,graph);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>=tin[node]){
                    mark[node]=1;
                }
                child++;
            }else{
                low[node]=Math.min(low[node],tin[it]);
            }
        }
        if(parent==-1 && child>1){
            mark[node]=1;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<graph.size();i++){
            if(mark[i]==1){
                ans.add(i);
            }
        }
        return ans;
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
        int[] mark=new int[vertices+1];
        int[] low=new int[vertices+1];
        List<Integer> res=articulation(0,-1,vis,tin,low,mark,graph);
        for(Integer i:res){
            System.out.print(i+" ");
        }
    }
}
