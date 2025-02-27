// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import java.util.function.Supplier;

/** Add your docs here. */
public final class Controllers {
  public static CommandXboxController pilotController =
      new CommandXboxController(Constants.Controllers.PILOT_CONTROLLER_PORT);

  public static CommandXboxController operatorController =
      new CommandXboxController(Constants.Controllers.OPERATOR_CONTROLLER_PORT);

  /**
   * Represents an axis on a controller. Used to pass into {@link Controllers#getControllerAxis}.
   */
  public enum ControllerAxis {
    /** Left stick X axis (left to right) */
    LeftX,
    /** Left stick Y axis (up and down) */
    LeftY,
    /** Right stick X axis (left to right) */
    RightX,
    /** Right stick Y axis (up and down) */
    RightY
  }

  /** Enumeration of possible keymaps for the robot. */
  public enum Keymap {
    /** Default keymap defined by drive team. Uses both controllers. */
    Default,
    /** Keymap that doesn't use the {@link operatorController}. */
    Operatorless,
  }

  /** Configures the robot with default keybinds for competition. */
  private static void configureDefaultKeybinds() {
    /* TODO: Add controller default keybinds eventually */
  }

  /**
   * Configures the robot with keybinds for if we can't use the operator controller. (All buttons
   * bound to pilotController)
   */
  private static void configureOperatorlessKeybinds() {
    /* TODO: Add controller operatorless keybinds eventually */
  }

  /**
   * Configures robot keybinds.
   *
   * <p>Should be called at least once somewhere in robot initialization.
   *
   * @param keymap Which keymap to be used. Supplied by {@link Controllers.Keymap}.
   */
  public static void configureKeybinds(Keymap keymap) {
    CommandScheduler.getInstance().getActiveButtonLoop().clear();
    switch (keymap) {
      case Default:
        configureDefaultKeybinds();
        break;
      case Operatorless:
        configureOperatorlessKeybinds();
        break;
      default:
        throw new IllegalArgumentException(
            "configureKeybinds() received an illegal enum constant argument");
    }
  }

  /**
   * Scales a controller axis (joystick value).
   *
   * @param axis Axis value to scale.
   * @return Scaled axis value.
   */
  private static double scaleAxis(double axis) {
    double deadbanded =
        MathUtil.applyDeadband(axis, Constants.Controllers.DRIVER_CONTROLLER_DEADBAND);
    return -Math.pow(deadbanded, 2) * Math.signum(axis);
  }

  /**
   * Gets a given controller axis (a joystick value).
   *
   * @throws IllegalArgumentException If an enum value for ControllerAxis is passed that doesn't
   *     exist within that type
   * @param controller The controller to get the axis from. Should probably pass a public field of
   *     {@link Controllers}
   * @param controllerAxis Enum representing which axis (left stick vs. right stick and x axis vs. y
   *     axis) to get.
   * @param scaled Whether or not to deadband and quadratically scale the axis.
   * @return Axis value.
   */
  public static double getControllerAxis(
      CommandXboxController controller, ControllerAxis controllerAxis, boolean scaled) {
    if (scaled) {
      return scaleAxis(getControllerAxis(controller, controllerAxis, false));
    } else {
      switch (controllerAxis) {
        case LeftX:
          return controller.getLeftX();
        case LeftY:
          return controller.getLeftY();
        case RightX:
          return controller.getRightX();
        case RightY:
          return controller.getRightY();
        default:
          throw new IllegalArgumentException(
              "getControllerAxis() received an illegal enum constant argument");
      }
    }
  }

  /**
   * Gets supplier for a given controller axis (a joystick value).
   *
   * @param controller The controller to get the axis from. Should probably pass a public field of
   *     {@link Controllers}
   * @param controllerAxis Enum representing which axis (left stick vs. right stick and x axis vs. y
   *     axis) to get.
   * @param scaled Whether or not to deadband and quadratically scale the axis.
   * @return Supplier that, when .get() is run, will return the requested axis value.
   */
  public static Supplier<Double> getControllerAxisSupplier(
      CommandXboxController controller, ControllerAxis controllerAxis, boolean scaled) {
    return () -> getControllerAxis(controller, controllerAxis, scaled);
  }
}
