package Model;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Класс модели, реализует интерфейс iGetModel для работы с данными студентов в виде HashMap.
 */
public class ModelClassHash implements iGetModel {
    private HashMap<Integer, Student> studentHashMapStorage;

    /**
     * Конструктор класса, инициализирующий HashMap студентов.
     * @param students - список студентов для инициализации HashMap.
     */
    public ModelClassHash(List<Student> students) {
        this.studentHashMapStorage = new HashMap<>();
        for (Student student : students) {
            this.studentHashMapStorage.put(student.getId(), student);
        }
    }

    /**
     * Метод получения всех студентов из HashMap.
     * @return список всех студентов.
     */
    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        for (Student student : studentHashMapStorage.values()) {
            students.add(student);
        }
        return students;
    }

    /**
     * @apiNote Удаляет студента из HashMap по его идентификатору.
     * @param idStudent - идентификатор студента для удаления.
     */
    @Override
    public boolean deleteStudent(int idStudent) {
        if (!studentHashMapStorage.containsKey(idStudent)) {
            return false;
        }
        studentHashMapStorage.remove(idStudent);
        return true;
    }
}
