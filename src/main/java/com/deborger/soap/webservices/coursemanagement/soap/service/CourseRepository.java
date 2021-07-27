package com.deborger.soap.webservices.coursemanagement.soap.service;

import com.deborger.soap.webservices.coursemanagement.soap.bean.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
