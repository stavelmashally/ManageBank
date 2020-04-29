package application.view;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AccountTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Account No","Name","Type", "Creation Date", "Amount"};
    private List<Account> accountList;

    public AccountTableModel(){
    }

    public void setList(List<Account> accounts){
        this.accountList = accounts;
    }

    @Override
    public int getRowCount() {
        int size;
        if (accountList == null) {
            size = 0;
        }
        else {
            size = accountList.size();
        }
        return size;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {
            temp = accountList.get(row).getAccountNo();
        }
        else if (col == 1) {
            temp = accountList.get(row).getName();
        }
        else if (col == 2) {
            temp = accountList.get(row).getType();
        }
        else if (col == 3) {
            temp = accountList.get(row).getCreationDate();
        }
        else if (col == 4) {
            temp = accountList.get(row).getAmount();
        }
        return temp;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }
}
