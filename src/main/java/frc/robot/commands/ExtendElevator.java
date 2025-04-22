// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Elevator;
import java.security.InvalidParameterException;

/** Command that extends on elevator on the robot */
public class ExtendElevator extends Command {

  private Elevator elevator;
  private double setpoint;

  /** Creates a new ExtendElevator. */
  public ExtendElevator(int level) {
    this.elevator = RobotContainer.elevator;
    if (level == 1) {
      setpoint = Constants.Elevator.L1_SETPOINT;
    } else if (level == 2) {
      setpoint = Constants.Elevator.L2_SETPOINT;
    } else {
      throw new InvalidParameterException("Invalid level");
    }
    addRequirements(this.elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.elevator.extendElevator(this.setpoint);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    this.elevator.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
