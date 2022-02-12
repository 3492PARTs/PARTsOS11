package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.Constants;

public class Intake {  
    Boolean isOn = false;
    int pinNumber = Constants.intakeMotorPin;
    TalonSRX intakeMotor = new TalonSRX(pinNumber);
    

    private Intake(){
    
    }
    private static Intake ballIntake = new Intake();
    public static Intake getballIntake () {
        return ballIntake;
    }


    public void toggleIntake(){ // todo: fix the whole not working thing
        if(isOn){
            setIntakeSpeed(1);
        } else {
            setIntakeSpeed(0);
        }
        isOn = !isOn;
    }

    public void setIntakeSpeed(double speed){
        intakeMotor.set(ControlMode.PercentOutput,speed);

    }



    


    


}
