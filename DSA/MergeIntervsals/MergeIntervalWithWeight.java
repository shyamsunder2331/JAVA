import java.util.*;
import java.io.*;
class Pair{
  int start;
  int end;
  int weight;
  public Pair(int start,int end,int weight){
    this.start=start;
    this.end=end;
    this.weight=weight;
  }
}
public class Main{
  public static void main(String[] args) throws IOException{
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
    List<Pair> list=new ArrayList<>();
    for(int i=0;i<n;i++){
      String[] s=br.readLine().split(" ");
      int start=Integer.parseInt(s[0]);
      int end=Integer.parseInt(s[1]);
      int weight=Integer.parseInt(s[2]);
      list.add(new Pair(start,end,weight));
    }
    List<Pair> res=new ArrayList<>();
    for(Pair i:list){
        if(res.isEmpty() || res.get(res.size()-1).end<i.start){
          res.add(i);
        }else{
            res.get(res.size()-1).end=Math.max(res.get(res.size()-1).end,i.end);
          res.get(res.size()-1).weight=res.get(res.size()-1).weight+i.weight;
        }
    }
    for(Pair i:res){
      System.out.println(i.start+" "+i.end+" "+i.weight);
    }
  }
}
      
  
