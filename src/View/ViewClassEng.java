package View;

import Controller.Interfaces.iGetView;
import Model.Domain.Student;

import java.util.List;
import java.util.Scanner;

/**
 * Класс для реализации функций представления (отображение инфо на английском языке).
 */
public class ViewClassEng implements iGetView {

    /**
     * @apiNote Метод вывода студентов из списка на английском языке.
     * @param students - список студентов для вывода.
     */
    @Override
    public void printAllStudents(List<Student> students) {

        System.out.println("------------------- Student list ---------------------------");

        for (Student student : students
        ) {
            System.out.println(student);
        }
        System.out.println("------------------------------------------------------------------");
    }

    /**
     * @apiNote Метод запроса информации от пользователя.
     * @param msg - сообщение для отображения пользователю перед вводом данных.
     * @return введенные пользователем данные типа String.
     */
    @Override
    public String prompt(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextLine();
    }
}
