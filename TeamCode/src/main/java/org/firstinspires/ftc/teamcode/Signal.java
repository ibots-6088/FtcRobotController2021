package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Signal", group="Autonomous")
//@Disabled
public class Signal extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor lf = null;  //left front wheel
    private DcMotor rf = null;  //right front wheel
    private DcMotor lb = null;  //left back wheel
    private DcMotor rb = null;  //right back wheel
    //private DcMotor tower1 = null; //arm motor 1
    //private DcMotor tower2 = null; //arm motor 2


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        lf = hardwareMap.get(DcMotor.class, "lf");
        rf = hardwareMap.get(DcMotor.class, "rf");
        lb = hardwareMap.get(DcMotor.class, "lb");
        rb = hardwareMap.get(DcMotor.class, "rb");
        //tower1 = hardwareMap.get(DcMotor.class, "tower1");
        //tower2 = hardwareMap.get(DcMotor.class, "tower2");

        double sidemult = -1.0; //Red side = 1.0 Blue = -1.0


        lf.setDirection(DcMotor.Direction.FORWARD);//do we need?
        rf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rb.setDirection(DcMotor.Direction.REVERSE);
        //tower1.setDirection(DcMotor.Direction.FORWARD);
        //tower2.setDirection(DcMotor.Direction.FORWARD);


        waitForStart();
        runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 30.0)) {

            //tower1.setPower(0);
            //tower2.setPower(0);
            lf.setPower(0);
            rf.setPower(0);
            lb.setPower(0);
            rb.setPower(0);

            sleep(20000); // Wait for 20 Seconds


            //tower1.setPower(0);
            //tower2.setPower(0);
            lf.setPower(-0.5 * sidemult);
            rf.setPower(-0.5 * sidemult);
            lb.setPower(-0.5 * sidemult);
            rb.setPower(-0.5 * sidemult);

            sleep(521); // Forward to low junction
        }
    }
}