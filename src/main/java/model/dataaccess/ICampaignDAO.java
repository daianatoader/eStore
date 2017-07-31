package model.dataaccess;

import model.entities.*;
import java.util.ArrayList;

public interface ICampaignDAO {

    ArrayList<Campaign> getAll();
    Campaign getById(int id);
    void add(Campaign campaign);
    void update(Campaign campaign);
    void delete(Campaign campaign);

}