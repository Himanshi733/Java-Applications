/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dell
 */
import java.io.BufferedReader;
import java.io.FileReader;
import  java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
public class Server extends UnicastRemoteObject implements Adder {
    public Server() throws RemoteException{
        
    }
    @Override
    public String[] getWeatherUpdate(String location) throws RemoteException{
        String file = "src/Weather.csv";
        BufferedReader reader = null;
        String line = "";
        try{
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                String[] row = line.split(",");
                if(row[0].contains(location)){
                    return row;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static void main(String[] args) throws RemoteException{
        try{
            Registry reg = LocateRegistry.createRegistry(9999);
            reg.rebind("hi server", new Server());
            System.out.println("Server is ready");
        }
        catch(RemoteException e){
            System.out.println(e);
        }
    }
}
