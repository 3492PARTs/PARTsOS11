package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.Constants;

public class Shooter {


    TalonSRX ShooterMotor = new TalonSRX(Constants.shooterMotorPin);

    private Shooter(){
    
    }
    private static Shooter ballShooter = new Shooter();
    public static Shooter getballShooter () {
        return ballShooter;
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


}
