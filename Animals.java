public abstract class Animals {
    private String nameAnimal;
    private String skillsAnimal;
    private String dateOfBirthday;

    // конструктор для присваивания значения переменной данного объекта
    public Animals(String nameAnimal, String skillsAnimal, String dateOfBirthday) {
        this.nameAnimal = nameAnimal;
        this.skillsAnimal = skillsAnimal;
        this.dateOfBirthday=dateOfBirthday;
    }

    // геттеры и сеттеры для доступа. Принцип открытости закрытости
    public String getNameAnimal() {
        return nameAnimal;
    }

    public String getSkillsAnimal() {
        return skillsAnimal;
    }
    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setSkillsAnimal(String updatedSkills) {
        this.skillsAnimal = updatedSkills;
    }

    public abstract void viewCommands();

    public abstract void newCommand(String command);
}




