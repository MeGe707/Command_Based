package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class gyroSubsystem extends SubsystemBase{
    private final AnalogGyro gyro = new AnalogGyro(Constants.Analog_Ports.gyro_port);

} 