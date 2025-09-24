import java.io.*;
import java.util.*;
public class CoinCom{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[] arr=new int[3];
		for(int i=0;i<3;i++){
			arr[i]=Integer.parseInt(br.readLine());
		}
		int tar=Integer.parseInt(br.readLine());
		int[] dp=new int[tar+1];
		dp[0]=1;
		for(int i=0;i<arr.length;i++){
			for(int j=arr[i];j<dp.length;j++){
				dp[j]+=dp[j-arr[i]];
			}
		}
		System.out.println(dp[tar]);
	}
}
		