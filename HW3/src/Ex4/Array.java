package Ex4;

public class Array implements IMath {
    private int[] array;

    public Array(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] arr) {
        this.array = arr;
    }

    @Override
    public int Max() {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив пуст");
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    @Override
    public int Min() {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив пуст");
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public float Avg() {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив пуст");
        }
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return (float) sum / array.length;
    }
}
