import java.util.*;
import java.io.*;
class Pair{
    int pos;
    double profit;
    double weight;
    double ratio;
    public Pair(int pos,double profit,double weight){
        this.pos=pos;
        this.profit=profit;
        this.weight=weight;
        this.ratio=profit/weight;
    }
}
public class knapsack
{
	public static void main(String[] args) {
		double[] profits=new double[]{10,5,15,7,6,18,3};
		double[] weights=new double[]{2,3,5,7,1,4,1};
		PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Double.compare(b.ratio,a.ratio));
		for(int i=0;i<profits.length;i++){
		    pq.add(new Pair(i,profits[i],weights[i]));
		}
		int remWeight=15;
		double totalProfit=0;
		double[] res=new double[profits.length];
		while(true){
		    Pair temp=pq.poll();
		    if(temp.weight<=remWeight){
		        System.out.println(temp.profit);
		        totalProfit+=temp.profit;
		        remWeight-=temp.weight;
		        res[temp.pos]=1;
		    }else{
		        totalProfit+=(remWeight/temp.weight)*temp.profit;
		        System.out.println((remWeight/temp.weight)*temp.profit);
		        res[temp.pos]=remWeight/temp.weight;
		         break;
		    }
		}
		System.out.printf("%.2f",totalProfit);
		System.out.println();
		for(double i:res){
		    System.out.print(i+" ");
		}
	}
}
