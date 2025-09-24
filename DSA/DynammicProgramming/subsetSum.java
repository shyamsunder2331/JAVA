import java.util.*;
public class subsetSum {
    public static void main(String[] args){
        int[] arr=new int[]{4,2,7,1,3};
        int tar=10;
        int n=arr.length;
        boolean[][] dp=new boolean[n+1][tar+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=tar;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                }else if(i==0){
                    dp[i][j]=false;
                }else if(j==0){
                    dp[i][j]=true;
                }else{
                    // First option: don't include current element
                    dp[i][j] = dp[i-1][j];
                    
                    // Second option: include current element if possible
                    int val=arr[i-1];
                    if(j >= val && dp[i-1][j-val] == true){
                        dp[i][j] = true;
                    }
                }
            }
        }
        System.out.println(dp[n][tar]); 
    }
}
