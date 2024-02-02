public class Dog extends Animals{

    public Dog(String nameAnimal, String skillsAnimal, String dateOfBirthday) {
        super(nameAnimal, skillsAnimal, dateOfBirthday);
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
    }
}
