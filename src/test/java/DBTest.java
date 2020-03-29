import DataSource.FileIODataSource;
import DataSource.PostgreSQLDataSource;
import DataSource.models.Comment;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;


public class DBTest {

    @Test
    void fileGetCommentByShopId() {
        FileIODataSource fileIODataSource = new FileIODataSource("./res");

        try {
            Comment comment = fileIODataSource.getCommentByShopID(119);
            System.out.printf("Comment:%d %d\n", comment.getId(), comment.getShop_id());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void dbGetCommentByShopId() {
        PostgreSQLDataSource postgreSQLDataSource = new PostgreSQLDataSource();
        try {
            Comment comment = postgreSQLDataSource.getCommentByShopID(119);
            System.out.printf("Comment:%d %d\n", comment.getId(), comment.getShop_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
