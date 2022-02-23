package DAO;

import Model.IUtente;

import java.util.ArrayList;

public interface IUtenteDAO {
    IUtente findById(String email);

    ArrayList<IUtente> findAll();

    int addUtente(IUtente u);

    int removeById(String email);

    boolean userExists(String email);

    boolean credentialsOk(String email, String psw);

    IUtente getUserData(String email);
}
