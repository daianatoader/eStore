package model.dataaccess;

import model.entities.*;

import java.util.ArrayList;
import java.util.List;

public interface IBrandDAO {

    List<Brand> getAll();

    Brand getById(int id);

    Brand getByName(String name);

    void add(Brand brand);

    void update(Brand brand);

    void delete(Brand brand);
}