import java.util.*;
import java.io.*;
class Edge{
    String src;
    String dst;
    double rate; 
    public Edge(String src,String dst,double rate){
      this.src=src;
      this.dst=dst;
      this.rate=rate;
    }
}
public class CurrencyConverter{
    public static void dfs(Map<String,List<Edge>> graph,String src,String dst,double ratio,Set<String> vis){
        if(src.equals(dst)){
            System.out.printf("%.4f",ratio);   
        }
        vis.add(src);
        for(Edge e:graph.get(src)){
            if(!vis.contains(e.dst)){
                dfs(graph,e.dst,dst,ratio*e.rate,vis);
            }
        }
    }
  public static void main(String[] args) throws IOException {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      int n=Integer.parseInt(br.readLine());
      String[] s=new String[n];
      Map<String,List<Edge>> graph=new HashMap<>();
      for(int i=0;i<n;i++){
        s[i]=br.readLine();
      }
      for(String i:s){
        String[] temp=i.split(" ");
        graph.computeIfAbsent(temp[0],k->new ArrayList<>()).add(new Edge(temp[0],temp[1],Double.parseDouble(temp[2])));
        graph.computeIfAbsent(temp[1],k->new ArrayList<>()).add(new Edge(temp[1],temp[0],1/Double.parseDouble(temp[2])));
      }
      for(Map.Entry<String,List<Edge>> entry:graph.entrySet()){
          System.out.println(entry.getKey());
          for(Edge e:entry.getValue()){
              System.out.println(e.src+" "+e.dst+" "+e.rate);
          }
      }
      
      String src=br.readLine();
      String dst=br.readLine();
      double rate=0;
      Set<String> vis=new HashSet<>();
      dfs(graph,src,dst,1,vis);
  }
}
            
        
