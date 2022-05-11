// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.REVPhysicsSim;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.simulation.AnalogGyroSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Utils.encoderDistanceSparkMax;
import frc.robot.Constants;
import frc.robot.Robot;

public class driveTrain extends SubsystemBase {

  int[] CANLeft = Constants.driveTrainLeftSideCANIds;
  int[] CANRight = Constants.driveTrainRightSideCANIds;

  REVPhysicsSim sRevPhysicsSim = REVPhysicsSim.getInstance();


  CANSparkMax left1 = new CANSparkMax(CANLeft[0], MotorType.kBrushless);
  CANSparkMax left2 = new CANSparkMax(CANLeft[1], MotorType.kBrushless);
  CANSparkMax left3 = new CANSparkMax(CANLeft[2], MotorType.kBrushless);



  private Field2d m_field = new Field2d();

  

  CANSparkMax right1 = new CANSparkMax(CANRight[0], MotorType.kBrushless);
  CANSparkMax right2 = new CANSparkMax(CANRight[1], MotorType.kBrushless);
  CANSparkMax right3 = new CANSparkMax(CANRight[2], MotorType.kBrushless);

  RelativeEncoder[] leftEncoders = {left1.getEncoder(), left2.getEncoder(), left3.getEncoder()};
  RelativeEncoder[] rightEncoders = {right1.getEncoder(), right2.getEncoder(), right3.getEncoder()};





  

  MotorControllerGroup leftControllerGroup = new MotorControllerGroup(left1, left2, left3);
  
  MotorControllerGroup rightControllerGroup = new MotorControllerGroup(right1, right2, right3);
  DifferentialDrive m_Drive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);
// right positive and continous
//left negative and continous
  AnalogGyro gyro = new AnalogGyro(1);
  private AnalogGyroSim gyroSim = new AnalogGyroSim(gyro);
/**
 * 
 * @return right positive and to infinity, left negative to negative infinity.
 */
  public double getAngle(){
    return gyro.getAngle();
  }

  private double prevAngle = 0;
  private long prevTime = 0;
  /**
   * @see make sure you discard first run each time
   * @return the angular velocity of the robot
   */
  public double gyroVelocity(){
    double angVel = 1000* ((gyro.getAngle() - prevAngle) / ((System.currentTimeMillis() - prevTime)));
    prevTime = System.currentTimeMillis();
    prevAngle = gyro.getAngle();
    return angVel;

  }

  private static driveTrain m_DriveTrain = new driveTrain();
  
  /** Creates a new driveTrain. */
  private driveTrain() {
    leftControllerGroup.setInverted(true);

    double rampRate = .75;
    left1.setOpenLoopRampRate(rampRate);
    left2.setOpenLoopRampRate(rampRate);
    left3.setOpenLoopRampRate(rampRate);

    right1.setOpenLoopRampRate(rampRate);
    right2.setOpenLoopRampRate(rampRate);
    right3.setOpenLoopRampRate(rampRate);

    sRevPhysicsSim.addSparkMax(right1, 3.28f, 5820.0f);
    sRevPhysicsSim.addSparkMax(right2, 3.28f, 5820.0f);
    sRevPhysicsSim.addSparkMax(right3, 3.28f, 5820.0f);

    sRevPhysicsSim.addSparkMax(left1, 3.28f, 5820.0f);
    sRevPhysicsSim.addSparkMax(left2, 3.28f, 5820.0f);
    sRevPhysicsSim.addSparkMax(left3, 3.28f, 5820.0f);

    m_dSim.setPose(new Pose2d(2, 2, new Rotation2d(30)));

    SmartDashboard.putData(m_field);


  }
  // Singleton Pattern use this, DO NOT make a new instance of a subsystem
  public static driveTrain getM_DriveTrain() {
      return m_DriveTrain;
  }

  public void move(double left , double right){
    m_Drive.tankDrive(left, right);

  } 

  public void arcadeDrive(double speed, double rotation){
    m_Drive.arcadeDrive(speed, rotation);
  }

  public encoderDistanceSparkMax getDriveTrainDistanceMeasure(){
    encoderDistanceSparkMax encoders = new encoderDistanceSparkMax(leftEncoders, rightEncoders,8.01 ,6*Math.PI);
    return encoders;
    
  }

  public double getLeftVelocity(){
    double VelocityAccumulator = 0;
    for (int i = 0; i < leftEncoders.length; i++) {
      VelocityAccumulator += leftEncoders[i].getVelocity();
    }
    return VelocityAccumulator/3;
  }

  public double getRightVelocity(){
    double VelocityAccumulator = 0;
    for (int i = 0; i < rightEncoders.length; i++) {
      VelocityAccumulator += rightEncoders[i].getVelocity();
    }
    return VelocityAccumulator/3;
  }

  public void calibrateGyro(){
    gyro.calibrate();
  }
  DifferentialDrivetrainSim m_dSim = Constants.drivesSim;

  DifferentialDriveOdometry m_Odometry = new DifferentialDriveOdometry(new Rotation2d(gyroSim.getAngle()));


  @Override
  public void simulationPeriodic() {
      // TODO Auto-generated method stub
    m_dSim.setInputs(leftControllerGroup.get() * RobotController.getInputVoltage(), rightControllerGroup.get() * RobotController.getInputVoltage());
    m_dSim.update(.02);
    

    

    gyroSim.setAngle(-m_dSim.getHeading().getDegrees() % 360);
    getDriveTrainDistanceMeasure().setGroupOneAverage(Units.metersToInches(m_dSim.getLeftPositionMeters()));
    getDriveTrainDistanceMeasure().setGroupTwoAverage(Units.metersToInches(m_dSim.getLeftPositionMeters()));
      
    m_Odometry.update(new Rotation2d(gyroSim.getAngle()), m_dSim.getLeftPositionMeters(), m_dSim.getRightPositionMeters());
    m_field.setRobotPose(m_Odometry.getPoseMeters());

  }
  
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if(Robot.isReal()){
      getDriveTrainDistanceMeasure().update();
    }
 
  }
}
