// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.MotorConfigs;

/** Subsystem for the intake rollers */
public class IntakeRollers extends SubsystemBase {

  private SparkMax upperMotor;
  private SparkMax lowerMotor;
  private DigitalInput limitSwitch;

  /** Creates a new IntakeRollers. */
  public IntakeRollers() {

    this.upperMotor =
        new SparkMax(Constants.IntakeRollers.UPPER_INTAKE_MOTOR_ID, MotorType.kBrushless);
    this.lowerMotor =
        new SparkMax(Constants.IntakeRollers.LOWER_INTAKE_MOTOR_ID, MotorType.kBrushless);
    this.limitSwitch = new DigitalInput(Constants.IntakeRollers.INTAKE_LIMIT_SWITCH_DIO_PORT);

    MotorConfigs.initRollerConfigs(upperMotor, lowerMotor);
  }

  /** Runs the Intake Rollers */
  public void runRollers() {
    upperMotor.set(Constants.IntakeRollers.INTAKE_MOTOR_SPEED);
  }

  /** Runs the Intake Rollers in reverse */
  public void runRollersReverse() {

    upperMotor.set(-Constants.IntakeRollers.INTAKE_MOTOR_SPEED);
  }

  /**
   * Returns a boolean value on whether or not the limit switch (for the intake) is activated
   *
   * @return status of the limit switch
   */
  public boolean getLimitSwitch() {

    return !limitSwitch.get();
  }

  /** stops the rollers */
  public void stop() {

    upperMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
