package com.restapi.studentmanagementapi.studentMangController;
import com.restapi.studentmanagementapi.studentModel.StudentModel;
import com.restapi.studentmanagementapi.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/SchoolManagementSystem")
public class StudentMangController {

    @Autowired
    private StudentService service;

    @GetMapping("/")
    String getmsg(){
        return "testing";
    }
    @PostMapping("/addstudent")
    ResponseEntity<?> addStudent(@RequestBody StudentModel model){
        service.saveNewStudent(model);
        return ResponseEntity.status(200).build();
    }

    @GetMapping(value = "/{id}",
            produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    ResponseEntity<List<StudentModel>> findByStudentId(@PathVariable Long id){
        List<StudentModel> studentDetail=service.getStudentByID(id);
        return ResponseEntity.status(200).body(studentDetail);
        //return studentDetail;
    }

    @GetMapping("/allstudent")
    ResponseEntity<List<StudentModel>> findAllStudent(){
        List<StudentModel> studentDetail = service.findAllStudent();
        //return ResponseEntity.status(200).body(studentDetail);
        //return ResponseEntity.ok(studentDetail);
        return new ResponseEntity<>(studentDetail,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateStudentdetail(@PathVariable Long id,@RequestBody StudentModel model){
        service.updatedetail(id,model);
         return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{name}")
    ResponseEntity<?> deleteStudentById(@PathVariable String name){
        service.removeStudentById(name);
        return ResponseEntity.status(200).build();

    }
}
