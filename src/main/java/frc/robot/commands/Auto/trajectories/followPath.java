package frc.robot.commands.Auto.trajectories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiConsumer;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.auto.PIDConstants;
import com.pathplanner.lib.auto.RamseteAutoBuilder;
import com.pathplanner.lib.auto.SwerveAutoBuilder;
import com.pathplanner.lib.commands.PPRamseteCommand;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.driveTrain;

public class followPath {

        // This will load the file "FullAuto.path" and generate it with a max velocity of 4 m/s and a max acceleration of 3 m/s^2
    // for every path in the group
    
    ArrayList<PathPlannerTrajectory> pathGroup = PathPlanner.loadPathGroup("FullAuto", new PathConstraints(1, 1));
    static PathPlannerTrajectory traj = PathPlanner.loadPath("test", new PathConstraints(1, 1));
    static double ks = 0;
    static double kv = 0;
    static double ka = 0;
    static Subsystem m_dTrain = driveTrain.getM_DriveTrain();

    static PPRamseteCommand controller1 = new PPRamseteCommand(
        traj,
        driveTrain.getM_DriveTrain().getPoseSupplier(),
        new RamseteController(),
        new SimpleMotorFeedforward(ks, kv, ka),
        driveTrain.getM_DriveTrain().getKinematics(),
        driveTrain.getM_DriveTrain().getWheelSpeedSupplier(),
        new PIDController(0, 0, 0), // Left controller. Tune these values for your robot. Leaving them 0 will only use feedforwards.
        new PIDController(0, 0, 0),
        driveTrain.getM_DriveTrain().getBiConsumer(),
        m_dTrain
        );

    // This is just an example event map. It would be better to have a constant, global event map
    // in your code that will be used by all path following commands.
    HashMap<String, Command> eventMap = new HashMap<>();



    // Create the AutoBuilder. This only needs to be created once when robot code starts, not every time you want to create an auto command. A good place to put this is in RobotContainer along with your subsystems.
    RamseteAutoBuilder autoBuilder = new RamseteAutoBuilder(
        driveTrain.getM_DriveTrain().getPoseSupplier(), // Pose2d supplier
        driveTrain.getM_DriveTrain()::resetPose, // Pose2d consumer, used to reset odometry at the beginning of auto
        new RamseteController(), // SwerveDriveKinematics
        driveTrain.getM_DriveTrain().getKinematics(),
        driveTrain.getM_DriveTrain().getBiConsumer(),
        eventMap,
        driveTrain.getM_DriveTrain() // The drive subsystem. Used to properly set the requirements of path following commands
    );

    //Command fullAuto = autoBuilder.fullAuto(pathGroup);
    
    public static Command getAutoCommand(){
        return controller1;
    }
}
