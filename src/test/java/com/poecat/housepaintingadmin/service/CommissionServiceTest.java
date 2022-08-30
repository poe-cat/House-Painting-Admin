package com.poecat.housepaintingadmin.service;

import com.poecat.housepaintingadmin.model.Client;
import com.poecat.housepaintingadmin.model.Commission;
import com.poecat.housepaintingadmin.repository.CommissionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ExtendWith(MockitoExtension.class)
public class CommissionServiceTest {

    private Commission commission1;
    private Client client;

    @Test
    public void shouldAddNewCommission() {

        //given
        List<Commission> commissions = prepareCommissionData();
        CommissionRepository commissionRepository = mock(CommissionRepository.class);
        CommissionService commissionService = new CommissionService(commissionRepository);
        given(commissionService.listAll()).willReturn(commissions);

        //when
        List<Commission> commissionList = commissionService.listAll();

        //then
        assertThat(commissionList, hasSize(1));
    }

    @Test
    public void shouldNotAddAnyCommissions() {

        //given
        List<Commission> commissions = prepareCommissionData();
        CommissionRepository commissionRepository = mock(CommissionRepository.class);
        CommissionService commissionService = new CommissionService(commissionRepository);
        given(commissionService.listAll()).willReturn(Collections.emptyList());

        //when
        List<Commission> commissionList = commissionService.listAll();

        //then
        assertThat(commissionList, hasSize(0));
    }


    private List<Commission> prepareCommissionData() {

        List<Commission> commissionList = new ArrayList<>();

        client = new Client(1, "Eliza Orzeszkowa",
                "Kiedyś była piękna i tak mocno kochała", 234567);

        commission1 = new Commission(1, "Wooden fence", "Liściana 2",
                5, 500.0, "Short description", client);

        commissionList.add(commission1);

        return commissionList;
    }
}
