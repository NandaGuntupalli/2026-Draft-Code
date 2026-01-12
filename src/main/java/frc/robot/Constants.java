// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.MetersPerSecondPerSecond;
import static edu.wpi.first.units.Units.Seconds;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.StaticFeedforwardSignValue;

import edu.wpi.first.units.measure.LinearAcceleration;
import edu.wpi.first.units.measure.LinearVelocity;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static class TurretConstants {

    public static final LinearVelocity maxVelocity = MetersPerSecond.of(2.26 * 0.95); // 2.26*.9
    public static final LinearAcceleration maxAcceleration =
        maxVelocity.div(Seconds.of(0.5)); // .25

    public static final MotorOutputConfigs motorOutputConfigs =
        new MotorOutputConfigs()
            .withInverted(
                InvertedValue.CounterClockwise_Positive)
            .withNeutralMode(NeutralModeValue.Brake);
    public static final CurrentLimitsConfigs currentLimitConfigs =
        new CurrentLimitsConfigs().withStatorCurrentLimit(45).withStatorCurrentLimitEnable(true);

    public static final MotionMagicConfigs motionMagicConfigs =
        new MotionMagicConfigs()
            .withMotionMagicCruiseVelocity(maxVelocity.in(MetersPerSecond))
            .withMotionMagicAcceleration(maxAcceleration.in(MetersPerSecondPerSecond));

    public static final Slot0Configs slot0Configs =
        new Slot0Configs()
            .withKS(1) 
            .withKV(1) 
            .withKA(1) 
            .withKP(1) 
            .withKI(1)
            .withKD(1) 
            .withStaticFeedforwardSign(StaticFeedforwardSignValue.UseVelocitySign);


    public static final TalonFXConfiguration turretConfigs =
        new TalonFXConfiguration()
            .withCurrentLimits(currentLimitConfigs)
            .withSlot0(slot0Configs)
            .withMotionMagic(motionMagicConfigs)
            .withMotorOutput(motorOutputConfigs);
  }
}
