package reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        int number = myClass.getNumber();
        System.out.println(number);

        String name;
        try {
            Field field = myClass.getClass().getDeclaredField("name");
            field.setAccessible(true);
            name = (String) field.get(myClass);
            System.out.println(name);

            field.set(myClass, "Batyr");
            name = (String) field.get(myClass);
            System.out.println(name);

            Method method = myClass.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myClass);

            Method dynamicMethod = myClass.getClass().getDeclaredMethod("printSmth", String.class);
            dynamicMethod.setAccessible(true);
            dynamicMethod.invoke(myClass, "ss");
        } catch (NoSuchFieldException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
