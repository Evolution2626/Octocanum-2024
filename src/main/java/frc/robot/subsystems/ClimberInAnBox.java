// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class ClimberInAnBox extends SubsystemBase {
  private TalonSRX climberDroit;
  private TalonSRX climberGauche;
  /** Creates a new ClimberInAnBox. */
  public ClimberInAnBox() {
    OperatorConstants deviceNumber = new OperatorConstants();
    climberDroit = new TalonSRX(deviceNumber.DeviceNumberClimberDroit);
    climberGauche = new TalonSRX(deviceNumber.DeviceNumberClimberGauche);

    climberDroit.setInverted(false);
    climberGauche.setInverted(false);
  }
  public void climb(double activated){
    climberDroit.set(TalonSRXControlMode.PercentOutput, activated);
    climberGauche.set(TalonSRXControlMode.PercentOutput, activated);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
