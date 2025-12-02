import java.util.*;
import java.io.*;
public class NextGreaterElementII{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        String[] s=br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        int[] res=new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    res[i]=arr[j];
                    break;
                }
            }
            if(res[i]==-1){
                for(int j=0;j<i;j++){
                    if(arr[j]>arr[i]){
                        res[i]=arr[j];
                        break;
                    }
                }
            }
        }
        for(int i:res) System.out.print(i+" ");
        int[] Optres=optimizesAns(arr,n);
        System.out.println();
        for(int i:Optres) System.out.print(i+" ");
    }
    public static int[] optimizesAns(int[] arr,int n){
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            if(i<n){
                while(!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()) res[i]=-1;
                else res[i]=stack.peek();
                stack.push(arr[i]);
            }else{
                 while(!stack.isEmpty() && stack.peek()<=arr[i-n]){
                    stack.pop();
                }
                if(stack.isEmpty()) res[i-n]=-1;
                else res[i-n]=stack.peek();
                stack.push(arr[i-n]);
            }
        }
        return res;
    }
}
