package org.uv.dapp01practica01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miran
 */
public class DAPP01Practica01 {

    public static void main(String[] args) {
        Connection con=null;
        Statement st=null;
        try {
            String url="jdbc:postgresql://localhost:5432/ejemplo";
            String usr="postgres";
            String pwd="laptophp";
            con = DriverManager.getConnection(url,usr,pwd);
            
            //insert
            st= con.createStatement();
            String sql="insert into empleadotemporal (nombre,direccion,telefono)"+" values('Tato','calle 1','1234')";
              st.executeUpdate(sql); 
            
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Se conectó y Se insertó el dato correctamente.");

        } catch (SQLException ex) {
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if(st!=null)
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                if(con!=null)
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);   
            }
        }
        


    }
}
