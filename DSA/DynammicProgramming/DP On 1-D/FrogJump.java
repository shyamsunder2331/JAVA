import java.util.*;
public class FrogJump{
    public static void main(String[] args){
        int[] height={30,10,60,10,60,50};
        int cost=0;
        int i=0,n=height.length;
        while(i<n-1){
            if(i+2<n){
                int j1=Math.abs(height[i+1]-height[i]);
                int j2=Math.abs(height[i+2]-height[i]);
                if(j1<j2){
                    cost+=j1;
                    i=i+1;
                }else{
                    cost+=j2;
                    i=i+2;
                }
            }else{
                cost+=Math.abs(height[i]-height[i+1]);
                i=i+1;
            }
        }
        System.out.println(cost);
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int ans=memoization(height,height.length-1,dp);
        System.out.println(ans);
        int tab=tabulation(height);
        System.out.println(tab);
        int spaceO=spaceOptimized(height);
        System.out.println(spaceO);
        
    }
    public static int spaceOptimized(int[] height){
        int prev2=0,prev=0;
        for(int i=1;i<height.length;i++){
            int jump2=Integer.MAX_VALUE;
            int jump1=prev+Math.abs(height[i-1]-height[i]);
            if(i>1){
                jump2=prev2+Math.abs(height[i-2]-height[i]);
            }
            int curr=Math.min(jump1,jump2);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public static int tabulation(int[] height){
        int n=height.length;
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int j2=Integer.MAX_VALUE;
            int j1=dp[i-1]+Math.abs(height[i]-height[i-1]);
            if(i>1){
                j2=dp[i-2]+Math.abs(height[i-2]-height[i]);
            }
            dp[i]=Math.min(j1,j2);
        }
        return dp[n-1];
    }
    public static int memoization(int[] height,int ind,int[] dp){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int jumpOne=memoization(height,ind-1,dp)+Math.abs(height[ind]-height[ind-1]);
        int jumpTwo=Integer.MAX_VALUE;
        if(ind>1){
            jumpTwo=memoization(height,ind-2,dp)+Math.abs(height[ind]-height[ind-2]);
        }
        return dp[ind]=Math.min(jumpTwo,jumpOne);
    }
}
