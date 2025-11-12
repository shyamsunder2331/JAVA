import java.util.*;
public class Main
{
	public static void main(String[] args) {
    	String s1="horse";
    	String s2="ros";
    	int[][] dp=new int[s1.length()][s2.length()];
    	for(int[] i:dp) Arrays.fill(i,-1);
    	int[] calls={0};
    	int ans=memoization(s1,s2,s1.length()-1,s2.length()-1,dp,calls);
    	System.out.println(ans+" "+calls[0]);
    	int n=s1.length();
    	int m=s2.length();
    	int[][] tb=new int[n+1][m+1];
    	for(int i=0;i<n;i++) tb[i][0]=i;
    	for(int i=0;i<m;i++) tb[0][i]=i;
    	for(int i=1;i<=n;i++){
    	    for(int j=1;j<=m;j++){
    	        if(s1.charAt(i-1)==s2.charAt(j-1)){
    	            tb[i][j]=dp[i-1][j-1];
    	        }else{
    	            tb[i][j]=1+Math.min(tb[i-1][j-1],Math.min(tb[i-1][j],tb[i][j-1]));
    	        }
    	    }
    	}
    	System.out.println(tb[n][m]);
    	int sans=spaceOptimized(s1,s2);
    	System.out.println(sans);
	}
	public static int spaceOptimized(String s1,String s2){
	    int n=s1.length();
	    int m=s2.length();
	    int[] prev=new int[m+1];
	    for(int i=0;i<=m;i++) prev[i]=i;
	    int[] curr=new int[m+1];
	    for(int i=1;i<=n;i++){
	        curr[0]=i;
	        for(int j=1;j<=m;j++){
	            if(s1.charAt(i-1)==s2.charAt(j-1)){
	                curr[j]=prev[j-1];
	            }else{
	                curr[j]=1+Math.min(curr[j-1],Math.min(prev[j-1],prev[j]));
	            }
	        }
	        prev=curr.clone();
	    }
	    return prev[m];
	}
	public static int memoization(String s1,String s2,int i,int j,int[][] dp,int[] calls){
	    calls[0]++;
	    if(i<0){
	        return j+1;
	    }
	    if(j<0){
	        return i+1;
	       }
	       if(dp[i][j]!=-1) return dp[i][j];
	    if(s1.charAt(i)==s2.charAt(j)){
	        return dp[i][j]=memoization(s1,s2,i-1,j-1,dp,calls);
	    }
	    return dp[i][j]=1+Math.min(memoization(s1,s2,i-1,j,dp,calls),Math.min(memoization(s1,s2,i-1,j-1,dp,calls),memoization(s1,s2,i,j-1,dp,calls)));
	}
}
