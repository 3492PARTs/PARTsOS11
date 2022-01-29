package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class Shooter {
    TalonSRX ShooterMotor = new TalonSRX();

    private Shooter(){
    
    }
    private static Shooter ballShooter = new Shooter();
}
