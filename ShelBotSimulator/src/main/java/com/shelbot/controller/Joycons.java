package com.shelbot.controller;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import com.shelbot.comms.NetworkTables.LeftJoyconNetworkTableEntries;
import com.shelbot.comms.NetworkTables.RightJoyconNetworkTableEntries;

import JoyconLib.JoyconConstants;
import JoyconLib.LeftJoycon;
import JoyconLib.RightJoycon;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * Represent Joycons that can be used to control the shelbot
 * 
 * @author  
 * @version 5/16/20
 */
public class Joycons {

    private Timer timer;
    private long CONNECTION_CHECK_PERIOD = 2500;

    TimerTask checkConnectionStatus = new TimerTask() {
        @Override
        public void run() {
            testConnection();
        }
    };

    /**
     * Creates a new instance of Joycons
     */
    public Joycons() {
        timer = new Timer();
        // timer.schedule(checkConnectionStatus, 0, CONNECTION_CHECK_PERIOD);
        // inst.startClient(ConnectionVerifier.ip, 1735);
        // initNetworkTables();
    }

    public static LeftJoycon leftJoycon = new LeftJoycon() {

        @Override
        public void onInputReportDoThis(HashMap<String, Boolean> arg0) {
            pushNewLeftJoyconValueToNetworkTables(arg0);
        }
    };

    public static RightJoycon rightJoycon = new RightJoycon() {

        @Override
        public void onInputReportDoThis(HashMap<String, Boolean> arg0) {
            pushNewRightJoyconValueToNetworkTables(arg0);
        }
    };

    /**
     * used to test the connecion of the joycon
     */
    public void testConnection() {
        leftJoycon.testConnection(JoyconConstants.JOYCON_LEFT);
        rightJoycon.testConnection(JoyconConstants.JOYCON_RIGHT);
    }

    /**
     * Used to set initial joycon values on NetworkTables
     */
    public void initNetworkTables() {
        for (NetworkTableEntry e : LeftJoyconNetworkTableEntries.butttons) {
            e.forceSetBoolean(false);
        }
        for (NetworkTableEntry e : RightJoyconNetworkTableEntries.butttons) {
            e.forceSetBoolean(false);
        }
        LeftJoyconNetworkTableEntries.joystickState.forceSetString("NEUTRAL");
        RightJoyconNetworkTableEntries.joystickState.forceSetString("NEUTRAL");
    }

    /**
     * Used to push leftJoycon values to networrkTables
     * 
     * @param map values for this controller
     */
    public static void pushNewLeftJoyconValueToNetworkTables(HashMap<String, Boolean> map) {
        map.forEach((id, isPressed) -> {
            int buttonId = Integer.parseInt(id);
            if (buttonId == leftJoycon.minus.getId()) {
                LeftJoyconNetworkTableEntries.minus.forceSetBoolean(isPressed);
            } else if (buttonId == leftJoycon.l.getId()) {
                LeftJoyconNetworkTableEntries.l.forceSetBoolean(isPressed);
            } else if (buttonId == leftJoycon.zL.getId()) {
                LeftJoyconNetworkTableEntries.zL.forceSetBoolean(isPressed);
            } else if (buttonId == leftJoycon.joystickButton.getId()) {
                LeftJoyconNetworkTableEntries.joystickButton.forceSetBoolean(isPressed);
            } else if (buttonId == leftJoycon.up.getId()) {
                LeftJoyconNetworkTableEntries.up.forceSetBoolean(isPressed);
            } else if (buttonId == leftJoycon.down.getId()) {
                LeftJoyconNetworkTableEntries.down.forceSetBoolean(isPressed);
            } else if (buttonId == leftJoycon.left.getId()) {
                LeftJoyconNetworkTableEntries.left.forceSetBoolean(isPressed);
            } else if (buttonId == leftJoycon.right.getId()) {
                LeftJoyconNetworkTableEntries.right.forceSetBoolean(isPressed);
            } else if (buttonId == leftJoycon.capture.getId()) {
                LeftJoyconNetworkTableEntries.capture.forceSetBoolean(isPressed);
            } else if (buttonId == leftJoycon.sL.getId()) {
                LeftJoyconNetworkTableEntries.sL.forceSetBoolean(isPressed);
            } else if (buttonId == leftJoycon.sR.getId()) {
                LeftJoyconNetworkTableEntries.sR.forceSetBoolean(isPressed);
            } else if (buttonId == JoyconConstants.JoystickStates.DEGREES_0) {
                LeftJoyconNetworkTableEntries.joystickState.forceSetString("0");
            } else if (buttonId == JoyconConstants.JoystickStates.DEGREES_45) {
                LeftJoyconNetworkTableEntries.joystickState.forceSetString("45");
            } else if (buttonId == JoyconConstants.JoystickStates.DEGREES_90) {
                LeftJoyconNetworkTableEntries.joystickState.forceSetString("90");
            } else if (buttonId == JoyconConstants.JoystickStates.DEGREES_135) {
                LeftJoyconNetworkTableEntries.joystickState.forceSetString("135");
            } else if (buttonId == JoyconConstants.JoystickStates.DEGREES_180) {
                LeftJoyconNetworkTableEntries.joystickState.forceSetString("180");
            } else if (buttonId == JoyconConstants.JoystickStates.DEGREES_225) {
                LeftJoyconNetworkTableEntries.joystickState.forceSetString("225");
            } else if (buttonId == JoyconConstants.JoystickStates.DEGREES_270) {
                LeftJoyconNetworkTableEntries.joystickState.forceSetString("270");
            } else if (buttonId == JoyconConstants.JoystickStates.DEGREES_315) {
                LeftJoyconNetworkTableEntries.joystickState.forceSetString("315");
            } else if (buttonId == JoyconConstants.JoystickStates.NEUTRAL) {
                LeftJoyconNetworkTableEntries.joystickState.forceSetString("NEUTRAL");
            }
        });
    }

