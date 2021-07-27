package com.deborger.soap.webservices.coursemanagement.soap.service;

import com.deborger.soap.webservices.coursemanagement.soap.bean.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseRepositoryCommandLineRunner implements CommandLineRunner {

        private static final Logger log =
                LoggerFactory.getLogger(CourseRepositoryCommandLineRunner.class);

        @Autowired
        private CourseRepository courseRepository;

        @Override
        public void run(String... arg0) throws Exception {
            Course course1 = new Course("Spring Boot Beginners", "Basics of Spring Boot");
            courseRepository.save(course1);
            log.info("New Course is created : " + course1);

            Course course2 = new Course("Spring MVC", "The Model/View/Controller");
            courseRepository.save(course2);
            log.info("New Course is created : " + course2);

            Course course3 = new Course("Spring DATA", "The real Data");
            courseRepository.save(course3);
            log.info("New Course is created : " + course3);

            Course course4 = new Course("Spring & Maven", "The Repo's");
            courseRepository.save(course4);
            log.info("New Course is created : " + course4);
        }
}
