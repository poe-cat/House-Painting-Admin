package com.poecat.housepaintingadmin.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CommissionTest {

    @Test
    public void shouldSetClientForCommission() {

        //given
        Commission commission = new Commission();
        Client client = new Client(1, "Eliza Orzeszkowa",
                "Kiedyś była piękna i tak mocno kochała", 234567);

        //when
        commission.setClient(client);

        //then
        assertThat(commission.getClient().getClientName(), is("Eliza Orzeszkowa"));
    }
}
