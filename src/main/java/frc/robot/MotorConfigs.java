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
  public static void initRollerConfigs(SparkMax leadingMotor) {
    SparkMaxConfig generalIntakeRollerConfig =
        configureGeneralConfig(
            Constants.IntakeRollers.INTAKE_MOTOR_IDLE_MODE,
            Constants.IntakeRollers.INTAKE_MOTOR_CURRENT_LIMIT);

    leadingMotorConfig = new SparkMaxConfig().apply(generalIntakeRollerConfig);

    leadingMotor.configure(
        leadingMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
  }

  /**
   * Configures the Elevator Motors for the intake, using the relavent constants.
   *
   * @param LeadMotor The main motor leading the follower motor.
   * @param FollowMotor The motor that follows the leading motor.
   */
  public static void initElevatorConfigs(SparkMax FollowMotor, SparkMax LeadMotor) {
    SparkMaxConfig generalElevatorConfig =
        configureGeneralConfig(
            Constants.Elevator.ELEVATOR_MOTOR_IDLE_MODE,
            Constants.Elevator.ELEVATOR_MOTOR_CURRENT_LIMIT);

    leadingMotorConfig = new SparkMaxConfig().apply(generalElevatorConfig);
    followingMotorConfig = new SparkMaxConfig().apply(generalElevatorConfig);

    followingMotorConfig.follow(LeadMotor, Constants.Elevator.ELEVATOR_FOLLOWER_INVERSE_STATE);
    leadingMotorConfig.inverted(Constants.Elevator.RIGHT_ELEVATOR_MOTOR_INVERTED);

    // leadingMotorConfig.closedLoop.pid(
    //     Constants.Elevator.ELEVATOR_PID[0],
    //     Constants.Elevator.ELEVATOR_PID[1],
    //     Constants.Elevator.ELEVATOR_PID[2]);
    // leadingMotorConfig.closedLoop.feedbackSensor(FeedbackSensor.kPrimaryEncoder);
    // followingMotorConfig.closedLoop.apply(leadingMotorConfig.closedLoop);

    LeadMotor.configure(
        leadingMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    FollowMotor.configure(
        followingMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
  }
}
