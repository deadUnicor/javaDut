import entities.RestaurantMenu;
import org.jetbrains.annotations.NotNull;
import java.util.Random;
import java.util.UUID;

public class Main {

    public static void main(final String[] args) throws Exception {
        final IDatabaseContext context = DatabaseContext.getContext();
        
        System.out.println("adding items");
        for(int i = 0; i < 10; i++) {
            context.addItem(CreateEntity());
        }
       
        System.out.println("getting maximum 1kg combo");
        for (var item:context.getKgMax()) {
            System.out.println(item.toString());
        }

        System.out.println("getting by price from 100 to 200");
        for (var item:context.getByPrice(100,200)) {
            System.out.println(item.toString());
        }

        System.out.println("getting only for sale");
        for (var item:context.getOnlyOnSale()) {
            System.out.println(item.toString());
        }
        
    }
    
    private static @NotNull RestaurantMenu CreateEntity(){
        var rand = new Random();
        final var restaurantMenu = new RestaurantMenu();
        restaurantMenu.setId(UUID.randomUUID().toString());
        restaurantMenu.setName(UUID.randomUUID().toString().substring(0,5));
        restaurantMenu.setPrice(rand.nextDouble()*1000 / 3);
        restaurantMenu.setWeight(rand.nextDouble() / 2);
        restaurantMenu.setIs_on_sale(rand.nextBoolean());
        return restaurantMenu;
    }
    
}