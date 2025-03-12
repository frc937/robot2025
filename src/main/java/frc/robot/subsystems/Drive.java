// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** The subsystem that represents the drivetrain. */
public class Drive extends SubsystemBase {

  /** Creates a new Drive. */
  public Drive() {}

  /**
   * Drives the robot in either field relative or robot relative.
   *
   * @param translation {@link Translation2d} that represents the commanded robot velocities on the
   *     x and y axes. Front-left positive. Relative to the field.
   * @param z Robot angular velocity around the z-axis in radians per second. Counter-clockwise is
   *     positive.
   * @param isFieldOriented If the robot should either drive field oriented or robot oriented.
   */
  public void driveRobot(Translation2d translation, double z, boolean isFieldOriented) {}

  /** Stops all motors in the subsystem. */
  public void stop() {}

  /** Points the wheels toward the inside and stops the wheels from moving in any direction. */
  public void enterXMode() {}

  /**
   * Zeroes the NavX gyro. Mostly used for resetting the angle for field-oriented drive (for now).
   *
   * <p>Somewhat notably, this will also reset odometry to the same position it's currently at, but
   * facing towards zero.
   */
  public void zeroGyro() {}

  /**
   * Gets the maximum speed the robot chassis can achieve in m/s.
   *
   * @return Maximum speed the robot chassis can achieve in m/s.
   */
  public double getMaximumSpeed() {}

  /**
   * Gets the maximum angular speed the robot chassis can achieve in rad/s.
   *
   * @return Maximum angular speed the robot chassis can achieve in rad/s.
   */
  public double getMaximumAngularSpeed() {}

  /**
   * Set the heading correction capabilities of YAGSL. Should only be enabled when heading
   * correction capabilities are in use
   *
   * @param state SwerveDrive.headingCorrection state
   */
  public void setHeadingCorrection(boolean state) {}

  /**
   * Takes [-1, 1] joystick-like inputs and converts them to a {@link ChassisSpeeds} object that
   * represents the commanded robot velocities
   *
   * @param translationX joystick input for the left to right axis. [-1, 1], left is positive.
   * @param translationY joystick input for the forward to backward axis. [-1, 1], forward is
   *     positive.
   * @param headingX x component of the cartesian angle of the robot's heading
   * @param headingY y component of the cartesian angle of the robot's heading
   * @return {@link ChassisSpeeds} object that represents the commanded robot velocities
   */
  public ChassisSpeeds getTargetSpeeds(
      double translationX, double translationY, double headingX, double headingY) {}

  /**
   * Sets the drive mode in SmartDashboard.
   *
   * <p><strong> THIS DOES NOT SET THE ROBOT'S DRIVE MODE</strong>
   *
   * @param driveMode The mode to display in SmartDashboard.
   */
  public void setDriveMode(String driveMode) {}

  /**
   * Returns the heading of the robot.
   *
   * @return The heading of the robot.
   */
  public Rotation2d getHeading() {}

  /** Runs every scheduler run. */
  @Override
  public void periodic() {}
}
