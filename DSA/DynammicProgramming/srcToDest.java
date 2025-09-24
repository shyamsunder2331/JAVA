import java.util.*;
public class srcToDest {
    public static void main(String[] args){
        int[][]  arr=new int[][]{{2,8,4,1,6,4,2},
                                 {6,0,9,5,3,8,5},
                                 {1,4,3,4,0,6,5},
                                 {6,4,7,2,4,6,1},
                                 {1,0,3,7,1,2,7},
                                 {1,5,3,2,3,0,9},
                                 {2,2,5,1,9,8,2}};
        int n=arr.length;
        int m=arr[0].length;
        int[][] dp=new int[n][m];
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1){
                    dp[i][j]=arr[i][j];
                }else if(i==n-1){
                    dp[i][j]=dp[i][j+1]+arr[i][j];
                }else if(j==m-1){
                    dp[i][j]=dp[i+1][j]+arr[i][j];
                }else{
                    dp[i][j]=arr[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
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
