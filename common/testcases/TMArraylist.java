import com.thinking.machines.util.*;
class TMArrayListTest
{
public static void main(String gg[])
{
TMArrayList<Integer> list=new TMArrayList<Integer>();
for(int e=100;e<=120;e++) list.add(e+1000);
for(int e=0;e<list.size();e++) System.out.println(list.get(e));
System.out.println("----------------------------");
list.add(5,5341324);
for(int e=0;e<list.size();e++) System.out.println(list.get(e));
list.update(5,0);
System.out.println("----------------------------");
for(int e=0;e<list.size();e++) System.out.println(list.get(e));
TMArrayList list2=new TMArrayList();
list2.copyFrom(list);
System.out.println("******************************************");
for(int e=0;e<list2.size();e++) System.out.println(list2.get(e));
System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&");
list2.appendTo(list);
for(int e=0;e<list2.size();e++) System.out.println(list2.get(e));
System.out.println("(((((((((((((((((((((((((()))))))))))))))))))))");
for(int e=0;e<list.size();e++) System.out.println(list.get(e));
System.out.printf("\n\n\n\n\n");
System.out.println("(((((((((((((((((((((((((()))))))))))))))))))))");
list.removeAt(1);
list.removeAt(2);

list.removeAt(5);

for(int e=0;e<list.size();e++) System.out.println(list.get(e));

}
}