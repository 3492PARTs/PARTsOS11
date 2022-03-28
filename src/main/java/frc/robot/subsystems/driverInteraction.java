package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.intakePivot;

public class driverInteraction { 
                //Joystick leftJoystick = new Joystick(1); // get the left joystick
                //Joystick rightJoystick = new Joystick(0); // get the right joystick
                static driveTrain dTrain = driveTrain.getM_DriveTrain(); // get the driveTrain
                static driverInteraction dInteraction = new driverInteraction();
                XboxController m_driverController = new XboxController(0);
                XboxController buttonBox = new XboxController(1);
                boolean biFrontalDrive = false;
                boolean toggleIndexer = false;

        // singleton pattern

        private driverInteraction() { }


        public static driverInteraction getDriverInteraction(){
                return dInteraction;
        }
        
        public void updateButtonbox(){
                if(buttonBox.getXButton()){
                        Elevator.getElevator().setElevatorSpeed(-1);
                }
                else {
                        Elevator.getElevator().setElevatorSpeed(0);
                }



                

        }

        public void updateController() {
                int driveMult = biFrontalDrive ? 1 : -1;
                dTrain.arcadeDrive(driveMult * m_driverController.getRawAxis(1), driveMult *m_driverController.getRawAxis(4));

                if(m_driverController.getRawAxis(2) > 0.5){
                        Intake.getballIntake().setIntakeSpeed(-1);
                } else {
                        Intake.getballIntake().setIntakeSpeed(0);
                }

                if(m_driverController.getRightBumper()){
                        System.out.println(m_driverController.getRightBumper());
                        Shooter.getballShooter().setShooterSpeed(.6);
                }
                else if(m_driverController.getRightTriggerAxis() > .5){
                        Shooter.getballShooter().setShooterSpeed(1);
                }
                else{
                        Shooter.getballShooter().setShooterSpeed(0);
                }

                if(m_driverController.getXButton()){
                        Indexer.getIndexer().setIndexerSpeed(1);
                }
                else{
                        Indexer.getIndexer().setIndexerSpeed(0);
                }

                if(m_driverController.getRawButton(4) || buttonBox.getYButton()){
                        Intake.getballIntake().setPivotDirection(intakePivot.up);
                }
                else if(m_driverController.getRawButton(1) || buttonBox.getAButton()){
                        Intake.getballIntake().setPivotDirection(intakePivot.down);
                }
                else {
                        Intake.getballIntake().setPivotDirection(intakePivot.stop);
                }

                if(m_driverController.getRawButton(2)){
                        if(toggleIndexer) {
                                Indexer.getIndexer().setIndexerSpeed(-1);
                        } else {
                                Indexer.getIndexer().setIndexerSpeed(0);
                        }
                toggleIndexer = !toggleIndexer;
                }



                

                if(m_driverController.getRawButton(7)){
                        this.biFrontalDrive = !biFrontalDrive;
                }
        }

        // public void update() { // left , right
        //         dTrain.move(-1 * leftJoystick.getRawAxis(1), -1 * rightJoystick.getRawAxis(1));

        //         updateController();
        //         updateButtonbox();


        //         if(leftJoystick.getRawButton(5)){
        //                 Intake.getballIntake().setIntakeSpeed(-1);
        //         }

        //         /*if(leftJoystick.getRawButton(6)){
        //                 Intake.getballIntake().setIntakeSpeed(-1);
        //         }*/

        //         if(leftJoystick.getRawButton(6)){
        //                 Intake.getballIntake().setIntakeSpeed(0);
        //         }

        //         if(leftJoystick.getRawButton(7)){
        //               Shooter.getballShooter().setShooterSpeed(1);
        //         }

        //         if(leftJoystick.getRawButton(8)){
        //                 Shooter.getballShooter().setShooterSpeed(0);
        //         }

        //         if(leftJoystick.getRawButton(9)){
        //                 Shooter.getballShooter().setShooterSpeed(.7);

        //         }

        //         //Shooter.getballShooter().setShooterSpeed(leftJoystick.getY()); TODO: remove when testing concludes 


        //         if(leftJoystick.getRawButton(10)){
        //                 Intake.getballIntake().setPivotDirection(intakePivot.up);
        //         }
        //         else if(leftJoystick.getRawButton(11) && rightJoystick.getRawButton(11)){
        //                 Intake.getballIntake().setPivotDirection(intakePivot.down);
        //         }
        //         else if(leftJoystick.getRawButton(12)){
        //                 Intake.getballIntake().setPivotDirection(intakePivot.stop);
        //         }
        //         else{
        //                 Intake.getballIntake().setPivotDirection(intakePivot.stop);
        //         }
                        

        //         if(leftJoystick.getRawButton(13)) {
        //                 Elevator.getElevator().setElevatorSpeed(1);
        //         }
        //         if(leftJoystick.getRawButton(14)) {
        //                 Elevator.getElevator().setElevatorSpeed(-1);
        //         }
        //         if(leftJoystick.getRawButton(15)) {
        //                 Elevator.getElevator().setElevatorSpeed(0);
        //         }

        //         if(rightJoystick.getRawButton(5)) {
        //                 Indexer.getIndexer().setIndexerSpeed(-1);
        //         }
        //         if(rightJoystick.getRawButton(6)) {
        //                 Indexer.getIndexer().setIndexerSpeed(0);
        //         }

        // }

        

}