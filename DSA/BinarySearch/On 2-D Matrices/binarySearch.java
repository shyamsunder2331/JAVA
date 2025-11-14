// we are making a 2-d array search as the search for a 1-d array in a 2-d sorted array, time complexity is decreasing significantly. arr[I/col][I/col] where I is a overall Index in a 1-d array.
import java.util.*;
import java.io.*;
/* 2   5   9   14
 18  22  27   33
 40  45  52   60*/
public class Main
{
	public static void main(String[] args) {
		int[][] arr=new int[][]{{2,5,9,14},{18,22,27,33},{40,45,52,60}};
		int target=60;
		int[] calls={0};
		boolean flag=false;
		for(int i=0;i<arr.length;i++){
		    for(int j=0;j<arr[0].length;j++){
		        System.out.println(i+" "+j+" "+(++calls[0]));
		        if(arr[i][j]==target){
		            flag=true;
		            break;
		        }
		    }
		    if(flag) break;
		}
		System.out.println(flag+" "+calls[0]);
		calls[0]=0;
		boolean res=binarySearch(arr,calls,0,arr.length*arr[0].length-1,target,flag);
		System.out.println(res+" "+calls[0]);
	}
	public static boolean binarySearch(int[][] arr,int[] calls,int start,int end,int target,boolean flag){
	    calls[0]++;
	    if(start>end) return false;
	    int mid=start+(end-start)/2;
	    int midVal=arr[mid/arr[0].length][mid%arr[0].length];
	    if(midVal==target) return true;
	    else if(midVal<target){
	        return binarySearch(arr,calls,mid+1,end,target,flag);
	    }else{
	       return  binarySearch(arr,calls,start,mid-1,target,flag);
	    }
	}
}
