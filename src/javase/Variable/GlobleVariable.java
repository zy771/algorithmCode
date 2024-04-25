package src.javase.Variable;

/**
 * @Author：zz
 * @Package：src.javase.Variable
 * @Project：algorithmCode
 * @name：GlobleVariable
 * @Date：2024/4/12 9:41
 */


/*在这段Java代码中，展示了实例变量也叫全局变量的使用及其行为。实例变量是与类的单个实例相关联的变量。这意味着每个实例都有其自己的变量副本。

代码解释：
String myInstanceVar="instance variable";

这行定义了一个实例变量 myInstanceVar，并初始化为字符串 "instance variable"。这个变量属于 InstanceVarExample 类的实例，每个实例都有自己独
立的这个变量副本。
在 main 方法中，创建了三个 InstanceVarExample 类的实例：obj, obj2, obj3。

当调用 System.out.println(obj.myInstanceVar); 以及对 obj2 和 obj3 的同一操作时，每个调用都输出其各自实例中的 myInstanceVar 的初始值
"instance variable"。

接下来，通过 obj2.myInstanceVar = "Changed Text"; 修改了第二个实例 obj2 中的实例变量 myInstanceVar 的值。这表明实例变量的修改仅影响该具
体实例。

修改实例变量后，再次输出每个实例的 myInstanceVar 值。此时，obj 和 obj3 的值仍为初始值 "instance variable"，而 obj2 显示为 "Changed Tex
t"。这证实了实例变量是绑定到具体实例上的，与其他实例的同名变量互不影响。

关键点：
实例变量对每个实例来说是独立的。
任何实例对其实例变量的修改不会影响其他实例中相同名称的变量。
实例变量在每个对象的内存中都有独立的副本。
这种特性使得实例变量适合于管理与单个对象相关的状态信息。*/
public class GlobleVariable {
    String myInstanceVar="instance variable";

    public static void main(String args[]){
        GlobleVariable obj = new GlobleVariable();
        GlobleVariable obj2 = new GlobleVariable();
        GlobleVariable obj3 = new GlobleVariable();

        System.out.println(obj.myInstanceVar);
        System.out.println(obj2.myInstanceVar);
        System.out.println(obj3.myInstanceVar);


        obj2.myInstanceVar = "Changed Text";


        System.out.println(obj.myInstanceVar);
        System.out.println(obj2.myInstanceVar);
        System.out.println(obj3.myInstanceVar);
    }
}