package Model;

import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

/**
 * Класс ModelClass реализует интерфейс iGetModel для работы с данными студентов в памяти.
 */
public class ModelClass implements iGetModel {

    private List<Student> students;

    /**
     * Конструктор класса, инициализирующий список студентов.
     * @param students - список студентов.
     */
    public ModelClass(List<Student> students) {
        this.students = students;
    }

    /**
     * Метод для получения списка студентов.
     */
    public List<Student> getAllStudents()
    {
        return students;
    }

    /**
     * @apiNote Метод для удаления студента по индексу.
     * @param studentId - индекс студента в списке для удаления.
     * @return true/false определяющее наличие студента по индексу в списке.
     */
    @Override
    public boolean deleteStudent(int studentId) {
        boolean studentExist = false;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == studentId) {
                studentExist = true;
                students.remove(i);
                break;
            }
        }
        return studentExist;
    }
}
