// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IO.DRIVE_IO;

public class DriveTrain extends SubsystemBase {
  final boolean is_testing = true;

  CANSparkMax leftMotorOne;
  CANSparkMax leftMotorTwo;

  CANSparkMax rightMotorOne;
  CANSparkMax rightMotorTwo;

  MotorControllerGroup left;
  MotorControllerGroup right;

  DifferentialDrive drive;
  
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    initialize();

    config();

    if (is_testing) {
      enableTesting();
    }
  }

  // For when we initalize all our parts.
  public void initialize() {
    leftMotorOne = new CANSparkMax(DRIVE_IO.LEFT_ONE, MotorType.kBrushless);
    leftMotorTwo = new CANSparkMax(DRIVE_IO.LEFT_TWO, MotorType.kBrushless);

    rightMotorOne = new CANSparkMax(DRIVE_IO.RIGHT_ONE, MotorType.kBrushless);
    rightMotorTwo = new CANSparkMax(DRIVE_IO.RIGHT_TWO, MotorType.kBrushless);


    left = new MotorControllerGroup(leftMotorOne, leftMotorTwo);
    // does the same as the left group but for the right.
    right = new MotorControllerGroup(rightMotorOne, rightMotorTwo);

    drive = new DifferentialDrive(left, right);

  }
  
  // To configure all the parts that we have initalized beforehand.
  public void config() {}
  
  // Method to add all the testing parts to Shuffleboard or SmartDashboard.
  public void enableTesting() {}

  public void joystickInput(double y_value, double twist_value) {
    drive.arcadeDrive(y_value, twist_value);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
