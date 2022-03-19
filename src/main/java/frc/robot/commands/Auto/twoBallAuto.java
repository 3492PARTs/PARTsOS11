// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Auto.*;
import frc.robot.commands.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class twoBallAuto extends SequentialCommandGroup {
  /** Creates a new twoBallAuto. */
  public twoBallAuto() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new Delay(), new PIDDrive(-12), new ParallelCommandGroup( new autoShooting(.9), new Index()), new turnRobo(45), new ParallelCommandGroup(new PIDDrive(-72), new autoIntake(-1)) , new PIDDrive(72), new ParallelCommandGroup( new autoShooting(.9), new Index()) );
  }
}
