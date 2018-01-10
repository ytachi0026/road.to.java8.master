package lambdasinaction.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.BufferOverflowException;

public class FunctionalInterfaceTraining {

    public static void main(String[] args) {

        System.out.println("RESULT 1");
        String result = obtainDetailFromFile( (BufferedReader b) -> b.readLine());
        System.out.println(result);

        System.out.println("RESULT 2");
        result = obtainDetailFromFile( (BufferedReader b) -> {return b.readLine() + " PO " + b.readLine();});
        System.out.println(result);
    }


    public static String obtainDetailFromFile(BufferedReaderProcessor processor){

        try  {
            String test = FunctionalInterfaceTraining.class.getClassLoader().getResource("lambdasinaction/chap3/data.txt").getFile();

            System.out.println(test);

            BufferedReader reader = new BufferedReader(new FileReader(test));
            return processor.workOnThis(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    @FunctionalInterface
    public interface BufferedReaderProcessor {
        public abstract String workOnThis(BufferedReader br) throws IOException;

    }
}
