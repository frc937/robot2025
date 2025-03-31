// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;

/**
 * Auto that just taxis (or more accurately, moves us out of the auto starting box.) Taxi time and
 * velocity can be tuned in Constants.Drive.
 */
public class TaxiAuto extends ParallelDeadlineGroup {
  /** Creates a new TaxiAuto. */
  public TaxiAuto() {
    super(new WaitCommand(Constants.Auto.TAXI_WAIT_DURATION));
    addCommands(new DriveAutoRobotOriented(-Constants.Auto.TAXI_AUTO_SPEED, 0));
  }
}
