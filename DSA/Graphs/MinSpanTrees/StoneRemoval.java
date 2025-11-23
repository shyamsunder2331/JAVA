/*
    1 0 1 0
    0 0 0 1
    0 1 0 0
    1 0 1 0
    0 0 0 1
*/
import java.util.*;
import java.io.*;
class Pair{
    int start;
    int end;
    public Pair(int start,int end){
        this.start=start;
        this.end=end;
    }
}
class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int ultimateParent(int u){
        if(u==parent.get(u)) return u;
        int ulp=ultimateParent(parent.get(u));
        parent.set(u,ulp);
        return ulp;
    }
    public void unionByRank(int u,int v){
        int ulp_u=ultimateParent(u);
        int ulp_v=ultimateParent(v);
        if(ulp_u==ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            rank.set(ulp_v,rank.get(ulp_v)+1);
        }else if(rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_u,rank.get(ulp_u)+1);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }
    public void print(){

        for(int i=0;i<parent.size();i++) System.out.print(ultimateParent(i)+" ");
        System.out.println();
        for(int i:rank) System.out.print(i+" ");
    }
    
    
    public int resolve(List<Integer> list){
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<parent.size();i++){
            if(list.contains(i) && i==ultimateParent(i)){
                set.add(ultimateParent(i));
            }
        }
        return set.size();
    }
}
public class StoneRemoval
{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		int[][] arr=new int[n][m];
		for(int i=0;i<n;i++){
		    String[] s=br.readLine().split(" ");
		    for(int j=0;j<m;j++){
		        arr[i][j]=Integer.parseInt(s[j]);
		    }
		}
		List<Pair> list=new ArrayList<>();
		int noOfEdges=0,maxRow=0,maxCol=0;
	    for(int i=0;i<n;i++){
	        for(int j=0;j<m;j++){
	            if(arr[i][j]==1){
	                noOfEdges++;
	                maxRow=Math.max(maxRow,i);
	                maxCol=Math.max(maxCol,j);
	            }
	        }
	    }
	    List<Integer> cont=new ArrayList<>();
	    for(int i=0;i<n;i++){
	        for(int j=0;j<m;j++){
	            if(arr[i][j]==1){
	               list.add(new Pair(i,j+maxCol+2));
	               if(!cont.contains(i)) cont.add(i);
	               if(!cont.contains(j+maxCol+2)) cont.add(j=maxCol+2);
	            }
	        }
	    }
	    for(Pair i:list){
	        System.out.println(i.start+" "+i.end);
	    }
	    System.out.println(maxRow+" "+maxCol);
	    DisjointSet ds=new DisjointSet(maxCol+maxRow+1);
	    for(Pair i:list) ds.unionByRank(i.start,i.end);
		int resolve=ds.resolve(cont);
		ds.print();
		System.out.println(noOfEdges+" "+resolve);
	}
}
