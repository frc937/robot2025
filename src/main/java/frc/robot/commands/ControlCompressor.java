// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Compressor;

/** Keeps the compressor at the pressure the pressure switch looks for. */
public class ControlCompressor extends Command {
  private Compressor compressor;
  private int callsAtPressure = 0;

  /** Create a new ControlCompressor */
  public ControlCompressor() {
    compressor = RobotContainer.compressor;
    addRequirements(compressor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (compressor.isAtPressure()) {
      callsAtPressure++;
    } else {
      callsAtPressure = Math.max(0, callsAtPressure - 1);
    }
    if (callsAtPressure < Constants.Compressor.COMPRESSOR_PRESSURE_SWITCH_DEADBAND) {
      compressor.activateCompressor();
    } else {
      compressor.disableCompressor();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    compressor.disableCompressor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
