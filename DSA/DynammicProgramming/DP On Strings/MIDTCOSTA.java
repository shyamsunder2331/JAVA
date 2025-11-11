//minimum number of insertions or deletions to make one string into another
//max way will be delete all from s1 and add all of s2 so n+m
public class MIDTCOSTA {
    public static void main(String[] args){
        String s1="eat";
        String s2="ate";
        int n=lcs(s1,s2);
        System.out.println(s1.length()+s2.length()-2*n);
    }
    public static int lcs(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int[] curr=new int[m+1];
        int[] prev=new int[m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }else{
                    curr[j]=Math.max(curr[j-1],prev[j]);
                }
            }
            prev=curr.clone();
        }
        return prev[m];
    }
}
