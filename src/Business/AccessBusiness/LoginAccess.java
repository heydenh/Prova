package Business.AccessBusiness;

import Business.SessionManager;
import DAO.IUtenteDAO;
import DAO.UtenteDAO;
import Model.IUtente;

import static Business.Util.Md5.getMd5;

public class LoginAccess implements IAccessBusiness {
    private String email, psw;

    public LoginAccess(String email, String psw) {
        this.email = email;
        this.psw = getMd5(email);
    }


    @Override
    public String execute() {
        String result = "Errore";
        IUtenteDAO dao = new UtenteDAO();
        if (!dao.userExists(email)) {
            result = "L'utente non esiste";
            return result;
        }

        if(!dao.credentialsOk(email, psw)) {
            result = "Password errata";
            return result;
        }

        IUtente utente = dao.getUserData(email);
        if(utente!=null){
            result="Accesso effettuato. Benvenuto" + utente.getName();
            SessionManager.getInstance().setU(utente);
        }
        return result;
    }
}
