package tests;

import jdk.dynalink.Operation;

import java.util.*;
import java.util.stream.Stream;


public class ListDemo {

    public static void main(String args[]) {

        List<String> list = new ArrayList<String>();

        list.add("a");

        list.add("a");

        list.clear();

        list.add("b");

        list.add("b");

        System.out.println(list.size());


//        Object o = () -> {};
//
//        Operation o2 = () -> "Rally";
//
//        Operation<String> o3 = () -> {
//            return "Mario";
//        }
//
//        HashMap<String, String> map = new HashMap<>();
//
//        map.forEach();
//
//        Stream<String> stream = () -> {
//            return "Rally";
//        };
//
//        stream.filter();
//        stream.map();
//        stream.forEach();


    }

}