// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.MouseSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrain m_driveTrain;
  private MouseSubsystem m_mouseSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveCommand(DriveTrain driveTrain, MouseSubsystem mouseSubsystem) {
    m_driveTrain = driveTrain;
    m_mouseSubsystem = mouseSubsystem;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
    addRequirements(mouseSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    int mouseY = m_mouseSubsystem.mouseY;
    int mouseX = m_mouseSubsystem.mouseX;
    final int maxX = 1535; //Computer max pixels x axis
    final int maxY = 863; //Computer max pixels y axis
    final double turnPercent = ((mouseX) - (maxX / 2.0)) / maxX; //Currently reaches a maximum and minimum of 50% and -50%, respectively, for safety purposes
    final double forwardPercent = ((mouseY * -1) + (maxY / 2.0)) / maxY; //Same as above
    if (((turnPercent > 0.05 || turnPercent < -0.05) || (forwardPercent > 0.05 || forwardPercent < -0.05)) && (turnPercent <= 0.5 && forwardPercent <= 0.5 && turnPercent >= -0.5 && forwardPercent >= -0.5))
    {
      //if ()
      //System.out.println(turnPercent + " " + forwardPercent);
      //m_driveTrain.diffDrive.arcadeDrive(forwardPercent, turnPercent);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.diffDrive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
