import java.util.Arrays;

class Koko_Bananas {
    static int kokoEat(int[] arr, int k) {
        int mx = Arrays.stream(arr).max().getAsInt();
      
        for (int speed = 1; speed <= mx; speed++) {
            
            long time = 0;
            for (int i = 0; i < arr.length; i++) {
              
                // Time required to eat this pile 
                // of bananas at current speed
                time += arr[i] / speed;

                // 1 extra hour to eat the remainder 
                // number of bananas in this pile
                if (arr[i] % speed != 0) {
                    time++;
                }
            }
            
            // If total eating time at current speed
            // is smaller than given time
            if (time <= k) {
                return speed;
            }
        }
      
        return mx;
    }

    public static void main(String[] args) {
        int[] arr = {7,15,6,3};
        int k = 6;
        System.out.println(kokoEat(arr, k));
    }
}