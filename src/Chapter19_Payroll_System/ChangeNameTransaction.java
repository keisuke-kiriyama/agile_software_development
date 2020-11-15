package Chapter19_Payroll_System;

public class ChangeNameTransaction extends ChangeEmployeeTransaction {
    private String itsName;

    public ChangeNameTransaction(int empId, String name) {
        super(empId);
        itsName = name;
    }

    @Override
    void Change(Employee e) {
        e.setName(itsName);
    }
}
