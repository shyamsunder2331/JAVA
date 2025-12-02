import java.util.*;
import java.io.*;
public class TrappingWaterOptimized{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        String[] s=br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        int TrappedWater=0;
        int l=0,r=n-1,maxLeft=0,maxRight=0;
        while(l<=r){
            if(arr[l]<arr[r]){
                if(arr[l]>maxLeft) maxLeft=arr[l];
                else TrappedWater+=maxLeft-arr[l];
                l++;
            }else{
                if(arr[r]>maxRight) maxRight=arr[r];
                else TrappedWater+=maxRight-arr[r];
                r--;
            }
        }
        System.out.println(TrappedWater);
    }
}
