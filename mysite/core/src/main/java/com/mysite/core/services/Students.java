package com.mysite.core.services;

import java.util.List;

public interface Students {
    boolean isClassLimitReached(List<Student> list);
    int getPassingMarks();
}
