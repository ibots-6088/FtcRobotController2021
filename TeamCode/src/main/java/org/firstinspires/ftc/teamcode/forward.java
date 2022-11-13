package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.;


@TeleOp(name="forward", group="Teleop")
//@Disabled
public class forward extends LinearOpMode {

    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //left front wheel
        DcMotor lf = hardwareMap.get(DcMotor.class, "lf");
        //right front wheel
        DcMotor rf = hardwareMap.get(DcMotor.class, "rf");
        //left back wheel
        DcMotor lb = hardwareMap.get(DcMotor.class, "lb");
        //right back wheel
        DcMotor rb = hardwareMap.get(DcMotor.class, "rb");
        //arm motor 1
        DcMotor tower1 = hardwareMap.get(DcMotor.class, "tower1");

        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        lf.setDirection(DcMotor.Direction.REVERSE);
        rf.setDirection(DcMotor.Direction.FORWARD);
        lb.setDirection(DcMotor.Direction.REVERSE);
        rb.setDirection(DcMotor.Direction.FORWARD);
        tower1.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        gamepad1.rumble(1000);
        gamepad2.rumble(1000);
        while (opModeIsActive()) {

                double lPower;
                double towerPower;

                //powerMult = 0.8;
                double deadzone;
                deadzone = 0.5f;

                lPower = gamepad1.left_stick_y;
                double rPower = gamepad1.right_stick_y;
                towerPower = gamepad2.right_trigger;


                if (towerPower <= deadzone) {
                    towerPower = 0.0f;
                }

                lf.setPower(lPower * -.45);
                rf.setPower(rPower * -.45);
                lb.setPower(lPower * -.45);
                rb.setPower(rPower * -.45);
                tower1.setPower(towerPower);

        }
    }
}