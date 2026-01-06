package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/*
 * This file contains an example of an iterative (Non-Linear) "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When a selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all iterative OpModes contain.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */

@TeleOp(name="test_everybot_intake", group="Teleop")
public class test_everybot_intake extends OpMode {
    // Declare OpMode members
    private ElapsedTime runtime = new ElapsedTime();

    // Drive motors
    private DcMotor intakeMotor = null;

    @Override
    public void init() {
        telemetry.addData("Status", "Initializing");

        // Initialize hardware
        intakeMotor = hardwareMap.get(DcMotor.class, "intake_Motor");


        // Set motor directions
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);



        // Set motor behaviors


        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {


        // Gamepad 2: intake control
        if(gamepad2.a){
            intakeMotor.setPower(1.0);
        }
        else if (gamepad2.b){
            intakeMotor.setPower(-1.0);
        }
        else{
            intakeMotor.setPower(0);
        }



        // Telemetry
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("power:","volt:"+intakeMotor.getPower());



        telemetry.update();
    }

    @Override
    public void stop() {
        // Add stop logic if needed
    }
}