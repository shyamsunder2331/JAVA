/* longest increasing subsequence using the memoization technique, there is no need of storing increasing order
   elements in a seperate list and calculate its size while solving LIS length, we can just add 0 incase of 
   non-pick and 1 for pick and add them to the recursive calls which tells from that index what is the length for the LIS.*/
/* longest increasing subsequence using the memoization technique, there is no need of storing increasing order
   elements in a seperate list and calculate its size while solving LIS length, we can just add 0 incase of 
   non-pick and 1 for pick and add them to the recursive calls which tells from that index what is the length for the LIS.*/
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
    int[] calls={0};
    int[][] dp=new int[n][n+1];
    for(int[] i:dp) Arrays.fill(i,-1);
    int ans=memoization(arr,0,-1,calls,dp);
    System.out.println(ans+" "+calls[0]);
    int tab=tabulation(arr);
    System.out.println(tab);
    int spaceO=spaceOptimization(arr);
    System.out.println(spaceO);
  }
  public static int spaceOptimization(int[] arr){
      int n=arr.length;
      int[] curr=new int[n+1];
      int[] next=new int[n+1];
      Arrays.fill(next,-1);
      for(int i=n-1;i>=0;i--){
          for(int j=n-1;j>=-1;j--){
              int notTake=next[j+1];
              int take=0;
              if(j==-1 || arr[i]>arr[j]){
                  take=1+next[i+1];
              }
              curr[j+1]=Math.max(take,notTake);
          }
          next=curr.clone();
      }
      return next[0];
  }
  public static int tabulation(int[] arr){
      int n=arr.length;
      int[][] dp=new int[n+1][n+1];
      Arrays.fill(dp[n],0);
      for(int i=n-1;i>=0;i--){
          for(int j=n-1;j>=-1;j--){
              int notTake=dp[i+1][j+1];
              int take=0;
              if(j==-1 || arr[i]>arr[j]){
                  take=1+dp[i+1][i+1];
              }
              dp[i][j+1]=Math.max(take,notTake);
          }
      }
      return dp[0][0];
  }
  public static int memoization(int[] arr,int ind,int prev_ind,int[] calls,int[][] dp){
      calls[0]++;
    if(ind==arr.length) return 0;
    if(dp[ind][prev_ind+1]!=-1) return dp[ind][prev_ind+1];
    int notTake=0+memoization(arr,ind+1,prev_ind,calls,dp);
    int take=0;
    if(prev_ind==-1 || arr[ind]>arr[prev_ind]){
        take=1+memoization(arr,ind+1,ind,calls,dp);
    }
    return dp[ind][prev_ind+1]=Math.max(take,notTake);
  }
}
