/*CON ESTA CLASE NOS CONECTAMOS A LA BASE DE DATOS DE MYSQL*/
package base.de.datos.mantenimiento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
        
/**
 *
 * @author Noktuapc
 */
public class Conexion {
    Connection conn = null;
    Statement st = null;
    public Conexion() {
        try{
           Class.forName("com.mysql.jdbc.Driver");
           conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/agencia_mantenimiento","root","");
           st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           if(conn!= null){
               System.out.println("Conexion establecida");
           }
        }catch(ClassNotFoundException | SQLException e ){
            System.out.println("Error al conectar" + e);
        }
    }

    //DESCONECTAR DE LA BASE DE DATOS
    public void desconectar(){
         conn=null;
         if(conn==null){
             System.out.print("Conexion terminada");
         }
    }
     
    //FUNCION PARA INSERTAR Y ACTUALIZAR
    public void insertaryact (String query){
         try{
             PreparedStatement ps= conn.prepareStatement(query);
             ps.execute();
             
             if(query.startsWith("insert")||query.startsWith("Insert")||query.startsWith("INSERT")){
                 JOptionPane.showMessageDialog(null,"DATOS INSERTADOS");
             }else{
                 JOptionPane.showMessageDialog(null,"DATOS ACTUALIZADOS");
             } 
         }catch(SQLException e){
             System.out.println(e.getErrorCode());
             System.out.println(e.getMessage());
             if(e.getErrorCode()==1062){
                 JOptionPane.showMessageDialog(null, "ID Repetida","ERROR",JOptionPane.ERROR_MESSAGE);
             }else if(e.getErrorCode()==1366||e.getErrorCode()==1406){
                 JOptionPane.showMessageDialog(null, "Agruege un ID VALIDO","ERROR",JOptionPane.ERROR_MESSAGE);
             }else if(e.getErrorCode()==1292){
                 JOptionPane.showMessageDialog(null, "Formato de FECHA INCORRECTO","ERROR",JOptionPane.ERROR_MESSAGE);
             }
         }
    }
     
     //FUNCION PARA ELIMINAR
     public void eliminar(String query){         
         if(JOptionPane.showConfirmDialog(null,"Desea eliminar el sig. Registro?","Eliminar"
           ,JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)==JOptionPane.YES_OPTION){
             try {
                 PreparedStatement ps= conn.prepareStatement(query);
                 ps.executeUpdate();
                 JOptionPane.showMessageDialog(null,"Registro Eliminado!");
             } catch (SQLException e) {
                 System.out.println(e.getErrorCode());
                 System.out.println(e.getMessage());
                 
             }
         }                  
     }
     
     //FUNCION PARA LA TABLA
    public void tabla (String query, TableModel tabla){
        try{
            Statement st= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsm = rs.getMetaData();
            ArrayList <Object[]> data = new ArrayList<>();
            Object[] columna = new Object[rsm.getColumnCount()];
            DefaultTableModel modelo;
            modelo = (DefaultTableModel)tabla;
            modelo.setRowCount(0);
            modelo.setColumnCount(0);
            for (int t=1;t<=columna.length;t++){
                modelo.addColumn(rsm.getColumnName(t));
            }
            while(rs.next()){
                Object[] filas = new Object[rsm.getColumnCount()];                
                for (int i =0;i<filas.length;i++){
                    filas[i] = rs.getObject(i+1);
                }
                data.add(filas);
            }
            for (int j=0;j<data.size();j++){
                modelo.addRow(data.get(j));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
