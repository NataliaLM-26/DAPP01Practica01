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
        DAOEmpleado metodo = new DAOEmpleado();

        String nombre;
        String direccion;
        String telefono;
        int id;
        Scanner scan = new Scanner(System.in);
        int option;

        do {
            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Menú: \n1. Insertar \n2. Actualizar \n3. Eliminar \n4. Buscar por id \n5. Mostrar todo \n6. Salir");
            option = scan.nextInt();

            switch (option) {
                case 1:
                    PojoEmpleado empleado = new PojoEmpleado();
                    scan.nextLine();
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su nombre:");
                    nombre = scan.nextLine();
                    empleado.setNombre(nombre);

                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su dirección:");
                    direccion = scan.nextLine();
                    empleado.setDireccion(direccion);

                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su teléfono:");
                    telefono = scan.nextLine();
                    empleado.setTelefono(telefono);
                    boolean res = metodo.guardar(empleado);
                    if (res) {
                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Se guardó correctamente");
                    } else {
                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "No se guardó");
                    }
                    break;
                case 2:
                    PojoEmpleado emp = new PojoEmpleado();
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su id:");
                    id = scan.nextInt();
                    scan.nextLine();
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su nombre:");
                    nombre = scan.nextLine();
                    emp.setNombre(nombre);
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su dirección:");
                    direccion = scan.nextLine();
                    emp.setDireccion(direccion);
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su teléfono:");
                    telefono = scan.nextLine();
                    emp.setTelefono(telefono);

                    boolean re = metodo.modificar(emp, id);
                    if (re) {
                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Se guardó correctamente");
                    } else {
                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "No se actualizó correctamente.");
                    }
                    break;
                case 3:
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca el id que desea eliminar:");
                    id = scan.nextInt();
                    metodo.eliminar(id);

                    break;
                case 4:
                    //findById
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca el id que desea mostrar:");
                    id = scan.nextInt();
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, metodo.buscarById(id).toString());

                    break;
                case 5:
                    //Manda a traer al método findAll
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, metodo.buscarAll().toString());
                    break;
                default:
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca una opción válida.");
            }
        } while (option != 6);
        scan.close();
    }
}
