package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class drivetrainSubsystem extends SubsystemBase {
    private final PWMVictorSPX left_front = new PWMVictorSPX(Constants.PWMPorts.motor1);
    private final PWMVictorSPX left_middle = new PWMVictorSPX(Constants.PWMPorts.motor2);
    private final PWMVictorSPX left_back = new PWMVictorSPX(Constants.PWMPorts.motor3);
    private final PWMVictorSPX right_front = new PWMVictorSPX(Constants.PWMPorts.motor4);
    private final PWMVictorSPX right_middle = new PWMVictorSPX(Constants.PWMPorts.motor5);
    private final PWMVictorSPX right_back = new PWMVictorSPX(Constants.PWMPorts.motor6);

    private final SpeedControllerGroup left_motors = new SpeedControllerGroup(left_front, left_middle, left_back);
    private final SpeedControllerGroup right_motors = new SpeedControllerGroup(right_front, right_middle, right_back);

    private final DifferentialDrive drive = new DifferentialDrive(left_motors, right_motors);

    private static drivetrainSubsystem INSTANCE = new drivetrainSubsystem();

  public static drivetrainSubsystem getInstance() {
    if (INSTANCE == null){
        synchronized (drivetrainSubsystem.class) {
            if (INSTANCE == null){
                INSTANCE = new drivetrainSubsystem();
            }
        }
    }
    return INSTANCE;
}

public void TankDrive(double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed, rightSpeed);
}
    
    
    
    
    

}