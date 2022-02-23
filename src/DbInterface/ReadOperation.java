package DbInterface;

import java.sql.ResultSet;

public class ReadOperation implements IDbOperation {

    private static IDbConnection conn;
    private final String query;

    public ReadOperation(String query) {
        conn = DbConnection.getInstance();
        this.query = query;
    }

    @Override
    public ResultSet execute() {
        return conn.executeQuery(query);
    }
}