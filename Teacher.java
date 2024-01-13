package org.example;

import java.sql.*;

public class Teacher {
    String name;
    Teacher(){
        name="";
    }
    public void addStudentData(Student student){
        Connection connection=connectToDatabase();
        try{
            String query="Insert into attendance.student(id,name,nodays) values("+student.getId()+",'"+student.getName()+"',"+student.getNoDaysAbsent()+");";
            Statement statement=connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void viewStudentData(int id){
        Connection connection=connectToDatabase();
        try {
            String query="select * from attendance.student where id = "+id+";";
            Statement statement=connection.createStatement();
            ResultSet resultSet= statement.executeQuery(query);
            resultSet.next();
            System.out.println("Student name is:"+resultSet.getString("name"));
            System.out.println("Student days of absence:"+resultSet.getInt("nodays"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editStudentData(int id,int nodays){
        Connection connection=connectToDatabase();
        try {
            String query="Update attendance.student set nodays = "+nodays+" where id = "+id+";";
            Statement statement=connection.createStatement();
            boolean resultSet= statement.execute(query);
            if(resultSet){
                System.out.println("updated successfully");
            }
            else System.out.println("wrong data");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void viewAllstudents(){
        Connection connection=connectToDatabase();
        try {
            String query="select * from attendance.student ;";
            Statement statement=connection.createStatement();
            ResultSet resultSet= statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Student name is:" + resultSet.getString("name"));
                System.out.println("Student days of absence:" + resultSet.getInt("nodays"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection connectToDatabase(){
        String url="jdbc:mysql://127.0.0.1:3306/?user=root";
        String user="root";
        String password="yousef11";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection(url,user,password);
            System.out.println("connection is successful  "+url);
            return connection;
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
