package Controller.Interfaces;

import java.util.List;

import Model.Domain.Student;

/**
 * Интерфейс iGetView используется для взаимодействия с пользовательским интерфейсом.
 */
public interface iGetView {

     /**
      * @apiNote Метод вывода списка студентов.
      * @param students - список студентов для вывода.
      */
     public void printAllStudents(List<Student> students);

     /**
      * @apiNote Метод запроса информации от пользователя.
      * @param msg - сообщение для отображения пользователю перед вводом данных.
      * @return введенные пользователем данные типа String.
      */
     public String prompt(String msg);
}
