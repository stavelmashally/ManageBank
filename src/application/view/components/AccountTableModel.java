package application.view.components;

import application.model.BankAccount;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AccountTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Account No","Customer Id","Type", "Creation Date", "Balance"};
    private List<BankAccount> bankAccountList;

    public AccountTableModel(){
    }

    public void setList(List<BankAccount> bankAccounts){
        this.bankAccountList = bankAccounts;
    }

    @Override
    public int getRowCount() {
        if (bankAccountList == null) {
            return 0;
        }
        return bankAccountList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {
            temp = bankAccountList.get(row).getAccountNo();
        }
        else if (col == 1) {
            temp = bankAccountList.get(row).getCustomerId();
        }
        else if (col == 2) {
            temp = bankAccountList.get(row).getAccountType();
        }
        else if (col == 3) {
            temp = bankAccountList.get(row).getCreationDate();
        }
        else if (col == 4) {
            temp = bankAccountList.get(row).getBalance();
        }
        return temp;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }
}
