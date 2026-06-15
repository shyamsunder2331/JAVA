import java.util.*;
import java.io.*;
public class sortStack
{   
    public static void insert(Stack<Integer> stack,int temp){
        if(stack.isEmpty() || stack.peek()<=temp){
            stack.push(temp);
            return;
        }
        int val=stack.pop();
        insert(stack,temp);
        stack.push(val);
    }
    public static void sort(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int temp=stack.pop();
            sort(stack);
            insert(stack,temp);
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack=new Stack<>();
		stack.push(1);
		stack.push(23);
		stack.push(12);
		stack.push(19);
		stack.push(33);
		stack.push(24);
		
		sort(stack);
		while(!stack.isEmpty()) System.out.print(stack.pop()+" ");
	}
}
