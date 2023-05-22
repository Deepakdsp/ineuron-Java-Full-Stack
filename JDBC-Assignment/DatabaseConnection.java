package com.Jdbc.application;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DatabaseConnection {

    private final String url = "jdbc:postgresql://localhost:5432/test?currentSchema=public";
    private final String user = "postgres";
    private final String password = "postgres";

    public static void main(String[] argv) throws SQLException, ParseException {
        DatabaseConnection createTableExample = new DatabaseConnection();
        createTableExample.UserMenu();
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    /**
     * this method have menu driven program.
     *
     * @throws SQLException
     * @throws ParseException
     */
    public void UserMenu() throws SQLException, ParseException {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("-- Select Blow Option: --");
            System.out.println("--   1. Read Student : ");
            System.out.println("--   2. Create a New Student :");
            System.out.println("--   3. Update a Student :");
            System.out.println("--   4. Delete a Student :");

            int option = sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch (option) {
                case 1:
                    readStudent();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                default:
                    System.out.println("\nPlease Select a Valid Option\n");
            }

            System.out.println("Do you want to Exit? Y/N");
            char exit = sc.next().charAt(0);
            if (exit == 'Y') break;
        } while (true);
    }

    /**
     * This method will do insert the record the data to student table.
     *
     * @throws SQLException
     * @throws ParseException
     */
    public void createStudent() throws SQLException, ParseException {
        SimpleDateFormat dateBirth = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateJoining = new SimpleDateFormat("MM-dd-yyyy");
        SimpleDateFormat dateMarriage = new SimpleDateFormat("yyyy-MM-dd");

        Scanner sc = new Scanner(System.in);
        Integer studentId, studentAge;
        String studentName, studentAddress, studentGender, dateOfBirth, dateOfJoining, dateOfMarriage;
        System.out.println("Please Provide Student Information: ");
        System.out.println("Please Provide student Id : ");
        studentId = sc.nextInt();
        sc.nextLine();
        System.out.println("Please Provide Name: ");
        studentName = sc.nextLine();
        System.out.println("please Provide Your Age : ");
        studentAge = sc.nextInt();
        sc.nextLine();
        System.out.println("Please Provide Address: ");
        studentAddress = sc.nextLine();
        System.out.println("Please Provide gender: ");
        studentGender = sc.nextLine();

        System.out.println("Please Provide Date Of Birth (dd-MM-yyyy): ");
        dateOfBirth = sc.next();
        java.util.Date bDate = dateBirth.parse(dateOfBirth);
        dateOfBirth = dateBirth.format(bDate);

        System.out.println("Please Provide Date Of joining (MM-dd-yyyy): ");
        dateOfJoining = sc.next();
        java.util.Date jDate = dateJoining.parse(dateOfJoining);
        dateOfJoining = dateJoining.format(jDate);

        System.out.println("Please Provide Date Of Marriage (yyyy-MM-dd): ");
        dateOfMarriage = sc.next();
        java.util.Date mDate = dateMarriage.parse(dateOfMarriage);
        dateOfMarriage = dateMarriage.format(mDate);

//        String sqlInsertQuery = String.format("INSERT INTO student (ID,NAME, AGE, ADDRESS) VALUES (%d,'%s', %d, '%s', '%s',);", studentId, studentName, studentAge, studentAddress);

        Connection conn = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO STUDENT ( ID, NAME, AGE, ADDRESS,GENDER,DOB,DOJ,DOM) " + " values (?, ?, ?, ?, ? ,? ,? ,?)");
            pstmt.setInt(1, studentId);
            pstmt.setString(2, studentName);
            pstmt.setInt(3, studentAge);
            pstmt.setString(4, studentAddress);
            pstmt.setString(5, studentGender);
            pstmt.setDate(6, Date.valueOf(dateOfBirth));
            pstmt.setDate(7, Date.valueOf(dateOfJoining));
            pstmt.setDate(8, Date.valueOf(dateOfMarriage));
            System.out.println("Opened database successfully");
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            pstmt.execute();
            pstmt.close();
            conn.commit();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    /**
     * This method will use to get all data from database.
     */
    public void readStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Provide the Student Name You want to search: ");
        String studentName = sc.nextLine();
        String sqlSelectQuery = String.format("SELECT * FROM student WHERE name = '%s'", studentName);
        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String age = rs.getString("age");
                String address = rs.getString("address");
                System.out.println(id + "," + name + "," + age + "," + address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

    }

    /**
     * This method will use to update the user info.
     */
    public void updateStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Provide Student Name To Check if it's Available or Not ");
        String studentName = sc.nextLine();
        String sqlSelectQuery = String.format("SELECT * FROM student where name = '" + studentName + "'");
        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery)) {
            ResultSet rs = preparedStatement.executeQuery();
            String name = studentDetails(rs);
            System.out.println("Please Provide Student Name to update");
            System.out.println("Provide Student Name Updated: ");
            String studentNameToUpdate = sc.nextLine();
            if (name != null) {
                String sqlUpdateQuery = "UPDATE student SET name = '" + studentNameToUpdate + "'" + "WHERE name='" + name + "'";
                PreparedStatement preparedStatement1 = connection.prepareStatement(sqlUpdateQuery);
                int rowsAffected = preparedStatement1.executeUpdate();
                System.out.println("Record Successfully Updated");
                String sqlSelect = String.format("SELECT * FROM student");
                PreparedStatement prepared = connection.prepareStatement(sqlSelect);
                ResultSet resultSet = prepared.executeQuery();
                studentDetails(resultSet);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    /**
     * This method use to give data from resultSet.
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private String studentDetails(ResultSet rs) throws SQLException {
        String name = null;
        while (rs.next()) {
            int id = rs.getInt("id");
            name = rs.getString("name");
            String age = rs.getString("age");
            String address = rs.getString("address");
            System.out.println("Id  " + "Name   " + "Age  " + "Address  ");
            System.out.println(id + " " + name + " " + age + " " + address);
        }
        return name;
    }

    /**
     * This method use to delete the user based on name.
     */
    public void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Provide Student Name to Delete: ");
        String studentName = sc.nextLine();
        String sqlDeleteQuery = String.format("DELETE FROM student WHERE name = '%s'", studentName);
        try (Connection connection = DriverManager.getConnection(url, user, password); Statement statement = connection.createStatement();) {
            int rowsAffected = statement.executeUpdate(sqlDeleteQuery);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
