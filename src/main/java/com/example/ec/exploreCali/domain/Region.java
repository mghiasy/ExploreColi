package com.example.ec.exploreCali.domain;

public enum Region {
	NORTHERN_CALIFORNIA("Northern Califorina"),CENTRAL_COAST("Central Coast"),SOUTHERN_CALIFORNIA("Southern California"),VARIES("Varies");

	private String label;
	Region(String label) {
		this.label=label;
	}

	public static Region findByLabel(String label) {
		for (Region r: Region.values()) {
			if (r.label.equalsIgnoreCase(label))
				return r;
		}
		return null;
	}
}
