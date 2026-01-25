package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.mechanisms.TestBenchColor;

@TeleOp(name = "INTAKE COLOR DECODE")
public class ColorSensorTest extends OpMode {

    TestBenchColor colorBench = new TestBenchColor();
    DcMotor intake;

    @Override
    public void init() {
        colorBench.init(hardwareMap);
        intake = hardwareMap.get(DcMotor.class, "intake_Motor");
    }

    @Override
    public void loop() {

        TestBenchColor.DetectedColor color =
                colorBench.getStableColor();

        if (color == TestBenchColor.DetectedColor.GREEN ||
                color == TestBenchColor.DetectedColor.PURPLE) {

            intake.setPower(1.0);   // אינטייק ON
        } else {
            intake.setPower(0.0);   // אינטייק OFF
        }

        telemetry.addData("Detected Color", color);
        telemetry.update();
    }
}


