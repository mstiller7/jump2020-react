package functional.streams;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

class SerialStream {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
        System.out.println("listOfIntegers:....1");
        listOfIntegers.stream()
                .forEach(e -> System.out.print(e + " "));
        System.out.println("");
        List<Integer> serialStorage = new ArrayList<>();
        System.out.println("Serial stream:.....2");
        listOfIntegers
                .stream()
                .map(e -> {
                    serialStorage.add(e);
                    return e;
                })
                .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("");
        serialStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("");
        System.out.println("listOfIntegers sorted in reverse order:....3");
        Comparator<Integer> normal = Integer::compare;
        Comparator<Integer> reversed = normal.reversed();
        Collections.sort(listOfIntegers, reversed);
        listOfIntegers.stream()
                .forEach(e -> System.out.print(e + " "));
        System.out.println("");
    }
}

class ParallelStream2 {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
        System.out.println("listOfIntegers:....1");
        listOfIntegers.stream()
                .forEach(e -> System.out.print(e + " "));
        System.out.println("");
        System.out.println("Parallel stream:....2");
        List<Integer> parallelStorage = Collections.synchronizedList(new ArrayList<>());
        listOfIntegers
                .parallelStream()
                .map(e -> { parallelStorage.add(e); return e; })
                .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("");
        System.out.println("Parallel stream altered by forEachOrdered:....3");
        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("");
    }
}