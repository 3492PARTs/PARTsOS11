// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.teleop.*;
import frc.robot.commands.Auto.BackUp;
import frc.robot.commands.Auto.IntakeCom;
import frc.robot.commands.Auto.LowGoalButGood;

import frc.Utils.controls.beanieController;
import frc.robot.Constants.intakePivot;


import frc.robot.commands.Auto.PIDDrive;
import frc.robot.commands.Auto.ShootNScoot;
import frc.robot.commands.Auto.TwoBallLow;
import frc.robot.commands.Auto.flipFast;
import frc.robot.commands.Auto.turnRobo;
import frc.robot.commands.Auto.twoBallAuto;
import frc.robot.commands.Auto.twoBallDiagonal;
import frc.robot.commands.teleop.driveControllerCom;
import frc.robot.commands.teleop.elevatorUp;
import frc.robot.commands.teleop.indexCom;
import frc.robot.commands.teleop.intakePivotCom;
import frc.robot.commands.teleop.limelightTurn;
import frc.robot.commands.teleop.shootCom;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.driveTrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  Command com;
  
  private SendableChooser<Command> m_chooser = new SendableChooser<>();
  public static beanieController driverController = new beanieController(0);
  public static beanieController operatorController = new beanieController(1);

  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();


      SmartDashboard.putData("Choose Autonomous Mode", m_chooser);
      m_chooser.setDefaultOption("Two Ball auto", new twoBallAuto());
      m_chooser.addOption("SHOOT and SCoot", new ShootNScoot());
      m_chooser.addOption("PID TUNE", new PIDDrive(-48)); // move forward 48 in
      m_chooser.addOption("TUNETURN",new turnRobo(5));
      m_chooser.addOption("Two ball diagonal", new twoBallDiagonal());
      m_chooser.addOption("flipFast", new flipFast());
      m_chooser.addOption("low goal 2", new TwoBallLow());
      m_chooser.addOption("shooter test", new autoShooting(1));


      






  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private void configureButtonBindings() {
    // limelightbButton = new JoystickButton(driverInteraction.getDriverInteraction().getButtonBox(), 6);
    // limelightbButton.whenPressed(new limelightTurn());

    operatorController.getRightBumper().whileHeld(new limelightTurn());
    operatorController.getDpadUp().whileHeld(new elevatorUp());
    operatorController.getY().whileHeld(new intakePivotCom(intakePivot.up));
    operatorController.getA().whileHeld(new intakePivotCom(intakePivot.down));






    driverController.getRightBumper().whileHeld(new shootCom(.65)); // out low
    driverController.getRightTriggerButton(.2).whileHeld(new shootCom(1)); // out high
    driverController.getX().whileHeld(new indexCom(1)); // in
    driverController.getB().whileHeld(new indexCom(-1)); // out
    driverController.getY().whileHeld(new intakePivotCom(intakePivot.up));
    driverController.getA().whileHeld(new intakePivotCom(intakePivot.down));
    driverController.getLeftTriggerButton(.5).whileHeld(new IntakeCom());
    driverController.getLeftBumper().whileHeld(new limelightTurn());
    

    


    //TODO: bind new commands to buttons
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_chooser.getSelected();
  }
}
