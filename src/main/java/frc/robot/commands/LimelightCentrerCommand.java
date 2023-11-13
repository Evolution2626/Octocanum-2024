// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj.XboxController;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LimelightCentrerCommand extends PIDCommand {

  Drivetrain drivetrain;
  Limelight limelight;
  XboxController controller;
  public static boolean stop = false;

  /** Creates a new LimelightCommand1m. */
  public LimelightCentrerCommand(Drivetrain drivetrain, Limelight limelight, XboxController controller) {
    super(
        // The controller that the command will use
        new PIDController(0.5, 0, 0),
        // This should return the measurement
        () -> limelight.getRobotPosition()[1],
        // This should return the setpoint (can also be a constant)
        () -> -3,
        // This uses the output
        output -> {
          // Use the output here
          stop = false;
          if(controller.getLeftBumperPressed()){
            stop = true;
          }
          drivetrain.driveCartesian(0, -output, 0);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    this.limelight = limelight;
    this.drivetrain = drivetrain;
    addRequirements(drivetrain, limelight);
  
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
