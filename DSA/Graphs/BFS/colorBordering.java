import java.util.*;
import java.io.*;
public class colorBordering{ 
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[][] graph={{4,5,3,4,1},
					   {3,2,2,2,1},
					   {3,2,2,2,4},
					   {4,2,2,2,3},
					   {5,3,4,3,5}};
		int color=2;
		int reclr=8;
		int source=Integer.parseInt(br.readLine());
		int destination=Integer.parseInt(br.readLine());
		colorIt(graph,color,source,destination);
		for(int i=0;i<graph.length;i++){
			for(int j=0;j<graph[0].length;j++){
				if(graph[i][j]<0){
					graph[i][j]=reclr;
				}
			}
		}
		for(int[] i:graph){
			for(int j:i){
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	public static void colorIt(int[][] graph,int color,int row,int col){
		int[] rows=new int[]{0,0,1,-1};
		int[] cols=new int[]{1,-1,-1,0};
		if(row<0 || col<0 || row>=graph.length || row>=graph[0].length || Math.abs(graph[row][col])!=color){
			return;
		}
		int count=0;
		graph[row][col]=-color;
		for(int i=0;i<4;i++){
			int rowDash=row+rows[i];
			int colDash=col+cols[i];
			if(Math.abs(graph[rowDash][colDash])==color){
				count++;
                if(graph[rowDash][colDash]>0){
				    colorIt(graph,color,rowDash,colDash);
                }
			}
			if(count==4){
				graph[row][col]=color;
			}
		}
	}
}
		