package com.log.filter.context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/12
 */
@Slf4j
@Component
public class Common implements Runnable{
    @PostConstruct
    public void init(){
        final Thread t1 = new Thread(this);
        t1.setName("common-1");
        final Thread t2 = new Thread(this);
        t2.setName("common-2");
        final Thread t3 = new Thread(this);
        t3.setName("common-3");
        t1.start();
        t3.start();
        t2.start();
    }

    @Override
    public void run() {
        while (true){
            String name = Thread.currentThread().getName();
            log.info("common current thread:{},context:{}",name,"common context test");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String getContent(){
        String ss="\"bias|tag:0|curPosX:0|curPosY:0|prePosX:0|prePosY:0|deltaH:0|deltaX:0|deltaY:0\\n\" +\n" +
                "battery|tag:0|voltage:0|power:0.0\\n\" +\n" +
                "iostatus|fSensorFar:0|fSensorNear:0|fShelf:0|rSensorFar:0|rSensorNear:0|rShelf:0|shelf:0|DisChargedSensor:0|CleanerSensor:0\\n\" +\n" +
                "misc|robotState:0|isliftUpResetConfirm:true|isGyroscopeResetConfirm:true|isCameraOnCode:true|isMotorEnabled:true|bucketState:0|isCameraStart:false|loadFactorTag:0\\n\" +\n" +
                "op|tagVector:-52|orderID:0|frameType:0|opState:0|errno:0|upCameraTag:0\\n\" +\n" +
                "physical|x:0|y:0|heading:0|podHeight:0|speed:0\\n\" +\n" +
                "detail|leftCmdSpeed:0|leftSpeed:0|rightCmdSpeed:0|rightSpeed:0|xOffset:0|yOffset:0|barrierHeading:0|barrierDistance:0\\n\" +\n" +
                "|leftLoadRate:0|rightLoadRate:0|liftLoadRate:0|leftelectricity:0.0|rightelectricity:0.0|liftelectricity:0.0|batteryCurrency:0.0|slamdspMode:0\\n\" +\n" +
                "detail|isSpecialFrame:false|bucketID:-1|upCameraX:-1|upCameraY:-1|upCameraHeading:-1|isBuckeInNormalStateBeforeLiftup:false|isBuckeInNormalStateAfterLiftup:false\"";
        return ss;
    }
}
