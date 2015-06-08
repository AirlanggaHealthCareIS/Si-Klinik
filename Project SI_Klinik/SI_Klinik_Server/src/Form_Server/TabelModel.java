/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Form_Server;
import Form_Server.node;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author tinot
 */
public class TabelModel extends AbstractTableModel{
    private List<node> list = new ArrayList<node>();
    
    public TabelModel(){
    
    }
    
    public void insert(node n){
        list.add(n);
        fireTableDataChanged();
        }

    public void update(int row,node n){
        list.set(row, n);
        fireTableDataChanged();
    }

    public void delete(int row){
        list.remove(row);
        fireTableDataChanged();
    }
    
    public node get(int row){
        return list.get(row);
    }
    
    public void setData(List<node> list){
        this.list = list;
        fireTableDataChanged();
    }
    
     @Override
     public String getColumnName(int column) {
        switch(column){
            case 0 : return "No";
            case 1 : return "IP Address";
            case 2 : return "MAC Address";
            case 3 : return "Waktu";
            default: return null;
        }
    }
     
     public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 4;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return list.get(rowIndex).no;
            case 1 : return list.get(rowIndex).IpAddress;
            case 2 : return list.get(rowIndex).macAddress;
            case 3 : return list.get(rowIndex).waktu;                
            default : return null;
        }
    }
}
