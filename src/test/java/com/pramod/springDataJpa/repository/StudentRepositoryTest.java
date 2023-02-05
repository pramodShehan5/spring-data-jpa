package com.pramod.springDataJpa.repository;

import com.pramod.springDataJpa.model.Address;
import com.pramod.springDataJpa.model.Book;
import com.pramod.springDataJpa.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = new Student(10, "Pramod", "pramodshehan@gmail.com",
                new Address("my city", "001", "1st Street"));
        studentRepository.save(student);
//        Student student1 = new Student(2, "Achini", "achiniishani@gmail.com",
//                new Address("pinky city", "002", "1st Street"));
//        studentRepository.save(student1);
    }

    @Test
    public void deleteStudent() {
        studentRepository.findAll().forEach(s -> studentRepository.delete(s));
    }

    @Test
    public void getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        studentList.forEach(System.out::println);
    }

    @Test
    public void getStudentsByName() {
        List<Student> studentList = studentRepository.findByName("Pramod");
        studentList.forEach(System.out::println);
    }

    @Test
    public void getStudentsByEmail() {
        List<Student> studentList = studentRepository.findByEmailAddress("pramodshehan@gmail.com");
        studentList.forEach(System.out::println);
    }

    @Test
    public void getStudentOrderByStudentIdDesc() {
        Student studentList = studentRepository.findTopByOrderByStudentIdDesc();
        System.out.println(studentList);
    }

    @Test
    public void getStudentOrderByStudentIdAsc() {
        Student studentList = studentRepository.findTopByOrderByStudentIdAsc();
        System.out.println(studentList);
    }

    @Test
    public void getByLastnameAndFirstnameAllIgnoreCase() {
        List<Student> studentList = studentRepository.findByNameAndAddress_CityAllIgnoreCase("Pramod", "my city1");
        System.out.println(studentList);
    }

    @Test
    public void getFindDistinctStudent() {
        List<Student> studentList = studentRepository.findByNameIgnoreCase("Pramod");
        System.out.println(studentList);
    }

    @Test
    public void getStudentByHouseNo() {
        Student studentList = studentRepository.getStudentByHouseNo("12");
        System.out.println(studentList);
    }

    @Test
    public void getStudentByNameAndEmail() {
        Student studentList = studentRepository.getStudentByNameAndEmailAddress("Pramod", "pramodshehan@gmail.com");
        System.out.println(studentList);
    }

    @Test
    public void getEmailAddressByName() {
        String studentList = studentRepository.getEmailAddressByName("Pramod");
        System.out.println(studentList);
    }

    @Test
    public void getAddressByName() {
        Address address = studentRepository.getAddressByName("Pramod");
        System.out.println(address);
    }

    @Test
    public void getStudentById() {
        Student student = studentRepository.getStudentById(4L);
        System.out.println(student);
    }

    @Test
    public void getStudentByCity() {
        Student student = studentRepository.getStudentByCity("my city");
        System.out.println(student);
    }

    @Test
    public void updateStudentById() {
        studentRepository.updateStudentCityById("new city", 4);
    }

    @Test
    public void deleteStudentById() {
        studentRepository.deleteStudentById(6);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPage = PageRequest.of(0,1);
        Pageable secondPage = PageRequest.of(1, 1);
        List<Student> studentList = studentRepository.findAll(firstPage).getContent();
        System.out.println("Get Total Pages " + studentRepository.findAll(firstPage).getTotalPages());
        System.out.println("Total Elements " + studentRepository.findAll(firstPage).getTotalElements());
        studentList.forEach(System.out::println);

        List<Student> studentList1 = studentRepository.findAll(secondPage).getContent();
        System.out.println("Get Total Pages " + studentRepository.findAll(secondPage).getTotalPages());
        System.out.println("Total Elements " + studentRepository.findAll(secondPage).getTotalElements());
        studentList1.forEach(System.out::println);
    }

    @Test
    public void findAllSorting() {
       Pageable pageable = PageRequest.of(1, 2, Sort.by("emailAddress").descending());
       studentRepository.findAll(pageable).forEach(System.out::println);


        Pageable pageable1 = PageRequest.of(1, 2, Sort.by("emailAddress").descending()
                .and(Sort.by("studentId").ascending()));
        studentRepository.findAll(pageable1).forEach(System.out::println);
    }

    @Test
    public void findAllStudentsByEmailContaining() {
        Pageable firstPage = PageRequest.of(0,1);
        List<Student> studentList = studentRepository.findByEmailAddressContaining("achin1", firstPage).getContent();
        studentList.forEach(System.out::println);
    }
}