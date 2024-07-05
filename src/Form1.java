import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Form1 {
    private JButton btnOkCedula;
    public JPanel mainPanel;
    private JTextField consultaCedulatxt;
    private JTextField consultaNombretxt;
    private JButton btnenviarNombre;
    private JTextArea textAreaResultado;
    String url="jdbc:mysql://localhost:3306/estudiantes2024a";
    String user="root";
    String password="123456";
    public Form1() {
        btnOkCedula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try (Connection connection= DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");
                    String query="select * from estudiantes where cedula= '"+ consultaCedulatxt.getText()+"'";
                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    while(resultSet.next()){
                        Double n1 = Double.valueOf( resultSet.getDouble("b1"));
                        Double n2 = Double.valueOf(resultSet.getDouble("b2"));
                        Double nota = (n1 + n2)/2;
                        textAreaResultado.setText(" Nombre: "+resultSet.getString("nombre")+"\n Cedula: "+resultSet.getString("cedula")+"\n B1: "+resultSet.getString("b1")+"\n B2: "+resultSet.getString("b2")+"\n Promedio: "+nota);
                    }
                }catch (SQLException e1){
                    System.out.println(e1);
                }
            }
        });
        btnenviarNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection connection= DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");
                    String query="select * from estudiantes where nombre= '"+ consultaNombretxt.getText()+"'";
                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    while(resultSet.next()){
                        Double n1 = Double.valueOf( resultSet.getDouble("b1"));
                        Double n2 = Double.valueOf(resultSet.getDouble("b2"));
                        Double nota = (n1 + n2)/2;
                        textAreaResultado.setText(" Nombre: "+resultSet.getString("nombre")+"\n Cedula: "+resultSet.getString("cedula")+"\n B1: "+resultSet.getString("b1")+"\n B2: "+resultSet.getString("b2")+"\n Promedio: "+nota);
                    }
                }catch (SQLException e1){
                    System.out.println(e1);
                }

            }
        });
    }
}
