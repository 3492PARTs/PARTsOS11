package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;

public class driverInteraction { 
                Joystick leftJoystick = new Joystick(1);
                Joystick rightJoystick = new Joystick(0);
                static driveTrain dTrain = driveTrain.getM_DriveTrain();
                static driverInteraction dInteraction = new driverInteraction();
        
        private driverInteraction() {

        }

        public driverInteraction getDriverInteraction(){
                return dInteraction;
        }

        public void update() {
                dTrain.move(leftJoystick.getRawAxis(1), rightJoystick.getRawAxis(1));
        }
}