package org.firstinspires.ftc.teamcode;

public class DriveConstants {

    // Motor constants
    public static final double TICKS_PER_REV = 537.7;
    public static final double MAX_RPM = 312;

    // Wheel radius in INCHES (9.5 cm → 3.74 in → radius = 1.87 in)
    public static final double WHEEL_RADIUS = 1.87;  // inches

    public static final double GEAR_RATIO = 1.0; // GoBilda 5203 direct drive

    // Track width: 50 cm → 19.68 inches
    public static final double TRACK_WIDTH = 19.68; // inches

    public static final double IN_PER_TICK =
            (2 * Math.PI * WHEEL_RADIUS) / TICKS_PER_REV;
}
