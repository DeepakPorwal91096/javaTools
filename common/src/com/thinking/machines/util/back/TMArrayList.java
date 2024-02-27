package com.thinking.machines.util;
public class TMArrayList implements TMList
{
private int [] collection;
private int size;
public class TMArrayListIterator implements TMIterator
{
private int index;
public TMArrayListIterator()
{
this.index=0;
}
public boolean hasNext()
{
return this.index!=TMArrayList.this.size;
}
public int next()
{
if(this.index==TMArrayList.this.size) throw new InvalidIteratorException("Iterator has no more elements");
int data=TMArrayList.this.get(index);
this.index++;
return data;
}
}
public TMIterator iterator()
{
return new TMArrayListIterator();
}
public TMArrayList() 
{
this.collection=new int[10];
this.size=0;
}
public void add(int data)
{
if(this.size==this.collection.length)
{
int tmp[];
tmp=new int[this.size+10];
for(int i=0;i<this.size;i++) tmp[i]=collection[i];
this.collection=tmp;
}
this.collection[size]=data;
this.size++;
}
public void add(int index,int data)
{
if(index<0 || index>this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
if(this.size==this.collection.length)
{
int tmp[];
tmp=new int[this.size+10];
for(int i=0;i<this.size;i++) tmp[i]=collection[i];
this.collection=tmp;
}
int e;
for(e=this.size;e>index;e--) this.collection[e]=this.collection[e-1];
this.collection[index]=data;
this.size++;
}
public void insert(int index,int data)
{
add(index,data);
}
public int size()
{
return this.size;
}
public void clear()
{
this.size=0;
}
public void removeAll()
{
this.size=0;
}
public int removeAt(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
int data=this.collection[index];
int ep=this.size-2;
for(int e=index;e<=ep;e++) this.collection[e]=this.collection[e+1];
this.size--;
return data;
}
public int get(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
return this.collection[index];
}
public void update(int index,int data)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
this.collection[index]=data;
}
public void copyTo(TMList other)
{
other.clear();
for(int i=0;i<this.size();i++) other.add(this.get(i));
}
public void copyFrom(TMList other)
{
this.clear();
for(int i=0;i<other.size();i++) this.add(other.get(i));
}
public void appendTo(TMList other)
{
for(int i=0;i<this.size();i++) other.add(this.get(i));
}
public void appendFrom(TMList other)
{
for(int i=0;i<other.size();i++) this.add(other.get(i));
}
public void forEach(TMListItemAcceptor a)
{
if(a==null) return;
for(int i=0;i< this.size;i++) a.accept(collection[i]);
}
}