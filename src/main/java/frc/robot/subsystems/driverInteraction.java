package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;

public class driverInteraction { 
                Joystick leftJoystick = new Joystick(1);
                Joystick rightJoystick = new Joystick(0);
                static driveTrain dTrain = driveTrain.getM_DriveTrain();
                static driverInteraction dInteraction = new driverInteraction();
        
        private driverInteraction(){}

        public static driverInteraction getDriverInteraction(){
                return dInteraction;
        }

        public void update() {
                dTrain.move(.25 * leftJoystick.getRawAxis(1), .25 * rightJoystick.getRawAxis(1));

                if(leftJoystick.getRawButton(5)){
                        Intake.getballIntake().setIntakeSpeed(1);
                }

                if(leftJoystick.getRawButton(6)){
                        Intake.getballIntake().setIntakeSpeed(-1);
                }

                //Shooter.getballShooter().setShooterSpeed(leftJoystick.getY()); TODO: remove when testing concludes 

        }

        public void intakeInteraction() {

                if(leftJoystick.getRawButton(6)){
                        Intake.getballIntake().setIntakeSpeed(0);
                }
                if(leftJoystick.getRawButton(7)){
                      Shooter.getballShooter().setShooterSpeed(1);
                }
                if(leftJoystick.getRawButton(8)){
                        Shooter.getballShooter().setShooterSpeed(0);
                }
                if(leftJoystick.getRawButton(9)){
                        Shooter.getballShooter().setShooterSpeed(0.7);
                }
                
        }
}