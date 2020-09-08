package jerrydobner.net.iv;

public class Fruits {
    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " + 
                          findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " + 
                          findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }

    public static int findLength(char[] fruit) {
        String s = String.valueOf(fruit);
        return LongSubst.findLongestSubst2(s, 2);
    }


}
