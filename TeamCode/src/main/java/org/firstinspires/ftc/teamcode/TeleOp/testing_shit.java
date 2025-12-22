package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Two Motors Simple Turn")
public class testing_shit extends LinearOpMode {

    private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;

    private CRServo LauncherRightCRServo = null;
    private CRServo LauncherLeftCRServo = null;
    private DcMotor LauncherMotor = null;

    @Override
    public void runOpMode() {

        leftFrontDrive = hardwareMap.get(DcMotor.class, "left_front_drive");
        leftBackDrive = hardwareMap.get(DcMotor.class, "left_back_drive");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "right_front_drive");
        rightBackDrive = hardwareMap.get(DcMotor.class, "right_back_drive");

        LauncherRightCRServo = hardwareMap.get(CRServo.class,"Launcher_Right_CRServo");
        LauncherLeftCRServo = hardwareMap.get(CRServo.class,"Launcher_Left_CRServo");
        LauncherMotor = hardwareMap.get(DcMotor.class, "Launcher_Motor");



        waitForStart();


        if(gamepad2.right_bumper){
            LauncherRightCRServo.setPower(0.5);
            LauncherLeftCRServo.setPower(0.5);
        }
        else{
            LauncherRightCRServo.setPower(0);
            LauncherLeftCRServo.setPower(0);
        }
//        while (opModeIsActive()) {
//
//            if (gamepad1.x) {
//                // סיבוב במקום
//                leftMotor.setPower(1);
//                rightMotor.setPower(-1);
//            } else {
//                // עצירה
//                leftMotor.setPower(0);
//                rightMotor.setPower(0);
//            }
//        }
    }
}
