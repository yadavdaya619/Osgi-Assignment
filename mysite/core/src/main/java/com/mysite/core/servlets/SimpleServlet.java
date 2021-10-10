
package com.mysite.core.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import com.mysite.core.services.impl.StudentImpl;
import com.mysite.core.services.Student;
import com.mysite.core.services.StudentConfig;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysite.core.services.ClassSizeAndMarks;

/**
 * Servlet that writes some sample content into the response. It is mounted for
 * all resources of a specific Sling resource type. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link SlingAllMethodsServlet}.
 */
@Component(service = { Servlet.class })
@SlingServletPaths(value = "/bin/myservlet")
public class SimpleServlet extends SlingSafeMethodsServlet {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private static final long serialVersionUID = 1L;

    @Reference
    ClassSizeAndMarks classSizeAndMarks;

    @Reference
    StudentConfig studentConfig;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("servlet called");



        Student student1 = new Student("John", 101, 22, 90.0f);
        Student student2 = new Student("Paul", 102, 24, 80.5f);
        Student student3 = new Student("Ron", 103, 23, 70.5f);


        int ch = Integer.parseInt(req.getParameter("a"));

        switch (ch){
            case 1: studentConfig.addStudent(student1);
                studentConfig.addStudent(student2);
                studentConfig.addStudent(student3);
                resp.getWriter().write("Adding students: John,Paul and Ron\n");
                break;
            case 2: studentConfig.deleteStudent(student2);
                resp.getWriter().write("Deleting student: Paul\n");
                break;
            case 3: boolean status = studentConfig.isStudentPassed(student3);
                resp.getWriter().write("Is Ron passed?: " + String.valueOf(status));
                break;
            case 4: Student stu = studentConfig.getStudent(student3);
                resp.getWriter().write(String.valueOf(stu));
                break;
            case 5: resp.getWriter().write(String.valueOf(StudentImpl.listOfStudents));
                break;
            default: resp.getWriter().write("\nWaiting");
        }

        LOGGER.info("Switch case ran.");

        resp.getWriter().write("\n\nThe required marks are : " +
                classSizeAndMarks.getdesiredMarks());
        resp.getWriter().write("\nIs class Size limited? : " +
                classSizeAndMarks.isClassSizeLimited(StudentImpl.listOfStudents));



    }

}