package com.mysite.core.services.configurations;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Student Configuration")
public @interface ClassConfigurationService {

    @AttributeDefinition(name = "Number of Allowed Students", required = true)
    int noOfAllowedStudents() default 3;

    @AttributeDefinition(name = "Required marks", required = true)
    int requiredMarks() default 21;

}