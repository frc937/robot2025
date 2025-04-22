// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive;
import java.util.function.Supplier;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveRobot extends Command {
  private final Drive drive;
  private final Supplier<Double> xSupplier, ySupplier, zSupplier;

  /**
   * Drives the robot.
   *
   * @param xSupplier The joystick value for the Y axis. [-1, 1] left positive.
   * @param ySupplier The joystick value for the Y axis. [-1, 1] back positive.
   * @param zSupplier The joystick value for the Z axis. [-1, 1] counterclockwise positive.
   * @param isFieldOriented If the robot should drive field oriented or robot oriented.
   */
  public DriveRobot(
      Supplier<Double> xSupplier,
      Supplier<Double> ySupplier,
      Supplier<Double> zSupplier,
      boolean isFieldOriented) {
    this.xSupplier = xSupplier;
    this.ySupplier = ySupplier;
    this.zSupplier = zSupplier;
    this.drive = RobotContainer.drive;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.drive.driveRobot(
        xSupplier.get() * Constants.Drivetrain.MOVEMENT_MULTIPLITER,
        ySupplier.get() * Constants.Drivetrain.TURN_MULTIPLIER);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
