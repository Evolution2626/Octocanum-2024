// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI.Port;
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
  private ADXRS450_Gyro gyro;
  private MecanumDrive m_robotDrive;
  private double angleBase = 0.0;
  private boolean angleSet = false;
  private PIDController correction = new PIDController(0.1, 0.1, 0);
 





  /** Creates a new TankDrivetrain. */
  public Drivetrain() {
    gyro = new ADXRS450_Gyro(Port.kOnboardCS0);


    avantgauche = new Spark(deviceNumber.DeviceNumberAvantGauche);
    avantdroit = new Spark(deviceNumber.DeviceNumberAvantDroit);
    arrieredroit = new Spark(deviceNumber.DeviceNumberArriereDroit);
    arrieregauche = new Spark(deviceNumber.DeviceNumberArriereGauche);

    avantdroit.setInverted(true);
    avantgauche.setInverted(false);
    arrieredroit.setInverted(true);
    arrieregauche.setInverted(true);
    m_robotDrive = new MecanumDrive(avantgauche, arrieregauche, avantdroit, arrieredroit);

    

  }
  public double getGyroAngle(){
    return Math.abs(gyro.getAngle());
  }
  public double getGyroAngleRaw(){
    return gyro.getAngle();
  }

  public void resetGyroAngle(){
    gyro.reset();
  }



  public void setDriveMode(boolean isTankDrive){
    this.isTankDrive = isTankDrive;
  }

  public void drive(double rightX, double rightY, double leftX, double leftY, double leftTrigger, double rightTrigger){
    if(isTankDrive == true){
      driveTank(Math.pow(rightY, 3), Math.pow(leftY, 3));
    }else{
      driveCartesianGyro(rightX , leftY ,leftX , leftTrigger, rightTrigger);
    }
  }

  public void  driveCartesianGyro(double rightX, double leftY ,double leftx, double leftTrigger, double rightTrigger) {
    double sideValue = 0.0;
  
    if(rightTrigger > 0){
      if(!angleSet){
        angleBase = getGyroAngleRaw();
        angleSet = true;
      }
      sideValue = rightTrigger;
      m_robotDrive.driveCartesian(0, sideValue, -correction.calculate(getGyroAngleRaw(), angleBase));//correctionRotation(rightTrigger)
    }
    else if(leftTrigger > 0){
      if(!angleSet){
        angleBase = getGyroAngleRaw();
        angleSet = true;
      }
      sideValue = -leftTrigger;
      m_robotDrive.driveCartesian(0, sideValue, -correction.calculate(getGyroAngleRaw(), angleBase));//correctionRotation(rightTrigger)
    }
    else{
      angleSet = false;
    if(getGyroAngle() >= 45 && getGyroAngle() <= 135 || getGyroAngle() >= 225 && getGyroAngle() <= 315){
      m_robotDrive.driveCartesian(-leftY, leftx, -rightX, gyro.getRotation2d());
    }else{
      m_robotDrive.driveCartesian(leftY, -leftx, -rightX, gyro.getRotation2d());
    }
  }
  }
  
  

  public void driveTank(double joystickDroit, double joystickGauche){
    avantdroit.set(joystickDroit);
    avantgauche.set(joystickGauche);
    arrieregauche.set(joystickGauche);
    arrieredroit.set(joystickDroit);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler 
    SmartDashboard.putNumber("Gyro", gyro.getAngle());
    if(isTankDrive == true){
      SmartDashboard.putString("Mode","drivetank");
    }else{
      SmartDashboard.putString("Mode", "mecanum");
    }

    if(getGyroAngle() >= 360){
      resetGyroAngle();
    }
  }
}
