package gestionempleados2021;

//Importamos clases
import java.sql.*;
/**
 *
 * @author Adrian Raya Hernandez 
 */
public class ConsultarBD {

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
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM empleados WHERE Salario > 1300");
        
            //Mostrar los resultados
            while(resultado.next()){
                System.out.println(resultado.getString(2) +"\t\t"
                +resultado.getString(3) +"\t\t"
                +resultado.getString(4) +"\t\t"
                +resultado.getFloat(5) +"\n");    
            }
        
            //Liberamos recursos
            resultado.close();
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
