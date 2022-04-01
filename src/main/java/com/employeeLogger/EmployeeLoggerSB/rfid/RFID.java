package com.employeeLogger.EmployeeLoggerSB.rfid;

import com.fazecast.jSerialComm.SerialPort;

public class RFID {

    public static int packetSize = 8; //packet size in bytes

    //searches for and opens the right serial comm
    public static void comPortConnection(){

        int len = SerialPort.getCommPorts().length;
        String arduinoPortDescriptiveName = "USB-SERIAL CH340";
        SerialPort arduinoPort = null;
        SerialPort[] serialPorts = new SerialPort[len];

        serialPorts = SerialPort.getCommPorts();

        for(int i = 0; i < len; i++){
            String tmpPortDescriptiveName = serialPorts[i].getDescriptivePortName();
            if(tmpPortDescriptiveName.contains(arduinoPortDescriptiveName)){
                arduinoPort = serialPorts[i];
                arduinoPort.openPort();
                System.out.println("connected to: " + arduinoPort.getDescriptivePortName());
            }
        }

        PackageListener listener = new PackageListener();
        arduinoPort.addDataListener(listener);

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}