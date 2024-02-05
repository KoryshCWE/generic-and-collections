package org.example;

import org.w3c.dom.Node;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}
class MyArrayList {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    public MyArrayList(){
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public void add(Object value) {
        ensureCapacity();
        array[size++] = value;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        System.arraycopy(array, index +1,
                array, index, size - index - 1);
        array[--size] = null;

    }
    public void clear(){
        for (int i = 0; i < size; i++){
            array[i] = null;
        }
        size = 0;
    }
    public int size(){
        return size;
    }
    public Object get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");

        }
        return array[index];
    }
    private void ensureCapacity(){
        if (size == array.length){
            int newCapacity = array.length * 2;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;

        }
    }
}
class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;
    private class Node {
        Object data;
        Node next;
        Node prev;
        Node (Object data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    public void add(Object value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current.prev == null){
            head = current.next;
        }else {
            current.prev.next = current.next;
        }
        if(current.next == null){
            tail = current.prev;
        } else {
            current.next.prev = current.prev;
        }
        size--;
    }
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public Object get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

}
class MyQueue {

    private Object[] elements;
    private int size;
    private int front;
    private int rear;

    public MyQueue() {
        elements = new Object[10];
        size = 0;
        front = 0;
        rear = -1;
    }
    public void add(Object value){
        if(size == elements.length) {
            resize();

        }
        rear = (rear + 1) % elements.length;
        elements[rear] = value;
        size++;
    }
    private void resize() { // Метод для збільшення розміру масиву удвічі
        Object[] newArray = new Object[elements.length * 2]; // Створюємо новий масив удвічі більшого розміру
        int index = front;
        for (int i = 0; i < size; i++) { // Копіюємо елементи в новий масив
            newArray[i] = elements[index];
            index = (index + 1) % elements.length;
        }
        elements = newArray; // Призначаємо новий масив як основний
        front = 0; // Оновлюємо індекс початку черги
        rear = size - 1; // Оновлюємо індекс кінця черги
    }
    public void clear(){
        elements = new Object[10];
        size = 0;
        front = 0;
        rear =-1;
    }
    public int size(){
        return size;
    }
    public Object poll(){
        if (isEmpty()){
            return  null;

        }
        Object element = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return element;
    }
    private boolean isEmpty(){
        return size == 0;
    }
}
class MyStack {
    private Object[] stackArray;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        stackArray = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(Object value) {
        ensureCapacity();
        stackArray[size++] = value;
    }
    public Object remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Object removedElement = stackArray[index];
        for (int i = index; i < size -1; i++){
            stackArray[i] = stackArray[i + 1];
        }
        stackArray[size -1] = null;
        size--;
        return removedElement;
    }
    public void clear(){
        stackArray = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public int size(){
        return size;
    }
    public Object peek(){
        if(size == 0){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stackArray[size - 1];
    }
    public Object pop(){
        if(size == 0){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        Object poppedElement = stackArray[--size];
        stackArray[size] = null;
        return poppedElement;
    }
    private void ensureCapacity(){
        if(size == stackArray.length) {
            int newCapacity = stackArray.length * 2;
            stackArray= Arrays.copyOf(stackArray, newCapacity);
        }
    }

}
class MyHashMap{
    private static final int DEFAULT_CAPACITY= 16;
    private  Node[] table;
    private int size;
    public MyHashMap(){
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }
    public void put(Object key, Object value){
        int hash = hash(key);
        int index = getIndex(hash);
        Node newNode = new  Node(key, value);
        if (table[index] == null){
            table[index] = newNode;
        } else {
            Node current = table[index];
            while (current.next != null){
                if (current.key.equals(key)){
                    current.value = value;
                    return;
                }
                current = current.next;
            }

        }
        size++;
    }
    public Object get(Object key){
        int hash = hash(key);
        int index = getIndex(hash);
        Node current = table[index];
        while (current != null){
            if (current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    public void remove(Object key){
        int hash = hash(key);
        int index = getIndex(hash);
        Node current = table[index];
        Node prev = null;
        while (current != null){
            if (current.key.equals(key)){
                if(prev == null){
                    table[index] = current.next;
                }else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    public void clear(){
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }
    public  int size(){
        return  size;

    }
    private int hash(Object key) {
        return key == null ? 0 : key.hashCode();
    }
    private int getIndex(int hash){
        return hash % table.length;
    }
    private static class Node{
        Object key;
        Object value;
        Node next;
        Node(Object key, Object value){
            this.key = key;
            this.value = value;
        }
    }
}