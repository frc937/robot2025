// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/** The subsystem for the compressor */
public class Compressor extends SubsystemBase {
  private Relay compressorRelay;
  private DigitalInput pressureSwitch;

  /** Creates a new Compressor. */
  public Compressor() {
    this.compressorRelay = new Relay(Constants.Compressor.COMPRESSOR_RELAY_PORT);
    this.pressureSwitch = new DigitalInput(Constants.Compressor.PRESSURE_SWITCH_DIO_PORT);
  }

  /**
   * Activates the compressor.
   *
   * @return If the compressor was able to be turned on.
   */
  public boolean activateCompressor() {
    if (!this.pressureSwitch.get()) {
      this.compressorRelay.set(Value.kForward);
      return true;
    } else {
      DriverStation.reportWarning(
          "Warning: Attempted to activate compressor while pressure switch activated", false);
      return false;
    }
  }

  /** Disables the compressor. */
  public void disableCompressor() {
    this.compressorRelay.set(Relay.Value.kOff);
  }

  /**
   * Returns true if the compressor is at pressure. False otherwise.
   *
   * @return true if the compressor is at pressure. False otherwise.
   */
  public boolean isAtPressure() {
    return this.pressureSwitch.get();
  }

  @Override
  public void periodic() {}
}
