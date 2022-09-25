/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author dell
 */
import java.rmi.*;
import java.util.*;
public interface Adder extends Remote {
    public String[] getWeatherUpdate(String location) throws RemoteException;
}
