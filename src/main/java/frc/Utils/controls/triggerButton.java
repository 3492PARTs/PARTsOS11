// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Utils.controls;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

/** Add your docs here. */
public class triggerButton extends Button {
    XboxController controller;
    int axis;
    double threshold;

    /**
     * 
     * @param controller the controller the button is on
     * @param axis the axis that the command will be bound to
     * @param threshold the minimum value to trigger the command
     * @apiNote this can technicaly be used for joysticks too with no change but this is highly discouraged since it is evil
     */
    triggerButton(XboxController controller, int axis, double threshold){
        this.controller = controller;
        this.axis = axis;
        this.threshold = threshold;
        

    }
    
    @Override
    public boolean get() {
        return controller.getRawAxis(axis) > threshold;
    }
}
