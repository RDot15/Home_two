public class Hamster extends Animals{

    public Hamster(String nameAnimal, String skillsAnimal, String age) {
        super(nameAnimal, skillsAnimal, age);
    }

    @Override
    public void viewCommands() {
        System.out.println("Список команд для хомяка: ");
        System.out.println(getSkillsAnimal());

    }

    @Override
    public void newCommand(String command) {
        String updatedSkills = getSkillsAnimal() + ", " + command;
setSkillsAnimal(updatedSkills);
    }
}
