// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  /** Constants that are relating to the controllers. */
  public static final class Controllers {
    /** Driver station port number for the pilot controller */
    public static final int PILOT_CONTROLLER_PORT = 0;

    /** Driver station port number for the operator controller */
    public static final int OPERATOR_CONTROLLER_PORT = 2;

    /** Axis deadband for driver controller. */
    public static final double DRIVER_CONTROLLER_DEADBAND = 0.1;
  }

  /** The constants for the Compressor */
  public static final class Compressor {
    /** The DIO port for the pressure switch. */
    public static final int PRESSURE_SWITCH_DIO_PORT = 0;

    /** The relay port for the compressor */
    public static final int COMPRESSOR_RELAY_PORT = 0;

    /**
     * How many periodic loops do we want to wait for to turn off the compressor. Used to prevent
     * rapidly turning on and off the compressor.
     */
    public static final int COMPRESSOR_PRESSURE_SWITCH_DEADBAND = 50; /* 1 second */
  }

  /** The constants for the Elevator */
  public static final class Elevator {

    /** Motor ID for the left elevator motor */
    public static final int LEFT_ELEVATOR_MOTOR_ID = 11;

    /** Motor ID for the left elevator motor */
    public static final int RIGHT_ELEVATOR_MOTOR_ID = 15;

    /** Inversion state of the right elevator motor */
    public static final boolean RIGHT_ELEVATOR_MOTOR_INVERTED = false;

    /** Inversion state for the elevator follower motor */
    public static final boolean ELEVATOR_FOLLOWER_INVERSE_STATE = true;

    /** The current limit (in amps) for the elevator motor(s). */
    public static final int ELEVATOR_MOTOR_CURRENT_LIMIT = 60;

    /** Idle mode for the elevator motors (Either break or coast). */
    public static final IdleMode ELEVATOR_MOTOR_IDLE_MODE = IdleMode.kBrake;

    /** Pid for the elevator */
    public static final double[] ELEVATOR_PID = new double[] {0.225, 0.001, 0.01};

    /** Height of the first Elevator level */
    public static final double L1_SETPOINT = 0;

    /** Height of the second Elevator level */
    public static final double L2_SETPOINT = 0;

    /** Height of the third Elevator level */
    public static final double L3_SETPOINT = 0;

    /** Speed of the Elevator */
    public static final double ELEVATOR_LIFT_SPEED = 0.5;
  }

  public static final class IntakeRollers {

    /** Motor ID for the Upper intake motor */
    public static final int INTAKE_MOTOR_ID = 12;

    /** Dio port ID for the intake limit switch */
    public static final int INTAKE_LIMIT_SWITCH_DIO_PORT = 0;

    /** Inversion state of the upper intake motor */
    public static final boolean UPPER_INTAKE_MOTOR_INVERTED = false;

    /** speed we want the intake roller motors at */
    public static final double INTAKE_MOTOR_SPEED = 0.5;

    /** Inversion state of the followwer intake motor */
    public static final boolean INTAKE_FOLLOWER_INVERSE_STATE = false;

    /** The current limit (in amps) for the elevator motor(s). */
    public static final int INTAKE_MOTOR_CURRENT_LIMIT = 40;

    /** Idle mode for the elvator motors (Either break or coast) */
    public static final IdleMode INTAKE_MOTOR_IDLE_MODE = IdleMode.kBrake;
  }

  /** The constants for the drivetrain */
  public static final class Drivetrain {
    /** The max speed the robot can go in m/s */
    public static final double MAX_SPEED = Units.feetToMeters(14.5);

    /** Should the drivetrain motors break on */
    public static final boolean MOTOR_BREAK_ON_IDLE = true;

    /** An empty translation for the robot. */
    public static final Translation2d ZERO_TRANSLATION = new Translation2d();

    /** The theoretical max speed the robot can go in m/s */
    public static final double THEORETICAL_MAX_SPEED = 100;

    /** The theoretical max speed the robot can rotate */
    public static final double THEORETICAL_MAX_ANGULAR_SPEED = 100;

    /** Muliplier for movement speed (0.0 - 1.0) */
    public static final double MOVEMENT_MULTIPLITER = 0.80;

    /** Multiplier for turn speed (0.0 - 1.0) */
    public static final double TURN_MULTIPLIER = 0.80;

    /** ID for the front left motor */
    public static final int FRONT_LEFT_ID = 6; // 6

    /** ID for the front right motor */
    public static final int FRONT_RIGHT_ID = 8; // 8

    /** ID for the back left motor */
    public static final int BACK_LEFT_ID = 4; // 10

    /** ID for the back right motor */
    public static final int BACK_RIGHT_ID = 10; // 4
  }

  /** Constants for the autos */
  public static final class Auto {
    /** How long to wait before starting taxi */
    public static final double TAXI_WAIT_DURATION = 1.5;

    /** Speed of the taxi auto */
    public static final double TAXI_AUTO_SPEED = 0.50;

    /** Rotation of taxi auto */
    public static final double TAXI_AUTO_ROTATION = 0;
  }
}
