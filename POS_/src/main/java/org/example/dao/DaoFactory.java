package org.example.dao;

import org.example.dao.custom.IMPL.CustomerDAOIMPL;

public class DaoFactory {
    public static DaoFactory daoFactory;

    private DaoFactory(){

    }

    public static DaoFactory getdaoFactory(){
        return (daoFactory == null) ? daoFactory = new DaoFactory() : daoFactory;
    }



    public enum DaoTypes{
        CUSTOMER
    }
    public SuperDAO getDao(DaoTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER :
                return new CustomerDAOIMPL();
        }
        return null;
    }

}
