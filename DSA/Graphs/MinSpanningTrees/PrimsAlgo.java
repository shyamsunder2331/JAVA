import java.util.*;
import java.io.*;
class Edge{
  int src;
  int dst;
  int wt;
  public Edge(int src,int dst,int wt){
    this.src=src;
    this.dst=dst;
    this.wt=wt;
  }
}
public class PrimsAlgo{
  public static void main(String[] args) throws IOException{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int vertices=Integer.parseInt(br.readLine());
    int edges=Integer.parseInt(br.readLine());
    List<Edge>[] graph=new ArrayList[vertices];
    for(int i=0;i<vertices;i++){
      graph[i]=new ArrayList<>();
    }
    for(int i=0;i<edges;i++){
      String[] s=br.readLine().split(" ");;
      int src=Integer.parseInt(s[0]);
      int dst=Integer.parseInt(s[1]);
      int wt=Integer.parseInt(s[2]);
      graph[src].add(new Edge(src,dst,wt));
  }
    for(int i=0;i<vertices;i++){
      for(Edge j:graph[i]){
        System.out.print(j.src+" "+j.dst+" "+j.wt);
      }
      System.out.println();
    }
}
