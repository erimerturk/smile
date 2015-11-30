package com.smile.builder;

import com.smile.model.Month;
import org.apache.commons.lang.math.RandomUtils;

public class MonthBuilder extends BaseBuilder<Month, MonthBuilder> {

    private int value = RandomUtils.nextInt();

    @Override
    protected Month doBuild() {
        final Month month = new Month();
        month.setValue(value);
        return month;
    }

    public MonthBuilder value(int value) {
        this.value = value;
        return this;
    }
}
