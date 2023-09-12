package org.firstinspires.ftc.teamcode;

//import com.qualcomm.robotcore.hardware.;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Teleop24", group="Teleop")
//@Disabled
public class Teleop24 extends LinearOpMode {
    DcMotor lf = null;
    DcMotor rf = null;
    DcMotor lb = null;
    DcMotor rb = null;

    private float lfPower;
    private float rfPower;
    private float lbPower;
    private float rbPower;

    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        lf = hardwareMap.get(DcMotor.class, "lf");//left front wheel
        rf = hardwareMap.get(DcMotor.class, "rf");//left front wheel
        lb = hardwareMap.get(DcMotor.class, "lb");//left back wheel
        rb = hardwareMap.get(DcMotor.class, "rb");//right back wheel

        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        lf.setDirection(DcMotor.Direction.FORWARD);
        rf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rb.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        gamepad1.rumble(1000);
        gamepad2.rumble(1000);
        while (opModeIsActive()) {

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


            lf.setPower(lfPower * 0.5);
            lb.setPower(lbPower * 0.5);
            rb.setPower(rbPower * 0.5);
            rf.setPower(rfPower * 0.5);
         }
    }
}
