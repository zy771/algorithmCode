package src.javase.Variable;


/*在这段Java代码中，演示了静态变量（也称为类变量）的使用及其行为。静态变量是与类相关联的，而不是与类的任何特定实例相关联。这意味着无论创建多少个类的
实例，静态变量只有一份副本。

代码解释：
public static String myClassVar = "class or static variable";
这行定义了一个静态变量 myClassVar，并初始化为字符串 "class or static variable"。这个变量属于类 StaticVarExample，所有的实例共享这个变量。
在 main 方法中，创建了三个 StaticVarExample 类的实例：obj, obj2, obj3。
当调用 System.out.println(obj.myClassVar); 以及对 obj2 和 obj3 的同一操作时，所有的调用都输出初始值 "class or static variable"，
因为所有实例访问的是同一个静态变量。
接下来，通过 obj2.myClassVar = "Changed Text"; 修改了静态变量 myClassVar 的值。这表明无论通过哪个实例修改静态变量，它都会影响到所有实例访
问该静态变量的结果。
修改静态变量后，再次输出每个实例的 myClassVar 值，此时它们都显示为 "Changed Text"。这证实了静态变量不是绑定到任何特定实例上，而是属于类本身，
所有实例共享同一变量。

关键点：
静态变量对所有实例来说是共享的。
任何实例对静态变量的修改都会反映到其他所有实例上。
静态变量在内存中只有一份副本，由类所有，而不是单个实例。
这种特性使得静态变量特别适合于管理类级别的状态信息或在多个对象间共享某个变量时使用。*/

public class StaticVariable {
    public static String myClassVar="class or static variable";

    public static void main(String args[]){
        StaticVariable obj = new StaticVariable();
        StaticVariable obj2 = new StaticVariable();
        StaticVariable obj3 = new StaticVariable();

        //All three will display "class or static variable"
        System.out.println(obj.myClassVar);
        System.out.println(obj2.myClassVar);
        System.out.println(obj3.myClassVar);

        //changing the value of static variable using obj2
        obj2.myClassVar = "Changed Text";

        //All three will display "Changed Text"
        System.out.println(obj.myClassVar);
        System.out.println(obj2.myClassVar);
        System.out.println(obj3.myClassVar);

        //可以不创建实例来使用静态变量
        System.out.println(myClassVar);
    }
}