//package org.usfirst.frc.team4571.robot.components.sensors;
//
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.PIDSource;
//import edu.wpi.first.wpilibj.PIDSourceType;
//
//public class EncoderAverage implements PIDSource {
//	
//	private Encoder leftEncoder;
//	private Encoder rightEncoder;
//	private PIDSourceType pidSource;
//	
//	public EncoderAverage(Encoder leftEnoder, Encoder rightEncoder) {
//		this.leftEncoder = leftEnoder;
//		this.rightEncoder = rightEncoder;
//	}
//
//	@Override
//	public void setPIDSourceType(PIDSourceType pidSource) {
//		this.leftEncoder.setPIDSourceType(pidSource);
//		this.rightEncoder.setPIDSourceType(pidSource);
//		this.pidSource = pidSource;
//	}
//
//	@Override
//	public PIDSourceType getPIDSourceType() {
//		return this.pidSource;
//	}
//
//	@Override
//	public double pidGet() {
//		return (this.leftEncoder.pidGet() + this.rightEncoder.pidGet()) / 2.0;
//	}
//
//	public void reset() {
//		this.leftEncoder.reset();
//		this.rightEncoder.reset();
//	}
//}