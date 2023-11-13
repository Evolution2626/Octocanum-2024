// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSwitch;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;

public class OctocanumDrivetrainCommand extends CommandBase {
  private XboxController xboxController;
  private DriveTrainSwitch driveTrainSwitch;
  private Drivetrain drivetrain;
  private boolean isTankdrive;
  Limelight limelight;
  /** Creates a new PistonOctocanum. */
  public OctocanumDrivetrainCommand(XboxController xboxController, DriveTrainSwitch driveTrainSwitch, Drivetrain drivetrain, Limelight limelight) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.xboxController = xboxController;
    this.driveTrainSwitch = driveTrainSwitch;
    this.drivetrain = drivetrain;
    this.limelight = limelight;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(xboxController.getAButtonReleased()){
      driveTrainSwitch.ActivateOctocanum();
      isTankdrive = true;
    }

    else if(xboxController.getBButtonReleased()){
      driveTrainSwitch.ActivateMecanum();
      isTankdrive = false;
    }
    if(isTankdrive == true){
      drivetrain.driveTank(xboxController.getRightY(), xboxController.getLeftY());
    }
    else{
      drivetrain.driveCartesian(xboxController.getLeftY(), -xboxController.getLeftX(), -xboxController.getRightX());
    }
    double[] robotPosition = limelight.getRobotPosition();
    if(robotPosition!=null&&robotPosition.length>=6 )
    {
    SmartDashboard.putNumber("xPosition", robotPosition[0]);
    SmartDashboard.putNumber("yPosition", robotPosition[1]);
    SmartDashboard.putNumber("zPosition", robotPosition[2]);
    SmartDashboard.putNumber("xRotation", robotPosition[3]);
    SmartDashboard.putNumber("yRotation", robotPosition[4]);
    SmartDashboard.putNumber("zRotation", robotPosition[5]);
    }
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
