package lambdasinaction.chap4;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestingOptional {

    public static void main(String[] args) {
        String errorCode = "";

        System.out.println(Optional.ofNullable(errorCode).orElse( "41"));
    }

    @Test
    public void testingOnlyTraversedStream(){
        Stream test = Stream.of(Arrays.asList("temp", "tempe"));

        test.forEach(System.out::println);
        test.forEach(System.out::println);
    }

    @Test
    public void testDistinctStreams(){
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        numbers.stream().filter(i -> i%2 ==0).distinct().forEach(System.out::println);
    }

    @Test
    public void testLimit(){
        List<Dish> result = Dish.menu.stream().filter(d -> d.getCalories() > 400).limit(2).collect(Collectors.toList());
        System.out.println(result);
    }
    @Test
    public void testSkip(){
        List<Dish> result = Dish.menu.stream().filter(d -> d.getCalories() > 400).skip(2).collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void testFilterTwoMeatDishes(){
        List<Dish> result = Dish.menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT).limit(2).collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void testingMapInStreams(){
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");

        //Given a list of words, you’d like to return a list of the number of characters for each word
        List<Integer> result = words.stream().map(String::length).collect(Collectors.toList());
        System.out.println(result);

        //What if you wanted to find out the length of the name of each dish?
        List<Integer> result2 = Dish.menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        System.out.println(result2);
    }

    @Test
    public void testingFlatteningMaps(){
        // how could you return a list of all the unique characters for a list of words?
        String[] arrayOfWords = {"Hello", "World"};

        List<String[]> result = Stream.of(arrayOfWords).map(w -> w.split("")).distinct().collect(Collectors.toList());
        System.out.println(result);

        //WRONG APPROACH
//        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
//        streamOfwords.map(w -> w.split("")).map(Arrays::stream).distinct().collect(Collectors.toList());
        List<String> result2 =Stream.of(arrayOfWords).map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(result2);

    }
}
