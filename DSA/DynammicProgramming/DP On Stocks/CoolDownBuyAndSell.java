import java.util.*;
import java.io.*;
public class CoolDownBuyAndSell{
  public static void main(String[] args) throws IOException{
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
    int[] arr=new int[n];
    for(int i=0;i<n;i++){
      arr[i]=Integer.parseInt(br.readLine());
    }
    int[][] dp=new int[n+1][2];
    for(int[] i:dp) Arrays.fill(i,-1);
    int ans=memoization(arr,0,0,dp);
    System.out.println(ans);
  }
  public static int memoization(int[] arr,int ind,int buy,int[][] dp){
    if(ind>=arr.length) return 0;
    if(dp[ind][buy]!=-1) return dp[ind][buy];
    int op1=0,op2=0;
    if(buy==0){
      op1=memoization(arr,ind+1,0,dp);
      op2=-arr[ind]+memoization(arr,ind+1,1,dp);
    }
    if(buy==1){
      op1=memoization(arr,ind+1,1,dp);
      op2=arr[ind]+memoization(arr,ind+2,0,dp);
    }
    return dp[ind][buy]=Math.max(op1,op2);
  }
}

    
