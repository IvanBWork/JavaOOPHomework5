package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Domain.Student;

/**
 * Класс для реализации функций представления (отображение инфо на русском языке).
 */
public class ViewClass implements iGetView {

    /**
     * @apiNote Метод вывода студентов из списка на английском языке.
     * @param students - список студентов для вывода.
     */
    public void printAllStudents(List<Student> students)
    {
        System.out.println("------------------- Список студентов ---------------------------");

        for(Student s : students)
        {
            System.out.println(s);
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
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }
}
