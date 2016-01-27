package com.videotron.tests;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Service {

    public Service(long sa, int sb, Date sc, long sd, double se) {
        super();
        this.sa = sa;
        this.sb = sb;
        this.sc = sc;
        this.sd = sd;
        this.se = se;
    }

    private long sa;
    private int sb;
    private Date sc;
    private long sd;
    private double se;
}