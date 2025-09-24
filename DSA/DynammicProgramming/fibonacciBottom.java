import java.util.*;
public class fibonacciBottom {
    public static int dp(int n,int[] res){
        if(n<1){
            res[n]=0;
            return 0;
        }
        if(n==1){
            res[1]=1;
            return 1;}
        if(res[n]!=-1){
            return res[n];
        }
        res[n]=dp(n-1,res)+dp(n-2,res);
        return res[n];
    }
    public static void main(String[] args){
        int n=13;
        int[] res=new int[n+1];
        Arrays.fill(res,-1);
        dp(n,res);
        for(int i:res){
            System.out.print(i+" ");
        }
    }
}
