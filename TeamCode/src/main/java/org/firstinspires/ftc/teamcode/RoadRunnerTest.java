package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="RoadRunnerTest", group="Autonomous")
public class RoadRunnerTest extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();//assigns a variable for the program time limit
    private DcMotor lf = null;//assigns a name and a variable for the devices for the program
    private DcMotor rf = null;
    private DcMotor lb = null;
    private DcMotor rb = null;
    private ColorSensor CS = null;
    public static final double TICKS_PER_REV = 537.6;
    public static class DriveConstants {
        public static final double MAX_RPM = 312;
        public static final boolean RUN_USING_ENCODER = true;
        public static PIDFCoefficients MOTOR_VELO_PID = new PIDFCoefficients(0, 0, 0,
                getMotorVelocityF(MAX_RPM / 60 * TICKS_PER_REV));
        public static double WHEEL_RADIUS = 1.8898; // in
        public static double GEAR_RATIO = 1; // output (wheel) speed / input (motor) speed
        public static double TRACK_WIDTH = 16; // in
        public static double kV = 1.0 / rpmToVelocity(MAX_RPM);
        public static double kA = 0;
        public static double kStatic = 0;
        public static double MAX_VEL = 52.48291908330528;
        public static double MAX_ACCEL = 52.48291908330528;
        public static double MAX_ANG_VEL = Math.toRadians(187.94061000000002);
        public static double MAX_ANG_ACCEL = Math.toRadians(187.94061000000002);
        public static double encoderTicksToInches(double ticks) {
            return WHEEL_RADIUS * 2 * Math.PI * GEAR_RATIO * ticks / TICKS_PER_REV;
        }

        public static double rpmToVelocity(double rpm) {
            return rpm * GEAR_RATIO * 2 * Math.PI * WHEEL_RADIUS / 60.0;
        }

        public static double getMotorVelocityF(double ticksPerSecond) {
            // see https://docs.google.com/document/d/1tyWrXDfMidwYyP_5H4mZyVgaEswhOC35gvdmP-V-5hA/edit#heading=h.61g9ixenznbx
            return 32767 / ticksPerSecond;
        }
    }




    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        CS = hardwareMap.get(ColorSensor.class, "CS");//Color Sensor//assigns a name for the devices for the control hub
        lf = hardwareMap.get(DcMotor.class, "lf");//Left Front Motor
        rf = hardwareMap.get(DcMotor.class, "rf");//Right Front Motor
        lb = hardwareMap.get(DcMotor.class, "lb");//Left Back Motor
        rb = hardwareMap.get(DcMotor.class, "rb");//Right Back Motor

        lf.setDirection(DcMotor.Direction.FORWARD);//sets motor direction so that all the motors turn in the same direction
        rf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rb.setDirection(DcMotor.Direction.REVERSE);

    }

}
