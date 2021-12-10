package com.company;
import library.Functions;
import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(Functions.distance(new double[]{2,3}, new double[]{5, -1}));
        System.out.println();
        //please use Objects as types, not the primitive types (Integer instead of int and so on)
        Integer[][] M = {
                {2, 7, 10, 49},
                {7, 2, 29, 10},
                {0, 38, 10, 39}
        };
        Functions.serialize(M);
        Integer[][] s1 = Functions.deserialize();
        System.out.println(Arrays.deepToString(s1));
        System.out.println();
        System.out.println(Functions.matrixType(M));
        System.out.println();
        System.out.println(Arrays.deepToString(Functions.transpose(M)));
        System.out.println();
        System.out.println(Arrays.deepToString(Functions.spiral(5)));
    }
}
