import java.util.*;
import java.io.*;
public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
    int[] arr=new int[n];
    String[] s=br.readLine().split(" ");
    for(int i=0;i<n;i++){
      arr[i]=Integer.parseInt(s[i]);
    }
    int bruteRes=bruteForce(arr,n);
    System.out.println(bruteRes);
    int optimizedRes=optimized(arr,n);
    System.out.println(optimizedRes);
  }
  public static int optimized(int[] arr,int n){
    int[] nse=nselements(arr,n);
    int[] pse=pselements(arr,n);
    for(int i:nse) System.out.print(i+" ");
    System.out.println();
    for(int i:pse) System.out.print(i+" ");
    int total=0;
    for(int i=0;i<n;i++){
      int right=nse[i]-i;
      int left=i-pse[i];
      total+=right*left*arr[i];
    }
    return total;
  }
  public static int[] nselements(int[] arr,int n){
    int[] nse=new int[n];
    Stack<Integer> stack =new Stack<>();
    for(int i=n-1;i>=0;i--){
      while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
        stack.pop();
      }
      nse[i]=stack.isEmpty()?n:stack.peek();
      stack.push(i);
    }
    return nse;
  }
   public static int[] pselements(int[] arr,int n){
    int[] pse=new int[n];
    Stack<Integer> stack =new Stack<>();
    for(int i=0;i<n;i++){
      while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
        stack.pop();
      }
      pse[i]=stack.isEmpty()?-1:stack.peek();
      stack.push(i);
    }
    return pse;
  }  
  public static int bruteForce(int[] arr,int n){
    int mini=Integer.MAX_VALUE;
    int sum=0;
    for(int i=0;i<n;i++){
      mini=arr[i];
      for(int j=i;j<n;j++){
        mini=Math.min(mini,arr[j]);
        sum+=mini;
      }
    }
    return sum;
  }
}
