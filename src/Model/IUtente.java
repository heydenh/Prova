package Model;

public interface IUtente {
     void setName(String name);
     String getName();

     void setSurname(String surname);
     String getSurname();

     void setPsw(String psw);
     String getPsw();

     void setEmail(String email);
     String getEmail();

     Role getRole();
     void setRole(Role role);


}
