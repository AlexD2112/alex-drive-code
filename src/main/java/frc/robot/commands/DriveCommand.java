// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/** An example command that uses an example subsystem. */
public class DriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private DriveTrain m_driveTrain;
  private double throttle = 0;
  private double turn = 0;
  XboxController controller;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveCommand(DriveTrain driveTrain) {
    m_driveTrain = driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    controller = new XboxController(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DifferentialDrive drive = m_driveTrain.diffDrive;
    throttle = -controller.getLeftY();
    turn = controller.getRightX();
    if (throttle > 0.05 || throttle < -0.05 || turn > 0.05 || turn < -0.05) { //Checking to make sure at least throttle or turn are outside deadzones
      if (throttle < 0.05 && throttle > -0.05) { //Checking if throttle is in dead zone
        drive.arcadeDrive(0, turn);
      } else if (turn < 0.05 && turn > -0.05) {//Checking if turn is in dead zone 
        drive.arcadeDrive(throttle, 0); 
      } else {//if else, both are outside dead zones
        drive.arcadeDrive(throttle, turn);
      }
    } else {
      drive.arcadeDrive(0, 0);
    }

    System.out.println(throttle + " " + turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
