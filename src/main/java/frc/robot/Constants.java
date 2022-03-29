// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static int elevatorMotorPin = 5; //TODO: set value
    public static int elevatorMotorPin2 = 6;

    public static Object speed;
    public static boolean autoFireLock;
    public static int intakeMotorPin = 2; //TODO: Declare Value
    public static int shooterMotorPin = 1; //TODO: declare value
    public static int intakePivotPin = 11; // TODO: set final value
    public static int indexerMotor = 4; // TODO: set final value

    public static double[] PIDDriveConstants = { .4, 0 ,0}; //kp, ki , kd TODO: in tuning process do not change without test
    public static double[] PIDTurnConstants = {.008 , .011 ,0}; //kp, ki , kd TODO: in tuning process do not change without test .15 , .175 ,0
    public static double[] PIDLimelightConstants = {.010 , .02 ,0};


    public static int[] driveTrainLeftSideCANIds = {10,20,12}; //TODO: set left front, middle, back left
    public static int[] driveTrainRightSideCANIds = {7,8,9}; //TODO: right front, middle, right left
    public static String SD_AUTO_DELAY = "autoDelay1";

    public enum intakePivot{
        up,
        down,
        stop
    }


}
