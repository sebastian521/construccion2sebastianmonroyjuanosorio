package main;

import Config.MYSQLConnection;
import Controller.ControllerInterface;
import Controller.LoginController;

public class Club {

    public static void main(String[] args) {
        ControllerInterface controller = new LoginController();
        try {
            
            MYSQLConnection.getConnection();
            
          
            controller.session();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

