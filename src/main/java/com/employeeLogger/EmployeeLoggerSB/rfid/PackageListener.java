package com.employeeLogger.EmployeeLoggerSB.rfid;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.fazecast.jSerialComm.SerialPortPacketListener;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PackageListener implements SerialPortPacketListener {

    public String UidString = "";

    @Override
    public int getPacketSize() {
        return RFID.packetSize;
    }

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        byte[] newData = event.getReceivedData();
        String str = new String(newData).split("\n", 2)[0];
        UidString = str;
        int byteSize = 0;
        try {
            byteSize = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PackageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (byteSize == getPacketSize()) {
            System.out.println("Received data of size: " + "("+ byteSize + ")");
            System.out.println("Received data: " + UidString);
        }
    }
}