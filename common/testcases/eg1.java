import com.thinking.machines.util.*;
class psp
{
public static void main(String gg[])
{
TMLinkedList list=new TMLinkedList();
for(int i=100;i<120;i++) list.add(i+500);
TMArrayList list2=new TMArrayList();
for(int i=220;i<240;i++) list2.add(i+500);

int data;
TMIterator iterator1=list.iterator();
TMIterator iterator2=list2.iterator();
System.out.println("Traverse on tmlinkedlist");
while(iterator1.hasNext())
{
data=iterator1.next();
System.out.println(data);
}
System.out.println("Traverse on tmarraylist");
while(iterator2.hasNext())
{
data=iterator2.next();
System.out.println(data);
}
}
}