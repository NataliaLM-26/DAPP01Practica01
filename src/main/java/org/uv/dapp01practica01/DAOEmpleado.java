package org.uv.dapp01practica01;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAOEmpleado implements InterfaceDAO<PojoEmpleado, Long>{

    @Override
    public PojoEmpleado save(PojoEmpleado pojo) {
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        session.save(pojo);
        transaction.commit();
        session.close();
        return pojo;
    }

    @Override
    public PojoEmpleado update(PojoEmpleado pojo, Long id) {
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        PojoEmpleado empleado=session.get(PojoEmpleado.class, id);
        if(empleado!=null){
            empleado.setNombre(pojo.getNombre());
            empleado.setDireccion(pojo.getDireccion());
            empleado.setTelefono(pojo.getTelefono());
            session.update(empleado);
            transaction.commit();
        }
        session.close();
        return pojo;
    }

    @Override
    public boolean delete(Long id) {
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        boolean resul=false;
        PojoEmpleado empleado=session.get(PojoEmpleado.class, id);
        if(empleado!=null){
            session.delete(empleado);
            transaction.commit();
            resul=true;
        }
        session.close();
        return resul;
    }

    @Override
    public PojoEmpleado findById(Long id) {
        Session session=HibernateUtil.getSession();
        PojoEmpleado empleado=session.get(PojoEmpleado.class, id);
        session.close();
        return empleado;
    }

    @Override
    public List<PojoEmpleado> findAll() {
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        List<PojoEmpleado> empleados=session.createQuery("From empleadotemporal e order by e.id").list();
        transaction.commit();
        session.close();
        return empleados;
    }
    
}
