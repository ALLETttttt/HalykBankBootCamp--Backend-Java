public class jewelsAndStones {
    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int counter = 0;
        for(int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if(jewels.contains(String.valueOf(ch))) {
                counter++;
            }
        }
        return counter;
    }
}
