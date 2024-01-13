package org.example;
import java.sql.*;
public class Student {
    String name;
    int id;
    int noDaysAbsent;

    public Student(String name, int id, int noDaysAbsent) {
        this.name = name;
        this.id = id;
        this.noDaysAbsent = noDaysAbsent;
    }
    public Student(){
        this.name="";
        this.noDaysAbsent=0;
        this.id=0;
    }
    public void viewAbsentDays(){
        Connection connection=connectToDatabase();


        try{
            String query="Select * from attendance.student \n" +
                    "where name='"+this.name+"' && id="+this.id+";";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            resultSet.next();
            this.noDaysAbsent=resultSet.getInt("nodays");
            System.out.println("days of absence is :"+this.noDaysAbsent);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoDaysAbsent() {
        return noDaysAbsent;
    }

    public void setNoDaysAbsent(int noDaysAbsent) {
        this.noDaysAbsent = noDaysAbsent;
    }
}
