package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Domain.Student;

/**
 * Класс Controller выступает в качестве посредника между классами Model и View,
 * обрабатывая ввод пользователя и обновляя представление соответственно.
 */
public class ControllerClass {

    private iGetModel model;
    private iGetView view;
    private iGetView viewEng;
    private List<Student> buffer = new ArrayList<>();

    /**
     * Конструктор для инициализации Controller с ссылками на классы Model и View.
     * @param model - класс Model, реализующий интерфейс iGetModel.
     * @param view - класс View, реализующий интерфейс iGetView.
     * @param viewEng - класс View, реализующий интерфейс iGetView.
     */
    public ControllerClass(iGetModel model, iGetView view, iGetView viewEng) {
        this.model = model;
        this.view = view;
        this.viewEng = viewEng;
    }

    /**
     * @apiNote Проверка наличия данных о студентах в списке.
     * @param students - список студентов для проверки.
     * @return Возвращает true/false в зависимости от наличия студентов в списке.
     */
    private boolean testData(List<Student> students)
    {
        if(students.size()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * @apiNote Получение списка студентов из модели, проверка на наличие данных в списке
     * и передача на вывод в представление при наличии данных.
     */
    public void update()
    {
        buffer = model.getAllStudents();

        if(testData(buffer))
        {
            view.printAllStudents(buffer);
        }
        else{
            System.out.println("Список студентов пуст!");
        }
    }

    /**
     * @apiNote Метод запуска цикла взаимодействия с пользователем
     * посредством обработки данных из модели и передачи в представление в ответ на команду пользователя.
     */
    public void run() {
        Command com = Command.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            System.out.println("Список команд: \n" +
                    "list - Список студентов. \n" +
                    "listEng - Список студентов на английском языке. \n" +
                    "delete - Удаление студента из списка. \n" +
                    "exit - Выход из программы. \n");
            String command = view.prompt("Введите команду: ");
            com = Command.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    System.out.println("Выход из программы!");
                    break;
                case LIST:
                    view.printAllStudents(model.getAllStudents());
                    break;
                case LISTENG:
                    viewEng.printAllStudents(model.getAllStudents());
                    break;
                case DELETE:
                    System.out.println("Введите id студента для удаления: ");
                    Scanner scanner = new Scanner(System.in);
                    int studentId = scanner.nextInt();
                    if (model.deleteStudent(studentId)) System.out.println("Студент с id " + studentId + " удален.");
                    else System.out.println("Студент с id " + studentId + " отсутствует.");
                    break;
            }
        }
    }
}
