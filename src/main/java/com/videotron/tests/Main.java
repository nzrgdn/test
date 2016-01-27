package com.videotron.tests;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

public class Main {
    List<Service> services = null;
    List<Groupe>  groupes   = null;
    Client from = new Client();
    Client to   = new Client();
    Client clon  = null;

    public static void main(String [] args) {
        new Main().run();
    }

    private void run() {
        init();
        try {
            BeanUtils.copyProperties(to, from);
            clon = (Client)BeanUtils.cloneBean(from);
        }
        catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(from.toString());
        System.out.println(to.toString());
        System.out.println(clon.toString());
        System.out.println("end");
    }

    private void init() {

        services = new ArrayList<Service>();
        groupes   = new ArrayList<Groupe>();

        for (int i=1; i<=5; i++) {
            Service service = new Service(i, i, new Date(), i, i);
            services.add(service);
        }
        for (short i=1; i<=3; i++) {
            Groupe groupe = new Groupe(i, i, new Date());
            groupes.add(groupe);
        }

        from.setCa(1);
        from.setCb("b");
        from.setCc((short)2);
        from.setCd(services);
        from.setCe(groupes);
        from.setCf(true);
        from.setCg("g");
        from.setCh("h");
        from.setCi("i");
        from.setCj("j");
    }
}
