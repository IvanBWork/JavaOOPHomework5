package Controller.Interfaces;

import java.util.List;

import Model.Domain.Student;

/**
 * Интерфейс iGetModel используется для взаимодействия с моделью данных студентов.
 */
public interface iGetModel {
    /**
     * @apiNote Метод для получения списка студентов.
     * @return объекты типа Student в виде списка.
     */
    public List<Student> getAllStudents();

    /**
     * @apiNote Метод удаления студента из списка по индексу.
     * @param studentId - индекс студента в списке для удаления.
     */
    public boolean deleteStudent(int studentId);
}
