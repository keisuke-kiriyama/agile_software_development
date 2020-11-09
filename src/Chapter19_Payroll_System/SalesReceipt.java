package Chapter19_Payroll_System;

public class SalesReceipt {
    private long itsDate;
    private double itsAmount;

    public SalesReceipt(long date, double amount) {
        itsDate = date;
        itsAmount = amount;
    }

    public long GetDate() {
        return itsDate;
    }

    public double GetAount() {
        return itsAmount;
    }
}
