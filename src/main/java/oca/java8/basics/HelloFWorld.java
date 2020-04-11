package oca.java8.basics;

/**
 *  * Root:/road.to.java8.master/src/main/java
 * OJO:
 * Compile: javac oca/java8/basics/HelloFWorld.java
 * Run: java oca.java8.basics.HelloFWorld
 *
 *
 * PLAYING WITH JAR!
 * jar -cf library.jar oca
 * java -cp library.jar oca.java8.basics.HelloFWorld
 *
 * Same stuff, but playing with manifest, OJO siempre debe haber un enter al final de cada linea, sino el compilador no lo va a considerar!
 *  jar -cfm bib.jar mymanifest oca (TO ADD MANIFEST, the name of mymanifest, of course is the custom manifest you want to use)
 *  java -jar bib.jar
 */
public class HelloFWorld {

    public static void main(String[] args) {
        System.out.println("Hello FWorld");
    }
}
