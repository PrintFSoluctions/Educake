/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.printf.educake.view.payment;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a150276x
 */
public class PaymentsDash {

    private PaymentController paymentController = new PaymentController();
    private final ComponentFactory component = new ComponentFactory();
    ArrayList<ThumbPanel> payments = new ArrayList<ThumbPanel>();

    public StudentDash() {
        super("Alunos", "Novo Aluno");
        layout = new MigLayout("insets 4 4 4 4, flowy, w 100%", "grow");
        setBackground(MaterialColor.GREEN_200);
        paymentController.setDash(this);

//        titlePanel.getButton("Novo Pa").addActionListener(e -> MainFrame.goTo("newStudent"));
    }

    public void showAll(List<Student> allStudents) {
        if (allStudents.isEmpty()) {
            body.add(new ThumbPanel("Não há resultados!"));
        }

        allStudents.forEach(student -> {
            ThumbPanel thumb = new ThumbPanel(
                    student.getRm(),
                    student.getPerson().getName() + " " + student.getPerson().getSurname(),
                    String.valueOf(student.getPerson().getBirthdate()));

            thumb.addButton("delete", GoogleMaterialDesignIcons.DELETE);

            thumb.getButtonbyId("delete").addMouseListener(paymentController.delete(student.getIdStudent()));

            body.add(thumb);
        });
    }
}
