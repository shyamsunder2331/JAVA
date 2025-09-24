import java.util.*;
public class NoOfIslanda{
    public static void main(String[] args){
        int[][] graph={{0,0,1,1,1,0,0},
                       {0,0,0,1,1,0,1},
                       {1,1,0,0,0,0,1},
                       {0,0,0,1,1,1,1},
                       {1,1,0,0,1,1,1},
                       {1,1,1,1,1,1,0}};
        boolean[][] vis=new boolean[graph.length][graph[0].length];
        int count=0;
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[0].length;j++){
                if(!vis[i][j] && graph[i][j]==0){
                    drawTree(graph,i,j,vis);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void drawTree(int[][] graph,int i,int j,boolean[][] vis){
        if( i<0 || j<0 || i>=graph.length || j>=graph[0].length || graph[i][j]==1 || vis[i][j]==true){
            return;
        }
        vis[i][j]=true;
        drawTree(graph, i-1, j, vis);
        drawTree(graph, i, j+1, vis);
        drawTree(graph, i+1, j, vis);
        drawTree(graph, i, j-1, vis);
    }
}