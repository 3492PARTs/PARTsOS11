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
