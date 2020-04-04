package oca.java8.basics;

public class Test {
    static int x = 15;
    static int i = 3;
    int Test = 104;

    public static void main(String[] args) {
//        compilationError2();
//        shadowing();
//        shadowing2();
        new Test();
    }

    void Test() {
        System.out.println(Test);
    }

    static void compilationError1() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
        }
//        System.out.println(i); error de compilacion
    }

    static void compilationError2() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
        }
        int i = 15;
        System.out.println(i);

    }

    static void shadowing() {
        int x = 200;
        System.out.println(x);
    }

    static void shadowing2() {
        for (new Test().i = 10; new Test().i < 100; new Test().i++) {
            System.out.println(i);
        }
    }

}

/**
 * Podemos tener miembros con el mismo nombre.
 */
class B {
    String b;

    B() {

    }

    void b() {
    }
}

/**
 * Constructor con el mismo nombre de método.
 */
class Executor {
    Executor() {
    }

    void Executor() {

    }
}

/**
 * Un constructor puede tener un return vacío.
 */
class X {
    int j = 200;

    X(int i) {
        if (i < 10) {
            return;
        }
        j = i;
    }
}
