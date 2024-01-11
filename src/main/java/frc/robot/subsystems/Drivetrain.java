// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive.WheelSpeeds;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class Drivetrain extends SubsystemBase {
  OperatorConstants deviceNumber = new OperatorConstants();

  private Spark avantgauche;
  private Spark avantdroit;
  private Spark arrieregauche;
  private Spark arrieredroit;
  public boolean isTankDrive;




  /** Creates a new TankDrivetrain. */
  public Drivetrain() {


    avantgauche = new Spark(deviceNumber.DeviceNumberAvantGauche);
    avantdroit = new Spark(deviceNumber.DeviceNumberAvantDroit);
    arrieredroit = new Spark(deviceNumber.DeviceNumberArriereDroit);
    arrieregauche = new Spark(deviceNumber.DeviceNumberArriereGauche);

    avantdroit.setInverted(true);
    avantgauche.setInverted(false);
    arrieredroit.setInverted(true);
    arrieregauche.setInverted(true);
    

  }

  public void setDriveMode(boolean isTankDrive){
    this.isTankDrive = isTankDrive;
  }

  public void drive(double rightX, double rightY, double leftX, double leftY){
    if(isTankDrive == true){
      driveTank(Math.pow(rightY, 3) * 0.75, Math.pow(leftY, 3) * 0.75);
      SmartDashboard.putString("Mode","drivetank");
    }else{
      driveCartesian(Math.pow(leftY, 3) * 0.75, -Math.pow(leftX, 3) * 0.75, -Math.pow(rightX, 3) * 0.75);
      SmartDashboard.putString("Mode", "mecanum");
    }
  }
  public void  driveCartesian(double xSpeed, double ySpeed, double rotation) {

    WheelSpeeds wheelSpeed = MecanumDrive.driveCartesianIK(xSpeed, ySpeed, rotation);
    avantdroit.set(wheelSpeed.frontRight);
    avantgauche.set(wheelSpeed.frontLeft);
    arrieregauche.set(wheelSpeed.rearLeft);
    arrieredroit.set(wheelSpeed.rearRight);
  }

  public void driveTank(double joystickDroit, double joystickGauche){
    avantdroit.set(joystickDroit);
    avantgauche.set(joystickGauche);
    arrieregauche.set(joystickGauche);
    arrieredroit.set(joystickDroit);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
