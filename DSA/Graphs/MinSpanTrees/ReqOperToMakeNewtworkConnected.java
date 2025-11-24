import java.util.*;
import java.io.*;
class Edge{
    int src;
    int dst;
    public Edge(int src,int dst){
        this.src=src;
        this.dst=dst;
    }
}
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
        return parent.get(u);
    }
    public void unionByRank(int u,int v){
        int ulp_u=ultimateParent(u);
        int ulp_v=ultimateParent(v);
        if(ulp_u==ulp_v) return;
        if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }else if(rank.get(ulp_u)>rank.get(ulp_v)){
            parent.set(ulp_v,ulp_u);   
        }
        else{
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_u,rank.get(ulp_u)+1);
        }
    }
    public void print(){
        for(Integer i:rank) System.out.print(i+" ");
        System.out.println();
        for(Integer i:parent) System.out.print(i+" ");
    }
    public boolean resolve(List<Edge> list,int onlyReq){
        Set<Integer> set=new HashSet<>();
        for(int i:parent) set.add(i);
        int noOfComponents=set.size();
        System.out.println(onlyReq);
        return onlyReq>=(noOfComponents-1);
    }
}
public class ReqOperToMakeNewtworkConnected{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int vertices=Integer.parseInt(br.readLine());
        int edges=Integer.parseInt(br.readLine());
        DisjointSet ds=new DisjointSet(vertices);
        List<Edge> list=new ArrayList<>();
        int OnlyReq=0;
        for(int i=0;i<edges;i++){
            String[] s=br.readLine().split(" ");
            int src=Integer.parseInt(s[0]);
            int dst=Integer.parseInt(s[1]);
            if(ds.ultimateParent(src)!=ds.ultimateParent(dst)){
                ds.unionByRank(src,dst);   
                OnlyReq++;
            }
            list.add(new Edge(src,dst));
        }
        boolean result=ds.resolve(list,edges-OnlyReq);
        ds.print();
        System.out.println(result);
    }
}
