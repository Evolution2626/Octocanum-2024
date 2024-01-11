// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PCM;

public class DriveTrainSwitch extends SubsystemBase {
  PCM pcm = new PCM();
  private DoubleSolenoid piston;



  /** Creates a new DriveTrainSwitch. */
  public DriveTrainSwitch() {

    piston = new DoubleSolenoid(1, PneumaticsModuleType.CTREPCM, pcm.PISTON_FORWARD, pcm.PISTON_REVERSE);
    
  }

  public void ActivateDrivetank() {
    piston.set(DoubleSolenoid.Value.kReverse);
    

  }

  public void ActivateMecanum() {
    piston.set(DoubleSolenoid.Value.kForward);


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
