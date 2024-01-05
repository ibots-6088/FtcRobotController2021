package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.hardware.;


// JH: hey, wrote some code for you to get you started!
// all my notes are tagged JH, you can use ctrl+f to search for them


@TeleOp(name="teleop_21347_2324", group="Teleop")
public class
teleop_21347_2324 extends LinearOpMode {

    private DcMotor lf = null;  //left front wheel
    private DcMotor rf = null;  //right front wheel
    private DcMotor lb = null;  //left back wheel
    private DcMotor rb = null;  //right back wheel
    private DcMotor tower = null; //linear slide up

    // JH: changed names of servos to `pivot` and `claw`
    // note a servo in continuous mode needs to be specified as a CRservo
    private CRServo pivot = null; //pivot
    private Servo claw = null; //claw

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

        //JH: again, treat pivot as a crservo instead of standard servo
        pivot = hardwareMap.crservo.get("pivot");
        claw = hardwareMap.servo.get("claw");

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

        //JH: CR servos can't use position, only direction.
        // add in the pivot servo here once you get one with a limit.
        claw.setPosition(.5);

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
            }
            if (gamepad1.dpad_left) {
                lf.setPower(1);
                rf.setPower(-1);
                lb.setPower(-1);
                rb.setPower(1); //Strafe Left
            }
            if (gamepad1.dpad_up) {
                lf.setPower(1);
                rf.setPower(1);
                lb.setPower(1);
                rb.setPower(1);
            }
            if (gamepad1.dpad_down) {
                lf.setPower(-1);
                rf.setPower(-1);
                lb.setPower(-1);
                rb.setPower(-1);
            }

            tpower = gamepad2.right_trigger;
            tdpower = gamepad2.left_trigger;

            /* JH: disabling this code for now
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
            */


            // JH: really rough prototype code for the servos here- expect to need to edit it.
            // I highly recommend looking up the servo documentation if you run into any issues

            // JH: use A and B to move the claw. you may have to edit the positions or directions
            if (gamepad2.a) {
                claw.setPosition(0.1);
            } else if (gamepad2.b){
                claw.setPosition(0.9);
            }

            // JH: use X and Y to move the pivot CR servo.
            // note for continuous mode needs you to use setPower instead of setPosition
            if (gamepad2.x) {
                pivot.setPower(0.2);
            } else if (gamepad2.y){
                pivot.setPower(-0.2);
            } else {
                pivot.setPower(0);
            }

            // ___________


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