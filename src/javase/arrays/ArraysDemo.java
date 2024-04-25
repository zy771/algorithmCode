package src.javase.arrays;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] a={1,2,3};
        System.out.println(a[1]);

        int[] b=new int[10];
        b[0]=10;
        b[1]=10;

        System.out.println(b[0]);
        System.out.println(Arrays.toString(b));

        for (int array:a){
            System.out.println(array);
        }


        int sum=0;
        for (int i=0;i<a.length;i++){
            sum=sum+a[i];
        }
        System.out.println(sum);

        int max=a[0];
        for (int i=1;i<a.length;i++){
            if (a[i]>max){
                max=a[i];
            }
        }
        System.out.println("最大值"+max);


    }
}
