// Класс Database для хранения и управления животными
import java.io.*;
import java.util.*;

public class Database {
    private final List<Animals> animal;
    private static final String FILE_PATH = "Animal/database.txt";

    public Database() {
        animal = new ArrayList<>();
        loadDatabase();
    }

    public void addAnimal(Animals animals) {
        animal.add(animals);
        saveDatabase();
    }

    public void displayAnimalCommands(String name) {
        for (Animals animals : animal) {
            if (animals.getNameAnimal().equals(name)) {
                animals.viewCommands();
                return;
            }
        }
        System.out.println("Животное с именем " + name + " не найдено.");
    }



    public void teachNewCommand(String name, String command) {
        for (Animals animals : animal) {
            if (animals.getNameAnimal().equals(name)) {
                String[] commands = command.split(",");
                for (int i = 0; i < commands.length; i++) {
                    String trimmedCommand = commands[i].trim();
                    commands[i] = trimmedCommand;
                }
                animals.newCommand(command);
                saveDatabase();
                System.out.println("Команда успешно добавлена для животного.");
                return;
            }
        }
        System.out.println("Животное с именем " + name + " не найдено.");
    }


    private void loadDatabase() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    String className = data[0];
                    String name = data[1];
                    String skills = String.join(",", Arrays.copyOfRange(data, 2, data.length));
                    String age = data[3];

                    Animals animals;
                    switch (className) {
                        case "Dog" -> animals = new Dog(name, skills, age);
                        case "Cat" -> animals = new Cat(name, skills, age);
                        case "Hamster" -> animals = new Hamster(name, skills, age);
                        case "Donkey" -> animals = new Donkey(name, skills, age);
                        case "Horse" -> animals = new Hours(name, skills,age);
                        default -> {
                            System.out.println("Неизвестный класс животного: " + className);
                            continue;
                        }
                    }
                    animal.add(animals);
                } else {
                    System.out.println("Некорректные данные в файле: " + line);
                }
            }
            System.out.println("База данных успешно загружена.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении базы данных: " + e.getMessage());
        }
    }


    public void displayAllAnimals() {
        try {
            File file = new File(FILE_PATH);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String animalData = fileScanner.nextLine();
                System.out.println(animalData);
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл с данными о животных не найден.");
        }
    }

    private void saveDatabase() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Animals animals : animal) {
                String className = animals.getClass().getSimpleName();
                String name = animals.getNameAnimal();
                String skills = animals.getSkillsAnimal().replaceAll(",\\s+", ",");

                String line = className + "," + name + "," + skills;
                writer.write(line);
                writer.newLine();
            }
            System.out.println("База данных успешно сохранена.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении базы данных: " + e.getMessage());
        }
    }

}