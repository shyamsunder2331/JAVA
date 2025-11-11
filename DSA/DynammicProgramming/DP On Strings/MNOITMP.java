// minimum number of insertions to make a string palindrome
public class MNOITMP{
    public static void main(String[] args){
        String s="shyamsunder";
        int n=tabulation(s);
        System.out.println(s.length()-n);
    }
    public static String rev(String s){
        String res="";
        for(char i:s.toCharArray()){
            res=i+res;
        }
        return res;
    }
    public static int lcs(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int[] prev=new int[m+1];
        int[] curr=new int[m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }
            prev=curr.clone();
        }
        return prev[m];
    }
    public static int tabulation(String s){
        String s1=rev(s);
        int m=lcs(s,s1);
        return m;
    }
}