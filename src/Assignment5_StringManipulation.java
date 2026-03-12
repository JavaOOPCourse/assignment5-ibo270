import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Assignment5_StringManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GRADED ASSIGNMENT 5: STRING MANIPULATION ===");
            System.out.println("Выберите задание (1-8) или 0 для выхода:");
            System.out.println("1 — Count Vowels");
            System.out.println("2 — Reverse a String");
            System.out.println("3 — Check Palindrome");
            System.out.println("4 — Count Words in a Sentence");
            System.out.println("5 — Remove All Spaces");
            System.out.println("6 — Capitalize First Letter of Each Word");
            System.out.println("7 — Find the Most Frequent Character");
            System.out.println("8 — Check Anagrams");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число!");
                continue;
            }

            switch (choice) {
                case 1 -> task1(scanner);
                case 2 -> task2(scanner);
                case 3 -> task3(scanner);
                case 4 -> task4(scanner);
                case 5 -> task5(scanner);
                case 6 -> task6(scanner);
                case 7 -> task7(scanner);
                case 8 -> task8(scanner);
                case 0 -> {
                    System.out.println("До свидания! Удачи со сдачей задания :)");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    // ===================== TASK 1 =====================
    private static void task1(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Подсчитать количество гласных (a, e, i, o, u)
        int count = 0;
        HashSet<Character> vowels = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels.add(c);
        }

        for (char c : input.toCharArray()) {
            if (vowels.contains(c)) {
                count++;
            }
        }

        System.out.println("Number of vowels: " + count);
    }

    // ===================== TASK 2 =====================
    private static void task2(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Вывести строку в обратном порядке
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.addFirst(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!deque.isEmpty()) {
            reversed.append(deque.removeFirst());
        }

        System.out.println(reversed);
    }

    // ===================== TASK 3 =====================
    private static void task3(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Проверить, является ли строка палиндромом (игнорировать регистр)
        boolean isPalindrome = true;
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char i : input.toLowerCase().toCharArray()){
            deque.addLast(i);
        }
        while (deque.size() > 1){
            if(deque.removeFirst() != deque.removeLast()){
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome ? "Yes" : "No");
    }

    // ===================== TASK 4 =====================
    private static void task4(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // TODO: Подсчитать количество слов в предложении
        int wordCount = 0;
        String[] words = sentence.split("\\s+");
        ArrayList<String> wordList = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                wordList.add(word);
            }
        }
        wordCount = wordList.size();

        System.out.println("Number of words: " + wordCount);
    }

    // ===================== TASK 5 =====================
    private static void task5(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Удалить все пробелы из строки
        String noSpaces = "";
        StringBuilder sb = new StringBuilder();
        for(char c : input.toCharArray()){
            if(c != ' '){
                sb.append(c);
            }
        }
        noSpaces = sb.toString();


        String versionB = input.replaceAll(" ", "");


        System.out.println(noSpaces);
    }

    // ===================== TASK 6 =====================
    private static void task6(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // TODO: Преобразовать первую букву каждого слова в заглавную
        String result = "";

        String[] words = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    sb.append(word.substring(1).toLowerCase());
                }
                sb.append(" ");
            }
        }
        result = sb.toString().trim();
        System.out.println(result);
    }

    // ===================== TASK 7 =====================
    private static void task7(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Найти символ, который встречается чаще всего
        char mostFrequent = ' ';
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        int maxFrequency = 0;
        for (char c : frequencyMap.keySet()) {
            if (frequencyMap.get(c) > maxFrequency) {
                maxFrequency = frequencyMap.get(c);
                mostFrequent = c;
            }
        }
        System.out.println("The most frequent character is: " + mostFrequent);
    }

    // ===================== TASK 8 =====================
    private static void task8(Scanner scanner) {
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        // TODO: Проверить, являются ли две строки анаграммами (игнорировать пробелы и регистр)
        boolean areAnagrams = false;
        HashMap<Character , Integer> m1 = new HashMap<>();
        HashMap<Character , Integer > m2 = new HashMap<>();

        for(char i : str1.toCharArray()){
            m1.put(i,m1.getOrDefault(i,0)+1);
        }
        for(char k : str2.toCharArray()){
            m2.put(k,m2.getOrDefault(k,0)+1);
        }

        System.out.println(m1.equals(m2));

        char[] arr1 = str1.replaceAll("\\s+", "").toLowerCase().toCharArray();
        char[] arr2 = str2.replaceAll("\\s+", "").toLowerCase().toCharArray();

        System.out.println(arr1.equals(arr2));



        System.out.println(areAnagrams ? "Yes" : "No");
    }
}