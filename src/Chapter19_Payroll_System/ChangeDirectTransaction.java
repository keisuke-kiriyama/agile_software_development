package Chapter19_Payroll_System;

public class ChangeDirectTransaction extends ChangeMethodTransaction {
    private int itsBank;
    private int itsAccount;

    public ChangeDirectTransaction(int empId, int bank, int account) {
        super(empId);
        itsBank = bank;
        itsAccount = account;
    }

    @Override
    PaymentMethod GetMethod() {
        return new DirectMethod(itsBank, itsAccount);
    }
}
