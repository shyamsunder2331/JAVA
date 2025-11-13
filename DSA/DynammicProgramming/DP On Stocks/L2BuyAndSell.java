// limit the number of transactions onlu to 2
import java.util.*;
public class Main{
    public static void main(String[] args){
        int[] arr=new int[]{3,3,5,0,0,3,1,4};
        int[][][] dp=new int[arr.length+1][2][3];
        for(int[][] i:dp){
            for(int[] j:i){
                Arrays.fill(j,-1);
            }
        }
        int cap=2;
        int ans=memoization(arr,0,0,dp,cap);
        System.out.println(ans);
        int res=tabulation(arr,cap);
        System.out.println(res);
    }
    public static int tabulation(int[] arr,int cap){
        int n=arr.length;
        int[][][] dp=new int [n+1][2][3];
        for(int ind=n-1;ind>=0;ind--){
            for(int j=0;j<2;j++){
                for(int k=1;k<=2;k++){
                if(j==0){
                    dp[ind][j][k]=Math.max(dp[ind+1][0][k],-arr[ind]+dp[ind+1][1][k]);
                }
                if(j==1){
                    dp[ind][j][k]=Math.max(dp[ind+1][1][k],arr[ind]+dp[ind+1][0][k-1]);
                }}
            }
        }
        return dp[0][0][2];
    }
    public static int memoization(int[] arr,int ind,int buy,int[][][] dp,int cap){
        if(ind==arr.length || cap==0) return 0;
        int op1=0,op2=0;
        if(dp[ind][buy][cap]!=-1) return dp[ind][buy][cap];
        if(buy==0){
            op1=memoization(arr,ind+1,0,dp,cap);
            op2=-arr[ind]+memoization(arr,ind+1,1,dp,cap);
        }
        if(buy==1){
            op1=memoization(arr,ind+1,1,dp,cap);
            op2=arr[ind]+memoization(arr,ind+1,0,dp,cap-1);
        }
        return dp[ind][buy][cap]=Math.max(op1,op2);
    }
}
