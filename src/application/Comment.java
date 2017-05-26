package application;

/**
 * Created by Daniel on 26-05-2017.
 */
public class Comment {


    private int id;
    private String comment;


    public Comment(int id, String comment) {
        id           = id;
        this.comment = comment;
    }


    public Comment(String comment) {
        this.comment = comment;
    }

    public Comment(int id) {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}