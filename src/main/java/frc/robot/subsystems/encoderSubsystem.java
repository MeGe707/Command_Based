package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class encoderSubsystem extends SubsystemBase {
  private final Encoder left_encoder = new Encoder(Constants.Analog_Ports.left_encoder_port_1, Constants.Analog_Ports.left_encoder_port_2, true);
  private final Encoder right_encoder = new Encoder(Constants.Analog_Ports.right_encoder_port_1, Constants.Analog_Ports.right_encoder_port_2, true);

  
  private static encoderSubsystem INSTANCE = new encoderSubsystem();

  public static encoderSubsystem getInstance() {
    if (INSTANCE == null){
        synchronized (encoderSubsystem.class) {
            if (INSTANCE == null){
                INSTANCE = new encoderSubsystem();
            }
        }
    }
    return INSTANCE;
}

public void reset(){
    left_encoder.reset();
    right_encoder.reset();
}

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