    /**
     * Used to push right joyconValues to NetwoorkTables
     * 
     * @param map values for this controller
     */
    public static void pushNewRightJoyconValueToNetworkTables(HashMap<String, Boolean> map) {
        map.forEach((id, isPressed) -> {
            int buttonId = Integer.parseInt(id);
            if (buttonId == rightJoycon.plus.getId()) {
                RightJoyconNetworkTableEntries.plus.forceSetBoolean(isPressed);
            } else if (buttonId == rightJoycon.r.getId()) {
                RightJoyconNetworkTableEntries.r.forceSetBoolean(isPressed);
            } else if (buttonId == rightJoycon.zR.getId()) {
                RightJoyconNetworkTableEntries.zR.forceSetBoolean(isPressed);
            } else if (buttonId == rightJoycon.joystickButton.getId()) {
                RightJoyconNetworkTableEntries.joystickButton.forceSetBoolean(isPressed);
            } else if (buttonId == rightJoycon.x.getId()) {
                RightJoyconNetworkTableEntries.x.forceSetBoolean(isPressed);
            } else if (buttonId == rightJoycon.a.getId()) {
                RightJoyconNetworkTableEntries.a.forceSetBoolean(isPressed);
            } else if (buttonId == rightJoycon.b.getId()) {
                RightJoyconNetworkTableEntries.b.forceSetBoolean(isPressed);
            } else if (buttonId == rightJoycon.y.getId()) {
                RightJoyconNetworkTableEntries.y.forceSetBoolean(isPressed);
            } else if (buttonId == rightJoycon.home.getId()) {
                RightJoyconNetworkTableEntries.home.forceSetBoolean(isPressed);
            } else if (buttonId == rightJoycon.sL.getId()) {
                RightJoyconNetworkTableEntries.sL.forceSetBoolean(isPressed);
            } else if (buttonId == rightJoycon.sR.getId()) {
                RightJoyconNetworkTableEntries.sR.forceSetBoolean(isPressed);
            } else if (buttonId == JoyconConstants.JoystickStates.DEGREES_0) {
                RightJoyconNetworkTableEntries.joystickState.forceSetString("0");
            } else if (buttonId == JoyconConstants.JoystickStates.DEGREES_45) {
                RightJoyconNetworkTableEntries.joystickState.forceSetString("45");
            } else if (buttonId == JoyconConstants.JoystickStates.DEGREES_90) {
                RightJoyconNetworkTableEntries.joystickState.forceSetString("90");
            } else if (buttonId == JoyconConstants.JoystickStates.DEGREES_135) {
                RightJoyconNetworkTableEntries.joystickState.forceSetString("135");
            } else if (buttonId == JoyconConstants.JoystickStates.DEGREES_180) {
                RightJoyconNetworkTableEntries.joystickState.forceSetString("180");
            } else if (buttonId == JoyconConstants.JoystickStates.DEGREES_225) {
                RightJoyconNetworkTableEntries.joystickState.forceSetString("225");
            } else if (buttonId == JoyconConstants.JoystickStates.DEGREES_270) {
                RightJoyconNetworkTableEntries.joystickState.forceSetString("270");
            } else if (buttonId == JoyconConstants.JoystickStates.DEGREES_315) {
                RightJoyconNetworkTableEntries.joystickState.forceSetString("315");
            } else if (buttonId == JoyconConstants.JoystickStates.NEUTRAL) {
                RightJoyconNetworkTableEntries.joystickState.forceSetString("NEUTRAL");
            }
        });
    }
}