package com.restapi.studentmanagementapi.studentModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {

    @Id
    @GeneratedValue(strategy= AUTO)
    private Long studentId;

    @JsonProperty("name")
    private String firstName;
    @JsonProperty("Class")
    private String classes;
    @NonNull
    @JsonProperty("fees")
    private int fees;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }
}
