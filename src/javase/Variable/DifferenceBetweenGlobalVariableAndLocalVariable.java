package src.javase.Variable;

/**
 * @Author：zz
 * @Package：src.javase.Variable
 * @Project：algorithmCode
 * @name：DifferenceBetweenGlobalVariableAndLocalVariable
 * @Date：2024/4/12 9:58
 */
/*这段Java代码展示了全局变量和局部变量在Java程序中的行为和作用域。

代码解释：
private int myGlobalVariable = 100;

这行代码定义了一个私有的全局变量（也称为实例变量）myGlobalVariable，并初始化为100。作为一个实例变量，它在方法调用之间保留其值，只要使用的是同一个对象。
public void myMethod()

这个方法定义了一个局部变量myLocalVariable，并将其初始化为100。像这样的局部变量每次调用方法时都会创建和销毁；它们在方法调用之间不保留其值。
在这个方法内部，myGlobalVariable和myLocalVariable都增加了1。因为myGlobalVariable是一个实例变量，它的变化在方法调用之间被保留。
然后，方法将两个变量的值打印到控制台。
public static void main(String args[])

main方法是程序执行的起点。它创建了一个JavaExample类的实例obj。
然后它调用了三次obj的myMethod方法。每次调用都展示了全局变量和局部变量的行为：
第一次调用：两个变量都打印出101。对于myGlobalVariable，它从100增加到101；对于myLocalVariable，它初始化为100然后增加到101。
第二次调用：myGlobalVariable再次增加到102，显示其值在调用之间被保留；而myLocalVariable重新初始化为100，然后增加到101，显示它在调用之间不保留其值。
第三次调用：与前面类似，myGlobalVariable现在为103，myLocalVariable再次为101。
关键点：
全局（实例）变量：这些变量与类的实例相关联，它们的值在方法调用之间被保留，只要使用的是同一个实例。它们可以被类中的任何方法访问。
局部变量：这些变量仅对它们声明的方法可见。它们在方法调用时创建，在方法退出时销毁。每次方法调用都会重新初始化这些变量。
这种行为说明了Java如何管理变量的作用域和生命周期，这对于控制程序中数据的访问和生命周期至关重要。*/
public class DifferenceBetweenGlobalVariableAndLocalVariable {
    private int myGlobalVariable = 100;

    //a method
    public void myMethod() {
        int myLocalVariable = 100;

        myGlobalVariable++; //global variable increment
        myLocalVariable++; //local variable increment

        System.out.print("Global variable: " + myGlobalVariable);
        System.out.println(" Local variable: " + myLocalVariable);
    }
    public static void main(String args[]){
        DifferenceBetweenGlobalVariableAndLocalVariable obj = new DifferenceBetweenGlobalVariableAndLocalVariable();

        obj.myMethod();  // Output: Global variable: 101 Local variable: 101
        obj.myMethod();  // Output: Global variable: 102 Local variable: 101
        obj.myMethod();  // Output: Global variable: 103 Local variable: 101

    }
}