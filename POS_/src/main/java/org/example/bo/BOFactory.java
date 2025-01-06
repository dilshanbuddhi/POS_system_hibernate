package org.example.bo;

import org.example.bo.custom.IMPL.CustomerBoOMPL;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER
    }


    public SuperBO getBO(BOTypes types){
        switch (types){
            case CUSTOMER :
                return new CustomerBoOMPL();
        }

        return null;
    }
}
