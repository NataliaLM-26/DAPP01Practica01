package org.uv.dapp01practica01;

import org.hibernate.SessionFactory;

public class mainPrueba {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
    }
    
}
