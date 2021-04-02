package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogGyro;



public class drivetrainSubsystem extends SubsystemBase {
    //drive
    private final PWMVictorSPX left_front = new PWMVictorSPX(Constants.PWMPorts.motor1);
    private final PWMVictorSPX left_middle = new PWMVictorSPX(Constants.PWMPorts.motor2);
    private final PWMVictorSPX left_back = new PWMVictorSPX(Constants.PWMPorts.motor3);
    private final PWMVictorSPX right_front = new PWMVictorSPX(Constants.PWMPorts.motor4);
    private final PWMVictorSPX right_middle = new PWMVictorSPX(Constants.PWMPorts.motor5);
    private final PWMVictorSPX right_back = new PWMVictorSPX(Constants.PWMPorts.motor6);

    private final SpeedControllerGroup left_motors = new SpeedControllerGroup(left_front, left_middle, left_back);
    private final SpeedControllerGroup right_motors = new SpeedControllerGroup(right_front, right_middle, right_back);

    private final DifferentialDrive drive = new DifferentialDrive(left_motors, right_motors);


    //encoders
    private final Encoder left_encoder = new Encoder(Constants.Analog_Ports.left_encoder_port_1, Constants.Analog_Ports.left_encoder_port_2, true);
    private final Encoder right_encoder = new Encoder(Constants.Analog_Ports.right_encoder_port_1, Constants.Analog_Ports.right_encoder_port_2, true);


    //gyro
    private final AnalogGyro gyro = new AnalogGyro(Constants.Analog_Ports.gyro_port);

    
    //INSTANCE
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
   

    //DRIVE METHODS
    public void TankDrive(double leftSpeed, double rightSpeed){
        drive.tankDrive(leftSpeed, rightSpeed);
}


  
    

    //ENCODER METHODS
    
    //encoder reset methods
    public void left_reset(){
        left_encoder.reset();
    }

    public void right_reset(){
        right_encoder.reset();
    }

    
    
    
    //encoder distance methods
    public double getLeftDistance(){
        return left_encoder.getDistance();
    }
 
    public double getRightDistance(){
        return right_encoder.getDistance();
    }

    public void setLeftDistance(){
        left_encoder.setDistancePerPulse((2*Math.PI*Constants.Robot_Features.wheel_Radius/Constants.Robot_Features.left_encoder_pulse)*2.54);
    }

    public void setRightDistance(){
        right_encoder.setDistancePerPulse((2*Math.PI*Constants.Robot_Features.wheel_Radius/Constants.Robot_Features.left_encoder_pulse)*2.54);
    }




    
    
    
    
    

}