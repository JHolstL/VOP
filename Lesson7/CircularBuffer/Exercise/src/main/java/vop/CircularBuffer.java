package vop;

import java.net.StandardSocketOptions;
import java.util.Arrays;

public class CircularBuffer {

    private Integer[] buffer;
    private int size;
    int putIndex = 0;
    int getIndex = 0;
    int value = 0;


    public CircularBuffer(int size) {
        buffer = new Integer[size];
        this.size = size;
    }

    synchronized int get() {
        while(buffer[getIndex%size]==null){
            try{
                wait();
            } catch (InterruptedException e){
                System.out.println("Interrupted exeption caught!");
            }
        }
        System.out.println("Got: " + buffer[getIndex%size]);
        value = buffer[getIndex%size];
        buffer[getIndex%size] = null;
        getIndex++;

        notifyAll();
        return value;
    }

    synchronized void put(int n) {
        while(buffer[putIndex%size]!=null){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("Interrupted exeption caught");
            }
        }
        this.buffer[putIndex%size] = n;
        System.out.println("Put: " + buffer[putIndex%size]);
        putIndex++;

        notifyAll();
    }


    public String toString() {
        return "Buff: " + Arrays.toString(buffer);
    }
}

