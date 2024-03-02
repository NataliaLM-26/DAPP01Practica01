package org.uv.dapp01practica01;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAOVenta implements InterfaceDAO<Venta, Long>{
    @Override
    public Venta save(Venta pojo) {
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        session.save(pojo);
        transaction.commit();
        session.close();
        return pojo;    }

    
    
    @Override
    public Venta update(Venta pojo, Long id) {
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        Venta venta=session.get(Venta.class, id);
        if(venta!=null){
            venta.setCliente(pojo.getCliente());
            venta.setDetalleVenta(pojo.getDetalleVenta());
            venta.setFecha(pojo.getFecha());
            venta.setTotal(pojo.getTotal());
            session.update(venta);
            transaction.commit();
        }
        session.close();
        return pojo;    }

    @Override
    public boolean delete(Long id) {
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        boolean resul=false;
        Venta venta=session.get(Venta.class, id);
        if(venta!=null){
            session.delete(venta);
            transaction.commit();
            resul=true;
        }
        session.close();
        return resul;
    }

    @Override
    public Venta findById(Long id) {
        Session session=HibernateUtil.getSession();
        Venta venta=session.get(Venta.class, id);
        session.close();
        return venta;
    }

    @Override
    public List<Venta> findAll() {
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        List<Venta> venta=session.createQuery("From venta e order by e.id").list();
        transaction.commit();
        session.close();
        return venta;
    }



    
}
