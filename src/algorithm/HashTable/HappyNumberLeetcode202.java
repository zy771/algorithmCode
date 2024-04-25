package src.algorithm.HashTable;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HappyNumberLeetcode202 {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    //取余得出最后一位 再/删去最后一位，while不断循环
    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a positive integer to check if it's a happy number:");
        int number = scanner.nextInt();

        HappyNumberLeetcode202 checker = new HappyNumberLeetcode202();
        boolean isHappy = checker.isHappy(number);

        if (isHappy) {
            System.out.println(number + " is a happy number.");
        } else {
            System.out.println(number + " is not a happy number.");
        }
        scanner.close();
    }
}
