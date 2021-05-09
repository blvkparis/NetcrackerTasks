package ru.ncedu.popkov.vec;

import java.io.*;
import java.util.Arrays;

/**
 * Represents ArrayVector class
 * @author Anton Popkov
 */
public class ArrayVector implements Serializable {
    private Vectors[] vectorsArray;

    /**
     * Constructor
     * @param vectors
     */
    public ArrayVector(Vectors[] vectors) {
        this.vectorsArray = vectors;
    }

    public void writeToFile(String fileName) throws IOException {
        File file = new File("D:\\" + fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(file)
        );
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    public static ArrayVector readFromFile(String fileName) throws IOException, ClassNotFoundException {
        File file = new File("D:\\" + fileName);
        ArrayVector result;

        ObjectInputStream objectInputStream;
        objectInputStream = new ObjectInputStream(
                new FileInputStream(file)
        );
        result = (ArrayVector) objectInputStream.readObject();
        objectInputStream.close();

        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(vectorsArray);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayVector)) return false;

        ArrayVector that = (ArrayVector) o;

        boolean equals = true;
        int i = 0;
        while (equals && i != vectorsArray.length) {
            equals = vectorsArray[i].equals(that.vectorsArray[i]);
            i++;
        }
        return equals;
    }
}