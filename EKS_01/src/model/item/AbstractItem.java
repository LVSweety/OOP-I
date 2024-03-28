package model.item;

public abstract class AbstractItem {
    private static int auto_ID = 0;

    private int id;
    private String title;
    protected String itemCode;
    private int howManyCopies;

    public AbstractItem() throws Exception {
        id = auto_ID++;
        setTitle("Generic book");
        setHowManyCopies(1);
    }

    public AbstractItem(String title, int howManyCopies) throws Exception{
        id = auto_ID++;
        setTitle(title);
        setHowManyCopies(howManyCopies);
    }

    abstract void setItemCode() throws Exception;

    public void setHowManyCopies(int howManyCopies) {
        if (howManyCopies >= 0) {
            this.howManyCopies = howManyCopies;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: illegal argument");
    }

    public void setTitle(String title) throws Exception {
        if (title != null && title.matches("[A-Z]{1}[a-z]+([ ][A-Za-z]+)+") && title.length() > 5 && title.length() < 200) {
            this.title = title;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: illegal argument");
    }

    public int getId() {
        return id;
    }
    public int getHowManyCopies() {
        return howManyCopies;
    }
    public String getItemCode() {
        return itemCode;
    }
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "[ " +  this.id + "," + this.title + "," + this.itemCode + "," + this.howManyCopies + " ]";
    }
}
