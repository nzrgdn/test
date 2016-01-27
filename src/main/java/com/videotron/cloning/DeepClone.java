package com.videotron.cloning;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeepClone {

    public static void main(String[] args) {
        // (1) create a Person object named Al
        Address address = new Address("305 West Fern Avenue", "Palmer", "Alaska");
        Person al = new Person("Al", "Alexander", address);

        // (2) make a deep clone of Al
        Person neighbor = (Person) deepClone(al);

        // (3) modify the neighbor's attributes
        neighbor.firstName = "Martha";
        neighbor.lastName = "Stewart";

        // (4) show that it all worked
        System.out.println(al);
        System.out.println(neighbor);
    }

    /**
     * This method makes a "deep clone" of any object it is given.
     */
    public static Object deepClone(Object object) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
