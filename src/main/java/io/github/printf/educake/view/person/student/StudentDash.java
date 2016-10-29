package io.github.printf.educake.view.person.student;

import io.github.printf.educake.util.Components.DefaultFormPanel;
import io.github.printf.educake.util.Enums.Division;
import io.github.printf.educake.util.Enums.Flex;
import io.github.printf.educake.view.ThumbPanel;

import java.util.ArrayList;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class StudentDash extends DefaultFormPanel {

  ArrayList<ThumbPanel>  students = new ArrayList<ThumbPanel>();

  public StudentDash(){
    try{
    students.add((ThumbPanel) makeGrid(Division.BODY, Flex.HORIZONTAL)
        .addUnformattedPanel(new ThumbPanel
            ("a321556", "Fulano da Silva", "29/09/1995", "Caraguatatuba")));
    }catch(Exception ex){
      ex.printStackTrace();
    }
  }

}
