package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class Intake {  
    TalonSRX intakeMotor = new TalonSRX();
    
    private Intake(){
    
    }
    private static Intake ballIntake = new Intake();
    public static Intake getballIntake () {
        return ballIntake;
    }

    public void setIntakeSpeed(double speed){
        intakeMotor.set(ControlMode.PercentOutput,speed);

    }



    


    


}
