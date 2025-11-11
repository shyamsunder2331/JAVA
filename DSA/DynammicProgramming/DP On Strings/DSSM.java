
import java.util.*;
//distinct subsequences containing in a string of another string
public class DSSM{
    public static void main(String[] args){
        String s1="babgbag";
        String s2="bag";
        
        int[][] dp=new int[s1.length()][s2.length()];
        for(int i=0;i<s1.length();i++) Arrays.fill(dp[i],-1);
        int n=memoization(s1,s2,s1.length()-1,s2.length()-1,dp);
        System.out.println(n);
    }
    public static int memoization(String s1,String s2,int ind1,int ind2,int[][] dp){
        if(ind2<0){
            return 1;
        }
        if(ind1<0) return 0;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return dp[ind1][ind2]=memoization(s1,s2,ind1-1,ind2-1,dp)+memoization(s1, s2, ind1-1, ind2,dp);
        }
        else{
            return dp[ind1][ind2]=memoization(s1,s2,ind1-1,ind2,dp);
        }
    }
}