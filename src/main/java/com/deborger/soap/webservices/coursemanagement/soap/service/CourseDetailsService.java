package com.deborger.soap.webservices.coursemanagement.soap.service;

import com.deborger.soap.webservices.coursemanagement.soap.bean.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseDetailsService {

    public enum Status {SUCCESS,FAILURE}
    private static List<Course> courseList = new ArrayList<>();

    static {
        Course course1 = new Course(1,"Spring beginners", "The Basics");
        courseList.add(course1);

        Course course2 = new Course(2,"Spring MVC", "The Model/View/Controller");
        courseList.add(course2);

        Course course3 = new Course(3,"Spring DATA", "The real Data");
        courseList.add(course3);

        Course course4 = new Course(4,"Spring & Maven", "The Repo's");
        courseList.add(course4);
    }

    public Course findById(int id) {
        for(Course course:courseList) {
            if(course.getId()==id) return course;
        } return null;
    }

    public List<Course> findAll() {
        return courseList;
    }

    public Status deleteById(int id) {
        for(Course course:courseList) {
            if(course.getId()==id) {
                courseList.remove(course);
                return Status.SUCCESS;
            }
        } return Status.FAILURE;
    }
}
