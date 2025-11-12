import java.util.*;
public class Main{
    public static void main(String[] args){
        int[] height=new int[]{30,10,60,10,60,50};
        int[] calls={0};
        int k=3;
        int[] dp=new int[height.length+1];
        Arrays.fill(dp,-1);
        int ans=memoization(height,height.length-1,k,calls,dp);
        System.out.println(ans+" "+calls[0]);
        int tab=tabulation(height,k);
        System.out.println(tab);
    }
    public static int tabulation(int[] height,int k){
        int n=height.length;
        int[] dp=new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int mmSteps=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    mmSteps=Math.min(mmSteps,dp[i-j]+Math.abs(height[i]-height[i-j]));
                }
            }
            dp[i]=mmSteps;
        }
        return dp[n-1];
    }
    public static int memoization(int[] height,int ind,int k,int[] calls,int[] dp){
        calls[0]++;
        if(ind<=0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int mmSteps=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(ind-i>=0){
                mmSteps=Math.min(mmSteps,memoization(height,ind-i,k,calls,dp)+Math.abs(height[ind]-height[ind-i]));
            }
        }
        return dp[ind]=mmSteps;
    }
}
