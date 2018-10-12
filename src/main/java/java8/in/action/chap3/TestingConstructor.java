package java8.in.action.chap3;

import java.util.function.Function;
import java.util.function.Supplier;

public class TestingConstructor {

    public TestingConstructor() {
        System.out.println("HOLA!");
    }

    public TestingConstructor(Integer dry) {
        System.out.println("HOLA! 1 parameter: " + dry);
    }

    public TestingConstructor(String test1, String test2, String test3) {
        System.out.println("TRICA!");
        System.out.println(test1 + test2 + test3);
    }


    public static class Runner {

        public static void main(String[] args) {
            Supplier<TestingConstructor> hi = TestingConstructor::new;
            hi.get();

            Supplier<TestingConstructor> hi2 = () -> new TestingConstructor();
            hi2.get();

            TestingConstructorBuilder hi3 = () -> new TestingConstructor();
            hi3.createMe();


            Function<Integer, TestingConstructor> test = TestingConstructor::new;
            test.apply(3);

            TestingConstructorBuilderTRICA trica = (a1, a2, a3) -> new TestingConstructor(a1, a2, a3);
            trica.createMe("a1", "a2", "a3");


            TestingConstructorBuilderTRICA trica2 = TestingConstructor::new;
            trica2.createMe("b1", "b2", "b3");


        }

    }

    @FunctionalInterface
    interface TestingConstructorBuilder {

        TestingConstructor createMe();
    }

    @FunctionalInterface
    interface TestingConstructorBuilderTRICA {
        TestingConstructor createMe(String test1, String test2, String test3);
    }

}
