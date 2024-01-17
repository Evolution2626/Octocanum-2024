// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;
public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  private TalonSRX shooterGauche;
  private TalonSRX shooterDroit;
  public Shooter() {
    OperatorConstants deviceNumber = new OperatorConstants();
    shooterGauche = new TalonSRX(deviceNumber.DeviceNumberShooterGauche);
    shooterDroit = new TalonSRX(deviceNumber.DeviceNumberShooterDroit);
    
    shooterGauche.setInverted(false);
    shooterDroit.setInverted(false);

  }
  public void shoot(double activated){
    shooterGauche.set(TalonSRXControlMode.PercentOutput, activated);
    shooterDroit.set(TalonSRXControlMode.PercentOutput, activated);


  }

  @Override
  public void periodic() {

    // This method will be called once per scheduler run
  }
}
