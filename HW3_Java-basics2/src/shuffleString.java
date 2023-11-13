public class shuffleString {
    public static void main(String[] args) {
        String s = "codeleet";
        int[] arr = {4,5,6,7,0,2,1,3};
        System.out.println(restoreString(s, arr));
    }

    public static String restoreString(String s, int[] indices) {
        char[] arr = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            arr[indices[i]] = s.charAt(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : arr) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
