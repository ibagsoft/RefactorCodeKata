package agiledon.codekata.refactoring.elearning.db;

import agiledon.codekata.refactoring.elearning.entity.Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDb {
    private static final String DRIVER_CLASS = "";
    private static final String DB_URL = "";
    private static final String USER = "";
    private static final String PASSWORD = "";
    private static final String SQL_SELECT_PARTS = "select * from course";
    private List<Course> courses = new ArrayList<Course>();

    public void populate() throws Exception {
        Connection c = null;
        try {
            Class.forName(DRIVER_CLASS);
            c = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_SELECT_PARTS);
            while (rs.next()) {
                Course p = new Course(rs.getString("title"), rs.getInt("pricecode"));
                courses.add(p);
            }
        } finally {
            c.close();
        }
    }
}
