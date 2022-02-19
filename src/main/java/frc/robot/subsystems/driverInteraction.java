package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;

public class driverInteraction { 
                Joystick leftJoystick = new Joystick(1); // get the left joystick
                Joystick rightJoystick = new Joystick(0); // get the right joystick
                static driveTrain dTrain = driveTrain.getM_DriveTrain(); // get the driveTrain
                static driverInteraction dInteraction = new driverInteraction();
        
        // singleton pattern

        private driverInteraction() {

        }

        public driverInteraction getDriverInteraction(){
                return dInteraction;
        }

        public void update() {
                // move the drivetrain based on joystick y axis
                dTrain.move(leftJoystick.getRawAxis(1), rightJoystick.getRawAxis(1));
        }
}