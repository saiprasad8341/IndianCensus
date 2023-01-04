package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import static java.nio.file.Files.newBufferedReader;

public class CensusAnalyser {
    public int indiaCensusData(String indiaCensusCsv) throws CensusAnalyserException {
        try {
            Reader reader = newBufferedReader(Paths.get(indiaCensusCsv));
            CsvToBeanBuilder<IndiaCensusCsv> csvToBeanBuilder = new CsvToBeanBuilder<IndiaCensusCsv>(reader);
            csvToBeanBuilder.withType(IndiaCensusCsv.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusCsv> csvToBean = csvToBeanBuilder.build();
            final Iterator<IndiaCensusCsv> censusCsvIterator = csvToBean.iterator();
            Iterable<IndiaCensusCsv> csvIterable = new Iterable<IndiaCensusCsv>() {
                public Iterator<IndiaCensusCsv> iterator() {
                    return censusCsvIterator;
                }
            };
            int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
            return numOfEntries;
        }catch (IOException e){
            throw new CensusAnalyserException("File not present at the location", CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }catch (IllegalStateException e){
            throw new CensusAnalyserException("Invalid file type", CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        }catch (RuntimeException e){
            throw new CensusAnalyserException("Wrong Input, Please provide the valid file name like .csv file",CensusAnalyserException.ExceptionType.INCORRECT_HEADER_OR_DELIMITER);
        }
    }
    public int loadIndiaCensus(String indianCensusCsvFilePath) throws CensusAnalyserException {
        try {
            Reader reader = newBufferedReader(Paths.get(indianCensusCsvFilePath));
            CsvToBeanBuilder<IndiaCensusCsv> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCensusCsv.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusCsv> csvToBean = csvToBeanBuilder.build();
            final Iterator<IndiaCensusCsv> censusCsvIterator = csvToBean.iterator();
            Iterable<IndiaCensusCsv> csvIterable = new Iterable<IndiaCensusCsv>() {
                @Override
                public Iterator<IndiaCensusCsv> iterator() {
                    return censusCsvIterator;
                }
            };
            int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
            return numOfEntries;
        } catch (IOException e) {
            throw new CensusAnalyserException("File not present at the location", CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new CensusAnalyserException("Invalid file type", CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        }
    }


    public int loadIndiaStateData(String indianStateCsvFilePath) throws CensusAnalyserException {
        try {
            Reader reader = newBufferedReader(Paths.get(indianStateCsvFilePath));
            CsvToBeanBuilder<IndiaCensusCsv> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCensusCsv.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusCsv> csvToBean = csvToBeanBuilder.build();
            final Iterator<IndiaCensusCsv> censusCSVIterator = csvToBean.iterator();
            Iterable<IndiaCensusCsv> csvIterable = new Iterable<IndiaCensusCsv>() {
                @Override
                public Iterator<IndiaCensusCsv> iterator() {
                    return censusCSVIterator;
                }
            };
            int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
            return numOfEntries;
        } catch (IOException e) {
            throw new CensusAnalyserException("File not present at the location", CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (IllegalStateException e) {
            throw new CensusAnalyserException("Invalid file type", CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        }
    }
}