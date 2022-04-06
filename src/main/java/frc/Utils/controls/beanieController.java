// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Utils.controls;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/** Add your docs here. */
// heavily inspired by the beak squad controller class, just added a handfull of changes and it should hopefully evolve into its own new thing with time.
public class beanieController {
    private XboxController controller;

    private JoystickButton a;
    private JoystickButton b;
    private JoystickButton x;
    private JoystickButton y;

    private JoystickButton start;
    private JoystickButton back;

    private JoystickButton rightBumper;

    private JoystickButton leftBumper;

    private dpadButton dpadUp;



    public beanieController(int port){
        controller = new XboxController(port);

        a = new JoystickButton(controller, 1);
        b = new JoystickButton(controller, 2);
        x = new JoystickButton(controller, 3);
        y = new JoystickButton(controller, 4);
        rightBumper = new JoystickButton(controller, 5);
        leftBumper = new JoystickButton(controller, 6);
        back = new JoystickButton(controller, 7);
        start = new JoystickButton(controller, 8);

        dpadUp = new dpadButton(controller, 0);
        
    }
    public XboxController getController(){
        return controller;
    }

    public JoystickButton getA() {
        return a;
    }
    public JoystickButton getB() {
        return b;
    }
    public JoystickButton getX() {
        return x;
    }
    public JoystickButton getY() {
        return y;
    }
    public JoystickButton getRightBumper() {
        return rightBumper;
    }
    public JoystickButton getLeftBumper() {
        return leftBumper;
    }
    public JoystickButton getStart() {
        return start;
    }
    public JoystickButton getBack() {
        return back;
    }
    public dpadButton getDpadUp() {
        return dpadUp;
    }
    public double getLeftXAxis(){
        return controller.getRawAxis(0);
    }

    public double getLeftYAxis(){
        return controller.getRawAxis(1);
    }

    public double getRightXAxis(){
        return controller.getRawAxis(4);

    }

    public double getRightYAxis(){
        return controller.getRawAxis(5);
    }

    public double getLeftTrigger(){
        return controller.getRawAxis(2);
    }

    public double getRightTrigger(){
        return controller.getRawAxis(3);
    }

    public void Rumbling(Rumbler rumbler){
        controller.setRumble(RumbleType.kLeftRumble, rumbler.getRumbler());
        controller.setRumble(RumbleType.kLeftRumble, rumbler.getRumbler());
    }

    


}
