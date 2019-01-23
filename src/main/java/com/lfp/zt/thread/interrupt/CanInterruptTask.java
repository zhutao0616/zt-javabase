package com.lfp.zt.thread.interrupt;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-20
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class CanInterruptTask extends Thread {
    @Override
    public void run() {
        while (!isInterrupted()){
            interrupt();
            interrupted();
            isInterrupted();

        }
    }
}
