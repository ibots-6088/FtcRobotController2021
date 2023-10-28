package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="AutoTempBlueBackstage", group="Autonomous")
public class AutoTempBlueBackstage extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();//assigns a variable for the program time limit
    private DcMotor lf = null;//assigns a name and a variable for the devices for the program
    private DcMotor rf = null;
    private DcMotor lb = null;
    private DcMotor rb = null;
    private ColorSensor CS = null;



    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        CS = hardwareMap.get(ColorSensor.class, "CS");//Color Sensor//assigns a name for the devices for the control hub
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

        while (opModeIsActive() && (runtime.seconds() < 30.0) && rb.isBusy() && rf.isBusy() && lb.isBusy() && lf.isBusy()){//sets the time limit to 30 sec and makes sure that the motors keep running(last part my not be necessary)
            idle();

            CS.enableLed(true);//off = color from a light source, on = everything else
            telemetry.addData("Red", CS.red());//creates telemetry for the color values
            telemetry.addData("Green", CS.green());
            telemetry.addData("Blue", CS.blue());
            telemetry.addData("Alpha", CS.alpha());
            telemetry.update();
            StartUp();

            if(CS.blue() >= 1000)/*set number value to a value a little less than the number found in the test program*/{//Robot scans for beacon
                Program1();
            }else{
                Program2();
            }

            if(CS.blue() >= 1000){//Robot scans for beacon
                Program3();
            }else{
                Program2();
            }

            if(CS.blue() >= 1000){//Robot scans for Beacon
                Program4();
            }

        }
    }
    void StartUp() {
        telemetry.addLine("RUNNING StartUp");

        lf.setPower(0.5);
        rf.setPower(0.5);
        lb.setPower(0.5);
        rb.setPower(0.5);

        sleep(750);

        lf.setPower(-0.5);
        rf.setPower(0.5);
        lb.setPower(0.5);
        rb.setPower(-0.5);

        sleep(750);

        lf.setPower(0.5);
        rf.setPower(0.5);
        lb.setPower(0.5);
        rb.setPower(0.5);

        sleep(750);



    }
    void Program1(){telemetry.addLine("RUNNING PROGRAM 1");

        lf.setPower(-0.5);
        rf.setPower(-0.5);
        lb.setPower(0.5);
        rb.setPower(0.5);

        sleep(750);

        lf.setPower(1);
        rf.setPower(1);
        lb.setPower(1);
        rb.setPower(1);

        sleep(750);
        

    }
    void Program2(){telemetry.addLine("RUNNING PROGRAM 2");

    }
    void Program3(){telemetry.addLine("RUNNING PROGRAM 3");

    }
    void Program4(){telemetry.addLine("RUNNING PROGRAM 4");

    }
    void Program5(){telemetry.addLine("RUNNING PROGRAM 5");

    }
}
