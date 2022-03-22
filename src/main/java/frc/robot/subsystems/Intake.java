package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;
import frc.robot.Constants.intakePivot;
import frc.Utils.TalonSRXLinearDistance;

public class Intake {  
    Boolean isOn = false;
    Boolean isCoast = false;
    TalonSRX intakeMotor = new TalonSRX(Constants.intakeMotorPin);
    TalonSRX intakePivot = new TalonSRX(Constants.intakePivotPin);
    TalonSRXLinearDistance persistentDistanceMeasure = new TalonSRXLinearDistance(intakeMotor, 1.0);

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

    public void setPivotDirection(intakePivot dir){
        if(dir == frc.robot.Constants.intakePivot.up){
            intakePivot.set(ControlMode.PercentOutput,-.6);
        }
        if(dir == frc.robot.Constants.intakePivot.stop){
            intakePivot.set(ControlMode.PercentOutput, 0);
        }
        if(dir == frc.robot.Constants.intakePivot.down){
            intakePivot.set(ControlMode.PercentOutput, .6);
        }
    }

    public TalonSRXLinearDistance getPersistantDistanceMeasure() {
        return persistentDistanceMeasure;
    }


    public void toggleCoastPivot(){
        if(isCoast) {
            intakePivot.setNeutralMode(NeutralMode.Brake);
            
        } else {
            intakePivot.setNeutralMode(NeutralMode.Coast);
            
        }

        isCoast = !isCoast;
        
    }
}



    


    


