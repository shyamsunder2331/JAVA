import java.util.*;
public class Search_Rotates {
    public static void main(String[] args){
        List<Integer> arr=Arrays.asList(4,5,6,7,0,1,2);
        int res=-1;
        int target=0;
        int l=0,r=arr.size()-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr.get(mid)==target){
                res=mid;
                break;
            }
            if(arr.get(l)<=arr.get(mid)){
                if(arr.get(l)<=target && arr.get(mid)>=target){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(arr.get(mid)<target && arr.get(r)>=target){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        System.out.println(res);
    }
}