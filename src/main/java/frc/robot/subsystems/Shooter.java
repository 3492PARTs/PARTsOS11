package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Constants;

public class Shooter {

    TalonSRX ShooterMotor = new TalonSRX(Constants.shooterMotorPin);
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");

    Boolean isOn = false;


    private Shooter(){
        ShooterMotor.configClosedloopRamp(.3);
    }
    private static Shooter ballShooter = new Shooter();
    public static Shooter getballShooter () {
        return ballShooter;
    }


    public void toggleShooter(){
        if(isOn){
            setShooterSpeed(1);
        } else {
            setShooterSpeed(0);
        }
        isOn = !isOn;
    }

    public void setShooterSpeed(double speed){
        
        ShooterMotor.set(ControlMode.PercentOutput,speed);

    }

    public static boolean getShooterStatusLeft() {
        return false;
    }

    public static boolean getShooterStatusRight() {
        return false;
    }

    public double getRPM(){
        return (ShooterMotor.getSelectedSensorVelocity() * 10) / 4096;
    }

    public double getRawRot(){
        return ShooterMotor.getSelectedSensorVelocity();
    }


    MedianFilter limeLightFilterx = new MedianFilter(5); // at 90 fps 5/18th of a second shouldn't be a lot of latency can maybe be a rolling average it needs to be tested still
    public double getTX() {
            
        return limeLightFilterx.calculate(tx.getDouble(0));
    }

    MedianFilter limeLightFiltery = new MedianFilter(5);
    public double getTY(){
        return limeLightFilterx.calculate(ty.getDouble(0));
    }

    public double getTA(){
        return ta.getDouble(0);
    }
    /**
     * 
     * @return in feet
     */
    public double distFromFrontToTarget(){

        double heightOfLimeLightOffGround = 0;//TODO:measure Value
        double heightOfTarget = 8.66666666;
        return ((heightOfTarget - heightOfLimeLightOffGround)/Math.tan(Math.toRadians(43 + getTY()))) - (2 + 1.541);// to get relative to front;
        

    }
}
