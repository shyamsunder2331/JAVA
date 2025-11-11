//shortest common supersequence
public class SCS{
    public static int lcs(String s1,String s2){
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
                p--;q--;
            }else if(dp[p-1][q]>dp[p][q-1]){
                sb.append(s1.charAt(p-1));
                p--;
            }else{
                sb.append(s2.charAt(q-1));
                q--;
            }
        }
        while(p>0){
            sb.append(s1.charAt(p-1));
            p--;
        }
        while(q>0){
            sb.append(s2.charAt(q-1));
            q--;
        }
        System.out.println(sb.reverse());
        return dp[n][m];
    }
    public static void main(String[] args){
        String s1="brute";
        String s2="groot";
        int n=lcs(s1,s2);
        System.out.println(s1.length()+s2.length()-n);
    }
}