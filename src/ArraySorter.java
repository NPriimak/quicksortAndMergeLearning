import java.util.Comparator;

public class ArraySorter {

    public static <E> void quicksort (E [] array, int start, int end, Comparator<E> comparator){
        if (end - start <= 0){
            return;
        }

        int i = start;
        int j = end - 1;
        boolean movingI = true;

        while (i < j) {
            if (comparator.compare(array[i], array[j]) > 0) {
                swap(array, i, j);
                movingI = !movingI;
            }
            else {
                if (movingI) {
                    i++;
                }
                else {
                    j--;
                }
            }
        }
        quicksort(array, start, i, comparator);
        quicksort(array, i + 1, end, comparator);
    }

    public static <E> void quicksort (E [] array, Comparator <E> comparator){
        quicksort(array, 0, array.length, comparator);
    }
    public static <E> void swap(E [] array, int i, int j){
        if (i == j) return;

        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static <E> void merge(E [] array, int start, int mid, int end, E [] targetArray, Comparator<E> comparator){
        int i = start;
        int j = mid;
        int k = start;
        while (k < end){
            if (i == mid) {
                targetArray[k] = array[j];
                j++;
            } else if (j == end){
                targetArray[k] = array[i];
                i++;
            } else if (comparator.compare(array[i], array[j]) > 0){
                targetArray[k] = array[j];
                j++;
            } else {
                targetArray[k] = array[i];
                i++;
            }
            k++;
        }
    }

    public static <E> void mergeSort(E[] sourceArray, int start, int end, E[] tempArray, Comparator <E> comparator){
        if (start >= end - 1){
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(sourceArray, start, mid, tempArray, comparator);
        mergeSort(sourceArray, mid, end, tempArray, comparator);

        merge(sourceArray, start, mid, end, tempArray, comparator);
        System.arraycopy(tempArray, start, sourceArray, start, end - start);
    }
}
