import org.sikuli.script.*;

public class Utils
{
    // Wait for an image to appear and click it
    // Used for waiting for a page to load before clicking on an element
    public static <PS> void waitAndClick(Screen s, PS pattern) throws FindFailed 
    {
        s.wait(pattern, 60).highlight(1);
        s.click(s.getLastMatch());
    }

    // Scroll down until the menu item is found and return it
    public static <PS> Match scrollToFind(Screen s, PS pattern) throws FindFailed
    {
        s.type(Key.HOME);
        while(s.exists(pattern, 0) == null)
        {
        	s.type(Key.DOWN);
        	s.type(Key.DOWN);
        	s.type(Key.DOWN);
        	s.type(Key.DOWN);
        	s.type(Key.DOWN);
        }

        return s.find(pattern);
    }
        
    public static <PS> void clearCart(Screen s) throws FindFailed
    {
        s.click(Patterns.Cart);
        while(s.exists(Patterns.Hungry) == null)
        {
            waitAndClick(s, Patterns.RemoveFromCart);
        }
    }
}