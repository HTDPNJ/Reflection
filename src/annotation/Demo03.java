package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Demo03
{
    /*使用反射读取注解的信息，模拟处理注解信息的流程*/
    public static void main(String[] args)
    {
        try {
            Class clazz=Class.forName("Student");
            Annotation[] annotations=clazz.getAnnotations();
            for(Annotation a: annotations){
                System.out.println(a);
            }
            //获得类指定的注解
            Table st = (Table) clazz.getAnnotation(Table.class);
            System.out.println(st.value());

            //获得类的属性注解
            Field f=clazz.getDeclaredField("studentName");
            SxtField sxtField=f.getAnnotation(SxtField.class);
            System.out.println(sxtField.columName()+"--"+sxtField.type()+"--"+sxtField.length());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
