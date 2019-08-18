package Java8Constructs.LambdaAndStreams;

import Java8Constructs.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by shailendralohia on 11/26/17.
 */
public class MapExample {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(123,"GROCERY","24"),
                new Transaction(234, "CLOTHES","9458"),
                new Transaction(434,"CLOTHES","445"),
                new Transaction(234, "CLOTHES","9458")
        );

        // This list will contain only Id's of those whose transaction type is "CLOTHES"
        List<Integer> transactionsIds=
                transactions.stream()
                .filter(it->it.getType().equals("CLOTHES"))
                .sorted(Comparator.comparing(Transaction::getValue))
                .map(Transaction::getId)
                .limit(1)
                .collect(toList());

        //System.out.println("size of transactionIds" + " " + transactionsIds.size());
        transactionsIds.forEach(id->System.out.println(id));

        List<Transaction> transactionType=
                transactions.stream()
                .distinct() // Not sure how to use distinct
                .collect(toList());

        transactionType.forEach(type -> System.out.println(type.getType()));
    }
}
