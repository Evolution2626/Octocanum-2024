// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import java.time.temporal.ValueRange;

import com.ctre.phoenix.sensors.AbsoluteSensorRange;
//import java.time.temporal.ValueRange;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Limelight1mCommand extends PIDCommand {
  /** Creates a new Limelight1mCommand. */
  Drivetrain drivetrain;
  Limelight limelight;
 XboxController controller;
  public static boolean stop = false;

  public Limelight1mCommand(Drivetrain drivetrain, Limelight limelight, XboxController controller) {
    
    super(
        // The controller that the command will use
        new PIDController(0.45, 0, 0),
        // This should return the measurement
        () -> limelight.getRobotPosition()[0],
        // This should return the setpoint (can also be a constant)
        () -> 5.9,
        // This uses the output
        output -> {
          // Use the output here
      stop = false;
          
          if(controller.getLeftBumperPressed() || limelight.getRobotPosition()[0] >= 5.7 && limelight.getRobotPosition()[0] <= 6.0){
            stop = true;
          }
          drivetrain.driveCartesian( -output,0, 0);
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
    return stop;
  }
}
