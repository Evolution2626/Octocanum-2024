// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {

    public final int DeviceNumberAvantDroit = 1;
    public final int DeviceNumberAvantGauche = 0;
    public final int DeviceNumberArriereDroit = 3;
    public final int DeviceNumberArriereGauche = 9;

    public final int DeviceNumberClimberDroit = 0;
    public final int DeviceNumberClimberGauche = 0;
    
    public final int DeviceNumberShooterGauche = 0;
    public final int DeviceNumberShooterDroit = 0;
  }

  public static class PCM{
    public final int PISTON_FORWARD = 0;
    public final int PISTON_REVERSE = 1;
    
  }
}