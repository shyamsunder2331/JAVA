import java.util.*;
import java.io.*;
class Pair{
    int x;
    String name;
    double number;
    public Pair(int x,String name,double number){
        this.x=x;
        this.name=name;
        this.number=number;
    }
}
public class minHeap{
    public static void main(String[] args){
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(b.name.compareTo(a.name)));
        pq.offer(new Pair(23,"Sai",2344223221.0));
        pq.offer(new Pair(43,"Ram",45678922311.0));
        pq.offer(new Pair(25,"Sam",98765679.0));
        pq.offer(new Pair(12,"Lok",2343124323.0));
        pq.offer(new Pair(8,"ram",9876545678.0));
        Iterator<Pair> it=pq.iterator();
        while(it.hasNext()){
            Pair temp=it.next();
            System.out.println(temp.x+" "+temp.name+" "+temp.number);
        }
        System.out.println(pq.size());
    }
}