/*This is a test program for teleop, it is meant to test things without breaking the good program
if you test something and it doesnt work, change it to something that works so that it doesnt interfere with future tests
* Never Use In Competition
    -AstroBoy*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="TeleopTestProgram_DO_NOT_RUN_IN_COMPETITION_", group="Teleop")
public class TeleopTestProgram_DO_NOT_RUN_IN_COMPETITION_ extends LinearOpMode {
    DcMotor lf = null;//assigns a name for the devices for the program
    DcMotor rf = null;
    DcMotor lb = null;
    DcMotor rb = null;
    private float lfPower;//creates Variables for the motor power level
    private float rfPower;
    private float lbPower;
    private float rbPower;
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
            gamepad1.left_stick_y = 1f;
        }else if(gamepad1.b) {
            variable_speed = .5f;
            gamepad1.left_stick_y = .5f;
        }


        waitForStart();//stops running code until the start button is pressed
        gamepad1.rumble(1000);//makes the controllers shake when turned on
        gamepad2.rumble(1000);
        while (opModeIsActive()) {

            if (gamepad1.dpad_right) {
                lfPower = -variable_speed;
                rfPower = variable_speed;
                lbPower = variable_speed;
                rbPower = -variable_speed; //Strafe Right
            } else if (gamepad1.dpad_left) {
                lfPower = variable_speed;
                rfPower = -variable_speed;
                lbPower = -variable_speed;
                rbPower = variable_speed; //Strafe Left
            } else if (gamepad1.dpad_down) {
                lfPower = -variable_speed;
                rfPower = -variable_speed;
                lbPower = -variable_speed;
                rbPower = -variable_speed;//Drive Forward
            } else if (gamepad1.dpad_up) {
                lfPower = variable_speed;
                rfPower = variable_speed;
                lbPower = variable_speed;
                rbPower = variable_speed;//Drive Backwards
            } else {
                lfPower = gamepad1.left_stick_y;
                lbPower = gamepad1.left_stick_y;
                rbPower = gamepad1.right_stick_y;
                rfPower = gamepad1.right_stick_y; //Return Control To The Sticks
            }


            lf.setPower(lfPower);
            lb.setPower(lbPower);
            rb.setPower(rbPower);
            rf.setPower(rfPower);
        }
    }
}
