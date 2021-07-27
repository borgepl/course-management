package com.deborger.soap.webservices.coursemanagement.soap;

import com.deborger.courses.*;
import com.deborger.soap.webservices.coursemanagement.soap.bean.Course;
import com.deborger.soap.webservices.coursemanagement.soap.exception.CourseNotFoundException;
import com.deborger.soap.webservices.coursemanagement.soap.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CourseDetailsEndpoint {

    @Autowired
    CourseDetailsService service;

    @PayloadRoot(namespace = "http://deborger.com/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetails(@RequestPayload GetCourseDetailsRequest request) {

        Course course = service.findById(request.getId());
        if (course==null) {
            throw new CourseNotFoundException("Invalid course id " + request.getId());
        }
        return mapCourseDetails(course);
    }

    @PayloadRoot(namespace = "http://deborger.com/courses", localPart = "GetAllCourseDetailsRequest")
    @ResponsePayload
    public GetAllCourseDetailsResponse processAllCourseDetails(@RequestPayload GetAllCourseDetailsRequest request) {

        List<Course> courses = service.findAll();

        return mapAllCourseDetails(courses);
    }

    @PayloadRoot(namespace = "http://deborger.com/courses", localPart = "DeleteCourseDetailsRequest")
    @ResponsePayload
    public DeleteCourseDetailsResponse processDeleteCourseDetails(@RequestPayload DeleteCourseDetailsRequest request) {

        CourseDetailsService.Status status = service.deleteById(request.getId());
        DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
        response.setStatus(mapStatus(status));
        return response;
    }

    private Status mapStatus(CourseDetailsService.Status status) {
        if(status==CourseDetailsService.Status.FAILURE) {
            return Status.FAILURE;
        } return Status.SUCCESS;
    }

    private GetCourseDetailsResponse mapCourseDetails(Course course) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        response.setCourseDetails(mapCourse(course));
        return response;
    }

    private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
        GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
        for (Course course : courses) {
            CourseDetails mapCourse = mapCourse(course);
            response.getCourseDetails().add(mapCourse);
        }
        return response;
    }

    private CourseDetails mapCourse(Course course) {

        CourseDetails courseDetails = new CourseDetails();

        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());

        return courseDetails;
    }
}
