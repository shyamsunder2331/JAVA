import java.util.*;
import java.io.*;
class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
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
        if(rank.get(u)<rank.get(v)){
            parent.set(ulp_u,ulp_v);
        }else if(rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        }else{
            parent.set(ulp_u,ulp_v);
            rank.set(ulp_v,rank.get(ulp_v)+1);
        }
    }
    public void unionBySize(int u,int v){
        int ulp_u=ultimateParent(u);
        int ulp_v=ultimateParent(v);
        if(ulp_u==ulp_v) return;
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
public class MakingLargerIsland{
    public static boolean isValid(int nr,int nc,int n,int m){
        return nr>=0 && nr<n && nc>=0 && nc<m;
    }
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
        int[] dr={0,0,1,-1};
        int[] dc={1,-1,0,0};
        DisjointSet ds=new DisjointSet(n*m);
        //making connections
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0) continue;
                for(int k=0;k<4;k++){
                    int nr=i+dr[k];
                    int nc=j+dc[k];
                    if(isValid(nr,nc,n,m) && arr[nr][nc]==1){
                        int nodeNo=i*m+j;
                        int adjNode=nr*m+nc;
                        ds.unionBySize(nodeNo,adjNode);
                    }
                }
            }
        }
        //finding maxSize
        int resultSize=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1) continue;
                HashSet<Integer> components=new HashSet<>();
                for(int k=0;k<4;k++){
                    int nr=i+dr[k];
                    int nc=j+dc[k];
                    if(isValid(nr,nc,n,m) && arr[nr][nc]==1){
                        components.add(ds.ultimateParent(nr*m+nc));
                    }
                 }
                int size=0;
                for(Integer k:components){
                    size+=ds.size.get(k);
                }
                resultSize=Math.max(size+1,resultSize);
            }
        }
        for(int i=0;i<n*m;i++){
            resultSize=Math.max(resultSize,ds.size.get(ds.ultimateParent(i)));
        }
        System.out.println(resultSize);
    }
}
                
