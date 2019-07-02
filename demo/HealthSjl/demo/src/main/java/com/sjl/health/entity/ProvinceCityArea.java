package com.sjl.health.entity;

import java.io.Serializable;

public class ProvinceCityArea implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7902076957875461273L;

	private Integer pcaId;

    private String pcaName;

    private Integer pcaType;

    private Integer pcaParentId;

    public Integer getPcaId() {
        return pcaId;
    }

    public void setPcaId(Integer pcaId) {
        this.pcaId = pcaId;
    }

    public String getPcaName() {
        return pcaName;
    }

    public void setPcaName(String pcaName) {
        this.pcaName = pcaName == null ? null : pcaName.trim();
    }

    public Integer getPcaType() {
        return pcaType;
    }

    public void setPcaType(Integer pcaType) {
        this.pcaType = pcaType;
    }

    public Integer getPcaParentId() {
        return pcaParentId;
    }

    public void setPcaParentId(Integer pcaParentId) {
        this.pcaParentId = pcaParentId;
    }
}