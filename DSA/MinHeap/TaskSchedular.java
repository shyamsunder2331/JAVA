import java.util.*;
public class TaskSchedular{
    public static void main(String[] args){
        char[] arr=new char[]{'A','A','A','B','B','B'};
        int[] freq=new int[26];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]-'A']+=1;
        }
        Arrays.sort(freq);
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int n=2;
        StringBuilder sb=new StringBuilder();
        sb.append()

    }
} 