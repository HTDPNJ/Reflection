
import bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo03
{
    /*通过反射API动态的操作：构造器、方法、属性*/
    public static void main(String[] args)
    {
        String path="bean.User";
        try {
            Class clazz = Class.forName(path);

            //通过反射API动态调用构造方法，构造对象
            User u=(User) clazz.newInstance(); //其实是调用了User的无参构造方法
            System.out.println(u);

            Constructor<User>c=clazz.getDeclaredConstructor(int.class,int.class,String.class);
            User u2=c.newInstance(1001,18,"小明");
            System.out.println(u2.getUname());

            //通过反射API调用普通方法
            User u3= (User) clazz.newInstance();
            //u3.setUname("gao");//这是直接调用
            Method method=clazz.getDeclaredMethod("setUname", String.class);
            method.invoke(u3,"gao2");
            System.out.println(u3.getUname());

            //通过反射API操作属性
            User u4=(User) clazz.newInstance();
            Field field=clazz.getDeclaredField("uname");
            field.setAccessible(true);
            field.set(u4,"gao4"); //通过反射直接写属性
            System.out.println(u4.getUname());//通过反射直接读属性的值
            System.out.println(field.get(u4));


        }
        catch (Exception e) {
            e.printStackTrace();
        }

        }
}
