// Longest palindromic Subsequences

public class LPST {
    public static void main(String[] args){
        String s1="samas";
        String s2="";
        for(char i:s1.toCharArray()){
            s2=i+s2;
        }
        System.out.println(s1+" "+s2);
        int n=tabulation(s1,s2);
        int m=spaceOptimized(s1,s2);
        System.out.println(m);
        System.out.println(n);
    }
    public static int spaceOptimized(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int[] curr=new int[m+1];
        int[] prev=new int[m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }
            prev=curr.clone();
        }
        return prev[m];
    }
    public static int tabulation(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        int p=n;
        int q=m;
        while(p>0 && q>0){
            if(s1.charAt(p-1)==s2.charAt(q-1)){
                sb.append(s1.charAt(p-1));
                p--;
                q--;
            }else if(dp[p-1][q]>dp[p][q-1]){
                p--;
            }else{
                q--;
            }
        }
        System.out.println(sb);
        return dp[n][m];
    }
}
