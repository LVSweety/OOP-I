package model.item;

public class EBook extends AbstractItem{

    private int combinedMinutes;
    private Genre genre;

    public EBook() throws Exception {
        super();
        setCombinedMinutes(0);
        setGenre(Genre.CLASSIC);
        setItemCode();

    }

    public EBook(String title, int howManyCopies, int combinedMinutes, Genre genre) throws Exception {
        super(title, howManyCopies);
        setCombinedMinutes(combinedMinutes);
        setGenre(genre);
        setItemCode();
    }

    @Override
    void setItemCode() throws Exception {
        super.itemCode = super.getId() + "_EBook_" + super.getTitle().replace(" ", "");
    }

    public void setCombinedMinutes(int combinedMinutes) throws Exception {
        if (combinedMinutes >= 0) {
            this.combinedMinutes = combinedMinutes;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: illegal argument");
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getCombinedMinutes() {
        return combinedMinutes;
    }
    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return super.toString() + ":[ " + this.combinedMinutes + "," + this.genre + " ]";
    }

}
