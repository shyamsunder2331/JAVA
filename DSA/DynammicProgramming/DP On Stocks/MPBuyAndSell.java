// in this we will buy and sell stock as many times as we need, but need to buy before sell, and sell before buying the same stock again.
import java.util.*;
public class MPBuyAndSell{
  public static void main(String[] args){
    int[] arr=new int[]{7,1,5,3,6,4};
    int[] calls={0};
    int[][] dp=new int[arr.length][2];
    for(int[] i:dp) Arrays.fill(i,-1);
    int ans=memoization(arr,0,0,dp,calls);
    System.out.println(ans+" "+calls[0]);
    int tab=tabulation(arr);
    System.out.println(tab);
    int spaceO=spaceOptimization(arr);
    System.out.println(spaceO);
  }
  public static int spaceOptimization(int[] arr){
      int n=arr.length;
      int buyO=0,sellO=0;
      int profit=0;
      for(int i=n-1;i>=0;i--){
          for(int j=0;j<2;j++){
              if(j==0){
                  profit=Math.max(buyO,-arr[i]+sellO);
              }
              if(j==1){
                  profit=Math.max(sellO,arr[i]+buyO);
              }
              if(j==0) buyO=profit;
              else sellO=profit;
          }
      }
      return buyO;
  }
  public static int tabulation(int[] arr){
      int[][] dp=new int[arr.length+1][2];
      int n=arr.length;
      dp[n][0]=dp[n][1]=0;
      int profit=0;
      for(int i=n-1;i>=0;i--){
          for(int j=0;j<2;j++){
              if(j==0){
                  profit=Math.max(dp[i+1][0],-arr[i]+dp[i+1][1]);
              }else{
                  profit=Math.max(dp[i+1][1],arr[i]+dp[i][0]);
              }
              dp[i][j]=profit;
          }
      }
      return dp[0][0];
  }
public static int memoization(int[] arr,int ind,int buy,int[][] dp,int[] calls){
  calls[0]++;
  int op1=0,op2=0;
  if(ind==arr.length) return 0;
  if(dp[ind][buy]!=-1) return dp[ind][buy];
  if(buy==0){
    op1=memoization(arr,ind+1,0,dp,calls);
    op2=-arr[ind]+memoization(arr,ind+1,1,dp,calls);
  }
  if(buy==1){
    op1=memoization(arr,ind+1,1,dp,calls);
    op2=arr[ind]+memoization(arr,ind+1,0,dp,calls);
  }
  return dp[ind][buy]=Math.max(op1,op2);
}
}
