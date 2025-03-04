// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {

  private SparkMax leftMotor;
  private SparkMax rightMotor;
  private DigitalInput topLimitSwitch;
  private DigitalInput bottomLimitSwitch;

  /** Creates a new Elevator. */
  public Elevator() {

    this.leftMotor = new SparkMax(Constants.Elevator.LEFT_ELEVATOR_MOTOR_ID, MotorType.kBrushless);
    this.rightMotor = new SparkMax(Constants.Elevator.RIGHT_ELEVATOR_MOTOR_ID, MotorType.kBrushless);
    this.topLimitSwitch = new DigitalInput(Constants.Elevator.ELEVATOR_TOP_LIMIT_SWITCH_DIO_PORT);
    this.bottomLimitSwitch = new DigitalInput(Constants.Elevator.ELEVATOR_BOTTOM_LIMIT_SWITCH_DIO_PORT); 
  }

private void configureMotors() {
  SparkMaxConfig generalConfig = new SparkMaxConfig();
  generalConfig.idleMode(Constants.Elevator.ELEVATOR_MOTOR_IDLE_MODE);
  generalConfig.smartCurrentLimit(Constants.Elevator.ELEVATOR_MOTOR_CURRENT_LIMIT);

  SparkMaxConfig leftMotorConfig = new SparkMaxConfig().apply(generalConfig);
  SparkMaxConfig rightMotorConfig = new SparkMaxConfig().apply(generalConfig);

  leftMotorConfig.follow(this.rightMotor , Constants.Elevator.ELEVATOR_FOLLOWER_INVERSE_STATE);
  rightMotorConfig.inverted(Constants.Elevator.RIGHT_ELEVATOR_MOTOR_INVERTED);


  this.leftMotor.configure(leftMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  this.rightMotor.configure(rightMotorConfig,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
