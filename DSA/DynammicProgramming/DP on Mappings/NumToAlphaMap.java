import java.util.*;
import java.io.*;
public class Main{
    static String s;
    static int n;
    static Map<Integer,Integer> map=new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        s=br.readLine();
        n=s.length();
        int ans=decode(0);
        System.out.println(ans);
        int[] dp=new int[n+1];
        dp[0]=1;
      for(int i=1;i<=n;i++){
        char c=s.charAt(i);
        if(c=='*){
          dp[i]+=9*dp[i-1];
        }else if(c!='0'){
          dp[i]+=dp[i-1];
        }
        if(i>1){
          char p=s.cahrAt(i-2);
          if(p=='1'){
            if(c=='*'){
              dp[i]+=9*dp[i-2];
            }else{
              dp[i]+=dp[i-2];
            }
          }
          else if(p=='2'){
            if(c=='*'){
              dp[i]+=6*dp[i-2];
            }else{
              dp[i]+=dp[i-2];
            }
          }
          else if(p=='*'){
            if(c=='*'){
                dp[i]+=15*dp[i-2];
            }else if(c<='6'){
              dp[i]+=2*dp[i-2];
            }else{
              dp[i]+=dp[i-2];
            }
          }
        }
      }
      System.out.println(dp[n]);
}
    public static int decode(int i){
        
        if(i>=n) return 1;
        if(map.containsKey(i)) return map.get(i);
        char p=s.charAt(i);
        int ways=0;
        if(p=='*'){
            ways+=9*decode(i+1);
        }else if(p!='0'){
            ways+=decode(i+1);
        }
        
        if(i+1<n){
            char c=s.charAt(i+1);
            if(p=='1'){
                if(c=='*'){
                    ways+=9*decode(i+2);
                }else{
                    ways+=decode(i+2);
                }
            }else if(p=='2'){
                if(c=='*'){
                    ways+=6*decode(i+2);
                }else{
                    ways+=decode(i+2);
                }
            }else if(p=='*'){
                if(c=='*'){
                    ways+=15*decode(i+2);
                }else if(c<='6'){
                    ways+=2*decode(i+2);
                }else{
                    ways+=decode(i+2);
                }
            }
        }
        map.put(i,ways);
        return ways;
    }
}
