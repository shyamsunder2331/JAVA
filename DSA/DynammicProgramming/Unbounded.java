import java.util.*;
import java.io.*;
public class Unbounded{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] wts=new int[n];
		int[] pft=new int[n];
		String[] s=br.readLine().split(" ");
		for(int i=0;i<n;i++){
			wts[i]=Integer.parseInt(s[i]);
		}
		String[] p=br.readLine().split(" ");
		for(int i=0;i<n;i++){
			pft[i]=Integer.parseInt(p[i]);
		}	
		int tar=Integer.parseInt(br.readLine());
		int[] dp=new int[tar+1];
		dp[0]=0;
		for(int i=1;i<dp.length;i++){
				int max=0;
			for(int j=0;j<n;j++){
				if(i>=wts[j]){
					if(dp[i-wts[j]]+pft[j]>max){
						max=dp[i-wts[j]]+pft[j];
					}
				}
			}
			dp[i]=max;
		}
		System.out.println(dp[tar]);
	}
}
