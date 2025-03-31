// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Counter {
  private int i;
  private final int max;
  private final int min;
  private Increment incr;
  private Decrement decr;
  private RunActiveCommand activeCommand;
  private final Command[] commands;

  public class Increment extends Command {

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      commands[i].end(true);
      i = Math.min(max, i + 1);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {}

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return true;
    }
  }

  public class Decrement extends Command {

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      commands[i].end(true);
      i = Math.max(min, i - 1);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {}

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return true;
    }
  }

  public class RunActiveCommand extends Command {

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      commands[i].initialize();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      commands[i].execute();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
      commands[i].end(interrupted);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return commands[i].isFinished();
    }
  }

  /** Creates a new Counter. */
  public Counter(Command... commands) {
    this.i = 0;
    this.max = commands.length;
    this.min = 0;
    ;
    this.commands = commands;
    this.incr = new Increment();
    this.decr = new Decrement();
    this.activeCommand = new RunActiveCommand();
    // Use addRequirements() here to declare subsystem dependencies.
  }

  public Increment incrementCommand() {
    return this.incr;
  }

  public Decrement decrementCommand() {
    return this.decr;
  }

  public RunActiveCommand runActiveCommand() {
    return this.activeCommand;
  }
}
