import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Integer [] array = {10, 5, 2, 3, 78, 53, 3, 1, 1, 24, 1, 35, 35, 2, 67, 4, 33, 30};
        long m = System.currentTimeMillis();
        ArraySorter.quicksort(array, (a, b) -> a - b);
        System.out.println(Arrays.toString(array));
        System.out.printf("Quicksort take %d \n", System.currentTimeMillis() - m);

        long n = System.currentTimeMillis();
        ArraySorter.mergeSort(array, 0, array.length, new Integer [array.length], (a, b) -> a - b);
        System.out.println(Arrays.toString(array));
        System.out.printf("MergeSort take %d \n", System.currentTimeMillis() - n);

        Integer [] arr1 = {1, 2, 5, 8};
        Integer [] arr2 = {8, 10, 11, 15};

        n = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr1));
        list.addAll(Arrays.asList(arr2));
        Integer [] result = list.stream().sorted().collect(Collectors.toList()).toArray(new Integer [] {});

        System.out.println(Arrays.toString(result));
        System.out.printf("Stream take %d \n", System.currentTimeMillis() - n);

        Integer [] newResult = new Integer [arr1.length + arr2.length];
        int index = 0;
        n = System.currentTimeMillis();
        System.arraycopy(arr1, 0, newResult, 0, arr1.length);
        System.arraycopy(arr2, 0, newResult, arr1.length, arr2.length);
        ArraySorter.mergeSort(newResult, 0, newResult.length, new Integer [newResult.length], (a, b) -> a - b);

        System.out.println(Arrays.toString(result));
        System.out.printf("Merge take %d \n", System.currentTimeMillis() - n);

        n = System.currentTimeMillis();
        List <Integer> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList(arr1));
        list2.addAll(Arrays.asList(arr2));
        list2.sort(Comparator.comparingInt(a -> a));
        System.out.println(Arrays.toString(list2.toArray()));
        System.out.println(System.currentTimeMillis() - n);

        System.out.println(findRepeater(list2.toArray()));

    }

    public static <T> List <T> findRepeater(T [] arr){
        List <T> result = new ArrayList<>();
        List <T> list = new ArrayList<>();
        for (T t : arr){
            if (list.contains(t)){
                result.add(t);
            } else {
                list.add(t);
            }
        }

        return result;
    }
}
