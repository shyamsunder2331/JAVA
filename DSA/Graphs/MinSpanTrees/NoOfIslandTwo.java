import java.util.*;
import java.io.*;
class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
         rank.add(0);
        parent.add(i);
        }
    }
    public int ultimateParent(int u){
        if(u==parent.get(u)){
            return u;
        }
        int ulp=ultimateParent(parent.get(u));
        parent.set(u,ulp);
        return ulp;
    }
    public void unionByRank(int u,int v){
        int ulp_u=ultimateParent(u);
        int ulp_v=ultimateParent(v);
        if(ulp_u==ulp_v) return;
        if(rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_v,rank.get(ulp_v)+1);
        }else{
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_u,rank.get(ulp_u)+1);
        }
    }
}
//{0,0},{0,0},{1,1},{1,0},{0,1},{0,3},{1,3},{0,4}, {3,2}, {2,2},{1,2}, {0,2
public class import java.util.*;
import java.io.*;
class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
         rank.add(0);
        parent.add(i);
        }
    }
    public int ultimateParent(int u){
        if(u==parent.get(u)){
            return u;
        }
        int ulp=ultimateParent(parent.get(u));
        parent.set(u,ulp);
        return ulp;
    }
    public void unionByRank(int u,int v){
        int ulp_u=ultimateParent(u);
        int ulp_v=ultimateParent(v);
        if(ulp_u==ulp_v) return;
        if(rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_v,rank.get(ulp_v)+1);
        }else{
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_u,rank.get(ulp_u)+1);
        }
    }
}
//{0,0},{0,0},{1,1},{1,0},{0,1},{0,3},{1,3},{0,4}, {3,2}, {2,2},{1,2}, {0,2
public class NoOfIslandTwo{
    public static boolean isValid(int nr,int nc,int n,int m){
        return nr>=0 && nr<n && nc>=0 && nc<m;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine());
        List<int[]> arr=new ArrayList<>();
        for(int i=0;i<k;i++){
            String[] s=br.readLine().split(" ");
            arr.add(new int[]{Integer.parseInt(s[0]),Integer.parseInt(s[1])});
        }
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        int[][] vis=new int[n][m];
        int count=0;
        List<Integer> result=new ArrayList<>();
        DisjointSet ds=new DisjointSet(n*m);
        for(int[] i:arr){
            if(vis[i[0]][i[1]]==1){
                result.add(count);
                continue;
            }
            vis[i[0]][i[1]]=1;
            count++;
            int[] dx={0,0,1,-1};
            int[] dy={1,-1,0,0};
            for(int j=0;j<4;j++){
                int nr=i[0]+dx[j];
                int nc=i[1]+dy[j];
                if(isValid(nr,nc,n,m)){
                    int nodeNo=i[0]*m+i[1];
                    int adjNode=nr*m+nc;
                    if(vis[nr][nc]==1){
                        if(ds.ultimateParent(nodeNo)!=ds.ultimateParent(adjNode)){
                            count--;
                            ds.unionByRank(nodeNo,adjNode);
                        }
                    }
                }
            }
            result.add(count);
        }
        for(Integer i:result){
            System.out.println(i);
        }
    }
}{
    public static boolean isValid(int nr,int nc,int n,int m){
        return nr>=0 && nr<n && nc>=0 && nc<m;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine());
        List<int[]> arr=new ArrayList<>();
        for(int i=0;i<k;i++){
            String[] s=br.readLine().split(" ");
            arr.add(new int[]{Integer.parseInt(s[0]),Integer.parseInt(s[1])});
        }
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        int[][] vis=new int[n][m];
        int count=0;
        List<Integer> result=new ArrayList<>();
        DisjointSet ds=new DisjointSet(n*m);
        for(int[] i:arr){
            if(vis[i[0]][i[1]]==1){
                result.add(count);
                continue;
            }
            vis[i[0]][i[1]]=1;
            count++;
            int[] dx={0,0,1,-1};
            int[] dy={1,-1,0,0};
            for(int j=0;j<4;j++){
                int nr=i[0]+dx[j];
                int nc=i[1]+dy[j];
                if(isValid(nr,nc,n,m)){
                    int nodeNo=i[0]*m+i[1];
                    int adjNode=nr*m+nc;
                    if(vis[nr][nc]==1){
                        if(ds.ultimateParent(nodeNo)!=ds.ultimateParent(adjNode)){
                            count--;
                            ds.unionByRank(nodeNo,adjNode);
                        }
                    }
                }
            }
            result.add(count);
        }
        for(Integer i:result){
            System.out.println(i);
        }
    }
}
