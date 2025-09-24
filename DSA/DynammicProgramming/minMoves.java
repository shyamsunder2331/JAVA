import java.util.*;
public class minMoves{
    public static void main(String[] args){
        int[] arr=new int[]{3,2,4,2,0,2,3,1,2,2};
        Integer[] dp=new Integer[arr.length+1];
        int n=arr.length;
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>0){
                int min=Integer.MAX_VALUE;
                for(int j=1;j<=arr[i];j++){
                    if(i+j<n+1 && dp[i+j]!=null){
                        min=Math.min(min,dp[i+j]+1);
                    }
                }
                if(min!=Integer.MAX_VALUE){
                    dp[i]=min;
                }else{
                    dp[i]=null;
                }
            }
        }
        Arrays.stream(dp).forEach(i->System.out.print(i+" "));
        System.out.println(dp[0]);
    }
}