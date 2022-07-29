// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.autoShooting;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TurnRightandTaxi extends SequentialCommandGroup {
  /** Creates a new TurnRightandTaxi. */
  public TurnRightandTaxi() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new Delay(), 
    new ParallelCommandGroup( new LowerIntake(), new autoShooting(.98), new SequentialCommandGroup(new WaitCommand(.5), new Index())), new turnRobo(10), new ParallelRaceGroup(new PIDDrive(36 , .8), new IntakeCom()), new PIDDrive(-36, .75), new ParallelCommandGroup(new turnRobo(-10), new ParallelRaceGroup(new autoShooting(.98), new Index(), new IntakeCom())),  new ParallelCommandGroup(new flipFast(), new RaiseIntake()),
    new ParallelCommandGroup(new PIDDrive(-36, .9)));  }
}