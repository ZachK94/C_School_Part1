// Write a simple lottery game -> user chooses 6 numbers, the machine draws, verification of the result

import java.util.*;

public class Lotto {

    public static void main(String[] args) {

        //Choose numbers
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Please, enter 6 numbers {1-49}");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            numbers.add(scanner.nextInt());
            while (numbers.get(i) < 1 || numbers.get(i) > 49){
                System.out.println("Your number is out of range, try again");
                numbers.set(i, scanner.nextInt());
            }
            if (numbers.size()>1) {
                for (int j = 0; j < numbers.size()-1; j++) {
                    if (numbers.get(i).equals(numbers.get(j))) {
                        System.out.println("Already entered this number, try again");
                        numbers.set(i, scanner.nextInt());
                    }
                }
            }
        }

        Collections.sort(numbers);
        System.out.println("\nYour numbers: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }


        //Random numbers (6)
        Random random = new Random();
        ArrayList<Integer> randomNumbers = new ArrayList<>();

        for (int k = 0; k < 6; k++) {
            randomNumbers.add(random.nextInt(50));
            for (int j = 0; j < randomNumbers.size()-1; j++){
                if (numbers.get(k).equals(numbers.get(j))){
                    randomNumbers.set(k, random.nextInt(50));
                }
            }
        }

        Collections.sort(randomNumbers);
        System.out.println("\n\nRandom numbers: ");
        for (int number : randomNumbers) {
            System.out.print(number + " ");
        }


        System.out.println("\n\nYour result:");
        // verification
        int result = 0;
        for (Integer number : numbers) {
            if (randomNumbers.contains(number)){
                result++;
            }
        }


        if (result == 6) {
            System.out.println("The jackpot is yours! You hit 6!");
        } else if (result == 1) {
            System.out.println("1 hit");
        } else if (result == 2) {
            System.out.println("2 hits");
        } else if (result == 3) {
            System.out.println("3 hits");
        } else if (result == 4) {
            System.out.println("4 hits");
        } else if (result == 5) {
            System.out.println("5 hits");
        } else {
            System.out.println("0 bad luck :(");
        }
    }
}

