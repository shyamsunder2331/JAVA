import java.util.*;
import java.io.*;
class DisjointSetByRank{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    public DisjointSetByRank(int n){
        for(int i=0;i<=n;i++){
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
        if(ulp_v==ulp_u) return;
        if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }else if(rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        }else{
            parent.set(ulp_u,ulp_v);
            int rankU=rank.get(ulp_v);
            rank.set(ulp_v,rankU+1);
        }
    }
    public void print(){
        for(Integer i:rank) System.out.print(i+" ");
        for(Integer i:parent) System.out.print(i+" ");
    }
}
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int edges=Integer.parseInt(br.readLine());
        DisjointSetByRank ds=new DisjointSetByRank(n);
        for(int i=0;i<edges;i++){
            String[] s=br.readLine().split(" ");
            int src=Integer.parseInt(s[0]);
            int dst=Integer.parseInt(s[1]);
            ds.unionByRank(src,dst);
        }
        int start=Integer.parseInt(br.readLine());
        int end=Integer.parseInt(br.readLine());
        if(ds.ultimateParent(start)==ds.ultimateParent(end)){
            System.out.println("same component");
        }else{
            System.out.println("Not same component");
        }
        ds.print();
    }
}
