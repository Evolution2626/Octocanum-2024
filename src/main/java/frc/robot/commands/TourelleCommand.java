// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Tourelle;

public class TourelleCommand extends CommandBase {
  private XboxController xboxController;
  private Tourelle tourelle;
  /** Creates a new TourelleCommand. */
  public TourelleCommand(XboxController xboxController, Tourelle tourelle) {
    this.xboxController = xboxController;
    this.tourelle = tourelle;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(tourelle);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(xboxController.getRightTriggerAxis() > 0){
    tourelle.controle(xboxController.getRightTriggerAxis());
    }
    else if(xboxController.getLeftTriggerAxis() > 0){
    tourelle.controle(-xboxController.getLeftTriggerAxis());
    }
    else{
      tourelle.controle(0);
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
