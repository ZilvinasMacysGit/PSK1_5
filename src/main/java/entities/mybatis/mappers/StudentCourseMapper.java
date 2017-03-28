package entities.mybatis.mappers;

import entities.mybatis.models.StudentCourse;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface StudentCourseMapper {
    int deleteByPrimaryKey(Integer studentId, Integer courseId);
    int insert(StudentCourse record);
    List<StudentCourse> selectAll();
}