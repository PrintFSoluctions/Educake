import io.github.printf.educake.dao.StudentDAO;
import io.github.printf.educake.model.Address;
import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Phone;
import io.github.printf.educake.model.Student;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public class StudentTest {

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
            person.addPhone(new Phone("1238838105"));
            person.addPhone(new Phone("12996365912"));
            person.setAddress(getAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return person;
    }

    @Test
    public void persistStudent(){
        boolean result = true;
        Student student = new Student();
        StudentDAO dao = new StudentDAO();

        result = dao.persist(student);

        assertTrue(result);
    }

}
