class Base{
    public static int s;
    private int a;
    static {
        System.out.println("基类静态代码块，s："+s);
        s=1;
    }
    {
        System.out.println("基类实例代码块，a："+a);
        a=1;
    }
    public Base(){
        System.out.println("基类构造方法，a："+a);
        a=2;
    }
    protected void step(){
        System.out.println("base s: "+s+", a: "+a);
    }
    public void action(){
        System.out.println("start");
        step();
        System.out.println("end");
    }
}
class Child extends Base{
    public static int s;
    private int a;
    static {
        System.out.println("子类静态代码块，s："+s);
        s=10;
    }
    {
        System.out.println("子类实例代码块，a："+a);
        a=10;
    }
    public Child(){
        System.out.println("子类构造方法，a："+a);
        a=20;
    }
    protected void step(){
        System.out.println("child s: "+s+", a: "+a);
    }
}
public class ExtendsTest {
    public static void main(String[] args) {
        System.out.println("-----new Child()");
        Child c=new Child();
        System.out.println("\n----c.action()");
        c.action();
        Base b=c;
        System.out.println("\n----b.action()");
        b.action();
        System.out.println("\n----b.s: "+b.s);
        System.out.println("\n----c.s: "+c.s);
    }
}
