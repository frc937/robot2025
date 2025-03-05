// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;


import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


/**Subsystem for the intake rollers */
public class IntakeRollers extends SubsystemBase {
  
  private SparkMax upperMotor;
  private SparkMax lowerMotor;
  private DigitalInput limitSwitch;
  
  /** Creates a new IntakeRollers. */
  public IntakeRollers() {

    this.upperMotor = new SparkMax(Constants.IntakeRollers.UPPER_INTAKE_MOTOR_ID, MotorType.kBrushless);
    this.lowerMotor = new SparkMax( Constants.IntakeRollers.LOWER_INTAKE_MOTOR_ID, MotorType.kBrushless);
    this.limitSwitch = new DigitalInput(Constants.IntakeRollers.INTAKE_LIMIT_SWITCH_DIO_PORT);

    configureMotors();
  }

  private void configureMotors(){

SparkMaxConfig generalConfig = new SparkMaxConfig();
generalConfig.idleMode(Constants.IntakeRollers.INTAKE_MOTOR_IDLE_MODE);
generalConfig.smartCurrentLimit(Constants.IntakeRollers.INTAKE_MOTOR_CURRENT_LIMIT);

SparkMaxConfig upperMotorConfig = new SparkMaxConfig(). apply(generalConfig);
SparkMaxConfig lowerMotorConfig = new SparkMaxConfig(). apply (generalConfig);

lowerMotorConfig.follow(this.upperMotor ,Constants.IntakeRollers.INTAKE_FOLLOWER_INVERSE_STATE );
upperMotorConfig.inverted(Constants.IntakeRollers.UPPER_INTAKE_MOTOR_INVERTED);

this.lowerMotor.configure(
lowerMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);

this.upperMotor.configure(
upperMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);




  }

  public void runRollers(){
upperMotor.set(Constants.IntakeRollers.INTAKE_MOTOR_SPEED);


  }


  public void runRollersReverse(){

upperMotor.set(-Constants.IntakeRollers.INTAKE_MOTOR_SPEED);

  }

  public boolean getLimitSwitch(){

return !limitSwitch.get();

  }

  public void stop(){

    upperMotor.set(0);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
