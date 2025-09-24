import java.util.*;
import java.io.*;
class Par{
    int x;
    int y;
    int distance;
    public Par(int x,int y,int distance){
        this.x=x;
        this.y=y;
        this.distance=distance;
    }
}
public class FarFromLand{
    public static void main(String[] args){
        int[][] arr=new int[][]{{1,0,0,1},
                                {0,0,0,0},
                                {1,0,0,1}};
        boolean[][] b=new boolean[arr.length][arr[0].length];
        Queue<Par> q=new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1){
                    q.offer(new Par(i,j,0));
                    arr[i][j]=0;
                    b[i][j]=true;
                }
            }
        }
        int[] x=new int[]{0,0,1,-1};
        int[] y=new int[]{1,-1,0,0};

        while(!q.isEmpty()){
            Par temp=q.poll();
            for(int i=0;i<4;i++){
                int dx=temp.x+x[i];
                int dy=temp.y+y[i];
                if(dx<0 || dy<0 || dx>=arr.length  || dy>=arr[0].length || b[dx][dy]==true){
                    continue;
                }
                if(arr[dx][dy]==0){
                    b[dx][dy]=true;
                    arr[dx][dy]=temp.distance+1;
                    q.offer(new Par(dx,dy,temp.distance+1));
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}