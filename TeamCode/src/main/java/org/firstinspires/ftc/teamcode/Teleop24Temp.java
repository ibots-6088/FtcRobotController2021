package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Teleop24Temp", group="Teleop")
//@Disabled
public class Teleop24Temp extends LinearOpMode {
    DcMotor lf = null;//assigns a name for the devices for the program
    DcMotor rf = null;
    DcMotor lb = null;
    DcMotor rb = null;
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



        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        lf.setDirection(DcMotor.Direction.FORWARD);//sets motor direction so that all the motors turn in the same direction
        rf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rb.setDirection(DcMotor.Direction.REVERSE);


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


            lf.setPower(lfPower * .75);
            lb.setPower(lbPower * .75);
            rb.setPower(rbPower * .75);
            rf.setPower(rfPower * .75);

        }
    }
}
