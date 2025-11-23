import java.util.*;
import java.io.*;
class DisjointSet{
    int[] parent;
    int[] rank;
    public DisjointSet(int n){
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
    }
        public int ultimateParent(int u){
            if(u==parent[u]) return u;
            parent[u]=ultimateParent(parent[u]);
            return parent[u];
        }
        public void unionByRank(int u,int v){
            int ulp_u=ultimateParent(u);
            int ulp_v=ultimateParent(v);
            if(ulp_u==ulp_v) return;
            if(rank[ulp_u]<rank[ulp_v]){
                parent[ulp_u]=ulp_v;
                rank[ulp_v]+=1;
            }else{
                parent[ulp_v]=ulp_u;
                rank[ulp_v]+=1;
            }
        }
    }
public class MergeMails{
    public static List<List<String>> resolve(List<List<String>> list){
        int n=list.size();
        DisjointSet ds=new DisjointSet(n);
        Map<String,Integer> map=new HashMap<>();
        // mapping the mails to the indices
        for(int i=0;i<n;i++){
            for(int j=1;j<list.get(i).size();j++){
                String mail=list.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail,i);
                }else{
                    ds.unionByRank(i,map.get(mail));
                }
            }
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        List<String>[] merge=new ArrayList[n];
        for(int i=0;i<n;i++) merge[i]=new ArrayList<>();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            int node=ds.ultimateParent(entry.getValue());
            System.out.println(entry.getKey());
            merge[node].add(entry.getKey());
        }
        List<List<String>> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            Collections.sort(merge[i]);
            if(merge[i].isEmpty()) continue;
            List<String> temp=new ArrayList<>();
            temp.add(list.get(i).get(0));
            for(String j:merge[i]){
                temp.add(j);
            }
            result.add(new ArrayList<>(temp));
        }
        result.sort((a,b)->a.get(0).compareTo(b.get(0)));
        return result;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        List<List<String>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] s=br.readLine().split(" ");
            List<String> temp=new ArrayList<>();
            for(int j=0;j<s.length;j++){
                temp.add(s[j]);
            }
            list.add(temp);
        }
        List<List<String>> result=resolve(list);
        for(List<String> i:result){
            for(String j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        
    }
}
