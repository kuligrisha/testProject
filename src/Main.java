import animals.Animal;
import animals.pets.Cat;
import animals.pets.Dog;
import animals.birds.Duck;
import data.Commands;

import java.util.*;

public class Main {

    public static Animal animalGenerate(String anyAnimal, Scanner sc) {
        Animal animal;
        try {
            System.out.println("Введите имя");
            String name = sc.next();
            System.out.println("Введите возраст");
            int age = sc.nextInt();
            System.out.println("Введите вес");
            int weight = sc.nextInt();
            System.out.println("Введите цвет");
            String color = sc.next();
            switch (anyAnimal) {
                case "cat":
                    animal = new Cat(name, age, weight, color);
                    return animal;
                case "dog":
                    animal = new Dog(name, age, weight, color);
                    return animal;
                case "duck":
                    animal = new Duck(name, age, weight, color);
                    return animal;
            }
        } catch (InputMismatchException e) {
            System.out.println("Возраст и вес должны быть числовыми значениями");
        }
        return animalGenerate(anyAnimal, new Scanner(System.in));
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду(ADD, LIST, EXIT) ");
            String command = sc.next().toUpperCase().trim();
            boolean currentValue = Arrays.stream(Commands.values()).anyMatch(i -> i.toString().equals(command));
            if (currentValue) {
                Commands userChoice = Commands.valueOf(command);
                switch (userChoice) {
                    case ADD:
                        System.out.println("Какое животное(cat/dog/duck)?");
                        String animalType = sc.next();
                        if (animalType.equals("cat") || animalType.equals("dog") || animalType.equals("duck")) {
                            Animal animal = animalGenerate(animalType, sc);
                            animal.say();
                            animals.add(animal);
                        }
                        break;
                    case LIST:
                        for (Animal animal : animals) {
                            System.out.println(animal);
                        }
                        break;
                    case EXIT:
                        System.exit(0);
                        break;
                }
            } else {
                System.out.println("Неверная команда");
            }


        }

    }


}
