package Model.Domain;

/**
 * Класс Student.
 * Представляет собой структуру для создания объектов типа "Student" с идентификатором студентов и генератором id.
 */
public class Student extends Person implements Comparable<Student> {

    private int id;
    private static int generalId;

    /**
     * Конструктор класса Student:
     * @param name - имя студента.
     * @param age - возраст студента.
     */
    public Student(String name, int age) {
        super(name, age);
        this.id = generalId;
        generalId++;
    }

    /**
     * Метод для получения идентификатора студента.
     */
    public int getId() {
        return id;
    }

    /**
     * Переопределенный метод toString для вывода информации о студенте:
     * @return строковое представление объекта Student.
     */
    @Override
    public String toString() {
        return "Student [id = " + id + ", name = " + super.getName() + ", age = " + super.getAge() + "]";
    }

    /**
     * @apiNote Метод для сравнения студентов по возрасту и по id
     * @param o объект получаемый для сравнения.
     * @return возвращаемое сравнение по возрасту:
     * 0 - если значения равны. В таком случае идёт сравнение по идентификатору студента.
     * -1 - если вызываемый объект больше o.
     * 1 - если вызываемый объект меньше o.
     * @return возвращаемое сравнение по идентификатору студента:
     * 0 - если значения равны.
     * 1 - если вызываемый объект больше o.
     * -1 - если вызываемый объект меньше o.
     */
    @Override
    public int compareTo(Student o) {
        if(o.getAge() == super.getAge())
        {
            if(id == o.id) return 0;
            if(id > o.id) return 1;
            else return -1;
        }

        if(o.getAge() > super.getAge())
            return -1;
        else
            return 1;
    }
}
