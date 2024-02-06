public class Camel extends Animals{

    public Camel(String nameAnimal, String skillsAnimal, String age) {
        super(nameAnimal, skillsAnimal, age);
    }

    @Override
    public void viewCommands() {
        System.out.println("Список команд Верблюда: ");
        System.out.println(getSkillsAnimal());
    }

    @Override
    public void newCommand(String command) {
String updatedSkills = getSkillsAnimal() + ", " + command;
setSkillsAnimal(updatedSkills);
        System.out.println("Научился " + getNameAnimal() + " научился новой команде: " + command);
    }
}
