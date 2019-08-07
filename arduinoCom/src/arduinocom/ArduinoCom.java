/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinocom;
import java.util.Scanner;

import arduino.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author khutjo_laptop
 */
public class ArduinoCom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DateFormat df = new SimpleDateFormat("HH:mm");
        
                
                Scanner ob = new Scanner(System.in);
		Arduino arduino = new Arduino("COM15", 9600); //enter the port name here, and ensure that Arduino is connected, otherwise exception will be thrown.
		arduino.openConnection();
                String mainstring = "";
                String compstring = "";
                while (true){
                    try{
                        TimeUnit.SECONDS.sleep(2);
                        mainstring = df.format(new Date());
                        System.gc();
                        //if (!mainstring.equals(compstring)){
                            System.out.println("=_=>"+mainstring);
                            //arduino.serialWrite('~');
                            //for (char outstring : compstring.toCharArray())
                              //  arduino.serialWrite(outstring);
                            //arduino.serialWrite('@');
                            arduino.serialWrite("~55:55@");
                            System.out.println("=-=>"+arduino.serialRead());
                            compstring = mainstring;
                        //}
                    }catch(Exception e){
                    System.out.println("meh");
                }
                }
		//ob.close();
		//arduino.closeConnection();
    }
    
}



