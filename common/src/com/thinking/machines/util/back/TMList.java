package com.thinking.machines.util;
public interface TMList
{
public void add(int data);
public void add(int index,int data);
public void insert(int index,int data);
public int size();
public void clear();
public void removeAll();
public int removeAt(int index);
public int get(int index);
public void update(int index,int data);
public void copyTo(TMList other);
public void copyFrom(TMList other);
public void appendTo(TMList other);
public void appendFrom(TMList other);
public TMIterator iterator();
public void forEach(TMListItemAcceptor a);
}