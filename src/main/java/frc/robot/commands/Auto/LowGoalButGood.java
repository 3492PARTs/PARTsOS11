// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LowGoalButGood extends SequentialCommandGroup {
  /** Creates a new LowGoalButGood. */
  public LowGoalButGood() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new ParallelRaceGroup(new autoShooting(.65), new Index(false)), new ParallelRaceGroup(new PIDDrive(80, .8), new SequentialCommandGroup(new LowerIntake(), new IntakeCom())), 
    new PIDDrive(-80, .85), new ParallelRaceGroup(new autoShooting(.60), new Index(false), new IntakeCom()));
  }
}
