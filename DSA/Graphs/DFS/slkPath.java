import java.util.*;
import java.io.*;
class Edge{
    int src;
    int nbr;
    int wt;
    public Edge(int src,int nbr,int wt){
        this.src=src;
        this.nbr=nbr;
        this.wt=wt;
    }
}
class Pair{
    String psof;
    int weight;
    public Pair(String psof,int weight){
        this.psof=psof;
        this.weight=weight;
    }
}
public class slkPath {
    static int swsf=Integer.MAX_VALUE;
    static String spsf;
    static int lwsf=Integer.MIN_VALUE;
    static String lpsf;
    static int cwsf=Integer.MAX_VALUE;
    static String cpsf;
    static int fwsf=Integer.MIN_VALUE;
    static String fpsf;
    static PriorityQueue<Pair> queue=new PriorityQueue<>((a,b)->a.weight-b.weight);

    public static void printPaths(PriorityQueue<Pair> queue,ArrayList<Edge>[] graph,int source,int destination,int criteria,int weight,String psf,boolean[] vis){
        if(source==destination){
            if(weight<swsf){
                swsf=weight;
                spsf=psf;
            }
            if(weight>lwsf){
                lwsf=weight;
                lpsf=psf;
            }
            if(weight>criteria && weight<cwsf){
                cwsf=weight;
                cpsf=psf;
            }
            if(weight<criteria && weight>fwsf){
                fwsf=weight;
                fpsf=psf;
            }
            queue.offer(new Pair(psf,weight));
        }
        vis[source]=true;
        for(Edge edge:graph[source]){
            if(!vis[edge.nbr]){
                printPaths(queue,graph, edge.nbr, destination, criteria, weight+edge.wt, psf+edge.nbr+" ", vis);
            }
        }
        vis[source]=false;
    }
    public static void main(String[] args) throws IOException{
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
            int nbr=Integer.parseInt(s[1]);
            int wt=Integer.parseInt(s[2]);
            graph[src].add(new Edge(src,nbr,wt));
            graph[nbr].add(new Edge(nbr,src,wt));
        }
        boolean flag=true;
        while(flag){
            String sr=br.readLine();
            if(sr.equals("true")){
                flag=true;
                int weight=0;
                int criteria=20;
                int source=Integer.parseInt(br.readLine());
                int destination=Integer.parseInt(br.readLine());
                String psf="";
                boolean[] vis=new boolean[vertices];
                printPaths(queue,graph,source,destination,criteria,weight,psf+source+" ",vis);
                System.out.println(swsf+" "+spsf);
                System.out.println(lwsf+" "+lpsf);
                System.out.println(cwsf+" "+cpsf);
                System.out.println(fwsf+" "+fpsf);
            }else{
                flag=false;
            }
        }
        int k=Integer.parseInt(br.readLine());
        while(k-->0){
            queue.poll();
        }
        System.out.println(queue.peek().psof+" "+queue.peek().weight);
    }
}
