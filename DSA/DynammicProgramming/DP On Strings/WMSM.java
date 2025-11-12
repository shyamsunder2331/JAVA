// word matching of strings ? can be matched to any one character, *  can be mapped to any subsequence from starting to the respected index.

import java.util.*;
public class WMSM{
    public static void main(String[] args){
        String s1="ab*cd";
        String s2="abdefcd";
        int[] calls={0};
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        int ans=memoization(s1,s2,s1.length()-1,s2.length()-1,calls,dp);
        System.out.println((ans==1?true:false)+" "+calls[0]);
        
    }
    public static boolean isAllstars(String s,int n){
        for(int i=0;i<=n;i++){
            if(s.charAt(i)!='*') return false;
        }
        return true;
    }
    public static int memoization(String s1,String s2,int i,int j,int[] calls,int[][] dp){
        calls[0]++;
        if(i<0 && j<0) return 1;
        if(i<0 && j>=0) return 0;
        
        if(j<0 && i>=0) return isAllstars(s1,i)?1:0;
        if(dp[i][j]!=-1) return dp[i][j];
        if((s1.charAt(i)==s2.charAt(j)) || s1.charAt(i)=='?') return dp[i][j]=memoization(s1,s2,i-1,j-1,calls,dp);
        else{
            if(s1.charAt(i)=='*') return dp[i][j]=(memoization(s1,s2,i-1,j,calls,dp)==1 || memoization(s1,s2,i,j-1,calls,dp)==1)?1:0;
            else return 0;
        }
    }
}