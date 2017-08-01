import model.dataaccess.SectionDAO;
import model.dataaccess.ISectionDAO;
import model.entities.Section;
import org.junit.*;


import static main.MainClass.getConfig;
import static org.junit.Assert.*;


public class SectionDAOTest {


    @Test
    public void crudTest() {
        getConfig();
        ISectionDAO sdao = new SectionDAO();

        //----------------------ADD_TEST------------------------------
        Section section = new Section("Electronice");
        sdao.add(section);
        boolean tr = false;
        for (Section sectionTmp : sdao.getAll()) {
            if (sectionTmp.getSectionName().equals("Electronice")) {
                tr = true;
            }
        }
        assertTrue(tr);

        //---------------------UPDATE-TEST--------------------------

        section.setSectionName("Electrocasnice");
        sdao.update(section);
        Section sectionReloadedFromBD = sdao.getByName("Electrocasnice");
        assertTrue(sectionReloadedFromBD.getSectionName().equals("Electrocasnice"));

        //---------------------DELETE-TEST--------------------------
        sdao.delete(section);

        //---------------------SELECT-TEST--------------------------
        assertFalse(sdao.getAll().toString().contains("Electrocasnice"));
    }


}
