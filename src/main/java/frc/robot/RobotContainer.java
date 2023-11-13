// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.Limelight1mCommand;
import frc.robot.commands.LimelightCentrerCommand;
import frc.robot.commands.OctocanumDrivetrainCommand;
import frc.robot.subsystems.DriveTrainSwitch;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
private Limelight limelight;  
private Drivetrain drivetrain;
private DriveTrainSwitch driveTrainSwitch;
private XboxController xboxController;
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    limelight = new Limelight();
    drivetrain = new Drivetrain();
    driveTrainSwitch = new DriveTrainSwitch();
    xboxController = new XboxController(0);
    drivetrain.setDefaultCommand(new OctocanumDrivetrainCommand(xboxController, driveTrainSwitch, drivetrain, limelight));
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
    new JoystickButton(xboxController, Button.kX.value).onTrue(new Limelight1mCommand(drivetrain,limelight, xboxController));
    new JoystickButton(xboxController, Button.kY.value).onTrue(new LimelightCentrerCommand(drivetrain,limelight, xboxController));
   
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
