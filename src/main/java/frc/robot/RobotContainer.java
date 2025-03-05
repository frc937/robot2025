// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Controllers.Keymap;
import frc.robot.commands.ControlCompressor;
import frc.robot.commands.ExtendElevator;
import frc.robot.commands.RetractElevator;
import frc.robot.commands.Intake.RunIntakeRollers;
import frc.robot.commands.Intake.RunIntakeRollersReverse;
import frc.robot.subsystems.Compressor;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.intake.IntakeRollers;

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

  /** Singleton instance of {@link Compressor} for the whole robot. */
  public static Compressor compressor = new Compressor();

  /** Singleton instance of {@link Elevator} for the whole robot */
  public static Elevator elevator = new Elevator();

  /** Singleton instance of the {@link IntakeRollers} for the whole robot */
  public static IntakeRollers intakeRollers = new IntakeRollers();

  /*
   * ************
   * * COMMANDS *
   * ************
   */

  /** Singleton instance of the {@link ControlCompressor} for the whole robot. */
  public static ControlCompressor controlCompressor = new ControlCompressor();

  /** Singleton instance of the {@link ExtendElevator} for the whole robot. */
  public static ExtendElevator extendElevator = new ExtendElevator();

  /** Singleton instance of the {@link RetractElevator} for the whole robot */
  public static RetractElevator retractElevator = new RetractElevator();
/** Singleton instance of the {@link RunIntakeRollers} for the whole robot */
  public static RunIntakeRollers runIntakeRollers = new RunIntakeRollers();
/**Singleton instance of the {@link RunIntakeRollersReverse} */
  public static RunIntakeRollersReverse runIntakeRollersReverse = new RunIntakeRollersReverse();


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
