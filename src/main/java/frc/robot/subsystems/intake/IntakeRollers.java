// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


/**Subsystem for the intake rollers */
public class IntakeRollers extends SubsystemBase {
  
  private SparkMax upperMotor;
  private SparkMax lowerMotor;
  private DigitalInput limitSwitch;
  
  /** Creates a new IntakeRollers. */
  public IntakeRollers() {

    this.upperMotor = new SparkMax(Constants.IntakeRollers.UPPER_INTAKE_MOTOR_ID, MotorType.kBrushless);
    this.lowerMotor = new SparkMax( Constants.IntakeRollers.LOWER_INTAKE_MOTOR_ID, MotorType.kBrushless);
    this.limitSwitch = new DigitalInput(Constants.IntakeRollers.INTAKE_LIMIT_SWITCH_DIO_PORT);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
