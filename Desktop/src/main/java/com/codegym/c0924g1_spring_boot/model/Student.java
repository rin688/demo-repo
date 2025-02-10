package com.codegym.c0924g1_spring_boot.model;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT")
    private Integer id;

    @NotBlank(message = " không được để trống")
//    @Size(min = , max)
    @Column(name = "name_student", columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;

//    @Pattern(regexp = "", message = "Email không đúng định dạng")
    @Column(name = "email", columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;

//    @Min()
//    @Max()
//    @Range(min = , max = )
    @Column(name = "score", columnDefinition = "DOUBLE")
    private Float point;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Ngày sinh không được lớn hơn ngày hiện tại")
    private LocalDate dob;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    @NotNull(message = "Lớp không được để trống")
    private Classroom classroom;

}
