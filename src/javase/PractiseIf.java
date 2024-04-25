package src.javase;

import java.util.Scanner;

public class PractiseIf {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("please input content:");
        String s=scanner.nextLine();

        if (s.equals("hello")){
            System.out.println(s);
        }
        System.out.println("end");
        scanner.close();
    }
}
