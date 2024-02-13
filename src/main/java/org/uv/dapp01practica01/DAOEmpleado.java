package org.uv.dapp01practica01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOEmpleado {
    public boolean guardar(PojoEmpleado empleado){
        try{
            String url = "jdbc:postgresql://localhost:5432/ejemplo";
            String usr = "postgres";
            String pwd = "laptophp";
            Connection con = DriverManager.getConnection(url, usr, pwd);

            String sql="insert into empleadotemporal (nombre,direccion,telefono)" + " values(?,?,?)";

            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1, empleado.getNombre());
            pstm.setString(2, empleado.getDireccion());
            pstm.setString(3, empleado.getTelefono());

            pstm.execute();
            return true;
        } catch (SQLException ex){
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean eliminar(){
        return false;
    }
    
    public boolean modificar(){
        return false;
    }
    
    
    
    public PojoEmpleado buscarById(int id){
        try{
            String url = "jdbc:postgresql://localhost:5432/ejemplo";
            String usr = "postgres";
            String pwd = "laptophp";
            
            String sql="select * from empleadotemporal where id=?";
            Connection con = DriverManager.getConnection(url, usr, pwd);
            
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setInt(1, id);

            ResultSet reg=pstm.executeQuery();
            if(reg.next()){
                PojoEmpleado empleado= new PojoEmpleado();
                empleado.setId(reg.getInt(1));
                empleado.setNombre(reg.getString(2));
                empleado.setDireccion(reg.getString(3));
                empleado.setTelefono(reg.getString(4));
                return empleado;
            }
            return null;
        } catch (SQLException ex){
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }
    
    public List<PojoEmpleado> buscarAll(){
        List<PojoEmpleado> listaEmpleados = new ArrayList<>();
        try{
            String url = "jdbc:postgresql://localhost:5432/ejemplo";
            String usr = "postgres";
            String pwd = "laptophp";
            Connection con = DriverManager.getConnection(url, usr, pwd);
            
            String sql="select * from empleadotemporal";
            PreparedStatement pstm=con.prepareStatement(sql);
            ResultSet reg=pstm.executeQuery();
            
            while(reg.next()){
                PojoEmpleado empleado= new PojoEmpleado();
                empleado.setId(reg.getInt(1));
                empleado.setNombre(reg.getString(2));
                empleado.setDireccion(reg.getString(3));
                empleado.setTelefono(reg.getString(4));
                listaEmpleados.add(empleado);
            }
        } catch (SQLException ex){
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
        }
//        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Lista de Empleados:");
//        for (PojoEmpleado empleado : listaEmpleados) {
//            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, empleado.toString());
//        }
        return listaEmpleados;
    }
    
}
