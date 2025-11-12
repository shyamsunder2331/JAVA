import java.util.*;
public class WMST{
    
        public static boolean isAllStars(String s,int n){
            for(int i=0;i<=n;i++){
                if(s.charAt(i)!='*'){
                    return false;
                }
            }
            return true;
        }
        public static boolean spaceOptimized(String s1,String s2){
            int n=s1.length(),m=s2.length();
            boolean[] curr=new boolean[m+1];
            boolean[] prev=new boolean[m+1];
            prev[0]=true;
            for(int i=1;i<=n;i++){
                curr[0]=isAllStars(s1,i);
                for(int j=1;j<=m;j++){
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        curr[j]=prev[j-1];
                    }else{
                        if(s1.charAt(i-1)=='*'){
                            curr[j]=prev[j] || curr[j-1];
                        }else{
                            curr[j]=false;
                        }
                    }
                }
                prev=curr.clone();
            }
            return prev[m];
        }
        public static void main(String[] args) {
        String s1="ab*cd";
        String s2="abdefcd";
        int n=s1.length();
        int m=s2.length();
        boolean[][] dp=new boolean[n+1][m+1];
        Arrays.fill(dp[0],false);
        dp[0][0]=true;
        for(int i=1;i<=n;i++) dp[i][0]=isAllStars(s1, i-1);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    if(s1.charAt(i-1)=='*'){
                        dp[i][j]=dp[i-1][j] || dp[i][j-1];
                    }else{
                        dp[i][j]=false;
                    }
                }
            }
        }
        System.out.println(dp[n][m]);
        System.out.println(spaceOptimized(s1,s2));
    }

}