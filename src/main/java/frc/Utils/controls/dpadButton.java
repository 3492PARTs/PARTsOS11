// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Utils.controls;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

/** Add your docs here. */
public class dpadButton extends Button{
    int angle;
    XboxController controller;
    public dpadButton(XboxController controller, int angle){
        this.angle = angle;
        this.controller = controller;
        

    }

    @Override
    public boolean get() {
        return controller.getPOV() == angle;
    }
}
