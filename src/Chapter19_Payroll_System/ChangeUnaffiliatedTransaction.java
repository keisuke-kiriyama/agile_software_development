package Chapter19_Payroll_System;

import Chapter17_NullObject_Pattern.Employee;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {
    private int itsMemberId;

    public ChangeUnaffiliatedTransaction(int empId) {
        super(empId);
    }

    @Override
    void RecordMembership(Employee e) {
        Affiliation af = e.GetAffiliation();
        if (af instanceof UnionAffiliation) {
            /*
            ChangeUnAffiliatedTransactionがUnionAffiliationのことを
            知らないといけないため、満足できる設計ではない。
             */
            UnionAffiliation uf = (UnionAffiliation) af;
            int memberId = uf.GetMemberId();
            PayrollDatabase.RemoveUnionMember(memberId);
        }
    }

    @Override
    Affiliation GetAffiliation() {
        return new NoAfiliation();
    }
}
