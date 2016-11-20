package io.github.printf.educake.util.generators;

import io.github.printf.educake.dao.StudentDAO;
import io.github.printf.educake.model.Student;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public class Generator{

    public String rm(){
        return new RM().generateRm();
    }

    private class RM{

        public String generateRm() {
            Date date = new Date();
            DateFormat systemYear = new SimpleDateFormat("yy");
            DateFormat systemMonth = new SimpleDateFormat("MM");

            String month = systemMonth.format(date);
            String year = systemYear.format(date);

            String rm = year + month + getNextID();
            return rm;
        }

        private String getNextID() {
            String rm;
            Student lastStudent = (new StudentDAO()).getLastStudent();

            if (lastStudent != null) {
                rm = lastStudent.getRm();
                rm = rm.substring(4);

                if (rm.equals("999")) {
                    rm = "001";
                } else {
                    DecimalFormat decimal = new DecimalFormat("000");
                    int temp = Integer.parseInt(rm);
                    rm = decimal.format(++temp);
                }
            } else {
                rm = "001";
            }
            return rm;
        }
    }
}