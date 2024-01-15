// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ClimberInAnBox;

public class ClimberInABoxCommand extends CommandBase {
  private ClimberInAnBox climberInAnBox;
  private CommandXboxController xboxController;
  /** Creates a new ClimberInABoxCommand. */
  public ClimberInABoxCommand(ClimberInAnBox climberInAbox, CommandXboxController xboxController) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.climberInAnBox = climberInAbox;
    this.xboxController = xboxController;
    addRequirements(climberInAbox);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climberInAnBox.climb(xboxController.getRightTriggerAxis());
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
