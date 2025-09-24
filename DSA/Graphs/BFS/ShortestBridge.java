import java.util.*;
import java.io.*;
class Pat{
    int xi;
    int yi;
    int distance;
    public Pat(int xi,int yi,int distance){
        this.xi=xi;
        this.yi=yi;
        this.distance=distance;
    }
}
public class ShortestBridge{
    public static void main(String[] args){
        int[][] arr=new int[][]{{1,1,0,0,1},
                                {1,1,0,0,1},
                                {1,1,0,0,1}};
        boolean[][] b=new boolean[arr.length][arr[0].length];
        int x=0,y=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1){
                    x=i;y=j;
                    break;
                }
                
            }
        }
        int[] dx=new int[]{0,0,1,-1};
        int[] dy=new int[]{1,-1,0,0};
        Queue<Pat> q=new ArrayDeque<>();
        Queue<Pat> q2=new ArrayDeque<>();
        q.offer(new Pat(x,y,0));
        while(!q.isEmpty()){
            Pat temp=q.peek();
            q2.offer(q.poll());
            for(int i=0;i<4;i++){
                int nx=temp.xi+dx[i];
                int ny=temp.yi+dy[i];
                if(nx<0 || ny<0 || nx>=arr.length || ny>=arr[0].length || b[nx][ny]==true){
                    continue;
                }
                if(arr[nx][ny]==1){
                    q.offer(new Pat(nx,ny,0));
                    b[nx][ny]=true;
                }
            }
        }
        int mini=Integer.MAX_VALUE;
        while(!q2.isEmpty()){
            Pat temp=q2.poll();
            for(int i=0;i<4;i++){
                int nx=temp.xi+dx[i];
                int ny=temp.yi+dy[i];
                if(nx<0 || ny<0 || nx>=arr.length || ny>=arr[0].length || b[nx][ny]==true){
                    continue;
                }
                if(arr[nx][ny]==0){
                    q2.offer(new Pat(nx,ny,temp.distance+1));
                    b[nx][ny]=true;
                }
                if(arr[nx][ny]==1){
                    mini=Math.min(mini,temp.distance+1);
                    break;
                }
            }
        }
        System.out.println(mini==Integer.MAX_VALUE?-1:mini);
    }
}