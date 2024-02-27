import com.thinking.machines.util.*;
class forEachTestCase
{
public static void main(String gg[])
{
TMArrayList list1=new TMArrayList();
list1.add(100);
list1.add(200);
list1.add(300);
list1.add(400);
list1.forEach((m)->{System.out.println(m);});
System.out.println("*****************************");

}
}