/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;

import database.entity.Pasien;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */
public class TabelModel_PemeriksaanPasien extends AbstractTableModel {
    private List<Pasien> list = new ArrayList<Pasien>();
    
    public TabelModel_PemeriksaanPasien () {
        
    }
    
    public Pasien get (int row) {
        return list.get(row);
    }
    
    public void setData (List <Pasien> List) {
        this.list = list;
        //fireTableDataChanged();
    }
    
     @Override
     public String getColumnName(int column) {
        switch(column){
            case 0 : return "Nama Pasien";
            case 1 : return "Alamat";

            default: return null;
        }
     }
     
        public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 2;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return list.get(rowIndex).getNama_Pasien ();
            case 1 : return list.get(rowIndex).getAlamat ();
           
            default : return null;
        }
    }
}
