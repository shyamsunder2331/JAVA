import java.util.*;
import java.io.*;
public class TrappingWaterBF{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        String[] s=br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        int TrappedWater=0;
        for(int i=0;i<n;i++){
            int maxLef=arr[0];
            int maxRig=arr[n-1];
            for(int j=0;j<i;j++){
                if(maxLef<arr[j]) maxLef=arr[j];
            }
            for(int j=i+1;j<n;j++){
                if(maxRig<arr[j]) maxRig=arr[j];
            }
            if(arr[i]>maxLef && arr[i]>maxRig){
                continue;
            }else{
                TrappedWater+=(Math.min(maxRig,maxLef)-arr[i])>0?Math.min(maxRig,maxLef)-arr[i]:0;
            }
        }
        System.out.println(TrappedWater);
    }
}
