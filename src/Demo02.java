import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo02
{
    /*利用反射的API,获取类的信息（类的名字，属性，方法，构造器等）*/
    public static void main(String[] args)
    {
        String path="bean.User";
        try {
            Class clazz=Class.forName(path);
            //获取类的名字
            System.out.println(clazz.getName());
            System.out.println(clazz.getSimpleName());//获得类名
            //获得属性
            Field []fields =clazz.getFields(); //获得的是公开属性
            System.out.println(fields.length);

            Field[] fields02=clazz.getDeclaredFields();
            System.out.println(fields02.length);
            for(Field tem: fields02){
                System.out.println("属性："+tem);
            }

            try {
                Field u=clazz.getDeclaredField("uname");
            }
            catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            // 方法
            Method[] method=clazz.getDeclaredMethods();
            try {
                Method m=clazz.getDeclaredMethod("getUname");
                //如果方法有参数，则必须传递参数类型对应的class对象
                Method m02=clazz.getDeclaredMethod("setUname", String.class);
                for(Method temp:method){
                    System.out.println("方法："+temp);
                }
            }
            catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            // 构造器
            Constructor[] constructors=clazz.getDeclaredConstructors();
            for(Constructor temp:constructors){
                System.out.println("构造器："+temp);
            }

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
