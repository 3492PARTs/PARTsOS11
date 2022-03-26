// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Index;
import frc.robot.commands.autoShooting;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TwoBallLow extends SequentialCommandGroup {
  /** Creates a new TwoBallLow. */
  public TwoBallLow() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new PIDDrive(-26, .8), new ParallelRaceGroup(new autoShooting(.65), new Index(false)),
     new ParallelCommandGroup(new LowerIntake(), new SequentialCommandGroup(new PIDDrive(4), new turnRobo(-15), new ParallelRaceGroup( new PIDDrive(52, .9) , new IntakeCom()))),
      new PIDDrive(-52, .9), new ParallelRaceGroup(new autoShooting(.65), new Index(), new IntakeCom())
     );
  }
}
