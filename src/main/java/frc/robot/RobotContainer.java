// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.ActivateDrivetrainCommand;
import frc.robot.commands.ActivateMecanumCommand;
import frc.robot.commands.OctocanumDrivetrainCommand;
import frc.robot.commands.ResetGryoCommand;
import frc.robot.subsystems.DriveTrainSwitch;
import frc.robot.subsystems.Drivetrain;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
private Drivetrain drivetrain;
private DriveTrainSwitch driveTrainSwitch;
private CommandXboxController xboxController = new CommandXboxController(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    
    drivetrain = new Drivetrain();
    driveTrainSwitch = new DriveTrainSwitch();
    xboxController = new CommandXboxController(0);
    drivetrain.setDefaultCommand(new OctocanumDrivetrainCommand(xboxController, driveTrainSwitch, drivetrain));
    configureBindings();

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
   

    xboxController.a().onTrue(new ActivateDrivetrainCommand(driveTrainSwitch, drivetrain));
    xboxController.b().onTrue(new ActivateMecanumCommand(driveTrainSwitch, drivetrain));
    xboxController.x().onTrue(new ResetGryoCommand(drivetrain));

 }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
   return null;
  }
}
