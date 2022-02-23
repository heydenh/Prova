package DAO;

import DbInterface.*;
import Model.Admin;
import Model.Customer;
import Model.IUtente;
import Model.Manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtenteDAO implements IUtenteDAO {

    private static IUtenteDAO instance = new UtenteDAO();
    private IDbConnection conn = DbConnection.getInstance();
    private IUtente utente;

    public UtenteDAO() {
        utente = null;
    }

    public static IUtenteDAO getInstance() {
        return instance;
    }


    prova;

    @Override
    public IUtente findById(String email) {
        String sql = "SELECT * FROM ekea.user WHERE user.email='" + email + "';";
        DbOperationList opList = new DbOperationList();
        IDbOperation readOp = new ReadOperation(sql);
        ResultSet rs = (ResultSet) opList.executeOperation(readOp);
        try {
            rs.next();
            if (rs.getRow() == 1) {
                switch (rs.getString("role")) {
                    case "Admin":
                        utente = new Admin();
                        break;
                    case "Manager":
                        utente = new Manager();
                        break;
                    default:
                        utente = new Customer();
                        break;
                }
                utente.setName(rs.getString("name"));
                utente.setSurname(rs.getString("surname"));
                utente.setEmail(rs.getString("email"));
                utente.setPsw(rs.getString("password"));
                return utente;
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (NullPointerException e) {
            System.out.println("Resultset: " + e.getMessage());
        } finally {
            conn.close();
        }
        return null;
    }

    @Override
    public ArrayList<IUtente> findAll() {
        String sql = "SELECT * FROM Booking.Customer;";
        DbOperationList opList = new DbOperationList();
        IDbOperation readOp = new ReadOperation(sql);
        ResultSet rs = (ResultSet) opList.executeOperation(readOp);
        ArrayList<IUtente> utenti = new ArrayList<>();
        try {
            while (rs.next()) {
                switch (rs.getString("role")) {
                    case "Admin":
                        utente = new Admin();
                        break;
                    case "Manager":
                        utente = new Manager();
                        break;
                    default:
                        utente = new Customer();
                        break;
                }
                utente.setName(rs.getString("Nome"));
                utente.setSurname(rs.getString("Cognome"));
                utente.setEmail(rs.getString("Email"));
                utenti.add(utente);
            }
            return utenti;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (NullPointerException e) {
            System.out.println("Resultset: " + e.getMessage());
        } finally {
            conn.close();
        }
        return null;
    }

    public int removeById(String email) {
        String sql = "DELETE FROM ekea.user WHERE Email = '" + email + "';";
        DbOperationList opList = new DbOperationList();
        IDbOperation insertOp = new UpdateOperation(sql);
        return (int) opList.executeOperation(insertOp);
    }


    public int addUtente(IUtente u) {
        String r = "Customer";
        switch (u.getRole()) {
            case ADMIN:
                r = "Admin";
                break;
            case MANAGER:
                r = "Manager";
                break;
        }
        String sql = "INSERT INTO ekea.user (email,password,name,surname,role) VALUES('" + u.getEmail() + "','" + u.getPsw() + "','" + u.getName() + "','" + u.getSurname() + "','" + r + "');";
        DbOperationList opList = new DbOperationList();
        IDbOperation insertOp = new UpdateOperation(sql);
        return (int) opList.executeOperation(insertOp);
    }

    @Override
    public boolean userExists(String email) {
        if (findById(email) != null)
            return true;
        return false;
    }

    @Override
    public boolean credentialsOk(String email, String psw) {
        String sql = "SELECT count(*) AS C from user WHERE user.email='" + email + "' AND user.password='" + psw + "';";
        DbOperationList opList = new DbOperationList();
        IDbOperation checkOP = new ReadOperation(sql);
        ResultSet rs = (ResultSet) opList.executeOperation(checkOP);

        try {
            rs.next();
            if (rs.getRow() == 1 && rs.getInt("C") == 1)
                return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            conn.close();
        }
        return false;
    }

    @Override
    public IUtente getUserData(String email) {
        String sql = "SELECT name, surname, email, password, role FROM user WHERE user.email='" + email + "'";
        DbOperationList opList = new DbOperationList();
        IDbOperation readOp = new ReadOperation(sql);
        ResultSet rs = (ResultSet) opList.executeOperation(readOp);
        try {
            rs.next();
            if (rs.getRow() == 1) {
                switch (rs.getString("role")) {
                    case "Admin":
                        utente = new Admin();
                        break;
                    case "Manager":
                        utente = new Manager();
                        break;
                    default:
                        utente = new Customer();
                        break;
                }
                utente.setName(rs.getString("name"));
                utente.setSurname(rs.getString("surname"));
                utente.setEmail(rs.getString("email"));
                utente.setPsw(rs.getString("password"));
                return utente;
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (NullPointerException e) {
            System.out.println("Resultset: " + e.getMessage());
        } finally {
            conn.close();
        }
        return null;
    }
}