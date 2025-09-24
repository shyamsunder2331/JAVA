public class climbingTop{
    public static void main(String[] args){
        int n=10;
        int[] arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        arr[2]=2;
        arr[3]=4;
        for(int i=4;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}