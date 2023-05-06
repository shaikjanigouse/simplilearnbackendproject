

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;


public class SchoolDatabase {
    // JDBC driver and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/school";
    
    

    // Database credentials
    static final String USER = "root";
    static final String PASS = "Masthani@143";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
          //Developer details
            System.out.println("**Welcome to LearnersAcademy project**");
            System.out.println("Dveloper name: Shaik Jani Gouse");

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute a query to create the tables if they do not exist
            System.out.println("Creating tables in database...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS classes (" +
                    "class_id INT(11) NOT NULL AUTO_INCREMENT," +
                    "class_name VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY (class_id)" +
                    ") ENGINE=InnoDB;";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS subjects (" +
                    "subject_id INT(11) NOT NULL AUTO_INCREMENT," +
                    "subject_name VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY (subject_id)" +
                    ") ENGINE=InnoDB;";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS teachers (" +
                    "teacher_id INT(11) NOT NULL AUTO_INCREMENT," +
                    "teacher_name VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY (teacher_id)" +
                    ") ENGINE=InnoDB;";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS students (" +
                    "student_id INT(11) NOT NULL AUTO_INCREMENT," +
                    "student_name VARCHAR(255) NOT NULL," +
                    "class_id INT(11) NOT NULL," +
                    "PRIMARY KEY (student_id)," +
                    "FOREIGN KEY (class_id) REFERENCES classes(class_id)" +
                    ") ENGINE=InnoDB;";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS class_subjects (" +
                    "class_id INT(11) NOT NULL," +
                    "subject_id INT(11) NOT NULL," +
                    "PRIMARY KEY (class_id, subject_id)," +
                    "FOREIGN KEY (class_id) REFERENCES classes(class_id)," +
                    "FOREIGN KEY (subject_id) REFERENCES subjects(subject_id)" +
                    ") ENGINE=InnoDB;";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS class_teachers (" +
                    "class_id INT(11) NOT NULL," +
                    "teacher_id INT(11) NOT NULL," +
                    "subject_id INT(11) NOT NULL," +
                    "PRIMARY KEY (class_id, teacher_id, subject_id)," +
                    "FOREIGN KEY (class_id) REFERENCES classes(class_id)," +
                    "FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id)," +
                    "FOREIGN KEY (subject_id) REFERENCES subjects(subject_id)" +
                    ") ENGINE=InnoDB;";
            stmt.executeUpdate(sql);

            // Insert data into tables
            System.out.println("Inserting data into tables...");
            sql = "INSERT INTO classes (class_name) VALUES ('Class 1')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO subjects (subject_name) VALUES ('Maths')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO teachers (teacher_name) VALUES ('Teacher 1')";
            stmt.executeUpdate(sql);
         // Close resources
            stmt.close();
            conn.close();

            System.out.println("Finished!");
        }catch(Exception e) {
        	System.out.println("Error in jdbc");
        }
        Scanner sc=new Scanner(System.in);
        
    }
}
    
      
    

           
