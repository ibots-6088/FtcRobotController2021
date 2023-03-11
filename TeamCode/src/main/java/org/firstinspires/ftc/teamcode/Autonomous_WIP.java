package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Autonomous_Wip", group="Autonomous")

public class Autonomous_WIP extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor lf = null;  //left front wheel
    private DcMotor rf = null;  //right front wheel
    private DcMotor lb = null;  //left back wheel
    private DcMotor rb = null;  //right back wheel
    private DcMotor tower1 = null; //arm motor 1
    private Servo clamp = null; //servo clamp
    //private DcMotor towerl = null; //lower arm (do we need for autonomous)

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        lf = hardwareMap.get(DcMotor.class, "lf");
        rf = hardwareMap.get(DcMotor.class, "rf");
        lb = hardwareMap.get(DcMotor.class, "lb");
        rb = hardwareMap.get(DcMotor.class, "rb");
        tower1 = hardwareMap.get(DcMotor.class, "tower1");
        //towerl = hardwareMap.get(DcMotor.class,"tower1");
        clamp = hardwareMap.get(Servo.class, "clamp");

        double sidemult = -1.0; //Red side = 1.0 Blue = -1.0


        lf.setDirection(DcMotor.Direction.FORWARD);
        rf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rb.setDirection(DcMotor.Direction.REVERSE);
        tower1.setDirection(DcMotor.Direction.FORWARD);
        //towerl.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 30.0));

        tower1.setPower(0); //forward to low junction
        //towerl.setPower(0);
        lf.setPower(-.5);
        rf.setPower(-.5);
        lb.setPower(-.5);
        rb.setPower(-.5);
        clamp.setPosition(1);

        sleep(1500);

        tower1.setPower(1); //raise arm to score cone on low junction
        //towerl.setPower(0);
        lf.setPower(0);
        rf.setPower(0);
        lb.setPower(0);
        rb.setPower(0);
        clamp.setPosition(1);

        sleep(3000);

        tower1.setPower(0); //forward to line cone up with low junction
        //towerl.setPower(0);
        lf.setPower(-.5);
        rf.setPower(-.5);
        lb.setPower(-.5);
        rb.setPower(-.5);
        clamp.setPosition(1);

        sleep(500);

        tower1.setPower(0); //drop cone on low junction
       //towerl.setPower(0);
        lf.setPower(0);
        rf.setPower(0);
        lb.setPower(0);
        rb.setPower(0);
        clamp.setPosition(.45);

        sleep(500);

        tower1.setPower(-1); //close clamp, back away from low junction, and lower arm
        //towerl.setPower(1);
        lf.setPower(.5);
        rf.setPower(.5);
        lb.setPower(.5);
        rb.setPower(.5);
        clamp.setPosition(1);

        sleep(500);

        tower1.setPower(0); //back up to wall
        //towerl.setPower(0);
        lf.setPower(.5);
        rf.setPower(.5);
        lb.setPower(.5);
        rb.setPower(.5);
        clamp.setPosition(1);

        sleep(900);

        tower1.setPower(0); //strafe to park in corner
        //towerl.setPower(0);
        lf.setPower(-.5);
        rf.setPower(.5);
        lb.setPower(.5);
        rb.setPower(-.5);
        clamp.setPosition(1);

        sleep(1000);


    }
}
