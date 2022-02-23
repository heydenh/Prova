package Model;

public class Admin implements IUtente {

    private String name, surname, psw, email;
    Role role;

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setSurname(String surname) {

    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setPsw(String psw) {

    }

    @Override
    public String getPsw() {
        return psw;
    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public void setRole(Role role) {

    }

}
