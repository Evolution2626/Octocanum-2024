// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrainSwitch;
import frc.robot.subsystems.Drivetrain;


public class OctocanumDrivetrainCommand extends CommandBase {
  private CommandXboxController xboxController;
  private DriveTrainSwitch driveTrainSwitch;
  private Drivetrain drivetrain;
  private boolean isTankdrive;
  /** Creates a new PistonOctocanum. */
  public OctocanumDrivetrainCommand(CommandXboxController xboxController, DriveTrainSwitch driveTrainSwitch, Drivetrain drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.xboxController = xboxController;
    this.driveTrainSwitch = driveTrainSwitch;
    this.drivetrain = drivetrain;

    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
        drivetrain.drive(xboxController.getRightX(), xboxController.getRightY(), xboxController.getLeftX(), xboxController.getLeftY());
    
    
   
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
