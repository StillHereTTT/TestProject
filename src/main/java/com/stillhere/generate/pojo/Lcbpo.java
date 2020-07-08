package com.stillhere.generate.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * LCBPO
 * @author 
 */
@Data
public class Lcbpo implements Serializable {
    private String transno;

    private String bussno;

    private String busstype;

    private String comcode;

    private String zipfilename;

    private String oldtransno;

    private String backfilename;

    private String bussstate;

    private String operator;

    private Date makedate;

    private String maketime;

    private Date modifydate;

    private String modifytime;

    private static final long serialVersionUID = 1L;
}