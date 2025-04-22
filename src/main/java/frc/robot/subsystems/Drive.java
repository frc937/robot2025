// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/** The subsystem that represents the drivetrain. */
public class Drive extends SubsystemBase {
  private TalonFX fl, fr, bl, br;
  private TalonFXWrapper flr, frr;

  private DifferentialDrive dd;

  private static class TalonFXWrapper implements MotorController {
    private final TalonFX talon;

    public TalonFXWrapper(TalonFX talon) {
      this.talon = talon;
    }

    @Override
    public void set(double speed) {
      this.talon.set(speed);
    }

    @Override
    public double get() {
      return this.talon.get();
    }

    @Override
    public void setInverted(boolean isInverted) {
      this.talon.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
      return this.talon.getInverted();
    }

    @Override
    public void disable() {
      this.talon.disable();
    }

    @Override
    public void stopMotor() {
      this.talon.stopMotor();
    }
  }

  /** Creates a new Drive. */
  public Drive() {
    fl = new TalonFX(Constants.Drivetrain.FRONT_LEFT_ID);
    fr = new TalonFX(Constants.Drivetrain.FRONT_RIGHT_ID);
    bl = new TalonFX(Constants.Drivetrain.BACK_LEFT_ID);
    br = new TalonFX(Constants.Drivetrain.BACK_RIGHT_ID);

    bl.setControl(new Follower(fl.getDeviceID(), false));
    br.setControl(new Follower(fr.getDeviceID(), false));

    flr = new TalonFXWrapper(fl);
    frr = new TalonFXWrapper(fr);

    dd = new DifferentialDrive(flr, frr);

    // fl.setInverted(true);
    // bl.setInverted(true);
  }

  /**
   * Drives the robot in either field relative or robot relative.
   *
   * @param translation {@link Translation2d} that represents the commanded robot velocities on the
   *     x and y axes. Front-left positive. Relative to the field.
   * @param z Robot angular velocity around the z-axis in radians per second. Counter-clockwise is
   *     positive.
   * @param isFieldOriented If the robot should either drive field oriented or robot oriented.
   */
  public void driveRobot(double speed, double rot) {
    dd.arcadeDrive(speed, rot);
  }

  /** Stops all motors in the subsystem. */
  public void stop() {
    dd.stopMotor();
  }

  /** Runs every scheduler run. */
  @Override
  public void periodic() {}
}
