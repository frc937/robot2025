// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
}
