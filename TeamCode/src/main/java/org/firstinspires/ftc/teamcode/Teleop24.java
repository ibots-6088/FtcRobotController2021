package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Teleop24", group="Teleop")
//@Disabled
public class Teleop24 extends LinearOpMode {
    DcMotor lf = null;//assigns a name for the devices for the program
    DcMotor rf = null;
    DcMotor lb = null;
    DcMotor rb = null;
    DcMotor arm1 = null;
    DcMotor arm2 = null;
    Servo claw = null;
    DcMotor wrist = null;
    private float lfPower;//creates Variables for the motor power level
    private float rfPower;
    private float lbPower;
    private float rbPower;
    private float armPower;
    private float armPowerDown;
    private float variable_speed;

    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        lf = hardwareMap.get(DcMotor.class, "lf");//left front wheel//assigns a name for the devices for the control hub
        rf = hardwareMap.get(DcMotor.class, "rf");//right front wheel
        lb = hardwareMap.get(DcMotor.class, "lb");//left back wheel
        rb = hardwareMap.get(DcMotor.class, "rb");//right back wheel
        arm1 = hardwareMap.get(DcMotor.class, "arm");//arm motor 1
        arm2 = hardwareMap.get(DcMotor.class, "arm");//arm motor 2
        claw = hardwareMap.get(Servo.class, "claw");//claw closing/opening mechanism
        wrist = hardwareMap.get(DcMotor.class, "wrist");//claw rotation mechanism(motor)


        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        wrist.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        lf.setDirection(DcMotor.Direction.REVERSE);//sets motor direction so that all the motors turn in the same direction
        rf.setDirection(DcMotor.Direction.FORWARD);
        lb.setDirection(DcMotor.Direction.REVERSE);
        rb.setDirection(DcMotor.Direction.FORWARD);
        arm1.setDirection(DcMotor.Direction.FORWARD);
        arm2.setDirection(DcMotor.Direction.FORWARD);
        wrist.setDirection(DcMotor.Direction.FORWARD);

        if(gamepad1.a) {
            variable_speed = 1f;
        }else if(gamepad1.b) {
            variable_speed = .5f;
        }


        waitForStart();//stops running code until the start button is pressed
        gamepad1.rumble(1000);//makes the controllers shake when turned on
        gamepad2.rumble(1000);
        while (opModeIsActive()) {

            armPower = gamepad2.right_trigger;
            armPowerDown = gamepad2.left_trigger;
            if (gamepad2.a) {
                claw.setPosition(1);
            }
            if (gamepad2.b) {
                claw.setPosition(0);
            }
            if (gamepad2.x){
            wrist.setPower(.5);
            sleep(250);
            }else if (gamepad2.y){
            wrist.setPower(-.5);
            sleep(250);
            }else {
                wrist.setPower(0);
            }


            if (gamepad1.dpad_right) {
                lfPower = -1.0f;
                rfPower = 1.0f;
                lbPower = 1.0f;
                rbPower = -1.0f; //Strafe Right
            } else if (gamepad1.dpad_left) {
                lfPower = 1.0f;
                rfPower = -1.0f;
                lbPower = -1.0f;
                rbPower = 1.0f; //Strafe Left
            } else if (gamepad1.dpad_down) {
                lfPower = -1.0f;
                rfPower = -1.0f;
                lbPower = -1.0f;
                rbPower = -1.0f;//Drive Forward
            } else if (gamepad1.dpad_up) {
                lfPower = 1.0f;
                rfPower = 1.0f;
                lbPower = 1.0f;
                rbPower = 1.0f;//Drive Backwards
            } else {
                lfPower = gamepad1.left_stick_y;
                lbPower = gamepad1.left_stick_y;
                rbPower = gamepad1.right_stick_y;
                rfPower = gamepad1.right_stick_y; //Return Control To The Sticks
            }

            if (gamepad1.a) {
                lf.setPower(lfPower * 0.75);
                lb.setPower(lbPower * 0.75);
                rb.setPower(rbPower * 0.75);
                rf.setPower(rfPower * 0.75);
            } else if (gamepad1.b) {
                lf.setPower(lfPower * 0.5);
                lb.setPower(lbPower * 0.5);
                rb.setPower(rbPower * 0.5);
                rf.setPower(rfPower * 0.5);
            } else {
                lf.setPower(lfPower * 0.5);
                lb.setPower(lbPower * 0.5);
                rb.setPower(rbPower * 0.5);
                rf.setPower(rfPower * 0.5);
            }
            arm1.setPower(armPower * 0.5);
            arm1.setPower(armPowerDown * -0.5);
            arm2.setPower(armPower * 0.5);
            arm2.setPower(armPowerDown * -0.5);
        }
    }
}
