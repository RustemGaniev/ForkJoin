package com.company;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Main {


    public static void main(String[] args) {

       Integer[] array = newArray();
        int start = 0;
        int end = array.length;
        final int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(numberOfProcessors);
        final ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfProcessors);
        final ForkJoinTask<Integer> result = forkJoinPool.submit(new ArraySumTask(start, end, array));

        System.out.println("The result is : " + result.join());
    }

    public static Integer[] newArray() {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива i : \n");

        int arrayI = scanner.nextInt();
        Integer[] array = new Integer[arrayI];
        int arrayKey = 100;

        for (int i = 0; i < arrayI; i++) {
            array[i] = (int) (Math.random() * arrayKey * Math.random());
        }
        return array;
    }
}

