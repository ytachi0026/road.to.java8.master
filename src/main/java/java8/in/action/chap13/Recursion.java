package java8.in.action.chap13;

import org.junit.Test;

import java.util.stream.LongStream;


public class Recursion {

    public static void main(String[] args) {
//        System.out.println(factorialIterative(5));
//        System.out.println(factorialRecursive(5));
//        System.out.println(factorialStreams(5));
//        System.out.println(factorialTailRecursive(5));
    }

    @Test
    public void factorialIterative() {

        int r = 1, n=5;
        for (int i = 1; i <= n; i++) {
            r*=i;
        }
        System.out.println(r);
    }

    public static long factorialRecursive(long n) {
        return n == 1 ? 1 : n*factorialRecursive(n-1);
    }

    public static long factorialStreams(long n){
        return LongStream.rangeClosed(1, n)
                         .reduce(1, (long a, long b) -> a * b);
    }

    public static long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }

    public static long factorialHelper(long acc, long n) {
        return n == 1 ? acc : factorialHelper(acc * n, n-1);
    }
}
