// we can do atmost k transactions from the given number of days and return the max Profit we gonna make
import java.util.*;
public class LimitKBuyAndSell{
  public static void main(String[] args) throws IOException{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in);
    int[] arr=new int[]{3,3,5,0,0,3,1,4};
    int cap=Integer.parseInt(br.readLine());
    int[][][] dp=new int[arr.length][2][cap+1];
    for(int[][] i:dp){
      for(int[] j:i){
        Arrays.fill(j,-1);
      }
    }
    int ans=memoization(arr,0,0,cap,dp);
    System.out.println(ans);
  }
  public static int memoization(int[] arr,int buy,int ind,int cap,int[][][] dp){
    if(ind==arr.length || cap==0) return 0;
    if(dp[ind][buy][cap]!=-1) return dp[ind][buy][cap];
    int op1=0;
    int op2=0;
    if(buy==0){
        op1=memoization(arr,0,ind+1,cap,dp);
        op2=-arr[ind]+memoization(arr,1,ind+1,cap,dp);
    }
    if(buy==1){
      op1=memoization(arr,1,ind+1,cap,dp);
      op2=arr[ind]+memoization(arr,0,ind+1,cap,dp);
    }
    return dp[ind][buy][cap]=Math.max(op1,op2);
  }
}
