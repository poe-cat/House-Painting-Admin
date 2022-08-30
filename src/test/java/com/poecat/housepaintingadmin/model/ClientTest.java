package com.poecat.housepaintingadmin.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ClientTest {

    @Test
    public void shouldGetClientName() {

        //given
        String name = "Constantine";
        Client client = new Client();

        //when
        client.setClientName(name);

        //then
        assertThat(name, is("Constantine"));
    }
}
