// Класс Menu для отображения меню и взаимодействия с пользователем
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final Database database;
    private final Scanner scanner;

    Counter counter1 = new Counter();
    // добавил счетчик


    public Menu(Database database) {
        this.database = database;

        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println("Меню:");
                System.out.println("1. Добавить новое животное");
                System.out.println("2. Показать список всех животных");
                System.out.println("3. Просмотреть список команд животного");
                System.out.println("4. Обучить животное новой команде");
                System.out.println("0. Выход");
                System.out.print("Выберите пункт меню: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 :
                        addNewAnimal();
                    case 2 :
                        database.displayAllAnimals();
                    case 3 :
                        displayAnimalCommands();
                    case 4 :
                        teachNewCommand();
                    case 0 :
                    {

                        System.out.println("Программа завершена.");
                        return;
                    }
                    default :
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } catch (InputMismatchException e)
            // дословно исключенние неверного значения или вне диапазона для ожидаемого типа
            {
                System.out.println("Ошибка: неверный формат ввода. Попробуйте снова.");
                scanner.nextLine();
                // очистка буфера сканера после ошибочного ввода
            }
        }
    }


    private void addNewAnimal() {

        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();

        System.out.println("Введите возраст животного: ");
        String age = scanner.nextLine();

        System.out.println("Введите список команд через запятую:");
        String skills = scanner.nextLine();

        System.out.println("Выберите класс животного:");
        System.out.println("1. Собака");
        System.out.println("2. Кошка");
        System.out.println("3. Хомяк");
        System.out.println("4. Осёл");
        System.out.println("5. Конь");
        System.out.println("6. Верблюд");

        int animalClass = scanner.nextInt();
        scanner.nextLine();

        Animals animals;
        switch (animalClass) {
            case 1 -> animals = new Dog(name, age, skills);
            case 2 -> animals = new Cat(name, age,skills);
            case 3 -> animals = new Hamster(name, age, skills);
            case 4 -> animals = new Donkey(name,  age,skills);
            case 5 -> animals = new Hours(name,  age,skills);
            case 6 -> animals = new Camel(name, age,skills);
            default -> {
                System.out.println("Неверный выбор класса животного.");
                return;
            }
        }

        database.addAnimal(animals);

        // Увеличение счетчика


        System.out.println("Животное успешно добавлено в базу данных.");
        //counter1.showCounter();

    }

    private void displayAnimalCommands() {
        System.out.println("Введите имя животного: ");
        String name = scanner.nextLine();

        database.displayAnimalCommands(name);
    }

    private void teachNewCommand() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        System.out.println("Введите новые команды через запятую:");
        String command = scanner.nextLine();

        database.teachNewCommand(name, command);
        System.out.println("Команда успешно добавлена для животного.");
    }
}