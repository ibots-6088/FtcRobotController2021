package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="AutoTempRedBackstage", group="Autonomous")
public class AutoTempRedBackstage extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();//assigns a variable for the program time limit
    private DcMotor lf = null;//assigns a name and a variable for the devices for the program
    private DcMotor rf = null;
    private DcMotor lb = null;
    private DcMotor rb = null;



    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Ready to run");
        telemetry.update();


        lf = hardwareMap.get(DcMotor.class, "lf");//Left Front Motor
        rf = hardwareMap.get(DcMotor.class, "rf");//Right Front Motor
        lb = hardwareMap.get(DcMotor.class, "lb");//Left Back Motor
        rb = hardwareMap.get(DcMotor.class, "rb");//Right Back Motor

        lf.setDirection(DcMotor.Direction.FORWARD);//sets motor direction so that all the motors turn in the same direction
        rf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rb.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();//stops running code until the start button is pressed
        runtime.reset();//resets the time limit timer to zero


        //creates variables for speed and rotations

        while (opModeIsActive() && (runtime.seconds() < 30.0)) {//sets the time limit to 30 sec and makes sure that the motors keep running(last part my not be necessary)
            idle();



            lf.setPower(-1);
            rf.setPower(1);
            lb.setPower(1);
            rb.setPower(-1);

            sleep(500);

            lf.setPower(0);
            rf.setPower(0);
            lb.setPower(0);
            rb.setPower(0);

            sleep(600000);



        }
    }
}

