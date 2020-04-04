package java8.in.action.chap10;

import java.util.Optional;

public class OptionalMain {

    public static void main(String[] args) {

    }

//    public Insurance findCheapestInsurance(Person person, Car car) {
// queries services provided by the different insurance companies
// compare all those data
//        return cheapestCompany;
//    }

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
