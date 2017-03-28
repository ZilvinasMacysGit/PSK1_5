package services;

import entities.mybatis.models.Course;
import entities.mybatis.models.Student;
import entities.mybatis.models.StudentCourse;
import entities.mybatis.mappers.StudentCourseMapper;
import entities.mybatis.mappers.StudentMapper;
import entities.mybatis.mappers.CourseMapper;
import lombok.Getter;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
public class RequestUseCaseControllerMyBatis {

    @Getter
    private Course course = new Course();
    @Getter
    private Student student = new Student();

    @Inject
    private StudentMapper studentMapper;
    @Inject
    private CourseMapper courseMapper;
    @Inject
    private StudentCourseMapper studentCourseMapper;

    public List<Student> getAllStudents() {
        return studentMapper.selectAll();
    }

    @Transactional
    public void createCourseStudent() {
        courseMapper.insert(course);
        studentMapper.insert(student);
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setCourseId(course.getId());
        studentCourse.setStudentId(student.getId());
        studentCourseMapper.insert(studentCourse);
    }
}