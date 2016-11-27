import io.github.printf.educake.model.Course;
import org.junit.Test;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public class EnumTest {

    @Test
    public void curse(){
        System.out.println(Course.EN.name());
        System.out.println(Course.EN.ordinal());
        System.out.println(Course.EN.toString());
        System.out.println(Course.valueOf("EN"));
        System.out.println(Course.values()[Course.EN.ordinal()]);
        System.out.println(Course.EN.getCourse());
    }

}
