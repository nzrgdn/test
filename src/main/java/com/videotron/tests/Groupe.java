package com.videotron.tests;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Groupe {

    public Groupe(long ga, short gb, Date gc) {
        super();
        this.ga = ga;
        this.gb = gb;
        this.gc = gc;
    }

    private long  ga;
    private short gb;
    private Date  gc = null;
}
