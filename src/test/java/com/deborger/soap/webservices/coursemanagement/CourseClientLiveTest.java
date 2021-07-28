package com.deborger.soap.webservices.coursemanagement;

import static org.junit.Assert.assertEquals;

import com.deborger.soap.webservices.coursemanagement.security.WSSecurityHeaderSOAPHandler;
import com.deborger.soap.webservices.coursemanagement.soap.client.generated.CoursePort;
import com.deborger.soap.webservices.coursemanagement.soap.client.generated.CoursePortService;
import com.deborger.soap.webservices.coursemanagement.soap.client.generated.GetAllCourseDetailsRequest;
import com.deborger.soap.webservices.coursemanagement.soap.client.generated.GetCourseDetailsRequest;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;
import java.util.*;

public class CourseClientLiveTest {

    private static CoursePort coursePort;

    @BeforeClass
    public static void setup() {
        CoursePortService service = new CoursePortService();
        coursePort = service.getCoursePortSoap11();
        addSecurityHeader(coursePort,"user","password");
    }

    public static void addSecurityHeader(CoursePort coursePort, String user, String password) {
        // This is the block that apply the Ws Security to the request
        BindingProvider bindingProvider = (BindingProvider) coursePort;
        @SuppressWarnings("rawtypes")
        List<Handler> handlerChain = new ArrayList<Handler>();
        handlerChain.add(new WSSecurityHeaderSOAPHandler(user,password));
        bindingProvider.getBinding().setHandlerChain(handlerChain);
    }

    @Test
    public void givenCourseServive_whenCourseId1_thenCourseNameSpringBootBeginners() {
        GetCourseDetailsRequest request = new GetCourseDetailsRequest();
        request.setId(1);
        assertEquals("Spring Boot Beginners", coursePort.getCourseDetails(request).getCourseDetails().getName());
    }

    @Test
    public void givenCoourseService_whenGetAll_then4 () {
        GetAllCourseDetailsRequest request = new GetAllCourseDetailsRequest();
        assertEquals(4,coursePort.getAllCourseDetails(request).getCourseDetails().size());
    }





}
