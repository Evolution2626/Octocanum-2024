// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class Tourelle extends SubsystemBase {
  OperatorConstants deviceNumber = new OperatorConstants();

  // il y aura peut-etre 3 moteurs?
  private TalonSRX tourner;

  /** Creates a new Tourelle. */
  public Tourelle() {

    tourner = new TalonSRX(deviceNumber.DeviceNumberTourner);

    tourner.setInverted(true);

  }

  public void controle(double vitesse_tourner){

    tourner.set(TalonSRXControlMode.PercentOutput, vitesse_tourner);
}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
