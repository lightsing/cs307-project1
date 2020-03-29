package DataSource;

import DataSource.models.Comment;

import java.sql.*;

public class PostgreSQLDataSource implements DataSource {
    private Connection conn;

    public PostgreSQLDataSource() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/dianping",
                            "lightsing", "postgres");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public Comment getCommentByShopID(int shopId) throws SQLException {
        PreparedStatement st = conn.prepareStatement("SELECT * FROM comment WHERE shop_id = ? LIMIT 1");
        st.setInt(1, shopId);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return new Comment(rs);
        }
        return null;
    }
}
