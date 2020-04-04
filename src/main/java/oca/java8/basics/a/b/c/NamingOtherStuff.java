package oca.java8.basics.a.b.c;

import java.io.File;
import java.util.ArrayList;

class D {
    public static void main(String[] args) {
        ArrayList<String> existing = new ArrayList<>();

        for (String arg : args) {
            if (new E().existing(arg)) {
                existing.add(arg);
            }
        }
    }
}

class E {
    public boolean existing(String name) {
        File test = new File(name);
        return test.exists();
    }
}
