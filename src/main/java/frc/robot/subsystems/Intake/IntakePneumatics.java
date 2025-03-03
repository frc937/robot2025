// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakePneumatics extends SubsystemBase {
  private Relay pneumaticsRelay;

  /** Creates a new IntakePneumatics. */
  public IntakePneumatics() {
    pneumaticsRelay = new Relay(Constants.IntakePneumatics.INTAKE_SOLENOID_RELAY_ID);
  }

  /** Extends the Intake. */
  public void extend() {
    pneumaticsRelay.set(Relay.Value.kForward);
  }

  /** Retracts the Intake. */
  public void retract() {
    pneumaticsRelay.set(Relay.Value.kReverse);
  }

  /** Sets pistons to off */
  public void off() {
    pneumaticsRelay.set(Relay.Value.kOff);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
