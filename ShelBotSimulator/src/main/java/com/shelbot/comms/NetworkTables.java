package com.shelbot.comms;

import java.util.ArrayList;
import java.util.Arrays;

import com.shelbot.windows.TeleopWindow;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * NetworkTables act as a database with the server running on the robot and this
 * acting as a client. This way many things can be stored and accessed from the
 * database
 * 
 * @author  
 * @version 5/16/20
 */
public class NetworkTables {

    public static NetworkTableInstance inst = NetworkTableInstance.getDefault();
    public static NetworkTable dsTable = inst.getTable("DriverStation");

    /**
     * Used to get a specific network table
     * 
     * @param table The name/key of the table
     * @return The network table
     */
    public NetworkTable getTable(String table) {
        return inst.getTable(table);
    }

    public static class LeftJoyconNetworkTableEntries {

        public static NetworkTableEntry up = dsTable.getEntry("up");
        public static NetworkTableEntry down = dsTable.getEntry("down");
        public static NetworkTableEntry left = dsTable.getEntry("left");
        public static NetworkTableEntry right = dsTable.getEntry("right");
        public static NetworkTableEntry capture = dsTable.getEntry("capture");
        public static NetworkTableEntry sL = dsTable.getEntry("leftSL");
        public static NetworkTableEntry sR = dsTable.getEntry("leftSR");
        public static NetworkTableEntry l = dsTable.getEntry("l");
        public static NetworkTableEntry zL = dsTable.getEntry("zL");
        public static NetworkTableEntry minus = dsTable.getEntry("minus");
        public static NetworkTableEntry joystickButton = dsTable.getEntry("leftJoystickButton");

        public static ArrayList<NetworkTableEntry> butttons = new ArrayList<NetworkTableEntry>(
                Arrays.asList(up, down, left, right, capture, sL, sR, l, zL, minus, joystickButton));

        public static NetworkTableEntry joystickState = dsTable.getEntry("leftJoystickState");

    }

    public static class RightJoyconNetworkTableEntries {

        public static NetworkTableEntry x = dsTable.getEntry("x");
        public static NetworkTableEntry a = dsTable.getEntry("a");
        public static NetworkTableEntry b = dsTable.getEntry("b");
        public static NetworkTableEntry y = dsTable.getEntry("y");
        public static NetworkTableEntry home = dsTable.getEntry("home");
        public static NetworkTableEntry sL = dsTable.getEntry("rightSL");
        public static NetworkTableEntry sR = dsTable.getEntry("rightSR");
        public static NetworkTableEntry r = dsTable.getEntry("r");
        public static NetworkTableEntry zR = dsTable.getEntry("zR");
        public static NetworkTableEntry plus = dsTable.getEntry("plus");
        public static NetworkTableEntry joystickButton = dsTable.getEntry("rightJoystickButton");

        public static ArrayList<NetworkTableEntry> butttons = new ArrayList<NetworkTableEntry>(
                Arrays.asList(x, a, b, y, home, sL, sR, r, zR, plus, joystickButton));

        public static NetworkTableEntry joystickState = dsTable.getEntry("rightJoystickState");

    }

    public static class XboxNetworkTableEntries {

        public static NetworkTableEntry x = dsTable.getEntry("x");
        public static NetworkTableEntry a = dsTable.getEntry("a");
        public static NetworkTableEntry b = dsTable.getEntry("b");
        public static NetworkTableEntry y = dsTable.getEntry("y");
        public static NetworkTableEntry home = dsTable.getEntry("home");
        public static NetworkTableEntry leftBumper = dsTable.getEntry("rightSL");
        public static NetworkTableEntry rightBumper = dsTable.getEntry("rightSR");
        public static NetworkTableEntry rightJoystickButton = dsTable.getEntry("rightJoystickButton");
        public static NetworkTableEntry leftJoystickButton = dsTable.getEntry("rightJoystickButton");

        public static ArrayList<NetworkTableEntry> butttons = new ArrayList<NetworkTableEntry>(
                Arrays.asList(x, a, b, y, home, leftBumper, rightBumper, rightJoystickButton, leftJoystickButton));

        public static NetworkTableEntry rightJoystickXState = dsTable.getEntry("rightJoystickXState");
        public static NetworkTableEntry rightJoystickYState = dsTable.getEntry("rightJoystickYState");
        public static NetworkTableEntry leftJoystickXState = dsTable.getEntry("leftJoystickXState");
        public static NetworkTableEntry leftJoystickYState = dsTable.getEntry("leftJoystickSYtate");

        public static NetworkTableEntry leftTriggerState = dsTable.getEntry("leftTriggerState");
        public static NetworkTableEntry rightTriggerState = dsTable.getEntry("rightTriggerState");

        public static NetworkTableEntry dpadState = dsTable.getEntry("dpadState");
    }

    /**
     * Used to update the control type
     * 
     * @param view the new view that the user has selected
     */
    public static void updateControlType(TeleopWindow.CurrentView view) {
        NetworkTableEntry controlType = dsTable.getEntry("controlType");
        if (view.equals(TeleopWindow.CurrentView.TELEOP)) {
            controlType.setString("teleop");
        } else if (view.equals(TeleopWindow.CurrentView.AUTON)) {
            controlType.setString("auton");
        } else if (view.equals(TeleopWindow.CurrentView.SHELBYMODE)) {
            controlType.setString("shelby");
        } else if (view.equals(TeleopWindow.CurrentView.TAYLORMODE)) {
            controlType.setString("taylor");
        }
    }

}