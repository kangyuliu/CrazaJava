package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyPriorityQueue<E extends Comparable<E>> {
    private ArrayList<E> data;
    private int size;

    public MyPriorityQueue(){
        data = new ArrayList<>();
    }

    public MyPriorityQueue(int initCapacity){
        data = new ArrayList<>(initCapacity);
    }

    int leftSon(int i){
        if(i < 0){
            throw new IllegalArgumentException();
        }
        return 2*i+1;
    }

    int rightSon(int i){
        if(i < 0){
            throw new IllegalArgumentException();
        }
        return 2*i +2;
    }

    int parent(int i){
        if(i < 1){
            throw new IllegalArgumentException();
        }
        return (i-1)/2;
    }

    void siftUp(int i){
        E e = data.get(i);
        int p = parent(i);
        E parent = data.get(p);
        if(e.compareTo(parent) > 0){
            swap(i,p);
            i = p;
            siftUp(i);
        }
    }

    void siftDown(int i){
        int left = leftSon(i);
        int right = rightSon(i);
        int maxIndex = i;
        if(left < data.size() && data.get(left).compareTo(data.get(maxIndex)) > 0){
            maxIndex = left;
        }

        if(right < data.size() && data.get(right).compareTo(data.get(maxIndex)) > 0){
            maxIndex = right;
        }
        if(maxIndex != i){
            swap(i, maxIndex);
            siftDown(maxIndex);
        }
    }

    void swap(int i, int j){
        E e = data.get(i);
        data.set(i, data.get(j));
        data.set(j, e);
    }

    void add(E e){
        data.add(e);
        siftUp(data.size()-1);
    }

    E poll(){
        E e = data.get(0);
        swap(0, data.size()-1);
        data.remove(data.size()-1);
        siftDown(0);
        return e;
    }

    void replace(E e){
        E old = data.get(0);
        data.set(0, e);
        siftDown(0);
    }


}
