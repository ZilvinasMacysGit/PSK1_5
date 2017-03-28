package entities.mybatis.mappers;

import entities.mybatis.models.Course;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Course record);
    Course selectByPrimaryKey(Integer id);
    List<Course> selectAll();
    int updateByPrimaryKey(Course record);
}