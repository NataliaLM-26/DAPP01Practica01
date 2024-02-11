package org.uv.dapp01practica01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miran
 */
public class DAPP01Practica01 {

    public static void main(String[] args) {
        String nombre;
        String direccion;
        int telefono;
        Scanner n= new Scanner(System.in);
        Scanner d= new Scanner(System.in);
        Scanner t= new Scanner(System.in);
        
        Connection con=null;
        PreparedStatement ps=null;
        
        try {
            String url="jdbc:postgresql://localhost:5432/ejemplo";
            String usr="postgres";
            String pwd="laptophp";
            con = DriverManager.getConnection(url,usr,pwd);
            
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO,"Introduzca su nombre:");
            nombre = n.nextLine();
            
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO,"Introduzca su dirección:");
            direccion = d.nextLine();
            
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO,"Introduzca su teléfono:");
            telefono = t.nextInt();
            
            //insert
            String sql="insert into empleadotemporal (nombre,direccion,telefono)"+" values(?,?,?)";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setInt(3, telefono);
            
            ps.executeUpdate();
            
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Se conectó y Se insertó el dato correctamente.");

        } catch (SQLException ex) {
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if(ps!=null)
                    ps.close();
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