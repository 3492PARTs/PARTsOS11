package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants.intakePivot;

public class driverInteraction { 
                Joystick leftJoystick = new Joystick(1); // get the left joystick
                Joystick rightJoystick = new Joystick(0); // get the right joystick
                static driveTrain dTrain = driveTrain.getM_DriveTrain(); // get the driveTrain
                static driverInteraction dInteraction = new driverInteraction();

        // singleton pattern

        private driverInteraction() { }


        public static driverInteraction getDriverInteraction(){
                return dInteraction;
        }


        public void update() { // left , right
                dTrain.move(-1 * leftJoystick.getRawAxis(1), -1 * rightJoystick.getRawAxis(1));



                if(leftJoystick.getRawButton(5)){
                        Intake.getballIntake().setIntakeSpeed(-1);
                }

                /*if(leftJoystick.getRawButton(6)){
                        Intake.getballIntake().setIntakeSpeed(-1);
                }*/

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
                        Shooter.getballShooter().setShooterSpeed(.7);

                }

                //Shooter.getballShooter().setShooterSpeed(leftJoystick.getY()); TODO: remove when testing concludes 


                if(leftJoystick.getRawButton(10)){
                        Intake.getballIntake().setPivotDirection(intakePivot.up);
                }
                else if(leftJoystick.getRawButton(11) && rightJoystick.getRawButton(11)){
                        Intake.getballIntake().setPivotDirection(intakePivot.down);
                }
                else if(leftJoystick.getRawButton(12)){
                        Intake.getballIntake().setPivotDirection(intakePivot.stop);
                }
                else{
                        Intake.getballIntake().setPivotDirection(intakePivot.stop);
                }
                        

                if(leftJoystick.getRawButton(13)) {
                        Elevator.getElevator().setElevatorSpeed(1);
                }
                if(leftJoystick.getRawButton(14)) {
                        Elevator.getElevator().setElevatorSpeed(-1);
                }
                if(leftJoystick.getRawButton(15)) {
                        Elevator.getElevator().setElevatorSpeed(0);
                }

                if(rightJoystick.getRawButton(5)) {
                        Indexer.getIndexer().setIndexerSpeed(-1);
                }
                if(rightJoystick.getRawButton(6)) {
                        Indexer.getIndexer().setIndexerSpeed(0);
                }

        }

}