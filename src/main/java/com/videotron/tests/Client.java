package com.videotron.tests;

import java.util.List;

import lombok.Data;

@Data
public class Client {

    private int ca;
    private String cb;
    private short cc;

    /** Collection des Services correspondants au Client. */
    private List<Service> cd;

    /** Collection des Groupes correspondants au Client. */
    private List<Groupe> ce;

    private boolean cf;
    private String cg;
    private String ch;
    private String ci;
    private String cj;
}