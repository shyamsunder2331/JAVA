// for every transaction you gonna make , you are going to pay a transaction fee of user input
import java.util.*;
import java.io.*;
public class Main{
  public static void main(String[] args) throws IOException{
    
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
    int[] arr=new int[n];
    for(int i=0;i<n;i++){
      arr[i]=Integer.parseInt(br.readLine());
    }
    int[][] dp=new int[n][2];
    for(int[] i:dp) Arrays.fill(i,-1);
    int fee=Integer.parseInt(br.readLine());
    int ans=memoization(arr,0,0,fee,dp);
    System.out.println(ans);
  }
  public static int memoization(int[] arr,int ind,int buy,int fee,int[][] dp){
    if(ind==arr.length) return 0;
    if(dp[ind][buy]!=-1) return dp[ind][buy];
    int op1=0,op2=0;
    if(buy==0){
      op1=memoization(arr,ind+1,0,fee,dp);
      op2=-arr[ind]+memoization(arr,ind+1,1,fee,dp);
    }
    if(buy==1){
      op1=memoization(arr,ind+1,1,fee,dp);
      op2=arr[ind]-fee+memoization(arr,ind+1,0,fee,dp);
    }
    return dp[ind][buy]=Math.max(op1,op2);
  }
}
