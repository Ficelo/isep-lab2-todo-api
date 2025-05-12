package org.isep.cleancode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo {

    // this Todo class should be completed to achieve Step 1

    private String name;
    private String dueDate = null;

    public Todo(String name, String dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
