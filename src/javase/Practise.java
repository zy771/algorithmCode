package src.javase;

import java.util.Scanner;

public class Practise {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("使用next方式接收:");

        if (scanner.hasNext()){
            String str =scanner.next();
            System.out.println("输出的内容为："+str);
        }

        int i =0;
         float f=0.0f;

        System.out.println("请输入整数：");
        if (scanner.hasNextInt()){
            i=scanner.nextInt();
            System.out.println("整数数据："+i);
        }else {
            System.out.println("输入的不是整数");
        }

        System.out.println("请输入小数：");
        if (scanner.hasNextFloat()){
            f=scanner.nextFloat();
            System.out.println("浮点数为："+f);
        }else {
            System.out.println("不是浮点数");
        }


        scanner.close();
    }
}
