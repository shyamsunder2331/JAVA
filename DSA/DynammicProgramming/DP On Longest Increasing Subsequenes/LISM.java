/* longest increasing subsequence using the memoization technique, there is no need of storing increasing order
   elements in a seperate list and calculate its size while solving LIS length, we can just add 0 incase of 
   non-pick and 1 for pick and add them to the recursive calls which tells from that index what is the length for the LIS.*/
import java.util.*;
import java.io.*;
public class Main{
  public static void main(String[] args)[
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
    int[] arr=new int[n];
    for(int i=0;i<n;i++){
      arr[i]=Integer.parseInt(br.readLine());
    }  
    int ans=memoization(arr,0,-1);
    System.out.println(ans);
  }
  public static int memoization(int[] arr,int ind,int prev_ind){
    if(ind==arr.length) return 0;
    int notTake=0+memoization(arr,ind+1,prev_ind);
    int take=0;
    if(prev_ind==-1 || arr[ind]>arr[prev_ind]){
        take=1+memoization(arr,ind+1,ind);
    }
    return Math.max(take,notTake);
  }
}
