package DbInterface;

public class UpdateOperation implements IDbOperation {
    private static IDbConnection conn;
    private final String query;

    public UpdateOperation(String query) {
        conn = DbConnection.getInstance();
        this.query = query;
    }

    @Override
    public Integer execute() {
        int i = conn.executeUpdate(query);
        conn.close();
        return i;
    }
}