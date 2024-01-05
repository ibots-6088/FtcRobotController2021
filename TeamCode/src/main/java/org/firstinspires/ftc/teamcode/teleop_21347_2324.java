package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.hardware.;

@TeleOp(name="teleop_21347_2324", group="Teleop")
public class
teleop_21347_2324 extends LinearOpMode {

    private DcMotor lf = null;  //left front wheel
    private DcMotor rf = null;  //right front wheel
    private DcMotor lb = null;  //left back wheel
    private DcMotor rb = null;  //right back wheel
     private DcMotor tower = null; //linear slide up
      private Servo clawa = null; //claw
    private Servo clawb = null; //claw
 private float tpower;
 private float tdpower;
    private float lPower;
    private float rPower;


    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        lf = hardwareMap.get(DcMotor.class, "lf");
        rf = hardwareMap.get(DcMotor.class, "rf");
        lb = hardwareMap.get(DcMotor.class, "lb");
        rb = hardwareMap.get(DcMotor.class, "rb");
        tower = hardwareMap.get(DcMotor.class, "tower");
        clawa = hardwareMap.servo.get("clawa");
        clawb = hardwareMap.servo.get("clawb");

        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        tower.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        lf.setDirection(DcMotor.Direction.FORWARD);
        rf.setDirection(DcMotor.Direction.FORWARD);
        lb.setDirection(DcMotor.Direction.REVERSE);
        rb.setDirection(DcMotor.Direction.REVERSE);
        tower.setDirection(DcMotor.Direction.FORWARD);
        clawa.setPosition(.8);
        clawb.setPosition(.8);

        waitForStart();
        gamepad1.rumble(1000);
        gamepad2.rumble(1000);
        while (opModeIsActive()) {

            double powerMult;



            lPower = gamepad1.left_stick_y;
            rPower = gamepad1.right_stick_y;
            if (gamepad1.dpad_right) {
                lf.setPower(-1);
                rf.setPower(1);
                lb.setPower(1);
                rb.setPower(-1); //Strafe Right
            } if (gamepad1.dpad_left) {
                lf.setPower(1);
                rf.setPower(-1);
                lb.setPower(-1);
                rb.setPower(1); //Strafe Left
            } if (gamepad1.dpad_up) {
                lf.setPower(1);
                rf.setPower(1);
                lb.setPower(1);
                rb.setPower(1);
            } if (gamepad1.dpad_down) {
                lf.setPower(-1);
                rf.setPower(-1);
                lb.setPower(-1);
                rb.setPower(-1);
            }

                tpower = gamepad2.right_trigger;
                tdpower = gamepad2.left_trigger;

            if (gamepad2.b) {
                clawa.setPosition(0.8);

            }
            if (gamepad2.a) {
                clawa.setPosition(0.2);

            }
            if (gamepad2.y) {
                    clawb.setPosition(0.8);

                }
            if (gamepad2.x) {
                clawb.setPosition(0.2);
                }



                if (gamepad2.left_bumper) {
                tower.setPower(-1);

            }
            if (gamepad2.right_bumper) {
                tower.setPower(1);

            }

                lf.setPower(lPower * -1.0);
                rf.setPower(rPower * -1.0);
                lb.setPower(lPower * -1.0);
                rb.setPower(rPower * -1.0);
                tower.setPower(tpower * 1.0);
                tower.setPower(tdpower * -1.0);

        }

    }
}