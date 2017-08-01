package model.dataaccess;

import model.entities.*;

import java.util.List;

public interface IAdminDAO {

    List<Admin> getAll();
    Admin getById(int id);
    void add(Admin admin);
    void update(Admin admin);
    void delete(Admin admin);

}
