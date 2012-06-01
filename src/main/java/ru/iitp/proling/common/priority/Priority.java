package ru.iitp.proling.common.priority;

public interface Priority<E> extends Comparable<Priority<E>> {
	public void setObject(E object);
	public E object();
}
