import org.sikuli.script.*;

public class Category
{
    public static Category Burritos = new Category(Patterns.Burritos);
    public static Category Tacos = new Category(Patterns.Tacos);

    private Pattern pattern;

    public Pattern getPattern()
    {
        return pattern;
    }

    public Category(Pattern pattern)
    {
        this.pattern = pattern;
    }
}