// this is the bruteforce of approach for longest Increasing Subsequence
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

      int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] max = {0};
        bruteForce(arr, 0, new ArrayList<>(), max);
        System.out.println(max[0]);
    }
    public static void bruteForce(int[] arr, int index, List<Integer> list, int[] max) {
        if (index == arr.length) {
            max[0] = Math.max(max[0], list.size());
            return;
        }

        // Option 1: Include arr[index] if it maintains increasing order
        if (list.isEmpty() || arr[index] > list.get(list.size() - 1)) {
            list.add(arr[index]);
            bruteForce(arr, index + 1, list, max);
            list.remove(list.size()-1);
        }
        bruteForce(arr, index + 1, list, max);
    }
}
