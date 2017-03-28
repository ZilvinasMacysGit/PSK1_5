package controllers;

import entities.jpa.models.Course;
import entities.jpa.models.Student;
import entities.jpa.dao.CourseDAO;
import entities.jpa.dao.StudentDAO;
import lombok.Getter;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
public class RequestUseCaseControllerJPA {

    @Getter
    private Course course = new Course();
    @Getter
    private Student student = new Student();

    @Inject
    private CourseDAO courseDAO;
    @Inject
    private StudentDAO studentDAO;

    @Transactional
    public void createCourseStudent() {
        student.getCourseList().add(course);
        course.getStudentList().add(student);
        courseDAO.create(course);
        studentDAO.create(student);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
