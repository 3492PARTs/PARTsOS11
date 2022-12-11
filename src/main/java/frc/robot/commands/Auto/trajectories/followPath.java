package frc.robot.commands.Auto.trajectories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiConsumer;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.auto.RamseteAutoBuilder;
import com.pathplanner.lib.auto.SwerveAutoBuilder;
import com.pathplanner.lib.commands.PPRamseteCommand;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import frc.robot.subsystems.driveTrain;

public class followPath {

        // This will load the file "FullAuto.path" and generate it with a max velocity of 4 m/s and a max acceleration of 3 m/s^2
    // for every path in the group
    
    ArrayList<PathPlannerTrajectory> pathGroup = PathPlanner.loadPathGroup("FullAuto", new PathConstraints(1, 1));
    PathPlannerTrajectory traj = PathPlanner.loadPath("test", new PathConstraints(1, 1));
    double ks = 0;
    double kv = 0;
    double ka = 0;
    driveTrain m_dTrain = driveTrain.getM_DriveTrain();

    PPRamseteCommand controller1 = new PPRamseteCommand(
        traj,
        driveTrain.getM_DriveTrain().getPose(),
        new RamseteController(),
        new SimpleMotorFeedforward(ks, kv, ka),
        driveTrain.getM_DriveTrain().getWheelSpeeds(),
        new PIDController(0, 0, 0), // Left controller. Tune these values for your robot. Leaving them 0 will only use feedforwards.
        new PIDController(0, 0, 0),
        (BiConsumer<Double,Double> )driveTrain.getM_DriveTrain()::driveVolts,
        m_dTrain
        );

    // This is just an example event map. It would be better to have a constant, global event map
    // in your code that will be used by all path following commands.
    HashMap<String, Command> eventMap = new HashMap<>();

    eventMap.put("marker1", new PrintCommand("Passed marker 1"));
    eventMap.put("intakeDown", new IntakeDown());

    // Create the AutoBuilder. This only needs to be created once when robot code starts, not every time you want to create an auto command. A good place to put this is in RobotContainer along with your subsystems.
    RamseteAutoBuilder autoBuilder = new RamseteAutoBuilder(
        driveTrain.getM_DriveTrain()::getPose, // Pose2d supplier
        driveTrain.getM_DriveTrain()::resetPose, // Pose2d consumer, used to reset odometry at the beginning of auto
        driveControlRamsete.getRamsete(), // SwerveDriveKinematics
        new PIDConstants(5.0, 0.0, 0.0), // PID constants to correct for translation error (used to create the X and Y PID controllers)
        new PIDConstants(0.5, 0.0, 0.0), // PID constants to correct for rotation error (used to create the rotation controller)
        driveSubsystem::setModuleStates, // Module states consumer used to output to the drive subsystem
        eventMap,
        driveSubsystem // The drive subsystem. Used to properly set the requirements of path following commands
    );

    Command fullAuto = autoBuilder.fullAuto(pathGroup);
    
}
