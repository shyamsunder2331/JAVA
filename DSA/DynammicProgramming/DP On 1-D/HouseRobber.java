import java.util.*;
public class Main{
    public static void main(String[] args){
        int[] arr={1,5,2,1,6};
        int n=arr.length;
        int[] arr1=new int[arr.length-1];
        int[] arr2=new int[arr.length-1];
        for(int i=0;i<arr.length;i++){
            if(i!=n-1) arr1[i]=arr[i];
            if(i!=0) arr2[i-1]=arr[i];
        }
        int ans1=spaceOptimized(arr1);
        int ans2=spaceOptimized(arr2);
        System.out.println(Math.max(ans1,ans2));
    }
    public static int spaceOptimized(int[] arr){
        int prev2=arr[0];
        int prev=Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            int curr=Math.max(prev,arr[i]+prev2);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}
