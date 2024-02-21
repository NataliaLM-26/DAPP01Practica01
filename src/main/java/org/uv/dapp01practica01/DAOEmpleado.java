package org.uv.dapp01practica01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOEmpleado implements InterfaceDAO<PojoEmpleado, Long> {

    ConexionDB cx = null;
    Connection con = null;

    public DAOEmpleado() {
        cx = ConexionDB.getInstance();
        con = cx.con;
    }

    @Override
    public PojoEmpleado save(PojoEmpleado empleado) {
        try {
            String sql = "insert into empleadotemporal (nombre,direccion,telefono)" + " values(?,?,?)";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, empleado.getNombre());
            pstm.setString(2, empleado.getDireccion());
            pstm.setString(3, empleado.getTelefono());

            pstm.execute();
            return empleado;
        } catch (SQLException ex) {
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public PojoEmpleado update(PojoEmpleado empleado, Long id) {
        try {
            String sql = "UPDATE empleadotemporal SET nombre = ?, direccion = ?, telefono = ? WHERE id = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setInt(4, empleado.getId());
            pstm.setString(1, empleado.getNombre());
            pstm.setString(2, empleado.getDireccion());
            pstm.setString(3, empleado.getTelefono());
            pstm.setLong(4, id);
            pstm.executeUpdate();
            return empleado;

        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        try {
            String sql = "DELETE FROM empleadotemporal WHERE id = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setLong(1, id);
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public PojoEmpleado findById(Long id) {
        try {
            String sql = "select * from empleadotemporal where id=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setLong(1, id);

            ResultSet reg = pstm.executeQuery();
            if (reg.next()) {
                PojoEmpleado empleado = new PojoEmpleado();
                empleado.setId(reg.getInt(1));
                empleado.setNombre(reg.getString(2));
                empleado.setDireccion(reg.getString(3));
                empleado.setTelefono(reg.getString(4));
                return empleado;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<PojoEmpleado> findAll() {
  List<PojoEmpleado> listaEmpleados = new ArrayList<>();
        try {
            String sql = "select * from empleadotemporal";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet reg = pstm.executeQuery();

            while (reg.next()) {
                PojoEmpleado empleado = new PojoEmpleado();
                empleado.setId(reg.getInt(1));
                empleado.setNombre(reg.getString(2));
                empleado.setDireccion(reg.getString(3));
                empleado.setTelefono(reg.getString(4));
                listaEmpleados.add(empleado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaEmpleados;    }

}
