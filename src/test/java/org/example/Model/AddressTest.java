package org.example.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    Address address;
    Address emptyAddress;

    @BeforeEach
    void setup(){
        address = new Address("House", "Road", "Town", "County", "Country", "Postcode");
        emptyAddress = new Address();
    }

    @Test
    void whenGetAddressLine1InvokedReturnString() {
        String result = address.getAddressLine1();
        String expected = "House";
        assertEquals(expected,result);
    }

    @Test
    void whenSetAddressLine1InvokedAttributeContainsString() {
        emptyAddress.setAddressLine1("New House");
        assertEquals("New House", emptyAddress.getAddressLine1());
    }

    @Test
    void whenGetAddressLine2InvokedReturnString() {
        String result = address.getAddressLine1();
        String expected = "House";
        assertEquals(expected,result);
    }

    @Test
    void whenSetAddressLine2InvokedAttributeContainsString() {
        emptyAddress.setAddressLine2("New Road");
        assertEquals("New Road", emptyAddress.getAddressLine2());
    }

    @Test
    void whenGetTownInvokedReturnString() {
        String result = address.getAddressLine2();
        String expected = "Road";
        assertEquals(expected,result);
    }

    @Test
    void whenSetTownInvokedAttributeContainsString() {
        emptyAddress.setTown("New Town");
        assertEquals("New Town", emptyAddress.getTown());
    }

    @Test
    void whenGetCountyInvokedReturnString() {
        String result = address.getCounty();
        String expected = "County";
        assertEquals(expected,result);
    }

    @Test
    void whenSetCountyInvokedAttributeContainsString() {
        emptyAddress.setCounty("New County");
        assertEquals("New County", emptyAddress.getCounty());
    }

    @Test
    void whenGetCountryInvokedReturnString() {
        String result = address.getCountry();
        String expected = "Country";
        assertEquals(expected,result);
    }

    @Test
    void whenSetCountryInvokedAttributeContainsString() {
        emptyAddress.setCountry("New Country");
        assertEquals("New Country", emptyAddress.getCountry());
    }

    @Test
    void whenGetPostcodeInvokedReturnString() {
        String result = address.getPostcode();
        String expected = "Postcode";
        assertEquals(expected,result);
    }

    @Test
    void whenSetPostcodeInvokedAttributeContainsString() {
        emptyAddress.setPostcode("New Postcode");
        assertEquals("New Postcode", emptyAddress.getPostcode());
    }

    @Test
    void whenGetFullAddressIsInvokedReturnString() {
        String result = address.getFullAddress();
        String expected = "House, Road, Town, County, Country, Postcode";
        assertEquals(expected,result);
    }

    @Test
    void whenGetFullAddressInvokedWithEmptyValuesReturnAlternateString(){
        address.setAddressLine2("");
        address.setCounty("");
        String result = address.getFullAddress();
        String expected = "House, Town, Country, Postcode";
        assertEquals(expected, result);
    }
}