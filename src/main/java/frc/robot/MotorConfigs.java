// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

/** Add your docs here. */
public final class MotorConfigs {

  public static SparkMaxConfig generalConfig;

  public static SparkMaxConfig upperMotorConfig;
  public static SparkMaxConfig lowerMotorConfig;

  public static void initRollerConfigs(SparkMax leadingMotor, SparkMax followerMotor) {
    SparkMaxConfig generalIntakeRollerConfig = new SparkMaxConfig();
    generalIntakeRollerConfig.idleMode(Constants.IntakeRollers.INTAKE_MOTOR_IDLE_MODE);
    generalIntakeRollerConfig.smartCurrentLimit(Constants.IntakeRollers.INTAKE_MOTOR_CURRENT_LIMIT);

    upperMotorConfig = new SparkMaxConfig().apply(generalIntakeRollerConfig);
    lowerMotorConfig = new SparkMaxConfig().apply(generalIntakeRollerConfig);

    lowerMotorConfig.follow(followerMotor, Constants.IntakeRollers.INTAKE_FOLLOWER_INVERSE_STATE);
    upperMotorConfig.inverted(Constants.IntakeRollers.UPPER_INTAKE_MOTOR_INVERTED);

    leadingMotor.configure(
        lowerMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    followerMotor.configure(
        upperMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
  }
}
