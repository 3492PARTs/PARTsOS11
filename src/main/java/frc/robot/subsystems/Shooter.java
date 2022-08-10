package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Constants;

public class Shooter {



    AnalogInput ultrasonic;
    MedianFilter medianFilter = new MedianFilter(4);
    TalonSRX ShooterMotor = new TalonSRX(Constants.shooterMotorPin);
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    double cameraHeight = 24 / 12 ;// 24 inches

    Boolean isOn = false;

    public double getUltrasonicDistance() {
        double dist = (ultrasonic.getVoltage()) * 48.6111;
            medianFilter.calculate(dist);
        return dist; // in feet
    }

    private Shooter(){
        ultrasonic = new AnalogInput(0);
        ShooterMotor.configClosedloopRamp(.2);
    
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
    public void setRPMS(double speed){
        ShooterMotor.set(ControlMode.Velocity,speed);

    }

    public static boolean getShooterStatusLeft() {
        return false;
    }

    public static boolean getShooterStatusRight() {
        return false;
    }

    public void shootRPM(double velocity){
        ShooterMotor.set(ControlMode.Velocity, velocity);
    }

    public double getRPM(){
        return (ShooterMotor.getSelectedSensorVelocity() * 10) / 4096;
    }

    public double getRawRot(){
        return ShooterMotor.getSelectedSensorVelocity();
    }

    public double getTX() {
        return tx.getDouble(0);
    }

    public double getTY(){
        return ty.getDouble(0);
    }

    public double getTA(){
        return ta.getDouble(0);
    }
    /**
     * 
     * @return in feet
     */
    public double distFromFrontToTarget(){


        double heightOfTarget = 8.66666666;
        return ((heightOfTarget - cameraHeight)/Math.tan(Math.toRadians(43 + getTY()))) - (2 + 1.541);// to get relative to front;

        

    }
}
