package com.shelbot.comms;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Reads the text on a url. Helps us know about the acknowledgement from the bot
 * once it moves
 * 
 * @author  
 * @version 5/16/20
 */
public class ConnectionVerifier {

    public static String ip = "raspberrypi.local";

    private static boolean loggedOnce = false;
    private static boolean connected = false;

    /**
     * Used to see if a bot is connected by pinging the ip of the robot
     * 
     * @return isConnected true if the ping to the robot was successful
     */
    public static boolean isConnected() {
        Thread thread = new Thread() {
            public void run() {
                try {
                    InetAddress inet = InetAddress.getByName(ip);// InetAddress.getByAddress(toByteArray(ip.split(".")));
                    if (inet.isReachable(5000)) {
                        if (!loggedOnce) {
                            System.out.println("Connected to " + inet.getHostAddress().toString());
                            loggedOnce = true;
                        }
                        connected = true;
                    } else {
                        if (loggedOnce)
                            loggedOnce = false;
                        connected = false;
                    }

                } catch (UnknownHostException e) {
                    // e.printStackTrace();
                    connected = false;
                } catch (IOException e) {
                    // System.out.println("Exception thrown from connectionVerifier");
                    // e.printStackTrace();
                    connected = false;
                }
            }
        };

        thread.start();
        return connected;

    }

    /**
     * Converts a String array to a Byte array
     * 
     * @param strs the String array
     * @return the transformed byte array
     */
    public static byte[] toByteArray(String[] strs) {
        byte[] bytes = new byte[strs.length];
        for (int i = 0; i < strs.length; i++) {
            bytes[i] = Byte.parseByte(strs[i]);
        }
        return bytes;
    }
}