// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Tourelle;

public class TourelleLimeLightCommand extends PIDCommand{
Limelight limelight;
XboxController xboxController;
Tourelle tourelle;
public TourelleLimeLightCommand(Tourelle tourelle, Limelight limelight, XboxController controller) {
  super(
      // The controller that the command will use
      new PIDController(0.5, 0, 0),
      // This should return the measurement
      () -> limelight.getRobotPosition()[1],//TODO change for the right tracking target
      // This should return the setpoint (can also be a constant)
      () -> -3,
      // This uses the output
      output -> {
        // Use the output here
        
        if(controller.getLeftBumperPressed()){
          tourelle.controle(output);
        }
        
      });
  // Use addRequirements() here to declare subsystem dependencies.
  // Configure additional PID options by calling `getController` here.
  this.limelight = limelight;
  this.tourelle = tourelle;
  addRequirements(tourelle, limelight);

}

// Returns true when the command should end.
@Override
public boolean isFinished() {
  return false;
}
}

