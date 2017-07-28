import model.dataaccess.SectionDAO;
import model.dataaccess.ISectionDAO;
import model.entities.Section;
import org.junit.*;


import static model.dataaccess.SectionDAO.getConfig;
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
        for (Section Section : sdao.getAll()) {
            if (Section.getSectionName().equals("Electronice")) {
                tr = true;
            }
        }
        assertTrue(tr);

        //---------------------UPDATE-TEST--------------------------
        for (Section Section : sdao.getAll()) {
            if (Section.getSectionName().equals("Electronice")) {
                Section.setSectionName("Electrocasnice");
                sdao.update(Section);
                assertTrue(sdao.getById(Section.getId()).getSectionName().equals("Electrocasnice"));
            }
        }

        //---------------------DELETE-TEST--------------------------
        for (Section Section : sdao.getAll()) {
            if (Section.getSectionName().equals("Electrocasnice")) {
                sdao.delete(Section);
            }
        }

        //---------------------SELECT-TEST--------------------------
        assertFalse(sdao.getAll().toString().contains("Electrocasnice"));
    }


}
