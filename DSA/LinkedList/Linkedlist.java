import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
}
public class Main
{
    static Node head;
    static int counter=1;
	public static void main(String[] args) {
	     
	    head=new Node(9);
	    head.next=new Node(1);
	    head.next.next=new Node(3);
	    head.next.next.next=new Node(3);
	    head.next.next.next.next=new Node(11);
	    head.next.next.next.next.next=new Node(23);
	    head.next.next.next.next.next.next=new Node(16);
	    head.next.next.next.next.next.next.next=new Node(7);
	    head.next.next.next.next.next.next.next.next=new Node(8);
	    print();
	   // reverse();
	   // print();
	   // middle();
	   // loop();
	   //loopwithMap();
	   //startPointB();
	   //startingPointO();
	   //lengthofloopB();
	   //lenghtodloopO();
	   //checkforPalinB();
	   //checkforPalO();
	   //segregateOEB();
	   //segregateOEO();
	   //midDelB();
	   //midDelO();
	   //sortLLB();
	   Node res=sortLLO(head);
	   print(res);
	   
	}
	//sorting the linkedlist using the mergersort algorith, which makes space complexity as O(logN)
	public static void print(Node head){
	    Node curr=head;
	    while(curr!=null){
	        System.out.print(curr.data+" ");
	        curr=curr.next;
	    }
	    System.out.println();
	}
	public static Node mergeSort(Node left,Node right){
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(left!=null && right!=null){
            if(left.data<right.data){
                temp.next=left;
                left=left.next;
            }else{
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }
        if(left!=null){
            temp.next=left;
        }
        if(right!=null){
            temp.next=right;
        }
        
        return dummy.next;
	}
	public static Node findmiddle(Node head){
	    Node fast=head.next,slow=head;
	    while(fast!=null && fast.next!=null){
	        slow=slow.next;
	        fast=fast.next.next;
	    }
	    return slow;
	}
	public static Node sortLLO(Node head){
	    if(head==null || head.next==null){
	        return head;
	    }
	    Node middle=findmiddle(head);
	    System.out.println(middle.data);
	    Node right=middle.next;
	    middle.next=null;
	    Node left=head;
	    left=sortLLO(left);
	    right=sortLLO(right);
	    
	    return mergeSort(left,right);
	}
	//sorting the data of a linkedlist with space complexity as O(N)
	public static void sortLLB(){
	    List<Integer> list=new ArrayList<>();
	    Node temp=head;
	    while(temp!=null){
	        list.add(temp.data);
	        temp=temp.next;
	    }
	    Collections.sort(list);
	    Node curr=head;
	    int i=0;
	    while(curr!=null){
	        curr.data=list.get(i++);
	        curr=curr.next;
	    }
	    print();
	}
	//deleting middle node in the optimal way
	public static void midDelO(){
	    Node slow=head,fast=head;
	    fast=fast.next.next;
	    while(fast!=null && fast.next!=null){
	        slow=slow.next;
	        fast=fast.next.next;
	        }
	        slow.next=slow.next.next;
	        Node curr=head;
	        while(curr!=null){
	            System.out.print(curr.data+" ");
	            curr=curr.next;
	        }
	    
	}
	//deleting middle node of a linkedlist
	public static void midDelB(){
	    Node temp=head;
	    int counter=0;
	    while(temp!=null){
	        counter++;
	        temp=temp.next;
	       }
	       int mid=counter/2;
	       Node curr=head;
	       while(--mid!=0){
	           curr=curr.next;
	       }
	       curr.next=curr.next.next;
	       curr=head;
	       while(curr!=null){
	           System.out.print(curr.data+" ");
	           curr=curr.next;
	       }
	        
	}
	//segregation of odd and even numbers of a linkedlist using optimal approach
	public static void segregateOEO(){
	    Node evenhead=new Node(-1),eventail=evenhead;
	    Node oddhead=new Node(-1),oddtail=oddhead;
	    Node curr=head,temp;
	    while(curr!=null){
	         temp=curr;
	         curr=curr.next;
	         temp.next=null;
	         if((temp.data%2)==0){
	             eventail.next=temp;
	             eventail=temp;
	         }else{
	             oddtail.next=temp;
	             oddtail=temp;
	         }
	         
	    }
	    eventail.next=oddhead.next;
	         evenhead=evenhead.next;
	         while(evenhead!=null){
	             System.out.print(evenhead.data+" ");
	             evenhead=evenhead.next;
	         }
	}
	
	//segregation of odd and even number odd before even
	
	public static void segregateOEB(){
	    Node res=new Node(0);
	    Node ans=res;
	    Node curr=head;
	    while(curr!=null){
	        if(curr.data%2==1){
	            res.next=new Node(curr.data);
	            res=res.next;
	        }
	        curr=curr.next;
	    }
	    curr=head;
	    while(curr!=null){
	        if(curr.data%2==0){
	            res.next=new Node(curr.data);
	            res=res.next;
	        }
	        curr=curr.next;
	    }
	    ans=ans.next;
	    while(ans!=null){
	        System.out.print(ans.data+" ");
	        ans=ans.next;
	    }
	    
	}
	
	//reversing when passes a parameter
	public static Node reverse(Node head){
	    Node dummy=null;
	    Node currHead=head;
	    while(currHead!=null){
	        Node headNext=currHead.next;
	        currHead.next=dummy;
	        dummy=currHead;
	        currHead=headNext;
	    }
	    return dummy;
	}
	//checking for a plaindrome using optimal approach
	public static void checkforPalO(){
	    Node slow=head,fast=head;
	    while(fast!=null && fast.next!=null){
	        slow=slow.next;
	        fast=fast.next.next;
	    }
	    
	    Node newHead=reverse(slow.next);
	    Node first=head;
	    Node second=newHead;
	    while(second!=null){
	        if(first.data!=second.data){
	            System.out.println("Given linkedlist is not a palindrome");
	            reverse(newHead);
	           System.exit(0);
	        }
	        first=first.next;
	        second=second.next;
	    }
	    reverse(newHead);
	    System.out.println("Given linkedlist is a Palindrome");
	    
	}
	//checking if the given linkedlist is plaindrome or not using bruteforce
	public static void checkforPalinB(){
	    Stack<Integer> s=new Stack<>();
	    Node dummy=head;
	    while(dummy!=null){
	        s.push(dummy.data);
	        dummy=dummy.next;
	    }
	    Node trav=head;
	    while(trav!=null){
	        if(trav.data!=s.pop()){
	            System.out.println("the linkedlist is not a palindrome");
	            System.exit(0);
	        }
	        trav=trav.next;
	    }
	    System.out.println("this is a palindromic linkedlist");
	}
	//finding the lenght of the loop with optimal time
	public static void lenghtodloopO(){
	    Node slow=head,fast=head;
	    while(fast!=null && fast.next!=null){
	        slow=slow.next;
	        fast=fast.next.next;
	        if(slow==fast){
	            break;
	        }
	    }
	    int counter=0;
	    fast=fast.next;
	    while(fast!=slow){
	        counter++;
	        fast=fast.next;
	    }
	    System.out.println(counter+1);
	    
	}
	
	// finding length of the loop in a linkedlist
	public static void lengthofloopB(){
	    Node dummy=head;
	    Map<Node,Integer> map=new HashMap<>();
	    while(dummy!=null){
	        if(map.containsKey(dummy)){
	            System.out.println(counter-map.get(dummy));
	            System.exit(0);
	        }
	        
	        map.put(dummy,counter++);
	        dummy=dummy.next;
	    }
	    System.out.println("There is no loop in the linkedlist");
	}
	//Optimal approach to find a starting point of a loop in a linkedlist
	public static void startingPointO(){
	    Node fast=head,slow=head;
        while(fast!=null && fast.next!=null){
	        slow=slow.next;
	        fast=fast.next.next;
	        if(fast==slow){
	            slow=head;
	            break;
	        }
	    }
	    if(slow==null) {
	        System.out.println("There is no loop, so there will be no starting point");
	        System.exit(0);
	    }
	    while(fast!=null){
	        if(slow==fast) break;
	        slow=slow.next;
	        fast=fast.next;
	    }
	    if(fast==null) {
	        System.out.println("There is no loop, so there will be no starting point");
	        System.exit(0);
	    }
	   System.out.println(slow.data+" is the starting point of the loop in the linkedlist");
	}
	// bruteforce approach for a loop in a linkedlist
	public static void loopwithMap(){
	    Map<Node,Integer> map=new HashMap<>();
	    Node dummy=head;
	    while(dummy!=null){
	        if(map.containsKey(dummy)){
	            System.out.println("There is loop in the given linkedlist");
	            System.exit(0);
	        }
	        map.put(dummy,1);
	        dummy=dummy.next;
	    }
	    System.out.println("there is no loop in the map");
	    
	}
	//starting point of a loop
	public static void startPointB(){
	    Map<Node,Integer> map=new HashMap<>();
	    Node dummy=head;
	    while(dummy!=null){
	        if(map.containsKey(dummy)){
	            System.out.println(dummy.data);
	            System.exit(0);
	        }
	        map.put(dummy,1);
	        dummy=dummy.next;
	    }
	    System.out.println("there is no loop in the map");
	    
	}
	// loop in a linkedlist
	public static void loop(){
	    Node fast=head,slow=head;
	    while(fast!=null && fast.next!=null){
	        slow=slow.next;
	        fast=fast.next.next;
	        if(fast==slow){
	            System.out.println("There is a loop in a linkedlist");
	            System.exit(0);
	            
	        }
	    }
	    System.out.println("There is no loop in the linkedlist");
	}
	//printing elements of a linkedlist
	public static void print(){
	    Node curr=head;
	    while(curr!=null){
	        System.out.print(curr.data+" ");
	        curr=curr.next;
	    }
	    System.out.println("23");
	}
	
	//reversing a linkedlist
	public static void reverse(){
	    Node dummy=null;
	    Node currHead=head;
	    while(currHead!=null){
	        Node headNext=currHead.next;
	        currHead.next=dummy;
	        dummy=currHead;
	        currHead=headNext;
	    }
	    Node dum=dummy;
	    while(dum!=null){
	        System.out.print(dum.data+" ");
	        dum=dum.next;
	    }
	    System.out.println();
	}
	
	public static void middle(){
	    Node fast=head,slow=head;
	    while(fast.next!=null && fast.next!=null){
	        slow=slow.next;
	        fast=fast.next.next;
	    }
	    System.out.println(slow.data);
	}
}