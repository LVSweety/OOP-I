package model.item;

public class Magazine extends AbstractItem {

    private int posts;
    private String author;

    public Magazine() throws Exception {
        super();
        setPosts(1);
        setAuthor("Jeff Red");
        setItemCode();
    }

    public Magazine(String title, int howManyCopies, int posts, String author) throws Exception {
        super(title, howManyCopies);
        setPosts(posts);
        setAuthor(author);
        setItemCode();

    }

    @Override
    void setItemCode() throws Exception {
        super.itemCode = super.getId() + "_Magazine_" + super.getTitle().replace(" ", "");;
    }

    public void setPosts(int posts) {
        if (posts > 0) {
            this.posts = posts;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: illegal argument");
    }
    public void setAuthor(String author) {
        if (author != null && author.matches("[A-Z]{1}[a-z]+([ ][A-Z]{1}[a-z]+)+") && author.length() > 5 && author.length() < 200) {
            this.author = author;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: illegal argument");
    }

    public int getPosts() {
        return posts;
    }
    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return super.toString() + ":[ " + this.posts + "," + this.author + " ]";
    }

}
