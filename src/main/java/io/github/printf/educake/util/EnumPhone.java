package io.github.printf.educake.util;

/**
 *
 * @author Albino Freitas
 */
public enum EnumPhone {
    FIXO('F'), CELULAR('C');
    
    private char definition;
    
    EnumPhone(char definition){
        this.definition = definition;
    }
    
    public char getDefinition(){
        return this.definition;
    }
}
