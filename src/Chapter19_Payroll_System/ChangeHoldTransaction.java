package Chapter19_Payroll_System;

public class ChangeHoldTransaction extends ChangeMethodTransaction {
    private String itsAddress;

    public ChangeHoldTransaction(int empId, String address) {
        super(empId);
        itsAddress = address;
    }

    @Override
    PaymentMethod GetMethod() {
        return new HoldMethod(itsAddress);
    }
}
