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
  private DoubleSolenoid avantgauche;
  private DoubleSolenoid avantdroit;
  private DoubleSolenoid arrieregauche;
  private DoubleSolenoid arrieredroit;


  /** Creates a new DriveTrainSwitch. */
  public DriveTrainSwitch() {

    avantgauche = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, pcm.PISTON_FRONT_LEFT_FORWARD, pcm.PISTON_FRONT_LEFT_REVERSE);
    avantdroit = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, pcm.PISTON_FRONT_RIGHT_FORWARD, pcm.PISTON_FRONT_RIGHT_REVERSE);
    arrieredroit = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, pcm.PISTON_BACK_RIGHT_FORWARD, pcm.PISTON_BACK_RIGHT_REVERSE);
    arrieregauche = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, pcm.PISTON_BACK_LEFT_FORWARD, pcm.PISTON_BACK_LEFT_REVERSE);
  }

  public void ActivateOctocanum() {
    avantgauche.set(DoubleSolenoid.Value.kForward);
    avantdroit.set(DoubleSolenoid.Value.kForward);
    arrieredroit.set(DoubleSolenoid.Value.kForward);
    arrieregauche.set(DoubleSolenoid.Value.kForward);

  }

  public void ActivateMecanum() {
    avantgauche.set(DoubleSolenoid.Value.kReverse);
    avantdroit.set(DoubleSolenoid.Value.kReverse);
    arrieredroit.set(DoubleSolenoid.Value.kReverse);
    arrieregauche.set(DoubleSolenoid.Value.kReverse);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
