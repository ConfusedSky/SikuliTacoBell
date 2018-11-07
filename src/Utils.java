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

        return s.getLastMatch();
    }

    // Find a menu item and click on it
    public static <PS> void addToCart(Screen s, PS pattern) throws FindFailed
    {
        Match match = scrollToFind(s, pattern);
        match.highlight(1);
        match.click(Patterns.AddToOrder);
    }
}