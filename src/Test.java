import org.sikuli.script.*;
import org.sikuli.basics.Settings;

import org.sikuli.basics.Debug;

import java.util.List;
import java.util.ArrayList;

class Test 
{
    public static void main(String[] args) throws FindFailed, InterruptedException
    {
        //Settings.MoveMouseDelay = 0;
        Debug.setDebugLevel(3);
        Screen s = new Screen();

        String file = s.userCapture().getFile();
        Thread.sleep(2000);
        s.click(file);
        s.text();

        //// Open up the browser
        //App.open("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

        //// Wait for the browser to load up
        //// s.wait(Patterns.Google, 60);
        //// Google is different today to tell people to vote. 
        //// So just sleeping should be find
        //Thread.sleep(2000);

        //// Open up the tacobell site
        //s.type("l", KeyModifier.CTRL);
        //s.type("tacobell.com");
        //s.type(Key.ENTER);

        //List<MenuItem> menuItems = new ArrayList<MenuItem>();
        //menuItems.add(MenuItem.CheezyPotatoGriller);
        //menuItems.add(MenuItem.FiveLayerBurrito);
        //menuItems.add(MenuItem.SoftTaco);
        //menuItems.add(MenuItem.CheezyPotatoGriller);

        //for(MenuItem item : menuItems)
        //{
            //item.addToCart(s);
        //}

        //Utils.waitAndClick(s, Patterns.Cart);
        //double total = menuItems.stream().map(MenuItem::getCost).reduce(0d, (a,b) -> a+b);
        //s.findText("Order Total").highlight(2);
    }
}
