// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive.WheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class Drivetrain extends SubsystemBase {
  OperatorConstants deviceNumber = new OperatorConstants();

  private TalonSRX avantgauche;
  private TalonSRX avantdroit;
  private TalonSRX arrieregauche;
  private TalonSRX arrieredroit;





  /** Creates a new TankDrivetrain. */
  public Drivetrain() {


    avantgauche = new TalonSRX(deviceNumber.DeviceNumberAvantGauche);
    avantdroit = new TalonSRX(deviceNumber.DeviceNumberAvantDroit);
    arrieredroit = new TalonSRX(deviceNumber.DeviceNumberArriereDroit);
    arrieregauche = new TalonSRX(deviceNumber.DeviceNumberArriereGauche);

    avantdroit.setInverted(true);
    avantgauche.setInverted(false);
    arrieredroit.setInverted(true);
    arrieregauche.setInverted(false);
    

  }
  public void  driveCartesian(double xSpeed, double ySpeed, double rotation) {

    WheelSpeeds wheelSpeed = MecanumDrive.driveCartesianIK(xSpeed, ySpeed, rotation);
    avantdroit.set(TalonSRXControlMode.PercentOutput, wheelSpeed.frontRight);
    avantgauche.set(TalonSRXControlMode.PercentOutput, wheelSpeed.frontLeft);
    arrieregauche.set(TalonSRXControlMode.PercentOutput, wheelSpeed.rearLeft);
    arrieredroit.set(TalonSRXControlMode.PercentOutput, wheelSpeed.rearRight);
  }
  public void driveTank(double joystickDroit, double joystickGauche){
    avantdroit.set(TalonSRXControlMode.PercentOutput, joystickDroit);
    avantgauche.set(TalonSRXControlMode.PercentOutput, joystickGauche);
    arrieregauche.set(TalonSRXControlMode.PercentOutput, joystickGauche);
    arrieredroit.set(TalonSRXControlMode.PercentOutput, joystickDroit);


  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
