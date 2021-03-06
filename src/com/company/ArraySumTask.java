package com.company;

import java.util.concurrent.RecursiveTask;

public class ArraySumTask extends RecursiveTask<Integer> {

    int start;
    int end;

    static Integer[] array;

    public ArraySumTask(int start, int end, Integer[] array) {
        this.start = start;
        this.end = end;
        this.array = array;

        }

    @Override
    public Integer compute() {

        end = array.length;
        start = 0;
        final int diff = end - start;
        switch (diff) {
            case 0:
                return 0;
            case 1:
                return array[start];
            case 2:
                return array[start] + array[start + 1];
            default:
                final int middle = (end - start) / 2 + start;
                ArraySumTask task1 = new ArraySumTask(start, middle, array);
                ArraySumTask task2 = new ArraySumTask(middle, end, array);
                invokeAll(task1, task2);
                return task1.join() + task2.join();
        }
    }
}
