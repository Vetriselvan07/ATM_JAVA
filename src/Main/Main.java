package Main;

import UiLayer.HomeController;


public class Main {
    public static void main(String[] args){
        //------------------
        HomeController homeControllerObj =new HomeController();
        //---------------------
        System.out.println("Welcome");

        homeControllerObj.regOrLoginOrExitByUser();


    }
}
