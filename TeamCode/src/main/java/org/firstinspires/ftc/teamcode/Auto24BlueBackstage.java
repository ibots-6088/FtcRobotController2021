package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="Auto24BlueBackstage", group="Autonomous")
public class Auto24BlueBackstage extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();//assigns a variable for the program time limit
    private DcMotor lf = null;//assigns a name and a variable for the devices for the program
    private DcMotor rf = null;
    private DcMotor lb = null;
    private DcMotor rb = null;
    private ColorSensor CS = null;


    private int lfPos;//creates variable for the current encoder rotations
    private int lbPos;
    private int rfPos;
    private int rbPos;


    private void drive(int lfTarget/*sets left front target*/, int lbTarget/*sets left back target*/, int rfTarget/*sets right front target*/, int rbTarget/*sets right back target*/, double speed/*sets motor speed*/) {

        lfPos += lfTarget;
        lbPos += lbTarget;
        rfPos += rfTarget;
        rbPos += rbTarget;

        lf.setTargetPosition(lfPos);
        lb.setTargetPosition(lbPos);
        rf.setTargetPosition(rfPos);
        rb.setTargetPosition(rbPos);

        lf.setMode(DcMotor.RunMode.RUN_TO_POSITION);//resets encoder rotation count to zero
        lb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rb.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        lf.setPower(speed);//sets the motor power level to the variable 'speed'
        lb.setPower(speed);
        rf.setPower(speed);
        rb.setPower(speed);
    }
    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        CS = hardwareMap.get(ColorSensor.class, "CS");//Color Sensor//assigns a name for the devices for the control hub
        lf = hardwareMap.get(DcMotor.class, "lf");//Left Front Motor
        rf = hardwareMap.get(DcMotor.class, "rf");//Right Front Motor
        lb = hardwareMap.get(DcMotor.class, "lb");//Left Back Motor
        rb = hardwareMap.get(DcMotor.class, "rb");//Right Back Motor

        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);//resets encoder rotation count to zero
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lf.setDirection(DcMotor.Direction.FORWARD);//sets motor direction so that all the motors turn in the same direction
        rf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rb.setDirection(DcMotor.Direction.REVERSE);

        lfPos = 0;
        lbPos = 0;
        rfPos = 0;
        rbPos = 0;

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

            if(CS.blue() >= 1000)/*set number value to a value a little less than the number found in the test program*/{//Robot scans for beacon
                Program1();//if found, go to backdrop
            }else{
                Program2();//if not found, move on
            }

            if(CS.blue() >= 1000){//Robot scans for beacon
                Program3();//if found, go to backdrop
            }else{
                Program2();//if not found, move on
            }

            if(CS.blue() >= 1000){//Robot scans for Beacon
                Program4();//if found, go to backdrop
            }

        }
    }
    void Program1(){telemetry.addLine("RUNNING PROGRAM 1");
        drive(1000, 1000, 1000, 1000, .25);
        drive(1000, 1000, -1000, -1000,  .25);
        drive(-1000, -1000, 1000, 1000, .25);
        drive(1000, -1000, -1000, 1000,  .25);
        drive(-1000, 1000, 1000, -1000,  .25);//currently dances, replace with auto that brings robot from tape zone 1 to backdrop
    }
    void Program2(){telemetry.addLine("RUNNING PROGRAM 2");
        drive(1000, 1000, 1000, 1000, .25);
        drive(1000, 1000, -1000, -1000,  .25);
        drive(-1000, -1000, 1000, 1000, .25);
        drive(1000, -1000, -1000, 1000,  .25);
        drive(-1000, 1000, 1000, -1000,  .25);//currently dances, replace with auto that brings robot to next tape zone
    }
    void Program3(){telemetry.addLine("RUNNING PROGRAM 3");
        drive(1000, 1000, 1000, 1000, .25);
        drive(1000, 1000, -1000, -1000,  .25);
        drive(-1000, -1000, 1000, 1000, .25);
        drive(1000, -1000, -1000, 1000,  .25);
        drive(-1000, 1000, 1000, -1000,  .25);//currently dances, replace with auto that brings robot from tape zone 2 to the backdrop
    }
    void Program4(){telemetry.addLine("RUNNING PROGRAM 4");
        drive(1000, 1000, 1000, 1000, .25);
        drive(1000, 1000, -1000, -1000,  .25);
        drive(-1000, -1000, 1000, 1000, .25);
        drive(1000, -1000, -1000, 1000,  .25);
        drive(-1000, 1000, 1000, -1000,  .25);//currently dances, replace with auto that brings robot from tape zone 3 to backdrop
    }
    void Program5(){telemetry.addLine("RUNNING PROGRAM 5");
        drive(1000, 1000, 1000, 1000, .25);
        drive(1000, 1000, -1000, -1000,  .25);
        drive(-1000, -1000, 1000, 1000, .25);
        drive(1000, -1000, -1000, 1000,  .25);
        drive(-1000, 1000, 1000, -1000,  .25);//currently dances, replace with auto if needed
    }
}

