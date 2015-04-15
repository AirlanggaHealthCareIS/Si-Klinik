/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;

import database.entity.detail_Assessment;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author JESSICA
 */
public interface Assessment_Service extends Remote {
    detail_Assessment insertAssessment(detail_Assessment detail_Assessment) throws RemoteException;
    List<detail_Assessment> getAssessments (String ID_RM) throws RemoteException;
}