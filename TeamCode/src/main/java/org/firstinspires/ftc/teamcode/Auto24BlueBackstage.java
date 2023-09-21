package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Auto24BlueBackstage", group="Autonomous")
public class Auto24BlueBackstage extends LinearOpMode {

    private ColorSensor color;
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor lf = null;  //left front wheel
    private DcMotor rf = null;  //right front wheel
    private DcMotor lb = null;  //left back wheel
    private DcMotor rb = null;  //right back wheel

    private int leftPos;//creates variable for the current encoder rotations
    private int rightPos;

    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        color = hardwareMap.get(ColorSensor.class, "color");
        lf = hardwareMap.get(DcMotor.class, "lf");
        rf = hardwareMap.get(DcMotor.class, "rf");
        lb = hardwareMap.get(DcMotor.class, "lb");
        rb = hardwareMap.get(DcMotor.class, "rb");

        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);//resets encoder rotation count to zero
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lf.setDirection(DcMotor.Direction.FORWARD);
        rf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rb.setDirection(DcMotor.Direction.REVERSE);

        leftPos = 0;
        rightPos = 0;

        waitForStart();
        runtime.reset();

    }
    private void drive(int leftTarget/*sets left target*/, int rightTarget/*sets right target*/, double speed/*sets motor speed*/) {//creates variables for speed and rotations

        leftPos += leftTarget;
        rightPos += rightTarget;

        lf.setTargetPosition(leftPos);//assigns each motor to a destination
        lb.setTargetPosition(leftPos);
        rf.setTargetPosition(rightPos);
        rb.setTargetPosition(rightPos);

        lf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rb.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        lf.setPower(speed);//designates the motor power as whatever is in the speed slot above
        lb.setPower(speed);
        rf.setPower(speed);
        rb.setPower(speed);

        while (opModeIsActive() && (runtime.seconds() < 30.0) && rb.isBusy() && rf.isBusy() && lb.isBusy() && lf.isBusy()){
            idle();


            color.enableLed(true);//off = color from a light source, on = everything else
            telemetry.addData("Red", color.red());//creates telemetry for the color values
            telemetry.addData("Green", color.green());
            telemetry.addData("Blue", color.blue());
            telemetry.addData("Alpha", color.alpha());
            telemetry.update();

            if (color.blue() > 20);/*set number value to a value a little less than the number found in the test program*/ {

                drive(1000, 1000, .25);
                drive(1000, -1000, .25);
                drive(-1000, 1000, .25);
                drive(1000, -1000, .25);//currently dances, replace with auto
            }
        }
    }
}
