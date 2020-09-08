package jerrydobner.net.iv;

import java.util.*;
import java.util.stream.IntStream;


public class Arrays1 {
    
    public static void main(String[] args) {
        double[] result = getAverages(new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 }, 5);
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
        main2(null);
      }

    public static void main2(String[] args) {
        var result = findSmallestContiguousGreaterThan(7, new int[] { 2, 1, 5, 2, 3, 2 });
        result = findSmallestContiguousGreaterThan(7, new int[] { 2, 1, 5, 2, 8 });
        result = findSmallestContiguousGreaterThan(8, new int[] { 3, 4, 1, 1, 6 });
        final Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int[] numbers = IntStream.generate(() -> r.nextInt(7)).limit(10).toArray();
            result = findSmallestContiguousGreaterThan(r.nextInt(9) + 6, numbers);
        }
    }
    
    static double[] getAverages(int[] intArray, int k) {
        var kMinus1 = k -1;
        var averages = new double[intArray.length - kMinus1];
        var total = 0.0;
        for (int i = 0; i < intArray.length; i++) {
            total += intArray[i];
            int dropoffIndex = i - k;
            if (dropoffIndex >= 0) {
                total -= intArray[dropoffIndex];
            } 
            if (i >= kMinus1) {
                averages[i - kMinus1] = total / k;
            }
        }
        return averages;
        
    }

    static int findSmallestContiguousGreaterThan(int s, int[] numbers)  {
        System.out.println(
            "Searching for min sum of " + s + " in " + Arrays.toString(numbers));
        for (int chunkSize = 2; chunkSize <= numbers.length; chunkSize++) {
            if (findWithChunkSizeOf(s, numbers, chunkSize)) {
                System.out.println("Result: " + chunkSize + "\n");
                return chunkSize;
            }
        }
        System.out.println("Not found\n");
        return 0;
    }

    private static boolean findWithChunkSizeOf(int s, int[] numbers, int chunkSize) {
        for(int start = 0; start <= numbers.length - chunkSize; start++) {
            System.out.println("searching at start = " + start + " chunk = " + chunkSize);
            if (Arrays.stream(
                numbers, start, start + chunkSize).sum() >= s) {
                    return true;
                }
        }
        return false;
    }
}