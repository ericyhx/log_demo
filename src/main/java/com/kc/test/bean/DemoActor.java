package com.kc.test.bean;

import akka.actor.AbstractActor;
import com.kc.test.filters.LogFile;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.slf4j.MarkerFactory;

import java.time.Duration;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/11/9
 */
@Slf4j
public class DemoActor extends AbstractActor {
    private int counter=0;
    private final int id;
    public DemoActor(int id) {
        this.id = id;
    }
    @Override
    public void preStart() throws Exception {
        getContext().getSystem().scheduler().schedule(Duration.ZERO,Duration.ofMillis(10),()->{
            MDC.put("userid","DemoActor"+"_agvid"+id);
            counter++;
            log.info("DemoActor{} schedulter,counter={}",id,counter);
            log.error("DemoActor{} happened some error",id);
            log.debug("DemoActor{} come into debug|counter={}",id,counter);
//            log.info("------------------->\n" +
//                    "bias|tag:0|curPosX:0|curPosY:0|prePosX:0|prePosY:0|deltaH:0|deltaX:0|deltaY:0\n" +
//                    "battery|tag:0|voltage:0|power:0.0\n" +
//                    "iostatus|fSensorFar:0|fSensorNear:0|fShelf:0|rSensorFar:0|rSensorNear:0|rShelf:0|shelf:0|DisChargedSensor:0|CleanerSensor:0\n" +
//                    "misc|robotState:0|isliftUpResetConfirm:true|isGyroscopeResetConfirm:true|isCameraOnCode:true|isMotorEnabled:true|bucketState:0|isCameraStart:false|loadFactorTag:0\n" +
//                    "op|tagVector:-52|orderID:0|frameType:0|opState:0|errno:0|upCameraTag:0\n" +
//                    "physical|x:0|y:0|heading:0|podHeight:0|speed:0\n" +
//                    "detail|leftCmdSpeed:0|leftSpeed:0|rightCmdSpeed:0|rightSpeed:0|xOffset:0|yOffset:0|barrierHeading:0|barrierDistance:0\n" +
//                    "  |leftLoadRate:0|rightLoadRate:0|liftLoadRate:0|leftelectricity:0.0|rightelectricity:0.0|liftelectricity:0.0|batteryCurrency:0.0|slamdspMode:0\n" +
//                    "detail|isSpecialFrame:false|bucketID:-1|upCameraX:-1|upCameraY:-1|upCameraHeading:-1|isBuckeInNormalStateBeforeLiftup:false|isBuckeInNormalStateAfterLiftup:false");
        },getContext().dispatcher());
    }
    @Override
    public Receive createReceive() {
        return receiveBuilder().build();
    }
}
