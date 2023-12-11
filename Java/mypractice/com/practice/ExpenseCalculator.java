package mypractice.com.practice;
import java.util.*;

import java.util.*;

public class ExpenseCalculator {

    private static Map<Pair<Character, String>, Integer> expenses = new HashMap<>();
    private static Map<Pair<Character, Character>, Integer> loans = new HashMap<>();
    private static Map<Character, Integer> balances = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int i = 0; i < N; ++i) {
            String transaction = scanner.nextLine();
            processTransaction(transaction);
            calculateAndProcessInterest(i + 1);
        }

        reconcileBalances();
    }
    private static void processTransaction(String transaction) {
        Scanner scanner = new Scanner(transaction);
        if (scanner.hasNext()) {
            String type = scanner.next();

            if (type.equals("L")) {
                if (scanner.hasNext()) {
                    char borrower = scanner.next().charAt(0);
                    if (scanner.hasNext()) {
                        char lender = scanner.next().charAt(0);
                        if (scanner.hasNext()) {
                            type = scanner.next();
                            if (scanner.hasNextInt()) {
                                int amount = scanner.nextInt();
                                loans.merge(new Pair<>(borrower, lender), amount, Integer::sum);
                            } else {
                                // Handle invalid input for amount
                                System.out.println("Invalid input for amount in loan transaction");
                            }
                        } else {
                            // Handle incomplete loan transaction
                            System.out.println("Incomplete loan transaction");
                        }
                    } else {
                        // Handle incomplete loan transaction
                        System.out.println("Incomplete loan transaction");
                    }
                } else {
                    // Handle incomplete loan transaction
                    System.out.println("Incomplete loan transaction");
                }
            } else {
                // Process the non-loan transaction
                char paidBy = type.charAt(0);
                if (scanner.hasNextInt()) {
                    int amount = scanner.nextInt();
                    balances.merge(paidBy, -amount, Integer::sum);

                    int sharedAmong = 0;
                    while (scanner.hasNext()) {
                        char person = scanner.next().charAt(0);
                        balances.merge(person, amount / 3, Integer::sum);
                        sharedAmong++;
                    }
                    balances.merge(paidBy, amount - (amount / 3 * sharedAmong), Integer::sum);
                } else {
                    // Handle invalid input for amount in non-loan transaction
                    System.out.println("Invalid input for amount in non-loan transaction");
                }
            }
        }
    }



    private static void calculateAndProcessInterest(int currentDay) {
        for (Map.Entry<Pair<Character, Character>, Integer> entry : loans.entrySet()) {
            char borrower = entry.getKey().getFirst();
            char lender = entry.getKey().getSecond();
            int amount = entry.getValue();

            int weeks = (currentDay - 1) / 7;
            double interest = amount * Math.pow(1.01, weeks) - amount;
            expenses.merge(new Pair<>(lender, "I" + borrower), (int) Math.round(interest), Integer::sum);
        }
    }

    private static void reconcileBalances() {
        List<Map.Entry<Character, Integer>> creditors = new ArrayList<>();
        List<Map.Entry<Character, Integer>> debtors = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : balances.entrySet()) {
            if (entry.getValue() > 0) {
                creditors.add(entry);
            } else if (entry.getValue() < 0) {
                debtors.add(new AbstractMap.SimpleEntry<>(entry.getKey(), -entry.getValue()));
            }
        }

        creditors.sort(Comparator.comparing(Map.Entry::getKey));
        debtors.sort(Comparator.comparing(Map.Entry::getKey));

        Iterator<Map.Entry<Character, Integer>> creditorIterator = creditors.iterator();
        Iterator<Map.Entry<Character, Integer>> debtorIterator = debtors.iterator();

        while (creditorIterator.hasNext() && debtorIterator.hasNext()) {
            Map.Entry<Character, Integer> creditor = creditorIterator.next();
            Map.Entry<Character, Integer> debtor = debtorIterator.next();

            int settleAmount = Math.min(creditor.getValue(), debtor.getValue());
            System.out.println(debtor.getKey() + "/" + creditor.getKey() + "/" + settleAmount);

            creditor.setValue(creditor.getValue() - settleAmount);
            debtor.setValue(debtor.getValue() - settleAmount);

            if (creditor.getValue() == 0) {
                creditorIterator.remove();
            }
            if (debtor.getValue() == 0) {
                debtorIterator.remove();
            }
        }

        if (creditorIterator.hasNext() || debtorIterator.hasNext()) {
            System.out.println("NO DUES");
        }
    }

    private static class Pair<A, B> {
        private final A first;
        private final B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }
    }
}
