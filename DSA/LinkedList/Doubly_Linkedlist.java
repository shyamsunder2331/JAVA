import java.util.*;
class Node{
    int data;
    Node prev,next;
    Node(int data){
        this.data=data;
        
    }
}
public class Doubly_Linkedlist{
    public static Node head;
    public static void main(String[] args){
        head=new Node(1);
        head.next=new Node(2);
        head.next.prev=head;
        head.next.next=new Node(2);
        head.next.next.prev=head.next;
        head.next.next.next=new Node(3);
        head.next.next.next.prev=head.next.next;
        head.next.next.next.next=new Node(3);
        head.next.next.next.next.prev=head.next.next.next;
        head.next.next.next.next.next=new Node(4);
        head.next.next.next.next.next.prev=head.next.next.next.next;
        
        printdl();
        // removeDup();
        // pairSum();
        remSort();
        }
        //removing duplicates from a sorted duplicate doubly linkedlist
        public static void remSort(){
            Node i=head;
            Node j=head.next;
            
            while(j!=null){
                if(i.data!=j.data){
                    i.next=j;
                    j.prev=i;
                    i=i.next;
                }
                j=j.next;
            }
            if(i.next!=null) i.next=null;
            printdl();
        }
        // finding the pairs having sum equal to the target value
        public static void pairSum(){
            Node left=head;
            Node right=head;
            while(right.next!=null){
                right=right.next;
            }
            List<int[]> res=new ArrayList<>();
            int sum=0;
            int target=5;
            while(left!=null && right!=null && left!=right && left.prev!=right){
                sum=left.data+right.data;
                if(sum==target){
                    int[] temp=new int[]{left.data,right.data};
                    res.add(temp);
                    left=left.next;
                    right=right.prev;
                }else if(sum<target){
                    left=left.next;
                }else{
                    right=right.prev;
                }
            }
            System.out.println();
            for(int[] i:res){
                for(int j:i){
                    System.out.print(j+"    ");
                }
                System.out.println();
            }
        }
        //removing the duplicates of the duobly linkedlist with the target value given
        public static void removeDup(){
            int value=1;
            Node dum=new Node(0);
            Node curr=dum;
            Node temp=head;
            while(temp!=null){
                if(temp.data!=value){
                    curr.next=temp;
                    temp.prev=curr;
                    curr=curr.next;
                }
                temp=temp.next;
            }
            curr.next=null;
            head=dum.next;
            printdl();
        }
        
        //printing the elements of the linkedlist
        public static void printdl(){
            Node temp=head;
            System.out.println();
            while(temp!=null){
                
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
        }
        
}