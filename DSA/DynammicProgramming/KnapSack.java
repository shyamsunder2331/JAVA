import java.util.*;
import java.io.*;
public class KnapSack{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] wts=new int[n];
		int[] profit=new int[n];
		String[] s=br.readLine().split(" ");
		for(int i=0;i<n;i++){
			wts[i]=Integer.parseInt(s[i]);
		}
		String[] p=br.readLine().split(" ");
		for(int i=0;i<n;i++){
			profit[i]=Integer.parseInt(p[i]);
		}
		int cap=Integer.parseInt(br.readLine());
		int[][] dp=new int[n+1][cap+1];
		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){
				if(j>=wts[i-1]){
					int rcap=j-wts[i-1];
					if(dp[i-1][rcap]+profit[i-1]>dp[i-1][j]){
						dp[i][j]=dp[i-1][rcap]+profit[i-1];
					}else{
						dp[i][j]=dp[i-1][j];
					}
				}else{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		System.out.println(dp[n][cap]);
	}
}		