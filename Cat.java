public class  Cat extends Animals {

    public Cat(String nameAnimal, String skillsAnimal, String age) {
        super(nameAnimal, skillsAnimal, age);
    }

    @Override
    public void viewCommands() {
        System.out.println("Список команд кота: ");
        System.out.println(getSkillsAnimal());

    }

    @Override
    public void newCommand(String command) {

        String updatedSkills = getSkillsAnimal() + "," + command;
        setSkillsAnimal(updatedSkills);
        System.out.println("Кот " + getNameAnimal() + " научился новой команде: " + command);
    }

}