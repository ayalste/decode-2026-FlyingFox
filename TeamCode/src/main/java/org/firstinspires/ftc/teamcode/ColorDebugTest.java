package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

@TeleOp(name = "COLOR DEBUG")
public class ColorDebugTest extends OpMode {

    NormalizedColorSensor leftColor;
    NormalizedColorSensor rightColor;

    @Override
    public void init() {
        leftColor  = hardwareMap.get(NormalizedColorSensor.class, "color_left");
        rightColor = hardwareMap.get(NormalizedColorSensor.class, "color_right");


    }

    @Override
    public void loop() {

        NormalizedRGBA L = leftColor.getNormalizedColors();
        NormalizedRGBA R = rightColor.getNormalizedColors();

        telemetry.addLine("=== LEFT SENSOR ===");
        telemetry.addData("raw R", L.red);
        telemetry.addData("raw G", L.green);
        telemetry.addData("raw B", L.blue);
        telemetry.addData("alpha", L.alpha);

        if (L.alpha > 0) {
            telemetry.addData("norm R", L.red / L.alpha);
            telemetry.addData("norm G", L.green / L.alpha);
            telemetry.addData("norm B", L.blue / L.alpha);
        } else {
            telemetry.addLine("norm: alpha = 0");
        }

        telemetry.addLine("");
        telemetry.addLine("=== RIGHT SENSOR ===");
        telemetry.addData("raw R", R.red);
        telemetry.addData("raw G", R.green);
        telemetry.addData("raw B", R.blue);
        telemetry.addData("alpha", R.alpha);

        if (R.alpha > 0) {
            telemetry.addData("norm R", R.red / R.alpha);
            telemetry.addData("norm G", R.green / R.alpha);
            telemetry.addData("norm B", R.blue / R.alpha);
        } else {
            telemetry.addLine("norm: alpha = 0");
        }

        telemetry.update();
    }
}
