package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.hardware.;

@TeleOp(name="forward_21347", group="Teleop")
//@Disabled
public class forward_21347 extends LinearOpMode {

    private DcMotor lf = null;  //left front wheel
    private DcMotor rf = null;  //right front wheel
    private DcMotor lb = null;  //left back wheel
    private DcMotor rb = null;  //right back wheel
   // private DcMotor tower = null; //linear slide up
    private Servo claw = null; //claw
   // private float tpower;
    // private float tdpower;


    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        lf = hardwareMap.get(DcMotor.class, "lf");
        rf = hardwareMap.get(DcMotor.class, "rf");
        lb = hardwareMap.get(DcMotor.class, "lb");
        rb = hardwareMap.get(DcMotor.class, "rb");
       // tower = hardwareMap.get(DcMotor.class, "tower");
        claw = hardwareMap.servo.get("claw");

        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       // tower.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        lf.setDirection(DcMotor.Direction.FORWARD);
        rf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rb.setDirection(DcMotor.Direction.REVERSE);
       // tower.setDirection(DcMotor.Direction.FORWARD);
        claw.setPosition(.8);

        waitForStart();
        gamepad1.rumble(1000);
        gamepad2.rumble(1000);
        while (opModeIsActive()) {

            double powerMult;
            double lPower;
            double rPower;
           // boolean towerPower;
           // boolean towerlPower;
            double deadzone;
           // boolean towernoPower;

            /*powerMult = 0.8;
            lPower = 0.0f;
            rPower = 0.0f;
            towerPower = 0.0f;
            deadzone = 0.2f;*/

            lPower = gamepad1.left_stick_y;
            rPower = gamepad1.right_stick_y;
           // tpower = gamepad2.right_trigger;
           // tdpower = gamepad2.left_trigger;
            /*towerPower = gamepad2.y;
            towerlPower = gamepad2.x;
            towernoPower = gamepad2.left_bumper;*/

            if (gamepad2.b) {
                claw.setPosition(0.8);

            }
            if (gamepad2.a) {
                claw.setPosition(0.2);

            }


           /* if (gamepad2.x) {
                tower.setPower(-1);

            }
            if (gamepad2.y) {
                tower.setPower(1);

            }

            if (gamepad2.left_bumper) {
                tower.setPower(0);
            }*/

            /*if (gamepad2.x) {

            }else {

            }

            if (gamepad2.y) {


            }else {

            }*/

                lf.setPower(lPower * -1.0);
                rf.setPower(rPower * -1.0);
                lb.setPower(lPower * -1.0);
                rb.setPower(rPower * -1.0);
               // tower.setPower(tpower * 1.0);
               // tower.setPower(tdpower * -1.0);
            }
        }
    }