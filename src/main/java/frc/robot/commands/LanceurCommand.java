// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lanceur;

public class LanceurCommand extends CommandBase {
  private XboxController xboxController;
  private Lanceur lanceur;
  /** Creates a new LanceurCommand. */
  public LanceurCommand(XboxController xboxController, Lanceur lanceur) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.xboxController = xboxController;
    this.lanceur = lanceur;
    addRequirements(lanceur);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(xboxController.getYButtonPressed()){
      lanceur.controle(xboxController.getLeftTriggerAxis(), xboxController.getRightTriggerAxis());
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
