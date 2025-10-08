import java.util.*;
import java.io.*;
public class LongestSubstring{
  public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String s=br.readLine();
    int left=0,right=0;
    Set<Character> set=new HashSet<>();
    int maxLength=Integer.MIN_VALUE;
    while(right<s.length()){
        while(set.contains(s.charAt(right))){
            set.remove(s.charAt(left));
            left++;
        }
        set.add(s.charAt(right));
        maxLength=Math.max(maxLength,right-left+1);
      right++;
    }
    System.out.println(maxLength);
  }
}
