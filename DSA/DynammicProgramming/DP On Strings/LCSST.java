// Longest common substring Tabulation approach with space optimization
public class LCSST{
    public static void main(String[] args){
        String s1="shyamsunder";
        String s2="shyamsunderakash";
        int n=s1.length(),m=s2.length();
        int ans=0;
        int[] curr=new int[m+1];
        int[] prev=new int[m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                    ans=Math.max(curr[j],ans);
                }else{
                    curr[j]=0;
                }
            }
            prev=curr.clone();
        }
        System.out.println(ans);
        int res=unOptimized(s1,s2);
        System.out.println(res);
    }
    public static int unOptimized(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        int ans=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    ans=Math.max(dp[i][j],ans);
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }
}