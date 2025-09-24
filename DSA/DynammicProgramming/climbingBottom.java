
import java.util.*;
public class climbingBottom {
    public static int dp(int n,int[] arr){
        if(arr[n]!=-1) return arr[n];
        if(n==1){
             arr[n]=1;
             return arr[n];
        }
        if(n==2){
            arr[n]=2;
            return arr[n];
        }
        if(n==3){
            arr[n]=4;
            return arr[n];
        }
        arr[n]=dp(n-1,arr)+dp(n-2,arr)+dp(n-3,arr);
        return arr[n];
    }
    public static void main(String[] args){
        int n=10;
        int[] arr=new int[n+1];
        Arrays.fill(arr,-1);
        arr[0]=0;
        dp(n,arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
