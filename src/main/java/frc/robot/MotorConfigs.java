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

  private static SparkMaxConfig leadingMotorConfig;
  private static SparkMaxConfig followingMotorConfig;

  public static void initRollerConfigs(SparkMax leadingMotor, SparkMax followerMotor) {
    SparkMaxConfig generalIntakeRollerConfig = new SparkMaxConfig();
    generalIntakeRollerConfig.idleMode(Constants.IntakeRollers.INTAKE_MOTOR_IDLE_MODE);
    generalIntakeRollerConfig.smartCurrentLimit(Constants.IntakeRollers.INTAKE_MOTOR_CURRENT_LIMIT);

    leadingMotorConfig = new SparkMaxConfig().apply(generalIntakeRollerConfig);
    followingMotorConfig = new SparkMaxConfig().apply(generalIntakeRollerConfig);

    followingMotorConfig.follow(leadingMotor, Constants.IntakeRollers.INTAKE_FOLLOWER_INVERSE_STATE);
    leadingMotorConfig.inverted(Constants.IntakeRollers.UPPER_INTAKE_MOTOR_INVERTED);

    leadingMotor.configure(
        leadingMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    followerMotor.configure(
        followingMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
  }

  public static void initElevatorConfigs(SparkMax leadingMotor, SparkMax followerMotor) {
    SparkMaxConfig generalElevatorConfig = new SparkMaxConfig();
    generalElevatorConfig.idleMode(Constants.Elevator.ELEVATOR_MOTOR_IDLE_MODE);
    generalElevatorConfig.smartCurrentLimit(Constants.Elevator.ELEVATOR_MOTOR_CURRENT_LIMIT);

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
