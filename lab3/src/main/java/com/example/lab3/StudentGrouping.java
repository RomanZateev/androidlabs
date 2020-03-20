package com.example.lab3;

import java.util.List;

public class StudentGrouping implements ParentListItem {
    private List<Student> mStudents;

    @Override
    public List<?> getChildItemList() {
        return mStudents;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
