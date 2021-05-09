package ru.ncedu.popkov.vec;

import java.io.IOException;
import java.util.*;

/**
 * @author Anton Popkov
 */
public class VecMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Vectors vec1 = new Vectors(3, new ArrayList<>(Arrays.asList(5.0, 3.0, 2.0)));
        Vectors vec2 = new Vectors(3, new ArrayList<>(Arrays.asList(6.0, 7.0, 4.0)));
        //Vectors vec3 = new Vectors(3, new ArrayList<>(Arrays.asList(6.0, 7.0, 3.0)));

        System.out.println("Vector's addition");
        Vectors vec3 = Vectors.vectorAddition(vec1, vec2);
        System.out.println(vec3);
        System.out.println();

        System.out.println("Vectors scalar multiplication");
        double scalarProduct = Vectors.scalarVectors(vec1, vec2);
        System.out.println(scalarProduct);
        System.out.println();

        System.out.println("Scalar");
        Vectors.scalar(vec1, 5);
        System.out.println(vec1);
        System.out.println();

        ArrayVector arrayVector = new ArrayVector(new Vectors[]{vec1, vec2});
        arrayVector.writeToFile("arr.out");

        ArrayVector arrayVector1 = ArrayVector.readFromFile("arr.out");
        ArrayVector arrayVector3 = new ArrayVector(new Vectors[]{vec1, vec3});

        System.out.println(arrayVector);
        System.out.println(arrayVector1);
        System.out.println(arrayVector.equals(arrayVector1));
        System.out.println();


        LinkedListVector linkedListVector = new LinkedListVector(new LinkedList<>(Arrays.asList(vec1, vec2)));
        linkedListVector.writeToFile("list.out");

        LinkedListVector linkedListVector1 = LinkedListVector.readFromFile("list.out");

        System.out.println(linkedListVector);
        System.out.println(linkedListVector1);
        System.out.println(linkedListVector.equals(linkedListVector1));
    }
}