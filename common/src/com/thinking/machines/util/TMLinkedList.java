package com.thinking.machines.util;
public class TMLinkedList<T> implements TMList<T>
{
class TMNode<T>
{
public T data;
public TMNode<T> next;
public TMNode()
{
this.data=null;
this.next=null;
}
}
private TMNode<T> start,end;
private int size;
public class TMLinkedListIterator<T> implements TMIterator<T>
{
private TMNode<T> ptr;
public TMLinkedListIterator(TMNode<T> ptr)
{
this.ptr=ptr;
}
public boolean hasNext()
{
return this.ptr!=null;
}
public T next()
{
if(this.ptr==null) throw new InvalidIteratorException("Iterator has no more elements");
T data=this.ptr.data;
this.ptr=this.ptr.next;
return data;
}
}
public TMIterator<T> iterator()
{
return new TMLinkedListIterator<T>(this.start);
}
public TMLinkedList()
{
this.start=null;
this.end=null;
this.size=0;
}
public void add(T data)
{
TMNode<T> t=new TMNode<T>();
t.data=data;
if(this.start==null)
{
this.start=t;
this.end=t;
} else
{
this.end.next=t;
this.end=t;
}
this.size++;
}
public void add(int index,T data)
{
if(index<0) throw new IndexOutOfBoundsException("Invalid index : "+index);
if(index>=this.size) 
{
add(data);
return;
}
TMNode<T> t=new TMNode<T>();
t.data=data;
if(index==0)
{
t.next=this.start;
this.start=t;
} else
{
TMNode<T> p,p1;
p1=this.start;
p=null;
for(int i=0;i<index;i++)
{
p=p1;
p1=p1.next;
}
p.next=t;
t.next=p1;
}
this.size++;
}
public void insert(int index,T data)
{
add(index,data);
}
public int size()
{
return this.size;
}
public void clear()
{
this.start=null;
this.end=null;
this.size=0;
}
public void removeAll()
{
clear();
}
public T removeAt(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
T data;
if(this.start==this.end)
{
data=this.start.data;
clear();
return data;
}
if(index==0)
{
data=this.start.data;
this.start=this.start.next;
this.size--;
return data;
}
TMNode<T> p,p1;
p1=this.start;
p=null;
for(int i=0;i<index;i++) 
{
p=p1;
p1=p1.next;
}
data=p1.data;
p.next=p1.next;
if(p1==this.end) this.end=p;
this.size--;
return  data;
}
public T get(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
TMNode<T> t=this.start;
for(int i=0;i<index;i++) t=t.next;
return t.data;
}
public void update(int index,T data)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
if(index==0)
{
this.start.data=data;
return ;
}
if(index==this.size-1)
{
this.end.data=data;
return;
}
TMNode<T> t=this.start;
for(int i=0;i<index;i++) t=t.next;
t.data=data;
}
public void copyTo(TMList<T> other)
{
other.clear();
for(int i=0;i<this.size();i++) other.add(this.get(i));
}
public void copyFrom(TMList<T> other)
{
this.clear();
for(int i=0;i<other.size();i++) this.add(other.get(i));
}
public void appendTo(TMList<T> other)
{
for(int i=0;i<this.size();i++) other.add(this.get(i));
}
public void appendFrom(TMList<T> other)
{
for(int i=0;i<other.size();i++) this.add(other.get(i));
}
public void forEach(TMListItemAcceptor<T> a)
{
if(a==null) return;
TMNode<T> t;
for(t=this.start;t!=null;t=t.next) a.accept(t.data);
}
}