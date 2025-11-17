import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		List<int[]> list=new ArrayList<>();
		for(int i=0;i<n;i++){
		    String[] s=br.readLine().split(" ");
		    list.add(new int[]{Integer.parseInt(s[0]),Integer.parseInt(s[1])});
		}
		List<int[]> ans=gapInterval(list,0,22);
		for(int[] i:ans){
		    System.out.println(i[0]+" "+i[1]);
		}
	}
	public static List<int[]> gapInterval(List<int[]> list,int start,int end){
	    int prev=0;
	    List<int[]> ans=new ArrayList<>();
	    for(int[] curr:list){
	        if(curr[0]>prev){
	            ans.add(new int[]{prev,curr[0]});
	            prev=Math.max(curr[1],prev);
	        }
	    }
	    if(prev<end){
	        ans.add(new int[]{prev,end});
	    }
	    return ans;
	}
}
