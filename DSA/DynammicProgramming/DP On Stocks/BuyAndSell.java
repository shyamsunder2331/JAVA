//we can buy and sell a single stock on a day from the given days stock value, we will find maxProfit we can make from it.
import java.util.*;
public class BuyAndSell{
  public static void main(String[] args){
    int[] arr={7,1,5,3,6,4};
    int maxProfit=0;
    int mini=arr[0];
    for(int i=1;i<arr.length;i++){
      int currProfit=arr[i]-mini;
      maxProfit=Math.max(currProfit,maxProfit);
      mini=Math.min(mini,arr[i]);
    }
    System.out.println(maxProfit);
  }
}
