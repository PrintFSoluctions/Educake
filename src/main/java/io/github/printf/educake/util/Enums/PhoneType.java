package io.github.printf.educake.util.Enums;

/**
 *
 * @author Albino Freitas
 */
public enum PhoneType {
    T, C;

    public static PhoneType getPhoneType(int ord){
        return PhoneType.values()[ord];
    }
}