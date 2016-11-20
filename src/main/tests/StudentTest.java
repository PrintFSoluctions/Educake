import io.github.printf.educake.dao.StudentDAO;
import io.github.printf.educake.model.Address;
import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Phone;
import io.github.printf.educake.model.Student;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentTest {

    StudentDAO dao = new StudentDAO();

    @Test
    public void persistStudent(){
        boolean result = true;

        Student student = new Student();
        student.generateRM();
        student.setPerson(getPerson());
        result = dao.persist(student);

        assertTrue(result);
    }

    @Test
    public void qUpdateStudent(){ // O "q" é só pra mudar a sequencia de execução
        boolean result = true;
        try {
            Student student = dao.getLastStudent();
            student.getPerson().setName("Jhones Freitas");
            student.getPerson().getAddress().setCity("Caraguatatuba");
            student.getPerson().getPhones().get(0).setNumber("1238848888");
            dao.update(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(result);
    }

    @Test
    public void removeStudent(){
        boolean result = true;
        try {
            Student student = dao.getLastStudent();
            dao.remove(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(result);
    }

    public Address getAddress(){
        Address address = new Address();

        try {
            address.setCep("11670000");
            address.setState("SP");
            address.setCity("Caraguá");
            address.setDistrict("Jardim do Amanhã");
            address.setStreet("Rua São João");
            address.setHouseNumber("3164");
            address.setComplement("Casa 2");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return address;
    }

    public Person getPerson(){
        Person person = new Person();

        try {
            person.setName("Vitor Silvério");
            person.setBirthdate("29/09/1995");
            person.setCpf("427.866.768-00");
            person.addPhone(new Phone("1238833883"));
            person.addPhone(new Phone("12996363636"));
            person.setAddress(getAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return person;
    }

}
