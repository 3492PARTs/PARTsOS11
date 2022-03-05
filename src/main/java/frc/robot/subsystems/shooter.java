package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

// import edu.wpi.first.wpilibj.Joystick;

public class shooter {
    static shooter sTesting = new shooter(); 

    //Joystick rightJoystick = new Joystick(0);

    static TalonSRX shooterMotor1 = new TalonSRX(1); // get the shooterMotor

    static NetworkTable table;  // this is for the limelight
    NetworkTableEntry tx;
    NetworkTableEntry ty;
    NetworkTableEntry ta;
    
    private shooter() {
        table = NetworkTableInstance.getDefault().getTable("limelight"); // get the limelight
    }

    public static shooter getShooter(){
            return sTesting;
    }

    // functions for getting values

    public double getTX() {
        return table.getEntry("tx").getDouble(0); // limelight tX value
    }

    public double getTY() {
        return table.getEntry("ty").getDouble(0); // limelight tY value
    }

    public double getTA() {
        return table.getEntry("ta").getDouble(0); // limelight tA value
    }

    public void update(double speed) {
        shooterMotor1.set(ControlMode.PercentOutput, speed); // set the speed of the shooterMotor based on what is inputed
    }
}