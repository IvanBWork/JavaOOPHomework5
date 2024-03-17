package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

/**
 * Класс FileModelClass реализует интерфейс iGetModel для работы с данными студентов через файл.
 */
public class FileModelClass implements iGetModel {

    private String fileName;

    /**
     * Конструктор класса, инициализирующий объект для работы с файлом.
     * @param fileName - имя файла для работы.
     */
    public FileModelClass(String fileName) {
        this.fileName = fileName;

        try(FileWriter fw = new FileWriter(fileName, true))
        {
            fw.flush();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @apiNote Метод для записи студентов в виде списка в файл.
     * @param students - список студентов для записи в файл.
     */
    public void saveAllStudentToFile(List<Student> students)
    {
        try(FileWriter fw = new FileWriter(fileName, true))
        {
            for(Student pers : students)
            {
                fw.write(pers.getName()+" "+pers.getAge()+" "+pers.getId());
                fw.append('\n');
            }
            fw.flush();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод получения студентов в виде списка из файла.
     */
    @Override
    public List<Student> getAllStudents() {
        List<Student> students  = new ArrayList<Student>();
        try
        {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null)
            {
                String[] param = line.split(" ");
                Student pers = new Student(param[0], Integer.parseInt(param[1]));
                students.add(pers);
                line = reader.readLine();
            }
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return students;
    }

    /**
     * @apiNote Метод для удаления студента по индексу.
     * @param studentId - индекс студента в списке для удаления.
     * @return true/false определяющее наличие студента по индексу в списке.
     */
    @Override
    public boolean deleteStudent(int studentId) {
        List<Student> students = getAllStudents();
        boolean studentIsExist = false;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == studentId) {
                studentIsExist = true;
                students.remove(i);
                break;
            }
        }
        if (studentIsExist) {
            saveAllStudentToFile(students);
        }
        return studentIsExist;
    }
    
}
