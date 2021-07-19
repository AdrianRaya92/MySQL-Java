package gestionempleados2021;

//Importamos clases
import java.sql.*;
/**
 *
 * @author Adrian Raya Hernandez 
 */
public class CrearBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException{

        //Cargamos los Driver
        Class.forName("com.mysql.jdbc.Driver");
        
        //Establecer la conexion con BD
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/gestionempleados2021","root","");
    
        try{
            //Comprobamos si la conexion no está en AutoCommit
            if (!conexion.getAutoCommit() ){
            //La ponemos a true para que este el AutoCommit
            conexion.setAutoCommit( true ); 
            }           
        
            //Preparar sentencia
            Statement sentencia = conexion.createStatement();
    
            //Lanzar la sentencia
            String sql ="CREATE TABLE empleados ("
                + "codEmpleado INT PRIMARY KEY,"
                + "Nombre VARCHAR(40),"
                + "Apellidos VARCHAR(100),"
                + "Puesto VARCHAR(60),"
                + "Salario FLOAT(6, 2));";
        
            sentencia.executeUpdate(sql);
            
            //Liberamos recursos
            sentencia.close();
        }
        catch(Exception e){
            System.out.println(" "+e);
            conexion.rollback(); //Si falla deshacemos la transacción
        } 
        //Liberamos recursos
        conexion.close();
    } 
}
