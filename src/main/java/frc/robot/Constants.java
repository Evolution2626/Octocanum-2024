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

    public final int DeviceNumberAvantDroit = 6;
    public final int DeviceNumberAvantGauche = 5;
    public final int DeviceNumberArriereDroit = 7;
    public final int DeviceNumberArriereGauche = 3;

    public final int DeviceNumberTourner = 0; // a changer

    public static final int kDriverControllerPort = 0;


  
  }
    public static class PCM{
      public final int PISTON_BACK_LEFT_FORWARD = 0;
      public final int PISTON_BACK_LEFT_REVERSE = 1;
      public final int PISTON_BACK_RIGHT_FORWARD = 2;
      public final int PISTON_BACK_RIGHT_REVERSE = 3;

      public final int PISTON_FRONT_LEFT_FORWARD = 4;
      public final int PISTON_FRONT_LEFT_REVERSE = 5;
      public final int PISTON_FRONT_RIGHT_FORWARD = 6;
      public final int PISTON_FRONT_RIGHT_REVERSE = 7;
}
}