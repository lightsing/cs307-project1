package DataSource.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Comment {
    /**
     * create table comment (
     * id serial not null
     * constraint comments_pk
     * primary key,
     * user_id varchar,
     * rank integer default 0 not null,
     * content text not null,
     * shop_id integer
     * constraint comments_shop_cache_id_fk
     * references shop
     * on update cascade on delete cascade
     * );
     */
    private int id;
    private String user_id;
    private int rank;
    private String content;
    private int shop_id;

    public Comment(int id, String user_id, int rank, String content, int shop_id) {
        this.id = id;
        this.user_id = user_id;
        this.rank = rank;
        this.content = content;
        this.shop_id = shop_id;
    }

    public Comment(ResultSet rs) throws SQLException {
        this.id = rs.getInt(1);
        this.user_id = rs.getString(2);
        this.rank = rs.getInt(3);
        this.content = rs.getString(4);
        this.shop_id = rs.getInt(5);
    }

    public int getId() {
        return id;
    }

    public String getUser_id() {
        return user_id;
    }

    public int getRank() {
        return rank;
    }

    public String getContent() {
        return content;
    }

    public int getShop_id() {
        return shop_id;
    }
}
