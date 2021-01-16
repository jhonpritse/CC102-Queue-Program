package com.CC102;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isLoop = true;

        int arraySize = 5;
        Queue queue = new Queue(arraySize);

        Scanner input = new Scanner(System.in);
        String userResponse;

        while (isLoop){
            queue.Options();

            userResponse = input.nextLine().toUpperCase();

          if(userResponse.equals("A")) {
              System.out.print("\tEnter A Number: ");
              queue.Enqueue(Integer.parseInt(input.nextLine()));
          }
          else   if(userResponse.equals("B"))
              queue.Dequeue();
          else   if(userResponse.equals("C"))
              queue.Display();
          else   if(userResponse.equals("D"))
              isLoop = false;
          else
              queue.OtherResponse();
        }

    }

    public static class Queue{
    int front, rear, size;
    int capacity;
    int array[];

    public Queue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    boolean isFull(Queue queue) {
        return (queue.size == queue.capacity);
    }

    boolean isEmpty(Queue queue) {
        return (queue.size == 0);
    }

    void Enqueue(int num) {
        if (isFull(this)) {
            System.out.println("Queue Is Full\n");
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = num;
        this.size = this.size + 1;
        System.out.println("\t"+num + " was enqueued to queue\n");
    }

    int Dequeue() {
        if (isEmpty(this)){
            System.out.println("\tQueue is empty\n");
            return Integer.MIN_VALUE;
        }

        int item = this.array[this.front];
        this.array[this.front] = 0;
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        System.out.println("\t"+item + " was dequeued from the queue\n");
        return item;
    }

    void Display(){
        int[] arrayShow = new int[capacity];
        for (int i=0; i<capacity; i++){
            arrayShow[i] = array[ (this.front +i ) % this.capacity];
        }
        System.out.println(Arrays.toString(arrayShow) + "\n");
    }

    void Options(){
        System.out.println("[A] - PUSH");
        System.out.println("[B] - POP");
        System.out.println("[C] - DISPLAY");
        System.out.println("[D] - STOP");
        System.out.print("Choice: ");
    }
    void OtherResponse(){
        System.out.println("\n!!Please Input a Valid Option!!\n");
    }
}
}


