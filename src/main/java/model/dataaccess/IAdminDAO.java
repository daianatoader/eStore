package model.dataaccess;

import model.entities.*;
import java.util.ArrayList;

public interface IAdminDAO {

    ArrayList<Admin> getAll();
    Admin getById(int id);
    void add(Admin admin);
    void update(Admin admin);
    void delete(Admin admin);

}
