/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;

import database.Service.Assessment_Service;
import database.entity.detail_Assessment;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import si_klinik_server.DatabaseUtilities;

/**
 *
 * @author JESSICA
 */
public class Assessment_Server extends UnicastRemoteObject implements Assessment_Service {
    
    public Assessment_Server() throws RemoteException {    
    }
    
    @Override
    public detail_Assessment insertAssessment(detail_Assessment da) throws RemoteException{
         System.out.println("Client Melakukan Proses Insert");

        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO `detail_assessment_rekammedik`(`ID_Assessment`, `ID_REKAM_MEDIS`, `PPL`, `Assessment`, `DX`, `TX`, `MX`, `EX`) VALUES (null,?,?,?,?,?,?,?)"
        );
        
        statement.setString(1, da.getId_Rekam_Medis());
        statement.setString(2, da.getPPL());
        statement.setString(3, da.getAssessment());
        statement.setString(4, da.getDX());
        statement.setString(5, da.getTX());
        statement.setString(6, da.getMX());
        statement.setString(7, da.getEX());
        
        statement.executeUpdate();
        
        return da;
        }
        catch(SQLException exception){
            exception.printStackTrace();
            return null;
        }
        finally{
            if(statement != null){
                try{
                   statement.close();
                }catch(SQLException exception){

                }
            }
        }
    }
    
    @Override
    public List<detail_Assessment> getAssessments (String ID_RM) throws RemoteException{
        System.out.println("Client Melakukan Proses Get All");

        PreparedStatement statement = null;
        
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement("SELECT * FROM `detail_assessment_rekammedik` WHERE ID_REKAM_MEDIS =?");
            statement.setString(1, ID_RM);
            ResultSet result = statement.executeQuery();
            
            List<detail_Assessment> list = new ArrayList<detail_Assessment>();

            while(result.next()){
                detail_Assessment a = new detail_Assessment();
                a.setId_Rekam_Medis(result.getString("ID_REKAM_MEDIS"));
                a.setPPL(result.getString("PPL"));
                a.setAssessment(result.getString("Assessment"));
                a.setDX(result.getString("DX"));
                a.setTX(result.getString("TX"));
                a.setMX(result.getString("MX"));
                a.setEX(result.getString("EX"));
                list.add(a);
            }
           result.close();

          return list;

        }
        catch(SQLException exception){
          exception.printStackTrace();
          return null;
        }
        finally{
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException exception){
                   exception.printStackTrace();
                }
            }
        }
    }
}
