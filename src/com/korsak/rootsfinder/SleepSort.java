package com.korsak.rootsfinder;

import java.util.List;

class SleepSort {
    SleepSort(List<Double> input){

        for (final Double arg : input) {
            new Thread(() -> {
                try {
                    Thread.sleep(arg.longValue());
                } catch (Exception e) {
                }
                System.out.print(arg + " ");
            }).start();
        }
    }
}
