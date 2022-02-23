package DbInterface;

public class DbOperationList {

    public Object executeOperation(IDbOperation dbOperation) {
        return dbOperation.execute();
    }
}