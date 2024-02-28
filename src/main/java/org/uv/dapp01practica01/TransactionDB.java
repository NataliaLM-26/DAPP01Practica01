package org.uv.dapp01practica01;
import java.sql.Connection;


public abstract class TransactionDB <T>{
    //el tipo T es generic
    //es una agregación
    protected T pojo;
    
    public TransactionDB(T pojo){
        this.pojo=pojo;
    }
    
    public abstract boolean execute(Connection con);
    
    
}