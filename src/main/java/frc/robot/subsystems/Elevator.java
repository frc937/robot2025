// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.MotorConfigs;

/** Elevator of the robot */
public class Elevator extends SubsystemBase {

  private SparkMax leftMotor;
  private SparkMax rightMotor;
  private DigitalInput topLimitSwitch;
  private DigitalInput bottomLimitSwitch;

  /** Creates a new Elevator. */
  public Elevator() {

    this.leftMotor = new SparkMax(Constants.Elevator.LEFT_ELEVATOR_MOTOR_ID, MotorType.kBrushless);
    this.rightMotor =
        new SparkMax(Constants.Elevator.RIGHT_ELEVATOR_MOTOR_ID, MotorType.kBrushless);
    this.topLimitSwitch = new DigitalInput(Constants.Elevator.ELEVATOR_TOP_LIMIT_SWITCH_DIO_PORT);
    this.bottomLimitSwitch =
        new DigitalInput(Constants.Elevator.ELEVATOR_BOTTOM_LIMIT_SWITCH_DIO_PORT);

    MotorConfigs.initElevatorConfigs(rightMotor, leftMotor);
  }

  /** Runs the Elevator motor */
  public void extendElevator() {

    rightMotor.set(Constants.Elevator.ELEVATOR_MOTOR_SPEED);
  }

  /** Runs the elevator motors in reverse */
  public void retractElevator() {

    rightMotor.set(-Constants.Elevator.ELEVATOR_MOTOR_SPEED);
  }

  /**
   * Returns a Boolean Value that is whether or not the extension limit switch(for the elevator) has
   * been activated.
   *
   * @return the status of the top limit switch
   */
  public boolean getTopLimitSwitch() {
    /*assumes the limit switch is wired to be closed */
    return !topLimitSwitch.get();
  }

  /**
   * Returns a Boolean Value that is whether or not the retraction limit switch(for the elevator)
   * has been activated.
   *
   * @return the status of the bottom limit switch
   */
  public boolean getBottomLimitSwitch() {
    /*assumes the limit switch is wired to be closed */
    return !bottomLimitSwitch.get();
  }

  /** Stops the elevator motors */
  public void stop() {

    rightMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
