package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Constants;
import frc.robot.Constants.intakePivot;

public class Intake {  
    Boolean isOn = false;
    TalonSRX intakeMotor = new TalonSRX(Constants.intakeMotorPin);
    TalonSRX intakePivot = new TalonSRX(Constants.intakePivotPin);

    private Intake(){
    
    }
    private static Intake ballIntake = new Intake();
    public static Intake getballIntake () {
        return ballIntake;
    }


    public void toggleIntake(){ // todo: fix the whole not working thing
        if(isOn){
            setIntakeSpeed(1);
            isOn = !isOn;
        } else {
            setIntakeSpeed(0);
            isOn = !isOn;
        }
        
    }

    public void setIntakeSpeed(double speed){
        intakeMotor.set(ControlMode.PercentOutput,speed);

    }

    public void setPivotDirection(intakePivot dir){// TODO: confirm directions are accurate 
        if(dir == dir.up){
            intakePivot.set(ControlMode.PercentOutput, .6);
        }
        if(dir == dir.stop){
            intakePivot.set(ControlMode.PercentOutput, 0);
        }
        if(dir == dir.down){
            intakePivot.set(ControlMode.PercentOutput, -.6);
        }
    }



    


    


}
