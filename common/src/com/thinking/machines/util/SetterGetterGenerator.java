package com.thinking.machines.util;
import java.lang.reflect.*;
import java.io.*;
class SetterGetterGenerator
{
public static void main(String gg[])
{
if(gg.length!=1 && gg.length!=2)
{
System.out.println("Usage : java classpath path_to_jar_file;. com.thinking.machines.util.SetterGetterGenerator class_name construct=true");
return;
}
if(gg.length==2)
{
if(gg[1].equalsIgnoreCase("constructor=true")==false && gg[1].equalsIgnoreCase("constructor=false")==false)
{
System.out.println("Usage : java classpath path_to_jar_file;. com.thinking.machines.util.SetterGetterGenerator class_name construct=true");
return;
}
}
String className=gg[0];
String setterName,getterName;
String line,tmp;
String fieldName;
Class fieldType;
try
{
TMList<String>list=new TMLinkedList<String>();
Class c=Class.forName(className);
Field fields[]=c.getDeclaredFields();
Field field;
if(gg.length==1 ||(gg.length==2 && gg[1].equals("constructor=true")))
{
list.add("public "+c.getSimpleName()+"()");
list.add("{");
for(int e=0;e<fields.length;e++)
{
field=fields[e];
line="this."+field.getName()+"="+getDefaultValue(field.getType())+";";
list.add(line);
}
list.add("}");
}
for(int e=0;e<fields.length;e++)
{
field=fields[e];
fieldName=field.getName();
fieldType=field.getType();
if(fieldName.charAt(0)>=97 && fieldName.charAt(0)<=122)
{
tmp=fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
} else tmp=fieldName;
setterName="set"+tmp;
getterName="get"+tmp;
line="public void "+setterName+"("+fieldType.getName()+" "+fieldName+")";
list.add(line);
list.add("{");
line="this."+fieldName+"="+fieldName+";";
list.add(line);
list.add("}");
line="public "+fieldType.getName()+" "+getterName+"()";
list.add(line);
list.add("{");
line="return this."+fieldName+";";
list.add(line);
list.add("}");
}
File file=new File("tmp.tmp");
if(file.exists()) file.delete();
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(file,"rw");
TMIterator<String> iterator=list.iterator();
while(iterator.hasNext())
{
line=iterator.next();
randomAccessFile.writeBytes(line+"\r\n");
}
randomAccessFile.close();
System.out.println("Setter/Getter for "+c.getSimpleName()+" Generated in file named as tmp.tmp");
}catch(ClassNotFoundException classNotFoundException)
{
System.out.println("Unable to load class,classpath missing");
}catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
}
private static String getDefaultValue(Class c)
{
String className=c.getName();
if(className.equals("java.lang.Long") || className.equals("long")) return "0l";
if(className.equals("java.lang.Integer") || className.equals("int")) return "0";
if(className.equals("java.lang.Short") || className.equals("short")) return "0";
if(className.equals("java.lang.Byte") || className.equals("byte")) return "0";
if(className.equals("java.lang.Double") || className.equals("double")) return "0.0";
if(className.equals("java.lang.Float") || className.equals("float")) return "0.0f";
if(className.equals("java.lang.Boolean") || className.equals("boolean")) return "false";
if(className.equals("java.lang.Character") || className.equals("char")) return "' '";
if(className.equals("java.lang.String") ) return "\"\"";
return "null";
}
}