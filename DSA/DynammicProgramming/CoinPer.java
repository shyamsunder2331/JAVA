import java.util.*;
import java.io.*;
public class CoinPer{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(br.readLine());
		}
		int tar=Integer.parseInt(br.readLine());
		int[] dp=new int[tar+1];
		dp[0]=1;
		for(int i=1;i<=tar;i++){
			for(int coin:arr){
				if(coin<=i){
					dp[i]+=dp[i-coin];
				}
			}
		}
		System.out.println(dp[tar]);
	}
}