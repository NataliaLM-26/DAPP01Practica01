package org.uv.dapp01practica01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        int id;
        Scanner scan = new Scanner(System.in);
        int option;
        Connection con = null;
        PreparedStatement ps = null;
        //conexión a bd
        try {
            String url = "jdbc:postgresql://localhost:5432/libros";
            String usr = "postgres";
            String pwd = "24042002";
            con = DriverManager.getConnection(url, usr, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
        }

        do {
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Menú: \n1. Insertar \n2. Actualizar \n3. Eliminar \n4. Ver \n5. Salir");
            option = scan.nextInt();

            switch (option) {
                case 1:
                     try {
                    scan.nextLine();

                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su nombre:");
                    nombre = scan.nextLine();

                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su dirección:");
                    direccion = scan.nextLine();

                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su teléfono:");
                    telefono = scan.nextInt();

                    //insert
                    String sql = "insert into empleadotemporal (nombre,direccion,telefono)" + " values(?,?,?)";
                    ps = con.prepareStatement(sql);

                    ps.setString(1, nombre);
                    ps.setString(2, direccion);
                    ps.setInt(3, telefono);

                    ps.executeUpdate();

                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Se conectó y Se insertó el dato correctamente.");

                } catch (SQLException ex) {
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case 2:
                    try {
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su id:");
                    id = scan.nextInt();
                    scan.nextLine();
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su nombre:");
                    nombre = scan.nextLine();

                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su dirección:");
                    direccion = scan.nextLine();

                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su teléfono:");
                    telefono = scan.nextInt();

                    String sql = "UPDATE empleadotemporal SET nombre = ?, direccion = ?, telefono = ? WHERE id = ?";
                    ps = con.prepareStatement(sql);

                    ps.setString(1, nombre);
                    ps.setString(2, direccion);
                    ps.setInt(3, telefono);
                    ps.setInt(4, id);

                    ps.executeUpdate();

                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Se actualizó correctamente.");

                } catch (SQLException ex) {
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case 3:
                    try {
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca el id que desea eliminar:");
                    id = scan.nextInt();
                    String sql = "DELETE FROM empleadotemporal WHERE id = ?";
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Se actualizó correctamente.");

                } catch (SQLException ex) {
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case 4: 
                    try {
                    ResultSet resultado = null;
                    String sql = "select * from empleadotemporal";
                    ps = con.prepareStatement(sql);
                    resultado = ps.executeQuery();
                    while (resultado.next()) {
                        int i = resultado.getInt("id");
                        String n = resultado.getString("nombre");
                        String d = resultado.getString("direccion");
                        int t = resultado.getInt("telefono");
                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "ID: {0}, Nombre: {1}, Direccion: {2}, Telefono: {3}", new Object[]{i, n, d, t});
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                default:
                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca una opción válida.");
            }
        } while (option != 5);
        scan.close();
    }
}
