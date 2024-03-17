package Model.Domain;

/**
 * Абстрактный класс Person.
 * Представляет собой структуру для создания объектов типа "Person" с именем и возрастом.
 */
public abstract class Person {
    private String name;
    private int age;

    /**
     * Конструктор класса Person:
     * @param name - имя.
     * @param age - возраст.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Метод для получения имени персоны.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для установки имени персоны
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод для получения возраста персоны.
     */
    public int getAge() {
        return age;
    }

    /**
     * Метод для установки возраста персоны.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Переопределенный метод toString для вывода информации о персоне:
     * @return строковое представление объекта Person.
     */
    @Override
    public String toString() {
        return "Person [name = " + name + ", age = " + age + "]";
    }
}
