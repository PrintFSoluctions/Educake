/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import io.github.printf.educake.util.Enums.State;
import org.junit.Test;

import java.util.Map;

/**
 *
 * @author albinof
 */
public class Teste {

    @Test
    public void testaFalsoComFalso() throws Exception {
        Map<String, String> allStates = State.getAllStates();
        allStates.forEach(
        		(k, v) -> System.out.println(k+" : "+v)
        );
    }


}
