

import java.util.*;
import java.io.*;
class Pair{
    int src;
    int dst;
    int weight;
    public Pair(int src,int dst,int weight){
        this.src=src;
        this.dst=dst;
        this.weight=weight;
    }
}
class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            size.add(1);
            parent.add(i);
        }
    }
    public int ultimateParent(int u){
        if(u==parent.get(u)) return u;
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
            parent.set(ulp_v,ulp_u);
            int ranku=rank.get(ulp_u);
            rank.set(ulp_u,ranku+1);
        }
    }
    public void unionBySize(int u,int v){
        int ulp_v=ultimateParent(v);
        int ulp_u=ultimateParent(u);
        if(ulp_u==ulp_v) return;
        if(size.get(ulp_v)<size.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }
    }
}
public class KruskalsAlgo{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int vertices=Integer.parseInt(br.readLine());
        int edges=Integer.parseInt(br.readLine());
        PriorityQueue<Pair> queue=new PriorityQueue<>((a,b)->a.weight-b.weight);
        for(int i=0;i<edges;i++){
            String[] s=br.readLine().split(" ");
            int src=Integer.parseInt(s[0]);
            int dst=Integer.parseInt(s[1]);
            int wt=Integer.parseInt(s[2]);
            queue.offer(new Pair(src,dst,wt));
        }
        DisjointSet ds=new DisjointSet(vertices);
        int mstwt=0;
        while(!queue.isEmpty()){
            Pair temp=queue.poll();
            if(!(ds.ultimateParent(temp.src)==ds.ultimateParent(temp.dst))){
                mstwt+=temp.weight;
                ds.unionBySize(temp.src,temp.dst);
            }
        }  
        System.out.println(mstwt);
    }
}
