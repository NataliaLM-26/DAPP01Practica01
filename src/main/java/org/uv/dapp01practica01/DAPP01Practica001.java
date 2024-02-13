package org.uv.dapp01practica01;

/**
 *
 * @author miran
 */
public class DAPP01Practica001 {
    public static void main(String[] args) {
        DAOEmpleado dao=new DAOEmpleado();
        
//        PojoEmpleado empleado=new PojoEmpleado();
//        empleado.setNombre("Natalia");
//        empleado.setDireccion("calle 12");
//        empleado.setTelefono("1236");
        
        
//        PojoEmpleado emp=dao.buscarById(6);
//        if(emp!=null)
//            System.out.println(emp.getNombre());
        
        System.out.println(dao.buscarAll());
        
//        boolean res=dao.guardar(empleado);
//        if(res)
//            System.out.println("Se guardó");
//        else
//            System.out.println("No se guardó");
        
    }
    
}
