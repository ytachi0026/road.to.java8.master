package oca.java8.basics.b;

import oca.java8.basics.a.AEjercicio7;

import static oca.java8.basics.a.AEjercicio7.*;

class BEjercicio7 {

    void m7() {
        AEjercicio7 a = new AEjercicio7();
        // when using static, it won't import the class itself, just the methods
        a.run(VALUE);
    }
}
