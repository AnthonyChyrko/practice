package instanceOf;

/**
 * Created by Anton_Chyrko on 8/22/2017.
 */
class Parent{

}
class Child extends Parent{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Child();
    }
}
public class RunnerForInstanceOf {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
        System.out.println(child instanceof Parent);
        System.out.println(parent instanceof Parent);
        System.out.println(parent instanceof Child);
        System.out.println(child.getClass()==parent.getClass());
        System.out.println(child.getClass().equals(Parent.class));
        try {
//            parent.clone();
            child.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
