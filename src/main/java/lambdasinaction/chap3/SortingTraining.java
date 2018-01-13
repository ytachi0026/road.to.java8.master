package lambdasinaction.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingTraining {

    public static void main(String[] args) {
        List<Perapple> list = new ArrayList<>();
        list = Arrays.asList(new Perapple(10, "rojo"), new Perapple(20, "verde"),
                new Perapple(15, "malogrado"));

        list.sort(new Comparator<Perapple>() {
            @Override
            public int compare(Perapple o1, Perapple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        System.out.println(list);


        list.set(1, new Perapple(2, "green"));

        list.sort((p1, p2) -> p1.getWeight().compareTo(p2.getWeight()));
        System.out.println(list);


        list.set(1, new Perapple(3, "green"));
        Comparator<Perapple> test = Comparator.comparing((Perapple a) -> a.getWeight());

        list.sort(test);
        System.out.println(list);

        list.set(1, new Perapple(22, "green"));

        list.sort(Comparator.comparing(a -> a.getWeight()));
        System.out.println(list);


        list.set(1, new Perapple(1, "green"));
        list.sort(Comparator.comparing(Perapple::getWeight));
        System.out.println(list);

        list.sort(Comparator.comparing(Perapple::getWeight).reversed());
        System.out.println(list);


    }

    public static class Perapple {

        private Integer weight = 0;
        private String color = "";

        public Perapple(Integer weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }


}
