package Chapter19_Payroll_System;

public class ChangeMailTransaction extends ChangeMethodTransaction {
    private String itsAddress;

    public ChangeMailTransaction(int empId, String address) {
        super(empId);
        itsAddress = address;
    }

    @Override
    PaymentMethod GetMethod() {
        return MailMethod(address);
    }
}
