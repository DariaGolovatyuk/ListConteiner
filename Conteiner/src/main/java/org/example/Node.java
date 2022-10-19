package org.example;

/**
 * Шаблонный класс Node - это узел однонаправленного списка
 * @param <T> тип шаблонного класса
 */
public class Node <T>{
    public T x;
    protected Node <T> next;
    protected Node() {};
    public Node (T new_x) {
        x=new_x;
        next=null;
    };
}
