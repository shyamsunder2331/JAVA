// printing the longest increasing subsequence, here we need to store prev_ind which helps in making LIS, by back traversing we will add those elements into the list in revrerse order and print the list.
import java.util.*;
import java.io.*;
public class PrintingLIS{
  public static void lis(int[] arr,int[] dp,int[] prev){
    Arrays.fill(dp,1);
    int n=arr.length;
    for(int i=0;i<n;i++){
      for(int j=0;j<i;j++){
        if(arr[j]<arr[i]){
          dp[i]=Math.max(dp[i],1+dp[j]);
          prev[i]=j;
        }
      }
    }
  }
  public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        int[] dp=new int[n];
        int[] prev=new int[n];
        Arrays.fill(prev,-1);
        lis(arr,dp,prev);
        for(int i:dp) System.out.print(i+" ");
        System.out.println();
        int maxInd=0,maxLen=0;
        for(int i=0;i<n;i++){
          if(dp[i]>maxLen){
              maxLen=dp[i];
              maxInd=i;
          }
        }
        System.out.println(maxInd);
        List<Integer> list=new ArrayList<>();
        int curr=maxInd;
        while(curr!=-1){
            list.add(arr[curr]);
            curr=prev[curr];
        }
        
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+" ");
        }
  }
}
