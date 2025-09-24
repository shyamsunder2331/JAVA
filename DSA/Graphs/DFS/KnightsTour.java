import java.util.*;
import java.io.*;
class Edg{
    int src;
    int nbr;
    public Edg(int src,int nbr){
        this.src=src;
        this.nbr=nbr;
    }
}
public class KnightsTour{
    public static void printl(int[][] graph){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[0].length;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean tour(int[][] graph,int move,int row,int col){
        if(row<0 || col<0 || row>=graph.length || col>=graph[0].length ||  graph[row][col] != -1){
            return false;
        }

        if(move==graph.length*graph[0].length-1){
            graph[row][col]=move;
            printl(graph);
            // leave as-is or reset; we return true to stop search
            return true;
        }
        
        graph[row][col]=move;
        if(tour(graph, move+1, row-2, col+1)) return true;
        if(tour(graph, move+1, row-1, col+2)) return true;
        if(tour(graph, move+1, row+1, col+2)) return true;
        if(tour(graph, move+1, row+2, col+1)) return true;
        if(tour(graph, move+1, row+2, col-1)) return true;
        if(tour(graph, move+1, row+1, col-2)) return true;
        if(tour(graph, move+1, row-1, col-2)) return true;
        if(tour(graph, move+1, row-2, col-1)) return true;
        graph[row][col]=-1;
        return false;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] graph=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(graph[i], -1);
        }
        int move=0;
        int row=Integer.parseInt(br.readLine());
        int col=Integer.parseInt(br.readLine());
        boolean found = tour(graph, move, row, col);
        if(!found){
            System.out.println("No tour found");
        }
    }
}