///*
// * Programacion Concurrente Cliente Servidor
// * 
// * Emilio Evans Rodriguez
// * Jose David Mora Loria
// * Carlos Oreamuno Alfaro
// * 
// * Tercer cuatrimestre, 2017
// * Ulacit
// */
//package indieairways.client;
//
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author Carlos
// */
//public class Timer extends Thread {
//    private int id;
//    private FXMLDatosReservaController datos;
//    private IndieAirwaysClient application;
//    
//    public Timer(final int id) {
//        this.id = id;
//    }
//   
//    //Thread thread = new Thread();
//    
//    
//    @Override
//    public void run(){
//        try {
//            //System.out.print("Entra al run");
//            Thread.sleep(5000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        for (int i = 60; i >= 0; i--) {
//            System.out.println("For -> " + id + " i -> " + i);
//            
//            try {
//                application.setLabelTimer(application.getTipoReserva(), i);
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//    
//    
//    
//}
