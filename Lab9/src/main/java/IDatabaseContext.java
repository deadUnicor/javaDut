import entities.RestaurantMenu;

import java.util.ArrayList;
import java.util.List;

public interface IDatabaseContext{
    int addItem(RestaurantMenu dish);
    ArrayList<RestaurantMenu> getByPrice(double from, double to);
    ArrayList<RestaurantMenu> getOnlyOnSale();
    List<RestaurantMenu> getKgMax();
}
