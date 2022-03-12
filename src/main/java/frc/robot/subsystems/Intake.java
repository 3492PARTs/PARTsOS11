package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;
import frc.robot.Constants.intakePivot;

public class Intake {  
    Boolean isOn = false;
    TalonSRX intakeMotor = new TalonSRX(Constants.intakeMotorPin);
    CANSparkMax intakePivot = new CANSparkMax(Constants.intakePivotPin, MotorType.kBrushless);

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
            intakePivot.set(-.6);
        }
        if(dir == frc.robot.Constants.intakePivot.stop){
            intakePivot.set(0);
        }
        if(dir == frc.robot.Constants.intakePivot.down){
            intakePivot.set(.6);
        }
    }



    


    


}
