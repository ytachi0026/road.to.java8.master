package java8.in.action.chap5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestingStreamsOperations {

    @Test
    public void testQuiz5_2(){
        //problem 1
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);

        List<Integer> numbers1R = numbers1.stream().map(i -> i*i).collect(Collectors.toList());
        System.out.println(numbers1R);


        //problem 2
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(3,4);

        list1.stream().map(i -> list2.stream().map(j -> new int[]{i,j})).collect(Collectors.toList());

        List<int[]> result = list1.stream().flatMap(i -> list2.stream().map(j -> new int[]{i,j})).collect(Collectors.toList());
        System.out.println(result);

        List<int[]> result2 = list1.stream().flatMap(i -> list2.stream().filter(j -> (i+j) %3==0).map(j -> new int[]{i,j})).collect(Collectors.toList());
        System.out.println(result2);

        List<String> result22 = list1.stream().flatMap(i -> list2.stream().map(j -> "(".concat(i+",").concat(j+")"))).collect(Collectors.toList());
        System.out.println(result22);

        List<String> result33 = list1.stream().flatMap(i -> list2.stream().filter(j -> (i+j)%3==0).map(j -> "(".concat(i+",").concat(j+")"))).collect(Collectors.toList());
        System.out.println(result33);
    }


    @Test
    public void workingWithFindFirst(){
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);

//        Optional<Integer> result  = someNumbers.stream().filter(n -> (n*n)%3 == 0).findFirst();
        Optional<Integer> result  = someNumbers.stream().map(n -> n*n).filter(n -> n %3 ==0).findFirst();

        result.ifPresent(System.out::println);



    }
}
