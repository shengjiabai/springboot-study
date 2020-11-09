package com.bzy.service.other;

import java.util.Arrays;
import java.util.LinkedList;

public class SortTest {

    public static void main(String[] args) {
        int[] a ={4,52,6,2,45,56};
        int temp;
        for (int i = 0; i <a.length ; i++) {
            for (int j = i+1; j <a.length ; j++) {
                if(a[i]>a[j]){
                    temp=a[j];
                    a[j]=a[i];
                    a[i]=temp;
                }
            }
            
        }
        System.out.println(Arrays.asList(a));

        LinkedList<Integer> integers = new LinkedList<>();

        integers.add(10);

    }
}
