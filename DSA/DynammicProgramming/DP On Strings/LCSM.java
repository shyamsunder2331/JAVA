// Longest common subsequences memoization approach
import java.util.*;
public class LCSM{
    public static void main(String[] args){
        String s1="shyam";
        String s2="shyamsunder";
        int[][] dp=new int[s1.length()][s2.length()];
        for(int[] i:dp) Arrays.fill(i,-1);
        int n=memoization(s1,s2,s1.length()-1,s2.length()-1,dp);
        System.out.println(n);
    }
    public static int memoization(String s1,String s2,int ind1,int ind2,int[][] dp){
        if(ind1<0 || ind2<0) return 0;
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return 1+memoization(s1,s2,ind1-1,ind2-1,dp);
        }
        return Math.max(memoization(s1, s2, ind1-1, ind2, dp),memoization(s1, s2, ind1, ind2-1, dp));
    }
}