package Business.AccessBusiness;

import DAO.IUtenteDAO;
import DAO.UtenteDAO;
import Model.Role;

import static Business.Util.Md5.getMd5;

public class SignUpAccess implements IAccessBusiness {

    private String email, psw, name, surname;
    private Role role;

    public SignUpAccess(String email, String psw, String name, String surname, Role role) {
        this.email = email;
        this.psw = getMd5(psw);
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    @Override
    public String execute() {
        String result="Errore";
        IUtenteDAO dao= new UtenteDAO();
        if(dao.userExists(email)){
            result="L'utente è già registrato";
            return result;
        }
    }
}
