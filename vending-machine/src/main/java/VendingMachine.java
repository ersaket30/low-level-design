import java.util.List;

//Part 1
//https://javarevisited.blogspot.com/2016/06/design-vending-machine-in-java.html#axzz7eHUGI5NR
//Part 2
//https://javarevisited.blogspot.com/2016/06/java-object-oriented-analysis-and-design-vending-machine-part-2.html#axzz7eHUGI5NR
public interface VendingMachine {
    public long selectItemAndGetPrice(Item item);

    public void insertCoin(Coin coin);

    public List<Coin> refund();

    public Bucket<Item, List<Coin>> collectItemAndChange();

    public void reset();
}


