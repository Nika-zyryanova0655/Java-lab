public class Cat implements Meowable {
    private String name;

    // Конструктор
    public Cat(String name) {
        this.name = name;
    }

    // Геттер
    public String getName() {
        return name;
    }

    // Метод toString
    @Override
    public String toString() {
        return "кот: " + name;
    }

    // Реализация метода мяуканья
    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
    }
}
