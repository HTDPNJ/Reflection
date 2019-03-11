public class Demo01
{
    public static void main(String[] args)
    {
        String path="bean.User";
        try {
            Class clazz=Class.forName(path);
            Class clazz2=path.getClass();
            Class str=String.class;
            System.out.println(clazz);
            Class intClass=int.class;

            int[] arr01=new int[10];
            int[] arr02=new int[30];
            System.out.println(arr01.getClass().hashCode());

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
