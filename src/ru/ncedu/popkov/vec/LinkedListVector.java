package ru.ncedu.popkov.vec;

import java.io.*;
import java.util.LinkedList;

/**
 * @author Anton Popkov
 */
public class LinkedListVector implements Serializable {
    private LinkedList<Vectors> vectorsLinkedList;

    public LinkedListVector (LinkedList<Vectors> vectors) {
        this.vectorsLinkedList = vectors;
    }

    public void writeToFile(String fileName) throws IOException {
        File file = new File("D:\\" + fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(file)
        );
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    public static LinkedListVector readFromFile(String fileName) throws IOException, ClassNotFoundException {
        File file = new File("D:\\" + fileName);
        LinkedListVector result;

        ObjectInputStream objectInputStream;
        objectInputStream = new ObjectInputStream(
                new FileInputStream(file)
        );
        result = (LinkedListVector) objectInputStream.readObject();
        objectInputStream.close();

        return result;
    }

    @Override
    public String toString() {
        return vectorsLinkedList.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedListVector)) return false;

        LinkedListVector that = (LinkedListVector) o;

        boolean equals = true;
        int i = 0;
        while (equals && i != vectorsLinkedList.size()) {
            equals = vectorsLinkedList.get(i).equals(that.vectorsLinkedList.get(i));
            i++;
        }
        return equals;
    }
}