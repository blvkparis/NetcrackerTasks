package ru.ncedu.popkov.vec;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * Represents Vector class
 *
 * @author Anton Popkov
 */
public class Vectors implements Serializable {
    private ArrayList<Double> vector;
    private int size;

    /**
     * Constructor with params
     *
     * @param size   dimension of Vector
     * @param vector list of coordinates
     */
    public Vectors(int size, ArrayList<Double> vector) {
        this.vector = vector;
        this.size = size;
    }

    /**
     * Method that checks if size of vector entered correctly
     *
     * @return true or false
     */
    private boolean checkVectorSize() {
        return this.size == vector.size();
    }

    public ArrayList<Double> getVector() {
        return vector;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return vector.toString();
    }

    /**
     * Method that implements scalar product of one vector
     *
     * @param vec vector
     * @param num number to product with
     * @return scalar
     */
    public static Vectors scalar(Vectors vec, double num) {
        if (vec != null) {
            if (vec.checkVectorSize()) {
                for (int i = 0; i < vec.size; i++) {
                    vec.vector.set(i, vec.vector.get(i) * num);
                }
            } else System.out.println("Wrong value of size!");
        }

        assert vec != null;
        return vec;
    }

    /**
     * Method that implements addition of two vectors
     *
     * @param vec1 first vector
     * @param vec2 second vector
     * @return new vector
     */
    public static Vectors vectorAddition(Vectors vec1, Vectors vec2) {
        ArrayList<Double> resultVector = new ArrayList<>();
        if (vec1 != null && vec2 != null) {
            if (vec1.checkVectorSize() && vec2.checkVectorSize()) {
                if (vec1.size == vec2.size && vec1.size != 0) {
                    for (int i = 0; i < vec1.size; i++)
                        resultVector.add(vec1.vector.get(i) + vec2.vector.get(i));
                } else System.out.println("Vectors' dimensions are not the same");
            } else System.out.println("Wrong value of size!");
        } else System.out.println("Vectors shouldn't be null");

        assert vec1 != null;
        return new Vectors(vec1.size, resultVector);
    }

    /**
     * Method that implements scalar product of two vectors
     *
     * @param vec1 first vector
     * @param vec2 second vector
     * @return scalar product
     */
    public static Double scalarVectors(Vectors vec1, Vectors vec2) {
        double result = 0;
        if (vec1 != null && vec2 != null) {
            if (vec1.checkVectorSize() && vec2.checkVectorSize()) {
                if (vec1.size == vec2.size && vec1.size != 0) {
                    for (int i = 0; i < vec1.size; i++)
                        result += vec1.vector.get(i) * vec2.vector.get(i);
                } else System.out.println("Vectors' dimensions are not the same");
            }
        } else System.out.println("Vectors shouldn't be null");

        return result;
    }

    /**
     * Method that implements writing a vector to a byte stream
     *
     * @param v   vector
     * @param out Output stream
     */
    public void outputVector(Vectors v, OutputStream out) {
        byte[] buffer = new byte[v.size];
        for (int i = 0; i < v.size; i++) {
            buffer[i] = vector.get(i).byteValue();
        }

        try {
            out.write(buffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Method that implements reading a vector from a stream
     *
     * @param in Input Stream
     * @return Vector
     * @throws IOException
     */
    public Vectors inputVector(InputStream in) throws IOException {
        ArrayList<Double> vectorList = new ArrayList<>();
        byte[] buffer = in.readAllBytes();

        vectorList.add(ByteBuffer.wrap(buffer).getDouble());

        return new Vectors(vectorList.size(), vectorList);
    }

    /**
     * Method that implements writing a vector to a char stream
     *
     * @param v   vector
     * @param out Writer
     */
    public void writeVector(Vectors v, Writer out) {
        String buffer = v.toString();
        BufferedWriter bw = new BufferedWriter(out);

        try {
            bw.write(buffer);
            bw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Method that implements reading a vector from a Reader
     *
     * @param in Reader
     * @return Vector
     */
    public Vectors readVector(Reader in) {
        ArrayList<Double> vectorList = new ArrayList<>();

        try {
            while (in.read() != -1) {
                vectorList.add(Double.parseDouble(String.valueOf(in.read())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Vectors(vectorList.size(), vectorList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vectors)) return false;

        Vectors vectors = (Vectors) o;

        if (size != vectors.size) return false;
        return vector.equals(vectors.vector);
    }

    @Override
    public int hashCode() {
        int result = vector.hashCode();
        result = 31 * result + size;
        return result;
    }
}