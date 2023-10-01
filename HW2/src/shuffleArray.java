import java.util.Arrays;

public class shuffleArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }

    public static int[] shuffle(int[] arr, int n) {
        int[] result = new int[n*2];
        int i = 0, k = 0;
        int j = n;
        while(i < n && j < arr.length) {
            result[k++] = arr[i];
            result[k++] = arr[j];
            i++;
            j++;
        }
        return result;
    }
}
