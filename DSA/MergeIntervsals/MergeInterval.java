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
		List<int[]> res=new ArrayList<>();
		for(int[] interval:list){
		    if(res.isEmpty() || res.get(res.size()-1)[1]<interval[0]){
		        res.add(interval);
		    } 
		    else{
		        res.get(res.size()-1)[1]=Math.max(res.get(res.size()-1)[1],interval[1]);
		    }
		}
		for(int[] i:res){
		    System.out.println(i[0]+" "+i[1]);
		}
	}
}
