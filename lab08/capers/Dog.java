package capers;

import org.knowm.xchart.internal.Utils;

import java.io.File;
import java.io.Serializable;

/** Represents a dog that can be serialized.
 * @author Sean Dooher
*/
public class Dog implements Serializable{ // FIXME


    /** Folder that dogs live in. */
    static final File DOG_FOLDER = new File(".caper/dogs"); // FIXME

    /**
     * Creates a dog object with the specified parameters.
     * @param name Name of dog
     * @param breed Breed of dog
     * @param age Age of dog
     */
    public Dog(String name, String breed, int age) {
        _age = age;
        _breed = breed;
        _name = name;
    }

    /**
     * Reads in and deserializes a dog from a file with name NAME in DOG_FOLDER.
     *读取并反序列化文件
     * @param name Name of dog to load
     * @return capers.Dog read from file
     */
    public static Dog fromFile(String name) {
        File dog = new File(".capers/dogs/"+ name);
        return capers.Utils.readObject(dog, Dog.class);
    }

    /**
     * Increases a dog's age and celcebrates!
     */
    public void haveBirthday() {
        _age += 1;
        System.out.println(toString());
        System.out.println("Happy birthday! Woof! Woof!");
    }

    /**
     * Saves a dog to a file for future use.
     */
    public void saveDog() {
        // FIXME
        File dog = new File(".capers/dogs" + this._name);
        capers.Utils.writeContents(dog, "");
        capers.Utils.writeObject(dog, this);
    }

    @Override
    public String toString() {
        return String.format(
            "Woof! My name is %s and I am a %s! I am %d years old! Woof!",
            _name, _breed, _age);
    }

    /** Age of dog. */
    private int _age;
    /** Breed of dog. */
    private String _breed;
    /** Name of dog. */
    private String _name;
}
