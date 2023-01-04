package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensusCsv {
    @CsvBindByName
    private String State;
    @CsvBindByName(column = "Population", required = true)
    private String Population;
    @CsvBindByName(column = "AreaInSqKm")
    private String AreaInSqKm;
    @CsvBindByName
    private String DensityPerSqKm;

    @Override
    public String toString() {
        return "IndiaCensusCsv{" +
                "State='" + State + '\'' +
                ", Population='" + Population + '\'' +
                ", AreaInSqKm='" + AreaInSqKm + '\'' +
                ", DensityPerSqKm='" + DensityPerSqKm + '\'' +
                '}';
    }
}
