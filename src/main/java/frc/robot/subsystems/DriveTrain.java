// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class DriveTrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private WPI_TalonFX m_backLeft = new WPI_TalonFX(1); //Back left
  private WPI_TalonFX m_frontLeft = new WPI_TalonFX(2); //Front left
  private WPI_TalonFX m_backRight = new WPI_TalonFX(3); //Back right
  private WPI_TalonFX m_frontRight = new WPI_TalonFX(4); //Front right
  public DifferentialDrive diffDrive;
  public DriveTrain() {
    m_backLeft.setInverted(TalonFXInvertType.Clockwise);
    m_frontLeft.setInverted(TalonFXInvertType.Clockwise);

    m_frontLeft.follow(m_backLeft); //front motor follow commands given to back motor
    m_frontRight.follow(m_backRight);

    m_backLeft.setNeutralMode(NeutralMode.Brake);
    m_frontRight.setNeutralMode(NeutralMode.Coast);
    m_backRight.setNeutralMode(NeutralMode.Brake);
    m_frontRight.setNeutralMode(NeutralMode.Coast);

    diffDrive = new DifferentialDrive(m_backLeft, m_backRight);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
