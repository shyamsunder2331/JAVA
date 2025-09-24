import java.util.*;
import java.io.*;
class Pa{
    int x;
    int y;
    int time;
    public Pa(int x,int y,int time){
        this.x=x;
        this.y=y;
        this.time=time;
    }
}
public class rottenOranges {
    public static void main(String[] args){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[][] arr=new int[][]{{2,1,1},
                                {1,1,0},
                                {0,0,1}};
        boolean[][] b=new boolean[arr.length][arr[0].length];
        Queue<Pa> q=new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==2){
                    q.offer(new Pa(i,j,0));
                    arr[i][j]=0;
                    b[i][j]=true;
                }
            }
        }
        int[] x=new int[]{0,0,1,-1};
        int[] y=new int[]{1,-1,0,0};
        while(!q.isEmpty()){
            Pa temp=q.poll();
            for(int i=0;i<4;i++){
                int dx=temp.x+x[i];
                int dy=temp.y+y[i];

                if(dx<0 || dy<0 || dx>=arr.length || dy>=arr[0].length || arr[dx][dy]==0 || b[dx][dy]==true){
                    continue;
                }
                
                if(arr[dx][dy]==1){
                    b[dx][dy]=true;
                    arr[dx][dy]=temp.time+1;
                    q.offer(new Pa(dx,dy,temp.time+1));
                }
            }
        }
        int maxTime=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1 && !b[i][j]){
                    arr[i][j]=-1;
                    System.out.println("we are not able to rot all the ornages in the matrix");
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
                maxTime=Math.max(arr[i][j],maxTime);
            }
            System.out.println();
        }
        System.out.println(maxTime);
    }
}
