// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeRollers extends SubsystemBase {
  private SparkMax upperMotor;
  private SparkMax lowerMotor;
  private DigitalInput limitSwitch;

  /** Creates a new IntakeRollers. */
  public IntakeRollers() {
    this.lowerMotor =
        new SparkMax(Constants.IntakeRollers.LOWER_INTAKE_MOTOR_ID, MotorType.kBrushless);
    this.upperMotor =
        new SparkMax(Constants.IntakeRollers.UPPER_INTAKE_MOTOR_ID, MotorType.kBrushless);
    this.limitSwitch = new DigitalInput(Constants.IntakeRollers.INTAKE_LIMIT_SWITCH_DIO_PORT);

    configureMotors();
  }

  private void configureMotors() {
    SparkMaxConfig config = new SparkMaxConfig();
    config.smartCurrentLimit(Constants.IntakeRollers.INTAKE_MOTOR_CURRENT_LIMIT);
    config.idleMode(Constants.IntakeRollers.INTAKE_IDLE_MODE);

    SparkMaxConfig lowerMotorConfig = new SparkMaxConfig().apply(config);
    SparkMaxConfig upperMotorConfig = new SparkMaxConfig().apply(config);

    upperMotorConfig.inverted(Constants.IntakeRollers.UPPER_INTAKE_MOTOR_INVERTED);
    lowerMotorConfig.follow(this.upperMotor, Constants.IntakeRollers.INTAKE_FOLLOWER_INVERSE_STATE);

    upperMotor.configure(
        upperMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    lowerMotor.configure(
        lowerMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  /** Runs the rollers. */
  public void runRollers() {
    upperMotor.set(Constants.IntakeRollers.INTAKE_MOTOR_SPEED);
  }

  /** Runs the rollers in reverse. */
  public void runRollersReverse() {
    upperMotor.set(-Constants.IntakeRollers.INTAKE_MOTOR_SPEED);
  }

  /**
   * Returns a boolean value on whether or not the extension Limit Switch (for the intake rollers)
   * has been activated.
   *
   * @return the status of the top limit switch
   */
  public boolean getLimitSwitch() {
    /* Assumes the limit switch is wired to be normally closed. */
    return !limitSwitch.get();
  }

  /** Stops the belt. */
  public void stop() {
    upperMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
