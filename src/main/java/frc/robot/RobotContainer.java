// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Controllers.Keymap;
import frc.robot.commands.ControlCompressor;
import frc.robot.commands.Intake.DeployIntake;
import frc.robot.commands.Intake.DeployPneumatics;
import frc.robot.commands.Intake.RunIntakeRollers;
import frc.robot.subsystems.Compressor;
import frc.robot.subsystems.Intake.IntakePneumatics;
import frc.robot.subsystems.Intake.IntakeRollers;

public class RobotContainer {

  /*
   * **************
   * * SUBSYSTEMS *
   * **************
   */

  /* We declare all subsystems as public static because we don't dependency inject because
   * injecting a dependency through six or seven commands in a chain of command groups would be
   * awful.
   */

  /** Singleton instance of the {@link Compressor} for the whole robot. */
  public static Compressor compressor = new Compressor();

  /** Singleton instance of the {@link IntakePneumatics} */
  public static IntakePneumatics intakePneumatics = new IntakePneumatics();

  /** Singleton instance of the {@link IntakeRollers} */
  public static IntakeRollers intakeRollers = new IntakeRollers();

  /*
   * ************
   * * COMMANDS *
   * ************
   */

  /** Singleton instance of {@link ControlCompressor} for the whole robot. */
  public static ControlCompressor controlCompressor = new ControlCompressor();

  /** Singleton instance of {@link DeployIntake} for the whole robot */
  public static DeployIntake deployIntake = new DeployIntake();

  /** Singleton instance of {@link DeployPneumatics} for the whole robot */
  public static DeployPneumatics deployPneumatics = new DeployPneumatics();

  /** Singleton instance of {@link RunIntakeRollers} for the whole robot */
  public static RunIntakeRollers runIntakeRollers = new RunIntakeRollers();

  /*
   * ***********************
   * * OTHER INSTANCE VARS *
   * ***********************
   */

  public RobotContainer() {
    configureBindings();

    compressor.setDefaultCommand(controlCompressor);
  }

  private void configureBindings() {

    Controllers.configureKeybinds(Keymap.Default);
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
