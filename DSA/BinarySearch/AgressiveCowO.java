import java.util.*;
class AgressiveCowO{
    public static boolean canWePlace(int[] stalls,int dist,int k){
        int cowsCount=1;
        int last=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if((stalls[i]-last)>=dist){
                cowsCount++;
                last=stalls[i];
            }
            if(cowsCount>=k){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int res=0;
        int n=stalls.length;
        Arrays.sort(stalls);
        int mini=1,maxi=(stalls[n-1]-stalls[0]);
        while(mini<=maxi){
            int mid=mini+(maxi-mini)/2;
            if(canWePlace(stalls,mid,k)){
                mini=mid+1;
            }else{
                maxi=mid-1;
            }
            res=maxi;
        }
        System.out.println(res);
        
    }
}