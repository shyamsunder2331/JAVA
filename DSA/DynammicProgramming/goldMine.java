import java.util.*;
public class goldMine {
    public static void main(String[] args){
        int[][] arr=new int[][]{{0,1,4,2,8,2},
                                {4,3,6,5,0,4},
                                {1,2,4,1,4,6},
                                {2,0,7,3,2,2},
                                {3,1,5,9,2,4},
                                {2,7,0,8,5,1}};
        int n=arr.length;
        int m=arr[0].length;
        int[][] dp=new int[n][m];
        for(int j=m-1;j>=0;j--){
            for(int i=n-1;i>=0;i--){
                if(j==m-1){
                    dp[i][j]=arr[i][j];
                }else if(i==0){
                    dp[i][j]=arr[i][j]+Math.max(dp[i][j+1],dp[i+1][j+1]);
                }else if(i==n-1){
                    dp[i][j]=arr[i][j]+Math.max(dp[i-1][j+1],dp[i][j+1]);
                }else{
                    dp[i][j]=arr[i][j]+Math.max(dp[i+1][j+1],Math.max(dp[i][j+1],dp[i-1][j+1]));
                }
            }
        }
        for(int[] i:dp){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
 