package com.learning.main;
import java.util.*;
import java.lang.*;

class GameBullsCows {
    private static String secretCode;
    private static int possibleSymbol;
    private static int lengthCode;
    static final Scanner scan = new Scanner(System.in);
    static final Random random = new Random();

    public static String getSecretCode() {
        return secretCode;
    }

    public static String getRangeCode() {
        char[] possibleCode = getTableOfPossibleCodes(possibleSymbol);
        char[] secretCodeShow = new char[lengthCode];
        Arrays.fill(secretCodeShow, '*');
        if (possibleSymbol <= 10) {
            return String.format("%s (0-%c)", new String(secretCodeShow), possibleCode[possibleSymbol - 1]);
        } else {
            return String.format("%s (0-9, a-%c)", new String(secretCodeShow), possibleCode[possibleSymbol - 1]);
        }
    }

    private static void generateCode() {
        if (possibleSymbol > 36) {
            System.out.println("Error: can't generate a secret number with a length of 37 because there aren't enough unique digits and characters.");
        } else {
            secretCode = getUniqueCode();
        }
    }

    public static String getUniqueCode() {
        StringBuilder code = new StringBuilder();
        char[] possibleCode = getTableOfPossibleCodes(possibleSymbol);
        while (code.length() < lengthCode) {
            int index = createPseudoRandomNumber();
            if (isUniqueDigit(code, possibleCode[index])) {
                code.append(possibleCode[index]);
            }
        }
        return code.toString();
    }

    public static int createPseudoRandomNumber() {
        int upperBound = possibleSymbol - 1;
        int lowerBound = 0;
        int intervalLength = upperBound - lowerBound + 1;
        return random.nextInt(intervalLength) + lowerBound;
    }

    public static char[] getTableOfPossibleCodes(int lengthPossibleCode) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] digits = "0123456789".toCharArray();
        char[] possibleCodes = new char[alphabet.length + digits.length];
        System.arraycopy(digits, 0, possibleCodes, 0, digits.length);
        System.arraycopy(alphabet, 0, possibleCodes, digits.length, alphabet.length);
        return Arrays.copyOfRange(possibleCodes, 0, lengthPossibleCode);
    }

    public static boolean isUniqueDigit(StringBuilder code, char codeElement) {
        return !code.toString().contains(Character.toString(codeElement));
    }

    public static void gameAlgorithm() {
        int bull = 0;
        int cow;
        int turn = 1;
        while (bull != secretCode.length()) {
            bull = 0;
            cow = 0;
            System.out.println("Turn " + turn + ":");
            String answer = scan.next();
            for (int i = 0; i < secretCode.length(); i++) {
                char number = secretCode.charAt(i);
                boolean state = compareNumberInGame(answer, i);
                if (answer.contains(Character.toString(number)) && !state) {
                    cow++;
                } else if (state) {
                    bull++;
                }
            }
            turn++;
            System.out.println(gameScore(bull, cow));
        }
    }

    public static boolean compareNumberInGame(String answer, int index) {
        return answer.charAt(index) == secretCode.charAt(index);
    }

    public static String gameScore(int bull, int cow) {
        String message = "Grade: ";
        String cows = cow == 0 ? "" : cow > 1 ? cow + " cows." : cow + " cows.";
        String bulls = bull == 0 ? "" : bull > 1 ? bull + " bulls." : bull + " bulls";
        message = message.concat(bulls).concat(cows.length() > 0 ? bulls.length() > 0 ? " and" + " " + cows : cows : "");
        if (cow == 0 && bull == 0) {
            message += "None.";
        }
        return message;
    }

    public static void game() {
        do {
            System.out.println("Input the length od the secret code:");
            lengthCode = scan.nextInt();
            if (lengthCode >= 10) {
                System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            }
        } while (lengthCode >= 10);
        do {
            System.out.println("Input the number of possible symbols in the code:");
            possibleSymbol = scan.nextInt();
            generateCode();
        } while (possibleSymbol >= 36);
        System.out.println("The secret is prepared:");
        System.out.println(getRangeCode());
        System.out.println("Okay, let's start a game!");
        gameAlgorithm();
        System.out.println("Congratulations! You guessed the secret code.");
    }
}

public class Main {
    public static void main(String[] args) {
        GameBullsCows.game();
    }
}


