package src.javase;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入第一个数字：");
        int n1=scanner.nextInt();
        System.out.println("第二个");
        int n2=scanner.nextInt();
        scanner.close();

        int mul=n1*n2;
        System.out.println(mul);
    }
}