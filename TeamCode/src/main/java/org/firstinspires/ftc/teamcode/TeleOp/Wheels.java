//package org.firstinspires.ftc.teamcode.Teleop;
//
//import com.acmerobotics.dashboard.config.Config;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.util.Range;
//
//@TeleOp(name = "robot: aviel", group = "Hydra")
//@Config
//public class Wheels extends OpMode
//{
//    BetterGamepad betterGamepad = null;
//
//    DcMotor motorLeftFront = null;
//    DcMotor motorLeftBack = null;
//    DcMotor motorRightFront = null;
//    DcMotor motorRightBack = null;
//
//    double speed = 0;
//    double turn = 0;
//    double rotation = 0;
//    public static double wheelsPower = 1;
//
//
//    @Override
//    public void init(){
//        betterGamepad = new BetterGamepad(gamepad1);
//
//        motorLeftFront = hardwareMap.get(DcMotor.class, "mFL");
//        motorLeftBack = hardwareMap.get(DcMotor.class, "mBL");
//        motorRightFront = hardwareMap.get(DcMotor.class, "mFR");
//        motorRightBack = hardwareMap.get(DcMotor.class, "mBR");
//
//        motorLeftFront.setDirection(DcMotor.Direction.FORWARD);  //  FL  FR
//        motorLeftBack.setDirection(DcMotor.Direction.FORWARD);   //
//        motorRightFront.setDirection(DcMotor.Direction.REVERSE); //  BL  BR
//        motorRightBack.setDirection(DcMotor.Direction.FORWARD);  //
//
//    }
//
//    @Override
//    public void init_loop(){
//
//    }
//
//    @Override
//    public void start(){
//        telemetry.addLine("blip, blop. initiated");
//        telemetry.update();
//    }
//
//    @Override
//    public void loop(){
//        speed = -gamepad1.left_stick_y;
//        turn = -gamepad1.right_stick_x;
//        rotation = gamepad1.left_stick_x;
//
//        if (gamepad1.left_stick_button)
//        {
//            if (wheelsPower == 1)
//                wheelsPower = 0.5;
//            else
//                wheelsPower = 1;
//            telemetry.addLine("pressedBbum");
//        }
//
//        if (betterGamepad.CirOnce())
//        {
//            telemetry.addLine("pressedBcir");
//        }
//
//        motorLeftFront.setPower( (speed+turn+rotation) * wheelsPower );
//        motorRightFront.setPower( (speed-turn-rotation) * wheelsPower );
//        motorLeftBack.setPower( (speed+turn-rotation) * wheelsPower );
//        motorRightBack.setPower( (speed-turn+rotation) * wheelsPower );
//
//        telemetry.update();
//        betterGamepad.update();
//        telemetry.clear();
//    }
//
//    @Override
//    public void stop(){
//
//    }
//}

package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.hardware.lynx.commands.core.LynxResetMotorEncoderCommand;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

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

@TeleOp(name="good_wheels", group="Teleop")
public class Wheels extends OpMode {
    // Declare OpMode members
    private ElapsedTime runtime = new ElapsedTime();

    // Drive motors
    private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;

    // End-effector members


    // Constants
    private static final double INTAKE_IN_POWER = 1.0;
    private static final double INTAKE_OUT_POWER = -1.0;
    private static final double INTAKE_OFF_POWER = 0.0;

    private static final double EXTENSION_OUT_POWER = 1.0;
    private static final double EXTENSION_IN_POWER = -1.0;

    private static final double PIVOT_UP_POWER = 1.0;        // Full power for the slow motor (312 RPM)
    private static final double PIVOT_DOWN_POWER = -0.6;    // Example value for downward movement
    private static final double PIVOT_UP_POWER_FAST = 1;  // Scaled power for 435 RPM motor
    private static final double PIVOT_DOWN_POWER_FAST = -0.6;
    private static final double PIVOT_HOLD_POWER = 0.01;        // Power to hold position for the slow motor
    private static final double PIVOT_HOLD_POWER_FAST =0.01;

    @Override
    public void init() {
        telemetry.addData("Status", "Initializing");

        // Initialize hardware
        leftFrontDrive = hardwareMap.get(DcMotor.class, "left_front_drive");
        leftBackDrive = hardwareMap.get(DcMotor.class, "left_back_drive");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "right_front_drive");
        rightBackDrive = hardwareMap.get(DcMotor.class, "right_back_drive");



        // Set motor directions
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);



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
        // Gamepad 1: Drive control
        double speed = -gamepad1.left_stick_y;
        double turn = -gamepad1.right_stick_x;
        double rotation = gamepad1.left_stick_x;
        double wheelsPower = 1.0; // Default to full power, can add toggle if needed

        leftFrontDrive.setPower((speed + turn + rotation) * wheelsPower);
        rightFrontDrive.setPower((speed - turn - rotation) * wheelsPower);
        leftBackDrive.setPower((speed + turn - rotation) * wheelsPower);
        rightBackDrive.setPower((speed - turn + rotation) * wheelsPower);

        // Gamepad 2: Intake control


        // Gamepad 2: Extension control


        // Telemetry
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("power:","volt:"+leftBackDrive.getPower());
        telemetry.addData("power:","volt:"+leftFrontDrive.getPower());



        telemetry.update();
    }

    @Override
    public void stop() {
        // Add stop logic if needed
    }
}