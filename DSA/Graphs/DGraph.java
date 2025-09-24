import java.util.*;
import java.io.*;
import java.lang.constant.DynamicCallSiteDesc;
class DynamicGraph{
    static int minHops=Integer.MAX_VALUE;
    static int maxHops=Integer.MIN_VALUE;
    static String minPath;
    static String maxPath;
    private Map<String,List<String>> graph;
    public DynamicGraph(){
        graph=new HashMap<>();
    }
    public void addNode(String city){
        graph.putIfAbsent(city,new ArrayList<String>());
    }
    public void addEdge(String from,String to){
        graph.putIfAbsent(from, new ArrayList<>());
        graph.putIfAbsent(to, new ArrayList<>());
        graph.get(from).add(to);
        graph.get(to).add(from);
    }
    public void removeEdge(String from,String to){
        List<String> fromList=graph.get(from);
        List<String> toList=graph.get(to);
        if(fromList!=null) graph.get(from).remove(to);
        if(toList!=null) graph.get(to).remove(from);
    }
    public void removeNode(String city){
        graph.values().forEach(list->list.remove(city));
        graph.remove(city);
    }
    public List<String> get(String src){
        return graph.get(src);
    }
    public void displayCityMapping(){
        for(Map.Entry<String,List<String>> i:graph.entrySet()){
            System.out.println(i.getKey()+" "+i.getValue());
        }
    }
}
public class DGraph{
    static int minHops=Integer.MAX_VALUE;
    static int maxHops=Integer.MIN_VALUE;
    static String minPath="";
    static String maxPath="";
    static Set<String> set=new HashSet<>();
    public static void main(String[] args){
        DynamicGraph graph=new DynamicGraph();
        graph.addNode("Hyderabad");
        graph.addNode("Ahmedabad");
        graph.addNode("Bengaluru");
        graph.addNode("Coimbatore");
        graph.addNode("Goa");
        graph.addNode("Kolkata");
        graph.addNode("Lucknow");
        graph.addNode("Mumbai");
        graph.addNode("Delhi");
        graph.addNode("Pune");
        graph.addNode("Varanasi");
        graph.addNode("HongKong");
        graph.addNode("Chennai");
        graph.addEdge("Hyderabad","Pune");
        graph.addEdge("Pune","Coimbatore");
        graph.addEdge("Hyderabad","Chennai");
        graph.addEdge("Chennai","Delhi");
        graph.addEdge("Delhi","Pune");
        graph.addEdge("Pune","Varanasi");
        graph.addEdge("Varanasi","Coimbatore");
        graph.addEdge("Coimbatore","Kolkata");
        graph.displayCityMapping();
        String src="Hyderabad";
        String dst="HongKong";
        route(src,dst,graph,0,"");
        if(minHops==Integer.MAX_VALUE){
            System.out.println("There is no route from "+src+" to "+dst);
        }else{
            System.out.println("Minimum hops to reach " +dst +"from "+ src + " is " + minHops + " taking route as follows " + minPath);
        }
        if(maxHops==Integer.MIN_VALUE){
            System.out.println("There is no route from "+src+" to "+dst);
        }else{
            System.out.println("Maximum hops to reach " +dst +"from "+ src + " is " + maxHops + " taking route as follows " + maxPath);        
        }
        
        
        System.out.print(set);
    }
    public static void route(String src,String dst,DynamicGraph graph,int hops,String psf){
        if(src.equals(dst)){
            if(hops<minHops){
                minHops=hops;
                minPath=psf;
            }
            if(hops>maxHops){
                maxHops=hops;
                maxPath=psf;
            }
            return;
        }
        if(set.contains(src)){
            return;
        }
        set.add(src);
        for(String i:graph.get(src)){
            route(i,dst,graph,hops+1,psf+i+" ");
        }
        set.remove(src); // Backtrack
    }
} 