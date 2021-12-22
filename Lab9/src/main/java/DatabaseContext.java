import entities.RestaurantMenu;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.List;

public class DatabaseContext implements IDatabaseContext {

    private final SessionFactory _ourSessionFactory;
    
    DatabaseContext() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            _ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static DatabaseContext getContext() {
        return new DatabaseContext();
    }
    
    private Session getSession() throws HibernateException {
        return _ourSessionFactory.openSession();
    }

    @Override
    public int addItem(RestaurantMenu dish) {
        try (var session = getSession()) {
            var trans = session.beginTransaction();
            session.save(dish);
            trans.commit();
            session.close();
            return 0;
        }
    }

    @Override
    public ArrayList<RestaurantMenu> getByPrice(double from, double to) throws IllegalArgumentException{
        if(from > to) {
            throw new IllegalArgumentException("from is equal or more that to");
        }
        try (var session = getSession()) {
            var request = session.createQuery("from RestaurantMenu where price between :from and :to");
            request.setParameter("from", from);
            request.setParameter("to", to);
            ArrayList<RestaurantMenu> res =  (ArrayList<RestaurantMenu>)request.list();
            session.close();
            return res;
        }
    }

    @Override
    public ArrayList<RestaurantMenu> getOnlyOnSale() {
        try (var session = getSession()) {
            var request = session.createQuery("from RestaurantMenu where is_on_sale = true");
            ArrayList<RestaurantMenu> res =  (ArrayList<RestaurantMenu>)request.list();
            session.close();
            return res;
        }
    }

    @Override
    public List<RestaurantMenu> getKgMax() {
        try (var session = getSession()) {
            var request = session.createQuery("from RestaurantMenu where weight < 1");
            ArrayList<RestaurantMenu> res =  (ArrayList<RestaurantMenu>)request.list();
            session.close();
            double curWeight = 0;
            int index = 0;

            
            for (var item: res) {
                if(curWeight + item.getWeight() >= 1)
                    break;
                
                curWeight += item.getWeight();
                index ++;
                
            }
            
            return res.subList(0, index);
        }
    }


}
