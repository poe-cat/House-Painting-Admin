package com.poecat.housepaintingadmin.model;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserTest {

    @Test
    public void newUserAccountShouldNotBeActive() {

        //given
        User user = new User();

        //then
        assertThat(user.isEnabled(), equalTo(false));
    }

    @Test
    public void userAccountShouldBeActivated() {

        //given
        User user = new User();

        //when
        user.setEnabled(true);

        //then
        assertThat(user.isEnabled(), equalTo(true));
    }


    @Test
    public void shouldFetchUserRoles() {

        //given
        User user = new User();

        //when
        Set<Role> roles = prepareUserRoles();
        user.setRoles(roles);

        //then
        assertThat(user.getRoles(), hasSize(2));
    }

    @Test
    public void shouldNotFetchAnyUserRoles() {

        //given
        User user = new User();

        //when
        Set<Role> roles = new HashSet<>();
        user.setRoles(roles);

        //then
        MatcherAssert.assertThat(user.getRoles(), emptyCollectionOf(Role.class));
    }

    private Set<Role> prepareUserRoles() {

        Set<Role> roleSet = new HashSet<>();

        Role role1 = new Role(1,"USER");
        Role role2 = new Role(2,"MODERATOR");

        roleSet.add(role1);
        roleSet.add(role2);

        return roleSet;
    }
}
