// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

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
  /** The constants for the Elevator  */
  public static final class Elevator  {

    /** Motor ID for the left elevator motor */
    public static final int LEFT_ELEVATOR_MOTOR_ID = 0;

    /** Motor ID for the left elevator motor */
    public static final int RIGHT_ELEVATOR_MOTOR_ID = 0;  

    /** Dio port Id for the top elevator limit switch*/
    public static final int ELEVATOR_TOP_LIMIT_SWITCH_DIO_PORT =0;
    
    /** DIO port ID for the bottom elevator limit switch */
    public static final int ELEVATOR_BOTTOM_LIMIT_SWITCH_DIO_PORT =0;

    /** Inversion state of the right elevator motor */
    public static final boolean RIGHT_ELEVATOR_MOTOR_INVERTED = false;

    /** spead we want to run the elevator at */
    public static final double ELEVATOR_MOTOR_SPEED = 0;

    /** Inversion state for the elevator follower motor */
    public static final boolean ELEVATOR_FOLLOWER_INVERSE_STATE = false;

    /** The current limit (in amps) for the elevator motor(s). */
    public static final int ELEVATOR_MOTOR_CURRENT_LIMIT = 0;

    /** Idle mode for the elevator motors.(Either break or coast) */
    public static final IdleMode ELEVATOR_MOTOR_IDLE_MODE = IdleMode.kBrake;
  }

}
