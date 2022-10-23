import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] v = new int[]{5, 4, 2, 6, 7, 21, -2, 15, 23};
        System.out.println(Arrays.toString(bubbleSort(v)));
        System.out.println(binarySearch(v, 7));
        int[] w = new int[]{6,9,13,14,23,25,27,31};
        System.out.println(Arrays.toString(mergeArrays(v, w)));
    }

    public static int[] bubbleSort(int[] v){
        boolean swaped;
        int x = 0;
        do {
            swaped = false;
            int previousItem = v[0];
            for (int i = 1; i < v.length - x; i++){
                int currentItem = v[i];
                if (currentItem < previousItem){
                    v[i-1] = currentItem;
                    v[i] = previousItem;
                    swaped = true;
                }
                previousItem = v[i];
            }
            x++;
        } while (swaped);

        return v;
    }

    public static int binarySearch(int[] v, int number){
        int min = 0;
        int max = v.length;
        while (min < max){
            int mean = (min + max) / 2;
            if (v[mean] == number){
                return mean;
            } else if(v[mean] > number){
                max = mean;
            } else{
                min = mean + 1;
            }
        }
        return -1;
    }

    public static int[] mergeArrays(int[] v, int[] w){
        int[] res = new int[v.length + w.length];
        int n = 0;
        int m = 0;
        int k = 0;

        while (m < v.length && n < w.length){
            if (v[m] < w[n]){
                res[k] = v[m];
                m++;
            } else{
                res[k] = w[n];
                n++;
            }
            k++;
        }

        while (m < v.length){
            res[k] = v[m];
            k++;
            m++;
        }

        while (n < w.length){
            res[k] = w[n];
            k++;
            n++;
        }

        return res;
    }
}