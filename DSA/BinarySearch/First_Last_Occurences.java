import java.util.*;
public class First_Last_Occurences{
    public static void main(String[] args){
        int[] arr=new int[]{1,2,3,3,3,3,4,5};
        int[] res=new int[2];
        int target=3;
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i]==target){
        //         res[0]=i;
        //         break;
        //     }
        // }
        // for(int i=arr.length-1;i>=0;i--){
        //     if(arr[i]==target){
        //         res[1]=i;
        //         break;
        //     }
        // }
        // System.out.println(res[0]+" "+res[1]);
        int l=0,r=arr.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==target){
                res[0]=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        l=0;
        r=arr.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==target){
                res[1]=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        System.out.println(res[0]+" "+res[1]);
    }
}