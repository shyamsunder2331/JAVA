import java.util.*;
public class Main{
    public static void main(String[] args){
        int[] arr={2,1,4,9};
        int[] dp=new int[arr.length];
        Arrays.fill(dp,-1);
        int max=memoization(arr,arr.length-1,dp);
        System.out.println(max);
        int tab=tabulation(arr);
        System.out.println(tab);
    }
    public static int tabulation(int[] arr){
        int n=arr.length;
        int prev2=arr[0];
        int prev=Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            int curr=Math.max(prev,arr[i]+prev2);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public static int memoization(int[] arr,int ind,int[] dp){
        if(ind<0) return 0;
        if(ind==0) return arr[ind];
        if(dp[ind]!=-1) return dp[ind];
        int pick=arr[ind]+memoization(arr,ind-2,dp);
        int notpick=memoization(arr,ind-1,dp);
        return dp[ind]=Math.max(pick,notpick);
    }
}
