package lambdasinaction.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingTraining {

    public static void main(String[] args) {
        List<Perapple> list = new ArrayList<>();
        list = Arrays.asList(new Perapple(10,"rojo"),  new Perapple(20, "verde"),
                new Perapple(15, "malogrado"));

        list.sort(new Comparator<Perapple>() {
            @Override
            public int compare(Perapple o1, Perapple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        System.out.println(list);

    }
}

    class Perapple{

    private Integer weight = 0;
    private String color = "";

    public Perapple(Integer weight, String color){
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
