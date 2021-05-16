package examples.pattern23.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

interface Animal {
    void update();
}

class Dog implements Animal {
    Dog(AnimalList animalList){
        animalList.add(this);
    }

    @Override
    public void update() {
        System.out.println("Dog!!");
    }
}
class Cat implements Animal {
    Cat(AnimalList animalList){
        animalList.add(this);
    }

    @Override
    public void update() {
        System.out.println("Cat!!");
    }
}
class Horse implements Animal {
    Horse(AnimalList animalList){
        animalList.add(this);
    }

    @Override
    public void update() {
        System.out.println("Horse!!");
    }
}
class AnimalList {

    private List<Animal> animals;

    AnimalList() {
        animals = new ArrayList<Animal>();
    }

    public void add(Animal animal) {
        animals.add(animal);
    }

    public void notifyObservers() {
        for(Animal animal:animals) {
            animal.update();
        }
    }
}

public class ObserverAnimalApp {

    public static void main( String[] args ) {

        /* Subject == AnimalList
           Observer == Animal
           틀린개념: Observer가 감시하고 있다가 알아서 디텍팅한다.
           맞는개념: Subject에 감시대상 리스트를 모아두고, Observer에게 상태를 알려준다.
        */

        AnimalList animalList = new AnimalList();
        Dog dog = new Dog(animalList);
        Cat cat = new Cat(animalList);
        Horse horse = new Horse(animalList);

        // 한 방에 모두에게 알린다
        animalList.notifyObservers();
    }
}
