package io.github.printf.educake.model;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */

public enum Course {
    EN("Inglês"), ES("Espanhol"), PT("Português");

    public String course;
    Course(String lang) {
        course = lang;
    }

    public String getCourse() {
        return course;
    }
}
