import java.util.*;
import java.io.*;
public class ClimbingStairs{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int[] calls={0};
        int ans=memoization(n,calls,dp);
        System.out.println(ans+" "+calls[0]);
        calls[0]=0;
        int res=memoization(n,calls);
        System.out.println(res+" "+calls[0]);
        int tab=tabulation(n);
        System.out.println(tab);
        int spaceO=spaceOptimized(n);
        System.out.println(spaceO);
    }
    public static int spaceOptimized(int n){
        int prev2=1;
        int prev=2;
        int curr=0;
        for(int i=2;i<n;i++){
            curr=prev2+prev;
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public static int tabulation(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
    public static int memoization(int n,int[] calls){
        calls[0]++;
        if(n<=2) return n;
        return memoization(n-1, calls)+memoization(n-2,calls);
    }
    public static int memoization(int n,int[] calls,int[] dp){
        calls[0]++;
        if(n==1) return 1;
        if(n==2) return 2;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=memoization(n-1,calls,dp)+memoization(n-2,calls,dp);
    }
    
}
