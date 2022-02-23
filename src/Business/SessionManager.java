package Business;

import Model.IUtente;

public class SessionManager {
    private static SessionManager instance = new SessionManager();

    private IUtente u;

    public static SessionManager getInstance() {
        return instance;
    }

    public IUtente getU() {
        return u;
    }

    public void setU(IUtente u) {
        this.u = u;
    }

    public void clearUser() {
        u = null;
    }
}
