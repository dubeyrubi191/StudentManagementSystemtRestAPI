package com.restapi.studentmanagementapi.studentMangRepository;

import com.restapi.studentmanagementapi.studentModel.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMangRepository extends JpaRepository<StudentModel,Long> {

    List<StudentModel> findAllByStudentId(Long studentId);
    StudentModel deleteByFirstName(String name);
}
