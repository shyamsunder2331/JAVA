// now we are considering the disjoint set by size and parent
import java.util.*;
import java.io.*;
class DisjointSet{
  List<Integer> size=new ArrayList<>();
  List<Integer> parent=new ArrayList<>();
  public DisjointSet(int n){
    for(int i=0;i<=n;i++){
      size.add(1);
      parent.add(i);
    }
  }
  public int ultimateParent(int u){
    if(u==parent.get(u)){
      return u;
    }
    int par=ultimateParent(parent.get(u));
    parent.set(u,par);
    return parent.get(u);
}
  public void UnionBySize(int u,int v){
    int ulp_u=ultimateParent(u);
    int ulp_v=ultimateParent(v);
    if(ulp_u==ulp_v) return;
    if(size.get(ulp_u)<size.get(ulp_v)){
      parent.set(ulp_u,ulp_v);
      size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
    }else{
      parent.set(ulp_v,ulp_u);
      size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
    }
  }
}
public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
    int edges=Integer.parseInt(br.readLine());
    DisjointSet ds=new DisjointSet(n);
    for(int i=0;i<edges;i++){
      String[] s=br.readLine().split(" ");
      int src=Integer.parseInt(s[0]);
      int dst=Integer.parseInt(s[1]);
      ds.UnionBySize(src,dst);
    }
    int start=Integer.parseInt(br.readLine());
    int end=Integer.parseInt(br.readLine());
    if(ds.ultimateParent(start)==ds.ultimateParent(end)){
        System.out.println("nodes are from same components");
    }else{
        System.out.println("nodes are from different compponents");
    }
  }
}
