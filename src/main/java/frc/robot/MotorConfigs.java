// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

/** Utility class for configuring desired motors */
public final class MotorConfigs {

  private static SparkMaxConfig leadingMotorConfig;
  private static SparkMaxConfig followingMotorConfig;

  private static SparkMaxConfig configureGeneralConfig(IdleMode idleMode, int motorCurrentLimit) {
    SparkMaxConfig generalConfig = new SparkMaxConfig();
    generalConfig.idleMode(idleMode);
    generalConfig.smartCurrentLimit(motorCurrentLimit);
    return generalConfig;
  }

  /**
   * Configures the Roller Motors for the intake, using the relavent constants.
   *
   * @param leadingMotor The main motor leading the follower motor.
   * @param followerMotor The motor that follows the leading motor.
   */
  public static void initRollerConfigs(SparkMax leadingMotor, SparkMax followerMotor) {
    SparkMaxConfig generalIntakeRollerConfig =
        configureGeneralConfig(
            Constants.IntakeRollers.INTAKE_MOTOR_IDLE_MODE,
            Constants.IntakeRollers.INTAKE_MOTOR_CURRENT_LIMIT);

    leadingMotorConfig = new SparkMaxConfig().apply(generalIntakeRollerConfig);
    followingMotorConfig = new SparkMaxConfig().apply(generalIntakeRollerConfig);

    followingMotorConfig.follow(
        leadingMotor, Constants.IntakeRollers.INTAKE_FOLLOWER_INVERSE_STATE);
    leadingMotorConfig.inverted(Constants.IntakeRollers.UPPER_INTAKE_MOTOR_INVERTED);

    leadingMotor.configure(
        leadingMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    followerMotor.configure(
        followingMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
  }

  /**
   * Configures the Elevator Motors for the intake, using the relavent constants.
   *
   * @param leadingMotor The main motor leading the follower motor.
   * @param followerMotor The motor that follows the leading motor.
   */
  public static void initElevatorConfigs(SparkMax leadingMotor, SparkMax followerMotor) {
    SparkMaxConfig generalElevatorConfig =
        configureGeneralConfig(
            Constants.Elevator.ELEVATOR_MOTOR_IDLE_MODE,
            Constants.Elevator.ELEVATOR_MOTOR_CURRENT_LIMIT);

    leadingMotorConfig = new SparkMaxConfig().apply(generalElevatorConfig);
    followingMotorConfig = new SparkMaxConfig().apply(generalElevatorConfig);

    followingMotorConfig.follow(leadingMotor, Constants.Elevator.ELEVATOR_FOLLOWER_INVERSE_STATE);
    leadingMotorConfig.inverted(Constants.Elevator.RIGHT_ELEVATOR_MOTOR_INVERTED);

    leadingMotor.configure(
        leadingMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    followerMotor.configure(
        followingMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
  }
}
