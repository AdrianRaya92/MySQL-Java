package gestionempleados2021;

//Importamos clases
import java.sql.*;
/**
 *
 * @author Adrian Raya Hernandez 
 */

public class InsertarBD {

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
            int filas = 0;
            filas = filas + sentencia.executeUpdate("INSERT INTO empleados VALUES (1, 'Adrián', 'Raya Hernández', 'Desarrollador', 1350)");
            filas = filas + sentencia.executeUpdate("INSERT INTO empleados VALUES (2, 'Francisco', 'Frailes', 'Administrativo', 1000)");
            filas = filas + sentencia.executeUpdate("INSERT INTO empleados VALUES (3, 'María', 'Méndez', 'Desarrollador', 1500)");
            filas = filas + sentencia.executeUpdate("INSERT INTO empleados VALUES (4, 'Melchor', 'Fuentes', 'Analista', 1300)");
            filas = filas + sentencia.executeUpdate("INSERT INTO empleados VALUES (5, 'Cristina', 'Jiménez', 'Gerente', 1700)");
        
            //Comprobamos cuantas filas se han insertado
            System.out.println("Se han insertado " + filas +" filas");
            
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
