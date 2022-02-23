package DbInterface;

import java.sql.ResultSet;

public interface IDbConnection {
    ResultSet executeQuery(String sql);

    int executeUpdate(String sql);

    void close();
}
