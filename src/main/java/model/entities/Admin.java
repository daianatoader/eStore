package model.entities;
import javax.persistence.*;

@Entity
@Table(name = "admin")

public class Admin {

    public Admin(String username, String PAROLA) {
        this.username = username;
        this.PAROLA = PAROLA;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;

    @Column(name = "username")
    private String username;

    @Column(name = "parola")
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

    public void setUsername( String name ) {

        this.username = name;
    }

    public String getPAROLA() {

        return PAROLA;
    }

    public void setPAROLA( String PAROLA){

        this.PAROLA = PAROLA;
    }
}
