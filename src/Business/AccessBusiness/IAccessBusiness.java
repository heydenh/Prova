package Business.AccessBusiness;

import DAO.IUtenteDAO;
import DAO.UtenteDAO;

public interface IAccessBusiness {
    IUtenteDAO dao = UtenteDAO.getInstance();

    String execute();
}
