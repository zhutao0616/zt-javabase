package com.lfp.zt.javabase.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

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
public final class CountSync extends AbstractQueuedSynchronizer {

    private volatile int lastCount;

    public CountSync(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("count must large than zero.");
        }
        lastCount = count;
        setState(count);
    }

    public int getSyncState() {
        return super.getState();
    }

    public void setSyncState(int newState) {
        super.setState(newState);
    }


    public boolean compareAndSetSyncState(int expect, int update) {
        return super.compareAndSetState(expect, update);
    }


    protected boolean tryAcquire(int arg) {
        int current = getState();
        if (current>0 && compareAndSetState(current, 0)) {
            lastCount = current;
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    protected boolean tryRelease(int arg) {
        setExclusiveOwnerThread(null);
        setState(lastCount);
        return true;
    }

    protected int tryAcquireShared(int arg) {
        for (;;) {
            int current = getState();
            int newCount = current - arg;
            if (newCount < 0 || compareAndSetState(current, newCount)) {
                return newCount;
            }
        }
    }

    protected boolean tryReleaseShared(int arg) {
        for (;;) {
            int current = getState();
            int newCount = current + arg;
            if (compareAndSetState(current, newCount)) {
                return true;
            }
        }
    }

    protected boolean isHeldExclusively() {
        return getState() < 1;
    }

    protected Condition newCondition() {
        return new ConditionObject();
    }

}
