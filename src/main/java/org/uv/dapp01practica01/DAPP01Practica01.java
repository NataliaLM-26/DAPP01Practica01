package org.uv.dapp01practica01;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAPP01Practica01 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        PojoEmpleado empleado = new PojoEmpleado();
        empleado.setNombre("elsa");
        empleado.setDireccion("calle elsa");
        empleado.setTelefono("263");
        
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(empleado);
        transaction.commit();
        System.err.println("Se guardó con ID: " + empleado.getId());
        
//        DAOEmpleado metodo = new DAOEmpleado();
//
//        String nombre;
//        String direccion;
//        String telefono;
//        Long id;
//        try (Scanner scan = new Scanner(System.in)) {
//            int option;
//
//            do {
//                Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Menú: \n1. Insertar \n2. Actualizar \n3. Eliminar \n4. Buscar por id \n5. Mostrar todo \n6. Salir");
//                option = scan.nextInt();
//
//                switch (option) {
//                    case 1:
//                        PojoEmpleado empleado = new PojoEmpleado();
//                        scan.nextLine();
//                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su nombre:");
//                        nombre = scan.nextLine();
//                        empleado.setNombre(nombre);
//
//                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su dirección:");
//                        direccion = scan.nextLine();
//                        empleado.setDireccion(direccion);
//
//                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su teléfono:");
//                        telefono = scan.nextLine();
//                        empleado.setTelefono(telefono);
//                        metodo.save(empleado);
//                        break;
//                    case 2:
//                        PojoEmpleado emp = new PojoEmpleado();
//                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su id:");
//                        id = scan.nextLong();
//                        scan.nextLine();
//                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su nombre:");
//                        nombre = scan.nextLine();
//                        emp.setNombre(nombre);
//                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su dirección:");
//                        direccion = scan.nextLine();
//                        emp.setDireccion(direccion);
//                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca su teléfono:");
//                        telefono = scan.nextLine();
//                        emp.setTelefono(telefono);
//
//                        metodo.update(emp, id);
//                        break;
//                    case 3:
//                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca el id que desea eliminar:");
//                        id = scan.nextLong();
//                        metodo.delete(id);
//
//                        break;
//                    case 4:
//                        //findById
//                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca el id que desea mostrar:");
//                        id = scan.nextLong();
//                        if (metodo.findById(id) != null) {
//                            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, metodo.findById(id).toString());
//                        } else {
//                            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "ID inválido");
//
//                        }
//                        break;
//                    case 5:
//                        //Manda a traer al método findAll
//                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, metodo.findAll().toString());
//                        break;
//                    default:
//                        Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "Introduzca una opción válida.");
//                }
//            } while (option != 6);
//        }
    }
}
