package model.dataaccess;

import model.entities.*;
import java.util.ArrayList;

public interface IBrandDAO {

    ArrayList<Brand> getAll();
    Brand getById(int id);
    void add(Brand brand);
    void update(int id, Brand brand);
    void delete(int id);
}