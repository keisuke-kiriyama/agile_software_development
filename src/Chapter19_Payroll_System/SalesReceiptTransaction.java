package Chapter19_Payroll_System;

public class SalesReceiptTransaction implements Transaction {
    private long itsDate;
    private double itsAmount;
    private int itsEmpId;

    public SalesReceiptTransaction(long date, double amount, int empId) {
        itsDate = date;
        itsAmount = amount;
        itsEmpId = empId;
    }

    @Override
    public void Execute() {
        Employee e = PayrollDatabase.GetEmployee(itsEmpId);
        if (e != null) {
            PaymentClassification pc = e.GetClassification();
            if (pc instanceof HourlyClassification) {
                CommissionedCllasification hc = (CommissionedCllasification) pc;
                hc.AddSalesReceipt(new SalesReceipt(itsDate, itsAmount));
            } else {
                throw new RuntimeException("tried to add receipt to non-commissioned employee.");
            }
        } else {
            throw new RuntimeException("No such employee.");
        }
    }
}
