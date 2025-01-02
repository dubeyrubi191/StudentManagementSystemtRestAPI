package com.restapi.studentmanagementapi.studentService;

import com.restapi.studentmanagementapi.studentMangRepository.StudentMangRepository;
import com.restapi.studentmanagementapi.studentModel.StudentModel;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    private final StudentMangRepository repository;

    public StudentService(StudentMangRepository repository) {
        this.repository = repository;
    }

    public void saveNewStudent(StudentModel model){
        repository.save(model);
    }

    public List<StudentModel> getStudentByID(Long studentId){
        //List<StudentModel> studentDetail=repository.findAllById(studentId);
        return repository.findAllByStudentId(studentId);
    }

    public List<StudentModel> findAllStudent(){
        //List<StudentModel> studentDetail=repository.findAll();
        return repository.findAll();
    }

    public void updatedetail(Long id,StudentModel model){
       Optional<StudentModel> listOfStudnet =repository.findById(id);
       if(listOfStudnet.isPresent()){
           listOfStudnet.get().setFirstName(model.getFirstName());
           listOfStudnet.get().setFees(model.getFees());
           listOfStudnet.get().setClasses(model.getClasses());
           repository.save(listOfStudnet.get());
       }

    }

    public void removeStudentById(String name){
        //repository.deleteById(id);
        repository.deleteByFirstName(name);

    }
}
