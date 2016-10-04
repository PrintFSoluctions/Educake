
package io.github.printf.educake;

import io.github.printf.educake.model.*;
import io.github.printf.educake.model.dao.BillDAO;
import io.github.printf.educake.model.dao.InstallmentDAO;
import io.github.printf.educake.model.dao.PaymentDAO;
import io.github.printf.educake.util.EasyDate;

import java.util.ArrayList;
import java.util.List;

public class PaymentTest {

    public static void main(String[] args) {

        PaymentDAO paymentDAO =  new PaymentDAO();
        BillDAO billDAO = new BillDAO();
        InstallmentDAO installmentDAO = new InstallmentDAO();

        Person person = new Person("Vitor", "Silvério", EasyDate.toDate(29,9,1995));
        BillType billType = new BillType("Material");
        Bill bill = new Bill(person, billType);

        List<Installment> installments = new ArrayList<>();

        installments.add(new Installment(bill, 200d, EasyDate.toDate(25,  9, 2016)));
        installments.add(new Installment(bill, 100d, EasyDate.toDate(25, 10, 2016)));
        installments.add(new Installment(bill, 100d, EasyDate.toDate(25, 11, 2016)));

        bill.addInstallment(installments.get(0));
        bill.addInstallment(installments.get(1));
        bill.addInstallment(installments.get(2));

        billDAO.persist(bill);

        paymentDAO.persist(new Payment(installments.get(0)));

        System.exit(0);
    }

}
