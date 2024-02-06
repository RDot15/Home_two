public class Dog extends Animals{

    public Dog(String nameAnimal, String skillsAnimal, String age) {
        super(nameAnimal, skillsAnimal, age);
    }

    @Override
    public void viewCommands() {
        System.out.println("Список команд для собаки:");
        System.out.println(getSkillsAnimal());
    }

    @Override
    public void newCommand(String command) {
        String updatedSkills = getSkillsAnimal() + "," + command;
        setSkillsAnimal(updatedSkills);
        System.out.println("Пес " + getNameAnimal() + " научился новой команде: " + command);
    }
}
