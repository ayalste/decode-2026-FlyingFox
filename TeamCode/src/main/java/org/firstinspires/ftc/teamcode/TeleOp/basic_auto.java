package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
// ... other necessary imports

@Autonomous
public class basic_auto extends LinearOpMode {
    private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;
    @Override
    public void runOpMode() {
        leftFrontDrive = hardwareMap.get(DcMotor.class, "left_front_drive");
        leftBackDrive = hardwareMap.get(DcMotor.class, "left_back_drive");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "right_front_drive");
        rightBackDrive = hardwareMap.get(DcMotor.class, "right_back_drive");

        // Reverse one motor to drive straight
        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);

        // Set motor modes
//        leftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        rightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

//        double speed;
//        double turn;
//        double rotation;
//        double wheelsPower = 0.5;
//
//        speed = 0.5;
//        turn = 1.0;
//        rotation = 0.0;
//
//        leftFrontDrive.setPower((speed + turn + rotation) * wheelsPower);
//        rightFrontDrive.setPower((speed - turn - rotation) * wheelsPower);
//        leftBackDrive.setPower((speed - turn + rotation) * wheelsPower);
//        rightBackDrive.setPower((speed + turn - rotation) * wheelsPower);

        leftFrontDrive.setTargetPosition(200);
        leftBackDrive.setTargetPosition(200);
        rightFrontDrive.setTargetPosition(200);
        rightBackDrive.setTargetPosition(200);

        leftFrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftFrontDrive.setPower(0.2);
        leftBackDrive.setPower(0.2);
        rightFrontDrive.setPower(0.2);
        rightBackDrive.setPower(0.2);

        while (opModeIsActive() && leftFrontDrive.isBusy() && leftBackDrive.isBusy() && rightFrontDrive.isBusy() && rightBackDrive.isBusy()) {
            // Optional: Add telemetry updates here
            idle();
        }

        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
}
