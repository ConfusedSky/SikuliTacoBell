import org.sikuli.script.*;
import org.sikuli.basics.Settings;

import org.sikuli.basics.Debug;

import java.util.List;
import java.util.ArrayList;

class Test 
{
    public static void main(String[] args) throws FindFailed, InterruptedException
    {
        Settings.MoveMouseDelay = 0;
        Debug.setDebugLevel(3);
        Screen s = new Screen();

        // Open up the browser
        App.open("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

        // Wait for the browser to load up
        // s.wait(Patterns.Google, 60);
        // Google is different today to tell people to vote. 
        // So just sleeping should be fine
        Thread.sleep(2000);

        // Open up the tacobell site
        s.type("l", KeyModifier.CTRL);
        s.type("tacobell.com");
        s.type(Key.ENTER);

        List<MenuItem> menuItems = new ArrayList<MenuItem>();
        menuItems.add(MenuItem.CheezyPotatoGriller);
        menuItems.add(MenuItem.FiveLayerBurrito);
        menuItems.add(MenuItem.SoftTaco);
        menuItems.add(MenuItem.CheezyPotatoGriller);

        for(MenuItem item : menuItems)
        {
            item.addToCart(s);
        }

        // Calculate the cart total from the menu items
        double total = menuItems.stream().map(MenuItem::getCost).reduce(0d, (a,b) -> a+b);

        // Find the cart in the top right of the screen and extract the cart total from it
        Region right = s.wait(Patterns.Cart, 60).right();
        right.highlight(2);
        // Get the cart total from the screen
        double cartTotal = Double.parseDouble(right.text().substring(1)); 

        if(total != cartTotal)
        {
            System.out.printf("Cart total doesn't match calculated total: %f != %f\n", total, cartTotal);
            return;
        }
        else
        {
            System.out.printf("Cart total matches calculated total: %f == %f\n", total, cartTotal);
        }

        Utils.clearCart(s);

        // Go back to the home screen
        Utils.waitAndClick(s, Patterns.Logo);
    }
}
