package com.iba.messmanagementsystem.repositories;

import com.iba.messmanagementsystem.models.Students;
import com.iba.messmanagementsystem.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Integer> {

    @Override
    @Query("select student from Students student where student.visible=true")
    List<Students> findAll();

    @Query(value = "SELECT student from Students student where ((student.studentName like %?1%) or (student.studentPhone like %?1%)" +
            "or (student.studentHostel like %?1%) or (student.studentSemester like %?1%) or (student.studentRoom like %?1%) " +
            "or (student.studentCMS like %?1%) or (student.id like %?1%))")
    public List<Students> getStudentByFilter(@Param("keyword") String keyword);

    @Query("select student from Students student where student.visible=false")
    List<Students> findAllDeleted();

    @Query("SELECT COUNT(students) from Students students")
    public Integer getTotalStudentsCount();

    @Query("SELECT students from Students students where students.visible=true")
    public List<Students> getAllStudents();

    @Transactional
    @Modifying
    @Query("UPDATE Students student SET student.visible=false where student.id=?1")
    public void deleteStudentByVisible(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Students student SET student.visible=true where student.id=?1")
    public void recoverStudentByVisible(Integer id);

}
