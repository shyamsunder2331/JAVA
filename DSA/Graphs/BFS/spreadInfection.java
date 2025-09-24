import java.util.*;
import java.io.*;
class Pairi{
    int v;
    int time;
    public Pairi(int v,int time){
        this.v=v;
        this.time=time;
    }
}
public class spreadInfection {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int vertices=Integer.parseInt(br.readLine());
        int edges=Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph=new ArrayList[vertices];
        for(int i=0;i<vertices;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges;i++){
            String[] s=br.readLine().split(" ");
            int src=Integer.parseInt(s[0]);
            int dst=Integer.parseInt(s[1]);
            graph[src].add(new Edge(src,dst));
            graph[dst].add(new Edge(dst,src));
        }
        ArrayDeque<Pairi> q=new ArrayDeque<>();
        int source=Integer.parseInt(br.readLine());
        q.offer(new Pairi(source,0));
        int[] vis=new int[vertices];
        int count=0;
        while(!q.isEmpty()){
            Pairi temp=q.poll();
            if(vis[temp.v]>0){
                continue;
            }
            vis[temp.v]=temp.time;
            count++;
            for(Edge e:graph[temp.v]){
                if(vis[e.dst]==0){
                    q.offer(new Pairi(e.dst,temp.time+1));
                }
            }
        }
        int k=2;
        int res=0;
        for(int i:vis){
            System.out.print(i+" ");
            if(i<=k){
               
                res++;
            }
        }
        System.out.println(count-1+" "+res);
    }
}
