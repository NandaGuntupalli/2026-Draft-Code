// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TurretConstants;

public class Turret extends SubsystemBase {
  /** Creates a new Turret. */
  private TalonFX turretMotor;
  private CANcoder absoluteEncoder;

  public Turret() {
      turretMotor = new TalonFX(1);
      turretMotor.getConfigurator().apply(TurretConstants.turretConfigs);

      absoluteEncoder = new CANcoder(2);
  }

  public double getAngle(){
    return absoluteEncoder.getPosition().getValueAsDouble();
  }

  public void setPosition(double angle) {
    turretMotor.setPosition(angle);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
