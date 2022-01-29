package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Constants;

public class Intake {  
    int pinNumber = Constants.intakeMotorPin;
    TalonSRX intakeMotor = new TalonSRX(pinNumber);
    
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
