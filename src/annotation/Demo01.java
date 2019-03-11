package annotation;

import java.util.ArrayList;
import java.util.List;

public class Demo01
{
    @Override
    public String toString(){
        return "";
    }
    @Deprecated
    public static void test01(){
        System.out.println("hello");
    }

    @SuppressWarnings("all")
    public static void test002(){
        List list=new ArrayList();
    }
    public static void main(String[] args)
    {
        test01();
    }
}
