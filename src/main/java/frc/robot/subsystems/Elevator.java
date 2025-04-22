// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.MotorConfigs;

/** Elevator of the robot */
public class Elevator extends SubsystemBase {

  private SparkMax leftFollowMotor;
  private SparkMax rightLeadMotor;

  private ShuffleboardTab debug = Shuffleboard.getTab("Debug");

  private GenericEntry encoderValue = debug.add("Elevator Encoder value", 0.0).getEntry();

  /** Creates a new Elevator. */
  public Elevator() {

    this.leftFollowMotor =
        new SparkMax(Constants.Elevator.LEFT_ELEVATOR_MOTOR_ID, MotorType.kBrushless);
    this.rightLeadMotor =
        new SparkMax(Constants.Elevator.RIGHT_ELEVATOR_MOTOR_ID, MotorType.kBrushless);

    MotorConfigs.initElevatorConfigs(rightLeadMotor, leftFollowMotor);
    // pid = this.rightLeadMotor.getClosedLoopController();
  }

  public void rawExtendElevator() {
    rightLeadMotor.set(Constants.Elevator.ELEVATOR_LIFT_SPEED);
    leftFollowMotor.set(-Constants.Elevator.ELEVATOR_LIFT_SPEED);
  }

  public void rawRetractElevator() {
    rightLeadMotor.set(-Constants.Elevator.ELEVATOR_LIFT_SPEED);
    leftFollowMotor.set(Constants.Elevator.ELEVATOR_LIFT_SPEED);
  }

  /** Runs the Elevator motor */
  public void extendElevator(double target) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  /** Runs the elevator motors in reverse */
  public void resetElevator() {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  /** Stops the elevator motors */
  public void stop() {
    rightLeadMotor.set(0);
    leftFollowMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    encoderValue.setDouble(rightLeadMotor.getAbsoluteEncoder().getPosition());
  }
}
