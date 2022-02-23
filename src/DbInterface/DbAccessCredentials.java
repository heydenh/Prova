package DbInterface;

public class DbAccessCredentials {
    private static final DbAccessCredentials instance = new DbAccessCredentials();
    private final String schemaName;
    private final String userName;
    private final String pwd;

    private DbAccessCredentials() {
        userName = "root";
        pwd = "12345";
        schemaName = "ekea";
    }

    public static DbAccessCredentials getInstance() {
        return instance;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPwd() {
        return pwd;
    }
}