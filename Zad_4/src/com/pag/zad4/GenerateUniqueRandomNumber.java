package com.pag.zad4;
import java.util.*;

public class GenerateUniqueRandomNumber {
    private static LinkedList<Integer> randomNumber;
    private static Set<Integer> uniqueNumbers;


    public static LinkedList<Integer> getRandomNumber() {
        return randomNumber;
    }

    public static void setRandomNumber(LinkedList<Integer> randomNumber) {
        GenerateUniqueRandomNumber.randomNumber = randomNumber;
    }

    public static Set<Integer> getUniqueNumbers() {
        return uniqueNumbers;
    }

    public static void setUniqueNumbers(Set<Integer> uniqueNumbers) {
        GenerateUniqueRandomNumber.uniqueNumbers = uniqueNumbers;
    }

    public static void generateNumber(int MAX, int N, int S) {
        Random random = new Random();
        setRandomNumber(new LinkedList<>());
        setUniqueNumbers(new TreeSet<>());

        int next = -1;
        if (S > MAX) {
            System.out.println("Unique number is not in range!");
        } else {
            while(next != S) {
                next = random.nextInt(MAX + 1);
                GenerateUniqueRandomNumber.randomNumber.add(next);
                GenerateUniqueRandomNumber.uniqueNumbers.add(next);
                System.out.println(next);
            }

            if (N > GenerateUniqueRandomNumber.randomNumber.size()) {
                N = GenerateUniqueRandomNumber.randomNumber.size();
            }
            System.out.println("N-number from start array");
            for(int i = 0; i < N; i++) {
                System.out.println(GenerateUniqueRandomNumber.randomNumber.get(i));
            }

            System.out.println("N-number from end array");
            for(int i = GenerateUniqueRandomNumber.randomNumber.size() - 1; i >= GenerateUniqueRandomNumber.randomNumber.size() - N; i--) {
                System.out.println(GenerateUniqueRandomNumber.randomNumber.get(i));
            }

            System.out.println("Unique numbers");
            for (Integer number : GenerateUniqueRandomNumber.uniqueNumbers)
                System.out.println(number);
        }
    }
}
