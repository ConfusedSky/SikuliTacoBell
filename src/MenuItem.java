import org.sikuli.script.*;

public class MenuItem
{
    public static MenuItem FiveLayerBurrito = new MenuItem(Patterns.MenuItems.FiveLayer, Category.Burritos, 1.99d);
    public static MenuItem CheezyPotatoGriller = new MenuItem(Patterns.MenuItems.CheezyPotatoGriller, Category.Burritos, 1.89d);
    public static MenuItem SoftTaco = new MenuItem(Patterns.MenuItems.SoftTaco, Category.Tacos, 1.29d);

    private Category category;
    private Pattern pattern;
    private double cost;

    private static Category prevCategory = null;

    public MenuItem(Pattern pattern, Category category, double cost)
    {
        this.category = category;
        this.pattern = pattern;
        this.cost = cost;
    }

    public Category getCategory()
    {
        return category;
    }

    public Pattern getPattern()
    {
        return pattern;
    }

    public double getCost()
    {
        return cost;
    }

    public void addToCart(Screen s) throws FindFailed, InterruptedException
    {
        // If we aren't on the right category page go to the correct category page
        if(category != prevCategory)
        {
            Utils.waitAndClick(s, Patterns.Food);
            Utils.waitAndClick(s, category.getPattern());
            prevCategory = category;
        }

        Match match = Utils.scrollToFind(s, pattern);
        match.highlight(1);
        match.click(Patterns.AddToOrder);

        // Close the cart because it can get in the way of detections
        Utils.waitAndClick(s, Patterns.X);
        // Sleep to prevent the adding to cart from getting in the way of the next movement
        Thread.sleep(2000);
    }
}