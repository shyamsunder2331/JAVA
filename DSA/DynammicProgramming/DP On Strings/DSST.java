// distinct subsequences made from s1 of s2. using Tabulation approach
import java.util.*;
public class DSST {
    public static void main(String[] args){
        String s1="babgbag";
        String s2="bag";
        int n=s1.length();
        int m=s2.length();
        int res=spaceOptimized(s1,s2);
        System.out.println(res);
        int[][] dp=new int[n+1][m+1];
        Arrays.fill(dp[0],0);// every substring will be having empty string if s2 is empty for size 0 then all are empty cells
        for(int i=0;i<n;i++){
            dp[i][0]=1;// if s1 is empty nothing can be made to make s2 right
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][m]);
    }
    public static int spaceOptimized(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int[] curr=new int[m+1];
        int[] prev=new int[m+1];
        prev[0]=1;
        curr[0]=1;
        for(int i=1;i<=n;i++){
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=prev[j-1]+prev[j];
                }else{
                    curr[j]=prev[j];
                }
            }
            prev=curr.clone();
        }
        return prev[m];
    }
}
