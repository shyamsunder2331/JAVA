class Main{
    
    public static void main(String[] args){
        int number=341;
        int low=1,high=number;
        int res=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid*mid)<=number){
                low=mid+1;
                res=mid;
            }else{
                high=mid-1;
            }
        }
        System.out.println(res+" "+res*res);
    }
}