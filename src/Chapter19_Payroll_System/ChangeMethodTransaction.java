package Chapter19_Payroll_System;

public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {
    public ChangeMethodTransaction(int empId) {
        super(empId);
    }

    @Override
    void Change(Employee e) {
        e.SetMethod(GetMethod());
    }

    abstract PaymentMethod GetMethod();
}
