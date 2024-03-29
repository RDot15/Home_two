public abstract class Animals {
    private String nameAnimal;
    private String skillsAnimal;
    private String age;

    // на данном этапе я оставил возраст строкой. Заметил уже поздно.

    // конструктор для присваивания значения переменной данного объекта
    public Animals(String nameAnimal, String skillsAnimal, String age) {
        this.nameAnimal = nameAnimal;
        this.skillsAnimal = skillsAnimal;
        this.age = age;
    }

    // геттеры и сеттеры для доступа. Принцип открытости закрытости
    public String getNameAnimal() {
        return nameAnimal;
    }

    public String getSkillsAnimal() {
        return skillsAnimal;
    }
    public String getAgeAnimal() {
        return age;
    }

    public void setSkillsAnimal(String updatedSkills) {
        this.skillsAnimal = updatedSkills;
    }

    public abstract void viewCommands();

    public abstract void newCommand(String command);
}




