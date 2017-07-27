package model.entities;
import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id @GeneratedValue
    @Column(name = "ID")
    private int ID;

    @Column(name = "username")
    private String username;

    @Column(name = "PAROLA")
    private String PAROLA;

    public Admin() {}
    public int getID() {
        return ID;
    }
    public void setID( int ID ) {
        this.ID = ID;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername( String usermane ) {
        this.username = username;
    }
    public String getPAROLA() {
        return PAROLA;
    }
    public void setPAROLA( String PAROLA){
        this.PAROLA = PAROLA;
    }
}
