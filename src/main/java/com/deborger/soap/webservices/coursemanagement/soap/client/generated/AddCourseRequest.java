
package com.deborger.soap.webservices.coursemanagement.soap.client.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CourseInfo" type="{http://deborger.com/courses}CourseInfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "courseInfo"
})
@XmlRootElement(name = "AddCourseRequest")
public class AddCourseRequest {

    @XmlElement(name = "CourseInfo", required = true)
    protected CourseInfo courseInfo;

    /**
     * Gets the value of the courseInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CourseInfo }
     *     
     */
    public CourseInfo getCourseInfo() {
        return courseInfo;
    }

    /**
     * Sets the value of the courseInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourseInfo }
     *     
     */
    public void setCourseInfo(CourseInfo value) {
        this.courseInfo = value;
    }

}
