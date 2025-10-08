import java.util.*;
import java.io.*;
public class MaxSumOfK{
  public static void main(String[] args){
      int[] arr={1,4,2,3,7,5,6,9,2,4,12,15,6,23};
      int k=3;
      int sum=0;
      int maxSum=Integer.MIN_VALUE;
      for(int i=0;i<k;i++){
        sum+=arr[i];
      }
    maxSum=Math.max(sum,maxSum);
    for(int i=k;i<arr.length;i++){
      sum+=arr[i]-arr[i-k];
      maxSum=Math.max(sum,maxSum);
    }
    System.out.println(maxSum);
  }
}
