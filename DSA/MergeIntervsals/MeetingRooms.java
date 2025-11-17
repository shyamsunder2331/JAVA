import java.util.*;
import java.io.*;
public class MeetingRooms
{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		List<int[]> list=new ArrayList<>();
		for(int i=0;i<n;i++){
		    String[] s=br.readLine().split(" ");
		    list.add(new int[]{Integer.parseInt(s[0]),Integer.parseInt(s[1])});
		}
		int[] start=new int[list.size()];
		int[] end=new int[list.size()];
		for(int i=0;i<list.size();i++){
		    start[i]=list.get(i)[0];
		    end[i]=list.get(i)[1];
		}
		int p=0,q=0,rooms=0,maxRooms=0;
		while(p<list.size()){
		    if(start[p]<end[q]){
		        p++;
		        rooms++;
		        maxRooms=Math.max(maxRooms,rooms);
		    }else{
		        rooms--;
		        q++;
		    }
		}
		System.out.println(maxRooms);
	}
}
