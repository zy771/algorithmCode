package src.javase;

import java.util.Scanner;

public class PractiseScanner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double sum=0;
        int m=0;

        System.out.println("请输入数字，没输入一个空格确认");
        while (scanner.hasNextDouble()){
            double x=scanner.nextDouble();
            m++;//应该是m++，m=m++每次先把0赋给m，运行不通
            sum=sum+x;
        }
        System.out.println("和为"+sum+"平均数为"+(sum/m));
    }
}
