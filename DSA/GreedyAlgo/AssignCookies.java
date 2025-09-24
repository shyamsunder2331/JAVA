
import java.util.*;
import java.io.*;

public class AssignCookies
{
	public static void main(String[] args) {
		int[] g = {1,5,3,3,4};
		int[] s = {4,2,1,2,1,3};
		int l=0,r=0;
		int m=g.length;
		int n=s.length;
		Arrays.sort(g);
		Arrays.sort(s);
		while(l<n){
		    if(g[r]<=s[l]){
		        r=r+1;
		    }
		    l=l+1;
		}
		System.out.println(r);
	}
}
