import annotation.SxtField;
import annotation.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Demo05
{
    /*通过反射获取注解信息*/
    public static void main(String[] args)
    {
        try {
            Class clazz=Class.forName("annotation.Student");
            //获得类型的所有有效注解
            Annotation[] annotations=clazz.getAnnotations();
            for(Annotation a:annotations){
                System.out.println(a);
            }
            //获得类的指定注解
            Table st=(Table)clazz.getAnnotation(Table.class);
            System.out.println(st.value());
            //获得类的属性的注解
            Field f=clazz.getDeclaredField("studentName");
            SxtField sxtField=f.getAnnotation(SxtField.class);
            System.out.println(sxtField.columName()+"--"+sxtField.type()+"--"+sxtField.length());
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
