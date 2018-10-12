package java8.in.action.chap5;

import lambdasinaction.chap5.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PuttingIntoPractice{

    Trader raoul, mario, alan, brian;
    List<Transaction> transactions;
    @Before
    public void initializer(){
        raoul = new Trader("Raoul", "Cambridge");
        mario = new Trader("Mario","Milan");
        alan = new Trader("Alan","Cambridge");
        brian = new Trader("Brian","Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }


    @Test
    public void quiz01(){
        //Find all transactions in the year 2011 and sort them by value (small to high)
        List<Transaction> result = transactions
                .stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void quiz02(){
        //What are all the unique cities where the traders work?
        List<String> uniqueCities = transactions.stream()
                .map(d -> d.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println(uniqueCities);
    }

    @Test
    public void quiz03(){
        //Find all traders from Cambridge and sort them by name.
        List<Trader> result = transactions
                .stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        System.out.println(result);
    }

    @Test
    public void quiz04(){
        //Return a string of all traders’ names sorted alphabetically
        List<String> name =
                transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .sorted(comparing(Trader::getName))
                        .map(t -> t.getName())
                .collect(Collectors.toList());
        name = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(toList());

        String oneString = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a,b) -> a.concat(b));

        String oneStringB = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());

        System.out.println(name);
        System.out.println(oneString);
        System.out.println(oneStringB);

        //FIXME



    }

    @Test
    public void quiz05(){
        // Are any traders based in Milan?
        boolean findHim =  transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));

        System.out.println(findHim);
    }

    @Test
    public void quiz06(){
        //Print all transactions’ values from the traders living in Cambridge.
        List<Integer> result = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(toList());
        System.out.println(result);

        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    @Test
    public void q07(){
        //What’s the highest value of all the transactions?
        Optional<Transaction> result = transactions.stream().max(comparing(Transaction::getValue));

        System.out.println(result);


        Optional<Integer> test = transactions.stream()
                .map(t -> t.getValue())
                .reduce(Integer::max);
        test.ifPresent(System.out::println);
    }

    @Test
    public void q08(){
        //Find the transaction with the smallest value

        Optional<Transaction> result = transactions.stream().min(comparing(Transaction::getValue));
        System.out.println(result);

    }

    public static void main(String ...args){    
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
        

        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        List<Transaction> tr2011 = transactions.stream()
                                               .filter(transaction -> transaction.getYear() == 2011)
                                               .sorted(comparing(Transaction::getValue))
                                               .collect(toList());
        System.out.println(tr2011);
        
        // Query 2: What are all the unique cities where the traders work?
        List<String> cities = 
            transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .distinct()
                        .collect(toList());
        System.out.println(cities);

        // Query 3: Find all traders from Cambridge and sort them by name.
        
        List<Trader> traders = 
            transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(toList());
        System.out.println(traders);
        
        
        // Query 4: Return a string of all traders’ names sorted alphabetically.
        
        String traderStr = 
            transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(traderStr);
        
        // Query 5: Are there any trader based in Milan?
        
        boolean milanBased =
            transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                                            .getCity()
                                                            .equals("Milan")
                                 );
        System.out.println(milanBased);
        
        
        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        transactions.stream()
                    .map(Transaction::getTrader)
                    .filter(trader -> trader.getCity().equals("Milan"))
                    .forEach(trader -> trader.setCity("Cambridge"));
        System.out.println(transactions);
        
        
        // Query 7: What's the highest value in all the transactions?
        int highestValue = 
            transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(0, Integer::max);
        System.out.println(highestValue);      
    }
}