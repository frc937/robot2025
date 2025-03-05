// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.intake.IntakeRollers;

/** Command for running the intake rollers in reverse*/
public class RunIntakeRollersReverse extends Command {

  private IntakeRollers intakeRollers;
  /** Creates a new RunIntakeRollersReverse. */
  public RunIntakeRollersReverse() {
    this.intakeRollers = RobotContainer.intakeRollers;
    addRequirements(this.intakeRollers);


  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    this.intakeRollers.runRollersReverse();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    this.intakeRollers.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
