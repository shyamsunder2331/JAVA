import java.util.*;
import java.io.*;
public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};
        boolean flag=true;
        int five=0,ten=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five+=1;
            }
            else if(bills[i]==10){
                ten+=1;
                if(five==0){
                    flag=false;
                    break;
                }
                five-=1;
            }else if(bills[i]==20){
                if(five>0 && ten>0){
                    five-=1;
                    ten-=1;
                }
                else if(five>2){
                    five-=3;
                }else{
                    flag=false;
                    break;
                }
            }
        }
        System.out.println(flag);
    }
}
