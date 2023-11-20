package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class Lanceur extends SubsystemBase {
  OperatorConstants deviceNumber = new OperatorConstants();

  // il y aura peut-etre 3 moteurs?
  private TalonSRX moteur1;
  private TalonSRX moteur2;


  /** Creates a new Tourelle. */
  public Lanceur() {

    moteur1 = new TalonSRX(deviceNumber.DeviceNumberMoteur1);
    moteur2 = new TalonSRX(deviceNumber.DeviceNumberMoteur2);


    moteur1.setInverted(true);
    moteur2.setInverted(true);


  }

  public void controle(double vitesse1, double vitesse2){
  

    moteur1.set(TalonSRXControlMode.PercentOutput, vitesse1);
    moteur2.set(TalonSRXControlMode.PercentOutput, vitesse2);
}
}