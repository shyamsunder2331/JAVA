import java.util.*;
class Floor_Ceil{
public static void main(String args[]){
        int[] arr=new int[]{12,23,26,34,37,41,46,65,78,99};
        int l=0,r=arr.length-1;
        int ceil=0,floor=0;
        int value=43;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>=value){
                r=mid-1;
                ceil=arr[mid];
            }else{
                l=mid+1;
            }
        }
        l=0;
        r=arr.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]<=value){
                floor=arr[mid];
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        System.out.println(ceil+" "+floor);
    }
}