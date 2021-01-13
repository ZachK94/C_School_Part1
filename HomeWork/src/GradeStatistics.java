// A program for printing statistics for points in course.
// Points from zero to one hundred.

import java.util.ArrayList;
import java.util.Scanner;

public class GradeStatistics {

    public static void main(String[] args) {

        ArrayList<Double> pointsList = new ArrayList<>();
        ArrayList<Double> passingList = new ArrayList<>();
        double points;
        boolean b = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter point totals, -1 stops:");

        while (b){
            points = scanner.nextInt();
            if (points == (-1)){
                b = false;
            }
            else if (points < 0 || points > 100){
                System.out.println("Only numbers between [0-100] are accepted");
            }
            else {
                pointsList.add(points);
                //A passing grade is achieved by getting a minimum of 50 course points.
                if (points >= 50){
                    passingList.add(points);
                }
            }
        }
        scanner.close();

        int sum1 = 0;
        for (double point : pointsList){
            sum1 += point;
        }
        System.out.printf("Point average (all): %3.1f\n", sum1/(double)pointsList.size());

        if (passingList.size() == 0){
            System.out.print("Point average (passing): -\n");
        } else {
            int sum2 = 0;
            for (double point : passingList){
                sum2 += point;
            }
            System.out.printf("Point average (passing): %3.1f\n", sum2/(double)passingList.size());
        }

        // The pass percentage.
        System.out.printf("Pass percentage: %2.1f\n", ((double)passingList.size() * 100 /(double)pointsList.size()));

        /** Grade distribution.
         *  If there is one point total giving the grade 5,
         *  then it should print the row 5: *
         *  If there are no point totals giving a particular grade,
         *  then no stars should be printed for it.
         *  In the sample below this is true for e.g. the grade 4.
         */
        System.out.print("Grade distribution:");
        // >= 90 grade 5
        System.out.print("\n5: ");
        for (double point : pointsList){
            if (point >= 90) {
                System.out.print("* ");
            }
        }
        // < 90 grade 4
        System.out.print("\n4: ");
        for (double point : pointsList){
            if (point < 90 && point >= 80) {
                System.out.print("* ");
            }
        }
        // < 80 grade 3
        System.out.print("\n3: ");
        for (double point : pointsList){
            if (point < 80 && point >= 70) {
                System.out.print("* ");
            }
        }
        // < 70 grade 2
        System.out.print("\n2: ");
        for (double point : pointsList){
            if (point < 70 && point >= 60) {
                System.out.print("* ");
            }
        }
        // < 60 grade 1
        System.out.print("\n1: ");
        for (double point : pointsList){
            if (point < 60 && point >= 50) {
                System.out.print("* ");
            }
        }
        // < 50 failed
        System.out.print("\n0: ");
        for (double point : pointsList){
            if (point < 50) {
                System.out.print("* ");
            }
        }
    }
}
