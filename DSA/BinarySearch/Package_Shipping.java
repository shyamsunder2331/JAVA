import java.util.*;
public class Package_Shipping{
    public static boolean minCap(int[] weights,int capacity,int d){
        int days=1;
        int load=0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]+load<=capacity){
                load+=weights[i];
            }else{
                days=days+1;
                load=weights[i];
            }
        }
        return days<=d;
    }
    public static int minDays(int[] weights,int d){
        int mini=Integer.MAX_VALUE;
        int maxi=0;
        for(int i=0;i<weights.length;i++){
            mini=Math.min(mini,weights[i]);
            maxi+=weights[i];
        }
        System.out.println(mini+" "+maxi);
        for(int i=mini;i<=maxi;i++){
            if(minCap(weights,i,d)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
       System.out.println(minDays(weights,d));
    }
}