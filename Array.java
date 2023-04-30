import java.util.Random;

public class Array {
    private int[][][] array;
    private int a, b, c;

    public Array(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        array = new int[a][b][c];
        Random rand = new Random();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                for (int l = 0; l < c; l++) {
                    array[i][j][l] = rand.nextInt(100);
                }
            }
        }
    }

    public int getElement(int i, int j, int l) {
        return array[i][j][l];
    }

    public int getAiliffElement(int i, int j, int l) {
        return array[l][j][i];
    }

    public int[] getVector(int i, int j) {
        int[] vector = new int[c];
        for (int l = 0; l < c; l++) {
            vector[l] = array[i][j][l];
        }
        return vector;
    }

    public static void main(String[] args) {
        Array array = new Array(100, 100, 100);

        // Прямой доступ
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                for (int l = 0; l < 100; l++) {
                    int element = array.getElement(i, j, l);
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("1. Прямой доступ занимает " + (end - start) + " нс");

        // Доступ посредством векторов Айлиффа
        start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                for (int l = 0; l < 100; l++) {
                    int element = array.getAiliffElement(i, j, l);
                }
            }
        }
        end = System.nanoTime();
        System.out.println("2. Доступ посредством векторов Айлиффа занимает " + (end - start) + " нс");

        // Метод определения векторов
        start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int[] vector = array.getVector(i, j);
            }
        }
        end = System.nanoTime();
        System.out.println("3. Метод определения векторов занимает " + (end - start) + " нс");
    }
}
