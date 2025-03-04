// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;

/**
 * Deploys the intake pneumatics and runs the rollers; effectively deploys the intake on the bot.
 */
public class DeployIntake extends ParallelDeadlineGroup {
  /** Creates a new DeployIntake. */
  public DeployIntake() {
    super(new RunIntakeRollers(), new DeployPneumatics());
  }
}
