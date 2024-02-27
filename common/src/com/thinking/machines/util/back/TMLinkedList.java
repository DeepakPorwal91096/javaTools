package com.thinking.machines.util;
public class TMLinkedList implements TMList
{
class TMNode
{
public int data;
public TMNode next;
public TMNode()
{
this.data=0;
this.next=null;
}
}
private TMNode start,end;
private int size;
public class TMLinkedListIterator implements TMIterator
{
private TMNode ptr;
public TMLinkedListIterator(TMNode ptr)
{
this.ptr=ptr;
}
public boolean hasNext()
{
return this.ptr!=null;
}
public int next()
{
if(this.ptr==null) throw new InvalidIteratorException("Iterator has no more elements");
int data=this.ptr.data;
this.ptr=this.ptr.next;
return data;
}
}
public TMIterator iterator()
{
return new TMLinkedListIterator(this.start);
}
public TMLinkedList()
{
this.start=null;
this.end=null;
this.size=0;
}
public void add(int data)
{
TMNode t=new TMNode();
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
public void add(int index,int data)
{
if(index<0) throw new IndexOutOfBoundsException("Invalid index : "+index);
if(index>=this.size) 
{
add(data);
return;
}
TMNode t=new TMNode();
t.data=data;
if(index==0)
{
t.next=this.start;
this.start=t;
} else
{
TMNode p,p1;
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
this.start=null;
this.end=null;
this.size=0;
}
public void removeAll()
{
clear();
}
public int removeAt(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
int data;
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
TMNode p,p1;
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
public int get(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
TMNode t=this.start;
for(int i=0;i<index;i++) t=t.next;
return t.data;
}
public void update(int index,int data)
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
TMNode t=this.start;
for(int i=0;i<index;i++) t=t.next;
t.data=data;
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
TMNode t;
for(t=this.start;t!=null;t=t.next) a.accept(t.data);
}
}