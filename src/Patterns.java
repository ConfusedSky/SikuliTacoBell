import org.sikuli.script.*;

public class Patterns
{
    public static class MenuItems
    {
        public static final Pattern FiveLayer = new Pattern("imgs/5Layer.PNG").exact();
        public static final Pattern CheezyPotatoGriller = new Pattern("imgs/CheezyPotatoGriller.png").exact();
        public static final Pattern SoftTaco = new Pattern("imgs/SoftTaco.png");
    }

    public static final Pattern AddAnother = new Pattern("imgs/AddAnother.PNG");
    public static final Pattern AddToOrder = new Pattern("imgs/AddToOrder.PNG");
    public static final Pattern Burritos = new Pattern("imgs/Burritos.png");
    public static final Pattern Tacos = new Pattern("imgs/Tacos.png");
    public static final Pattern Food = new Pattern("imgs/Food.png");
    public static final Pattern Google = new Pattern("imgs/Google.png");
    public static final Pattern X = new Pattern("imgs/x.png");
    public static final Pattern Cart = new Pattern("imgs/Cart.png");
}