import java.util.*;
class Pai{
    int x;
    int y;
    public Pai(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class zeroOneMatrix{
    public static void main(String[] args){
        int[][] arr=new int[][]{{0,0,0,0},
                                {1,0,1,0},
                                {1,1,0,1},
                                {1,1,11}};
        Queue<Pai> q=new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){,
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==0){
                    q.offer(new Pai(i,j));
                }else{
                    arr[i][j]=-arr[i][j];
                }
            }
        }
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        while(!q.isEmpty()){
            Pai temp=q.poll();
            for(int i=0;i<4;i++){
                int nx=temp.x+dx[i];
                int ny=temp.y+dy[i];
                if(nx<0 || ny<0 || nx>=arr.length || ny>=arr[0].length || arr[nx][ny]>=0){
                    continue;
                }else{
                    arr[nx][ny]=arr[temp.x][temp.y]+1;
                    q.offer(new Pai(nx,ny));
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