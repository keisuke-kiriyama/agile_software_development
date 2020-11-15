package Chapter19_Payroll_System;

import java.util.Calendar;
import java.util.Dictionary;

public class PaydayTransaction implements Transaction {
    Calendar itsPayDate;
    Dictionary<Integer, Paycheck> itsPaycheks = [];

    public PaydayTransaction(Calendar date) {
        itsPayDate = date;
    }

    @Override
    public void Execute() {
        List<Integer> empIds = PayrollDatabase.GetAllEmployeeIds();
        for (int empId : empIds) {
            Employee e = PayrollDatabase.GetEmployee(empId);
            if (e.isPayDate(itsPayDate)) {
                Paycheck pc = new Paycheck(e.GetPayPeriodStartDate(itsPayDate), itsPayDate);
                itsPaychecks.put(empId, pc);
                e.Payday(pc);
            }
        }
    }
}
