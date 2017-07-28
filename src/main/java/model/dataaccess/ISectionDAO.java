package model.dataaccess;

import model.entities.*;

import java.util.List;

public interface ISectionDAO {

    List<Section> getAll();

    Section getById(int id);

    void add(Section section);

    void update(Section section);

    void delete(Section section);
}