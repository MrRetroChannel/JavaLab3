package com.Gnidskiy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class TimeEvaluator {

    /**
     * Helper method evaluating execution time of some action with list
     * @param fun - targeted function, preferably lambda
     * @param list - target list
     * @return Result of time evaluation
     */
    public static <T> double evaluateExecutionTimeInMilliseconds(Consumer<List<T>> fun, List<T> list) {
        long start = System.nanoTime();

        fun.accept(list);

        return (double)(System.nanoTime() - start) / 1_000_000.0;
    }

    /**
     * Helper function to fill List for further tests
     * @param list - target list
     * @param count - number of elements to be added
     */
    private static void fillList(List<Integer> list, int count) {
        for (int i = 0; i < count; ++i)
            list.add(i);
    }

    /**
     * Method evaluating execution time of add method of ArrayList and LinkedList
     * @return Results of time evaluation
     */
    public static double[] countAdd() {
        List<Integer> arrayList = new ArrayList<>();
        double arrayListResult = evaluateExecutionTimeInMilliseconds((List<Integer> list) -> {
            fillList(list, 2000);
        }, arrayList);

        List<Integer> linkedList = new LinkedList<>();
        double linkedListResult = evaluateExecutionTimeInMilliseconds((List<Integer> list) -> {
            fillList(list, 2000);
        }, linkedList);

        return new double[] { arrayListResult, linkedListResult };
    }

    /**
     * Method evaluating execution time of remove method of ArrayList and LinkedList
     * @return Results of time evaluation
     */
    public static double[] countRemove() {
        List<Integer> arrayList = new ArrayList<>();
        fillList(arrayList, 2000);

        double arrayListResult = evaluateExecutionTimeInMilliseconds((List<Integer> list) -> {
            for (int i = 0; i < 2000; ++i) {
                list.remove(0);
            }
        }, arrayList);


        List<Integer> linkedList = new LinkedList<>();
        fillList(linkedList, 2000);

        double linkedListResult = evaluateExecutionTimeInMilliseconds((List<Integer> list) -> {
            for (int i = 0; i < 2000; ++i) {
                list.remove(0);
            }
        }, linkedList);

        return new double[] { arrayListResult, linkedListResult };
    }

    /**
     * Method evaluating execution time of get method of ArrayList and LinkedList
     * @return Results of time evaluation
     */
    public static double[] countGet() {
        List<Integer> arrayList = new ArrayList<>();
        fillList(arrayList, 2000);

        double arrayListResult = evaluateExecutionTimeInMilliseconds((List<Integer> list) -> {
            for (int i = 0; i < 2000; ++i) {
                int get = list.get(i);
            }
        }, arrayList);


        List<Integer> linkedList = new LinkedList<>();
        fillList(linkedList, 2000);

        double linkedListResult = evaluateExecutionTimeInMilliseconds((List<Integer> list) -> {
            for (int i = 0; i < 2000; ++i) {
                int get = list.get(i);
            }
        }, linkedList);

        return new double[] { arrayListResult, linkedListResult };
    }
}
