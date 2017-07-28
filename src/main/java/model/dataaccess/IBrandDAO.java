package model.dataaccess;

import model.entities.*;
import java.util.ArrayList;
import java.util.List;

public interface IBrandDAO {

    List<Brand> getAll();
    Brand getById(int id);
    void add(Brand brand);
    void update(int id, Brand brand);
    void delete(int id);
}