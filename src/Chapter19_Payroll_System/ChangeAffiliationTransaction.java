package Chapter19_Payroll_System;

import Chapter17_NullObject_Pattern.Employee;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {

    public ChangeAffiliationTransaction(int empId) {
        super(empId);
    }

    @Override
    void Change(Employee e) {
        RecordMembership(e);
        e.SetAffiliation(GetAffiliation());
    }

    abstract void RecordMembership(Employee e);

    abstract Affiliation GetAffiliation();
}
