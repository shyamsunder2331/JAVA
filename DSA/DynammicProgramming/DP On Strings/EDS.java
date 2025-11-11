import java.util.*;

public class EDS {
    public static void main(String[] args) {
        String s1="horse";
        String s2="ros";
        int n=memoization(s1,s2,s1.length()-1,s2.length()-1);
        System.out.println(n);
    }    
    public static int memoization(String s1,String s2,int ind1,int ind2){
        if(ind1<0){
            return ind2+1;
        }
        if(ind2<0) return ind1;
        if(s1.charAt(ind1)==s2.charAt(ind2)) return memoization(s1,s2,ind1-1,ind2-1);
        else{
            return 1+Math.min(memoization(s1, s2, ind1-1, ind2-1),Math.min(memoization(s1, s2, ind1-1, ind2),memoization(s1, s2, ind1, ind2-1)));
        }
    }
}
