// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.awt.MouseInfo;
import java.awt.Point;

public class MouseSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public int mouseX;
  public int mouseY;
  //public MouseSubsystem() {
    //Point mousePoint = MouseInfo.getPointerInfo().getLocation();
    //mouseX = mousePoint.x;
    //mouseY = mousePoint.y;
    //System.out.println("functional");
  //}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    Point mousePoint = MouseInfo.getPointerInfo().getLocation();
    mouseX = mousePoint.x;
    mouseY = mousePoint.y;
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
