package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
    private static final String INDIAN_CENSUS_CSV_FILE_PATH = "./src/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/resources/IndiaStateCensusData.csv";
    private static final String INDIAN_STATE_CSV_FILE = "./src/resources/IndiaStateCode.csv";
    private static final String INDIAN_CENSUS_DELIMITER = "./src/resources/IndiaStateCensusDataDelimiter.csv";
    private static final String INDIAN_STATE_CSV_WRONG_FILE = "./src/resources/IndiaStateCode.txt";
    private static final String INDIAN_CENSUS_CSV_WRONG_FILE = "./src/resources/census.abv";

    @org.junit.Test
    public void givenIndianCensusCSVFile_Returns_CorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.indiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29, numOfRecords);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test
    public void givenIndianCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.indiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }


    @org.junit.Test
    public void givenIndiaCodeData_WithWrongFileDelimiter_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.indiaCensusData(INDIAN_CENSUS_DELIMITER);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_HEADER_OR_DELIMITER, e.type);
        }
    }

    @org.junit.Test

    public void givenIndianCensusData_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensus(INDIAN_CENSUS_CSV_WRONG_FILE);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }


    @org.junit.Test
    public void givenIndianStateCSV_ShouldReturnExactCount() {
        try {

            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaStateData(INDIAN_STATE_CSV_FILE);
            Assert.assertEquals(37, numOfRecords);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void givenIndianStateData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaStateData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @org.junit.Test
    public void givenIndianStateData_WithWrongHeader_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.indiaCensusData(INDIAN_STATE_CSV_FILE);

        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_HEADER_OR_DELIMITER, e.type);
        }
    }

    @org.junit.Test
    public void givenIndianstateData_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensus(INDIAN_STATE_CSV_WRONG_FILE);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }

}
