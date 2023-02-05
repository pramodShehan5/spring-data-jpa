package com.pramod.springDataJpa.repository;

import com.pramod.springDataJpa.model.Address;
import com.pramod.springDataJpa.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);
    List<Student> findByEmailAddress(String email);
    Student findTopByOrderByStudentIdDesc();
    Student findTopByOrderByStudentIdAsc();
    List<Student> findByNameAndAddress_CityAllIgnoreCase(String name, String city);

    List<Student> findByNameIgnoreCase(String name);

    Page<Student> findByEmailAddressContaining(String emailAddress, Pageable pageable);

    @Query(
            value = "update t_student set city = ?1 where student_id = ?2",
            nativeQuery = true
    )
    long updateStudentCityById(String city, long studentId);

    @Modifying
    @Transactional
    @Query("delete Student s where s.studentId = ?1")
    int deleteStudentById(long id);

    @Query("select s from Student s where s.address.houseNo = ?1")
    Student getStudentByHouseNo(String houseNo);

    @Query("select s from Student s where s.name = ?1 and s.emailAddress = ?2")
    Student getStudentByNameAndEmailAddress(String name, String emailAddress);

    @Query("select s.emailAddress from Student s where s.name = ?1")
    String getEmailAddressByName(String name);

    @Query("select s.address from Student s where s.name = ?1")
    Address getAddressByName(String name);

    @Query(
            value = "SELECT * FROM t_student WHERE student_id = ?1",
            nativeQuery = true
    )
    Student getStudentById(long id);

    @Query(
            value = "SELECT * FROM t_student WHERE city = :city",
            nativeQuery = true
    )
    Student getStudentByCity(@Param("city") String city);
}