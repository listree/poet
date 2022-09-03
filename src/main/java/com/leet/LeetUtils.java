package com.leet;

public class LeetUtils {

    public static void printArbitrary(Object... objects) {
        printSpace("Arbitrary:");
        for(Object obj: objects) printSpace(obj);
        printLine("");
    }

    public static void printArray(String[] strings) {
        printSpace("Array:");
        for(String str: strings) printSpace(str);
        printLine("");
    }

    public static void printResult(Object obj) {
        System.out.println("Result: "+ obj.toString());
    }

    public static void printLine(Object obj) {
        System.out.println(""+ obj.toString());
    }

    public static void printSpace(Object obj) {
        System.out.print("" + obj.toString() + " ");
    }

}
